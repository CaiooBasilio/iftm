package filosofos.monitor;

public class ThreadFilosofo implements Runnable {

    private final int id;
    private final MonitorFilosofo mesa;
    private final String nome;

    public ThreadFilosofo(int id, MonitorFilosofo mesa, String nome) {
        this.id = id;
        this.mesa = mesa;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(nome + " está pensando.");
                Thread.sleep(1000 + (long) (Math.random() * 2000)); 

                mesa.pegarGarfos(id); 
                try {
                    Thread.sleep(1000 + (long) (Math.random() * 2000)); 
                } finally {
                    mesa.largarGarfos(id); 
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(nome + " foi interrompido.");
        }
    }
}
