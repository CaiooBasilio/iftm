package leitoresescritores.monitor;


public class MonitorBaseDeDados {

    private int leitoresAtivos = 0;
    private int escritoresEsperando = 0;
    private boolean escrevendo = false;
    private int dado = 0; 

    
    private synchronized int iniciarLeitura() throws InterruptedException {
        while (escrevendo || escritoresEsperando > 0) {
            wait();
        }
        leitoresAtivos++;
        return leitoresAtivos;
    }

    private synchronized void finalizarLeitura() {
        leitoresAtivos--;
        if (leitoresAtivos == 0) {
            notifyAll(); 
        }
    }

    private synchronized void iniciarEscrita() throws InterruptedException {
        escritoresEsperando++;
        try {
            while (escrevendo || leitoresAtivos > 0) {
                wait();
            }
        } finally {
            escritoresEsperando--;
        }
        escrevendo = true;
    }

    private synchronized void finalizarEscrita() {
        escrevendo = false;
        notifyAll(); 
    }

    
    public void ler(String nome) throws InterruptedException {
        int simultaneos = iniciarLeitura();
        try {
            System.out.println(nome + " está LENDO dado=" + dado
                    + " (leitores simultâneos: " + simultaneos + ")");
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } finally {
            finalizarLeitura();
        }
    }

    public void escrever(String nome) throws InterruptedException {
        iniciarEscrita();
        try {
            dado++;
            System.out.println(">>> " + nome + " ESCREVEU dado=" + dado + " (acesso exclusivo)");
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } finally {
            finalizarEscrita();
        }
    }
}
