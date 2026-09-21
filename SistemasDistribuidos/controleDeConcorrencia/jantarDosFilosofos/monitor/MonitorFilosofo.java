package filosofos.monitor;


public class MonitorFilosofo {

    private enum Estado { PENSANDO, FAMINTO, COMENDO }

    private final int total;
    private final String[] nomes;
    private final Estado[] estados;

    public MonitorFilosofo(String[] nomes) {
        this.nomes = nomes;
        this.total = nomes.length;
        this.estados = new Estado[total];
        for (int i = 0; i < total; i++) {
            estados[i] = Estado.PENSANDO;
        }
    }

    public synchronized void pegarGarfos(int id) throws InterruptedException {
        estados[id] = Estado.FAMINTO;
        System.out.println("Filósofo " + nomes[id] + " está com FOME.");

        
        while (!garfosLivres(id)) {
            wait();
        }

        estados[id] = Estado.COMENDO;
        System.out.println("Filósofo " + nomes[id] + " pegou os garfos e está COMENDO.");
    }

    public synchronized void largarGarfos(int id) {
        estados[id] = Estado.PENSANDO;
        System.out.println("Filósofo " + nomes[id] + " largou os garfos e voltou a PENSAR.");
        notifyAll(); 
    }

    private boolean garfosLivres(int id) {
        return estados[esquerda(id)] != Estado.COMENDO
                && estados[direita(id)] != Estado.COMENDO;
    }

    private int esquerda(int id) { return (id + total - 1) % total; }
    private int direita(int id)  { return (id + 1) % total; }
}
