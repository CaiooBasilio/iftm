package barbeiro.semaforo;

import java.util.concurrent.Semaphore;

public class SemaforoBarbearia {

    private static final long TEMPO_CORTE = 1500; 

    private final int cadeiras;
    private int esperando = 0;

    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore clientesEsperando = new Semaphore(0);
    private final Semaphore barbeiroPronto = new Semaphore(0);
    private final Semaphore corteConcluido = new Semaphore(0);
    private final Semaphore clienteSaiu = new Semaphore(0);

    public SemaforoBarbearia(int cadeiras) {
        this.cadeiras = cadeiras;
    }

    public void atenderProximo() throws InterruptedException {
        if (clientesEsperando.availablePermits() == 0) {
            System.out.println("Barbeiro: sem clientes, foi DORMIR.");
        }
        clientesEsperando.acquire();

        mutex.acquire();
        esperando--;                 
        mutex.release();

        barbeiroPronto.release();   
        System.out.println("Barbeiro: cortando cabelo...");
        Thread.sleep(TEMPO_CORTE);
        corteConcluido.release();   
        clienteSaiu.acquire();       
    }

    public void cortarCabelo(String nome) throws InterruptedException {
        mutex.acquire();
        if (esperando >= cadeiras) { 
            mutex.release();
            System.out.println(nome + ": sala CHEIA, foi embora.");
            return;
        }
        esperando++;
        System.out.println(nome + ": sentou na espera (" + esperando + "/" + cadeiras + ").");
        clientesEsperando.release(); 
        mutex.release();

        barbeiroPronto.acquire();    
        System.out.println(nome + ": sentou na cadeira do barbeiro.");
        corteConcluido.acquire();    
        System.out.println(nome + ": terminou o corte e foi embora.");
        clienteSaiu.release();
    }
}
