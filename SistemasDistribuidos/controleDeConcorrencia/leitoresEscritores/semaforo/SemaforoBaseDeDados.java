package leitoresescritores.semaforo;

import java.util.concurrent.Semaphore;


public class SemaforoBaseDeDados {

    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore acessoBD = new Semaphore(1);

    private int leitoresAtivos = 0;
    private int dado = 0; 

    public void ler(String nome) throws InterruptedException {
        
        int simultaneos;
        mutex.acquire();
        leitoresAtivos++;
        simultaneos = leitoresAtivos;
        if (leitoresAtivos == 1) {
            acessoBD.acquire(); 
        }
        mutex.release();

        try {
            System.out.println(nome + " está LENDO dado=" + dado
                    + " (leitores simultâneos: " + simultaneos + ")");
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } finally {
            
            mutex.acquireUninterruptibly();
            leitoresAtivos--;
            if (leitoresAtivos == 0) {
                acessoBD.release(); 
            }
            mutex.release();
        }
    }

    public void escrever(String nome) throws InterruptedException {
        acessoBD.acquire(); 
        try {
            dado++;
            System.out.println(">>> " + nome + " ESCREVEU dado=" + dado + " (acesso exclusivo)");
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } finally {
            acessoBD.release();
        }
    }
}
