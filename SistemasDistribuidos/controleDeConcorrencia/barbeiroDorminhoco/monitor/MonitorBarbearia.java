package barbeiro.monitor;

public class MonitorBarbearia {

    private static final long TEMPO_CORTE = 1500; 

    private final int cadeiras;
    private int esperando = 0;
    private boolean barbeiroChamou = false;
    private boolean corteConcluido = false;

    public MonitorBarbearia(int cadeiras) {
        this.cadeiras = cadeiras;
    }

    
    public void atenderProximo() throws InterruptedException {
        chamarProximo();
        System.out.println("Barbeiro: cortando cabelo...");
        Thread.sleep(TEMPO_CORTE); 
        finalizarCorte();
    }

    private synchronized void chamarProximo() throws InterruptedException {
        if (esperando == 0) {
            System.out.println("Barbeiro: sem clientes, foi DORMIR.");
        }
        while (esperando == 0) {
            wait(); 
        }
        esperando--;
        barbeiroChamou = true;
        notifyAll(); 
    }

    private synchronized void finalizarCorte() throws InterruptedException {
        corteConcluido = true;
        notifyAll();
        while (corteConcluido) {
            wait(); 
        }
    }

    public void cortarCabelo(String nome) throws InterruptedException {
        if (!chegar(nome)) {
            return;
        }
        aguardarChamado(nome);
        aguardarFimDoCorte(nome);
    }

    private synchronized boolean chegar(String nome) {
        if (esperando >= cadeiras) {
            System.out.println(nome + ": sala CHEIA, foi embora.");
            return false;
        }
        esperando++;
        System.out.println(nome + ": sentou na espera (" + esperando + "/" + cadeiras + ").");
        notifyAll(); 
        return true;
    }

    private synchronized void aguardarChamado(String nome) throws InterruptedException {
        while (!barbeiroChamou) {
            wait();
        }
        barbeiroChamou = false; 
        System.out.println(nome + ": sentou na cadeira do barbeiro.");
    }

    private synchronized void aguardarFimDoCorte(String nome) throws InterruptedException {
        while (!corteConcluido) {
            wait();
        }
        corteConcluido = false;
        System.out.println(nome + ": terminou o corte e foi embora.");
        notifyAll();
    }
}
