package filosofos.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockFilosofo {

    private enum Estado { PENSANDO, FAMINTO, COMENDO }

    private final int total;
    private final String[] nomes;
    private final Estado[] estados;

    private final Lock lock = new ReentrantLock();
    private final Condition[] condicoes; 

    public LockFilosofo(String[] nomes) {
        this.nomes = nomes;
        this.total = nomes.length;
        this.estados = new Estado[total];
        this.condicoes = new Condition[total];
        for (int i = 0; i < total; i++) {
            estados[i] = Estado.PENSANDO;
            condicoes[i] = lock.newCondition();
        }
    }

    public void pegarGarfos(int id) throws InterruptedException {
        lock.lock();
        try {
            estados[id] = Estado.FAMINTO;
            System.out.println("Filósofo " + nomes[id] + " está com FOME.");
            tentarComer(id);

            
            while (estados[id] != Estado.COMENDO) {
                condicoes[id].await();
            }
        } finally {
            lock.unlock(); 
        }
    }

    public void largarGarfos(int id) {
        lock.lock();
        try {
            estados[id] = Estado.PENSANDO;
            System.out.println("Filósofo " + nomes[id] + " largou os garfos e voltou a PENSAR.");
            
            tentarComer(esquerda(id));
            tentarComer(direita(id));
        } finally {
            lock.unlock();
        }
    }

    
    private void tentarComer(int id) {
        if (estados[id] == Estado.FAMINTO
                && estados[esquerda(id)] != Estado.COMENDO
                && estados[direita(id)] != Estado.COMENDO) {
            estados[id] = Estado.COMENDO;
            System.out.println("Filósofo " + nomes[id] + " pegou os garfos e está COMENDO.");
            condicoes[id].signal();
        }
    }

    private int esquerda(int id) { return (id + total - 1) % total; }
    private int direita(int id)  { return (id + 1) % total; }
}
