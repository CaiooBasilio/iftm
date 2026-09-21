package leitoresescritores.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;


public class LockBaseDeDados {

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);
    private int dado = 0; 

    public void ler(String nome) throws InterruptedException {
        rwLock.readLock().lock();
        try {
            System.out.println(nome + " está LENDO dado=" + dado
                    + " (leitores simultâneos: " + rwLock.getReadLockCount() + ")");
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } finally {
            rwLock.readLock().unlock(); 
        }
    }

    public void escrever(String nome) throws InterruptedException {
        rwLock.writeLock().lock();
        try {
            dado++;
            System.out.println(">>> " + nome + " ESCREVEU dado=" + dado + " (acesso exclusivo)");
            Thread.sleep(1000 + (long) (Math.random() * 1000));
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
