package filosofos.semaforo;

import java.util.concurrent.Semaphore;


public class SemaforoFilosofo {

    private enum Estado { PENSANDO, FAMINTO, COMENDO }

    private final int total;
    private final String[] nomes;
    private final Estado[] estados;

    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore[] semaforos; 

    public SemaforoFilosofo(String[] nomes) {
        this.nomes = nomes;
        this.total = nomes.length;
        this.estados = new Estado[total];
        this.semaforos = new Semaphore[total];
        for (int i = 0; i < total; i++) {
            estados[i] = Estado.PENSANDO;
            semaforos[i] = new Semaphore(0);
        }
    }

    public void pegarGarfos(int id) throws InterruptedException {
        mutex.acquire();
        try {
            estados[id] = Estado.FAMINTO;
            System.out.println("Filósofo " + nomes[id] + " está com FOME.");
            tentarComer(id); 
        } finally {
            mutex.release();
        }
        semaforos[id].acquire(); 
    }

    public void largarGarfos(int id) throws InterruptedException {
        mutex.acquire();
        try {
            estados[id] = Estado.PENSANDO;
            System.out.println("Filósofo " + nomes[id] + " largou os garfos e voltou a PENSAR.");
            tentarComer(esquerda(id));
            tentarComer(direita(id));
        } finally {
            mutex.release();
        }
    }

    
    private void tentarComer(int id) {
        if (estados[id] == Estado.FAMINTO
                && estados[esquerda(id)] != Estado.COMENDO
                && estados[direita(id)] != Estado.COMENDO) {
            estados[id] = Estado.COMENDO;
            System.out.println("Filósofo " + nomes[id] + " pegou os garfos e está COMENDO.");
            semaforos[id].release(); 
        }
    }

    private int esquerda(int id) { return (id + total - 1) % total; }
    private int direita(int id)  { return (id + 1) % total; }
}
