package leitoresescritores.semaforo;

public class ThreadEscritor implements Runnable {

    private final SemaforoBaseDeDados base;
    private final String nome;

    public ThreadEscritor(SemaforoBaseDeDados base, String nome) {
        this.base = base;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000 + (long) (Math.random() * 3000)); 
                base.escrever(nome);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(nome + " foi interrompido.");
        }
    }
}
