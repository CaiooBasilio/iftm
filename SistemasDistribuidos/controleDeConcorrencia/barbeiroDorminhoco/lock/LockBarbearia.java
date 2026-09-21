package barbeiro.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockBarbearia {

    private static final long TEMPO_CORTE = 1500;
    private final int cadeiras;
    private int esperando = 0;
    private boolean barbeiroChamou = false;
    private boolean corteConcluido = false;

    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition haCliente = lock.newCondition();
    private final Condition chamado = lock.newCondition();
    private final Condition fimDoCorte = lock.newCondition();
    private final Condition clienteSaiu = lock.newCondition();

    public LockBarbearia(int cadeiras) {
        this.cadeiras = cadeiras;
    }

    public void atenderProximo() throws InterruptedException {
        lock.lock();
        try {
            if (esperando == 0) {
                System.out.println("Barbeiro: sem clientes, foi DORMIR.");
            }
            while (esperando == 0) {
                haCliente.await();
            }
            esperando--;                 
            barbeiroChamou = true;
            chamado.signal();            
        } finally {
            lock.unlock();
        }

        System.out.println("Barbeiro: cortando cabelo...");
        Thread.sleep(TEMPO_CORTE);

        lock.lock();
        try {
            corteConcluido = true;
            fimDoCorte.signal();         
            while (corteConcluido) {
                clienteSaiu.await();     
            }
        } finally {
            lock.unlock();
        }
    }

    
    public void cortarCabelo(String nome) throws InterruptedException {
        lock.lock();
        try {
            if (esperando >= cadeiras) {
                System.out.println(nome + ": sala CHEIA, foi embora.");
                return;
            }
            esperando++;
            System.out.println(nome + ": sentou na espera (" + esperando + "/" + cadeiras + ").");
            haCliente.signal();          

            while (!barbeiroChamou) {
                chamado.await();        
            }
            barbeiroChamou = false;
            System.out.println(nome + ": sentou na cadeira do barbeiro.");

            while (!corteConcluido) {
                fimDoCorte.await();      
            }
            corteConcluido = false;
            System.out.println(nome + ": terminou o corte e foi embora.");
            clienteSaiu.signal();      
        } finally {
            lock.unlock();
        }
    }
}
