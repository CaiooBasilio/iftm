package leitoresescritores.monitor;

public class ThreadLeitor implements Runnable {

    private final MonitorBaseDeDados base;
    private final String nome;

    public ThreadLeitor(MonitorBaseDeDados base, String nome) {
        this.base = base;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000 + (long) (Math.random() * 2000)); 
                base.ler(nome);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(nome + " foi interrompido.");
        }
    }
}
