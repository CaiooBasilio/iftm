package filosofos.lock;

public class App {
    public static void main(String[] args) {

        String[] nomes = {"Aristóteles", "Platão", "Sócrates", "Descartes", "Kant"};

        LockFilosofo mesa = new LockFilosofo(nomes);

        
        for (int i = 0; i < nomes.length; i++) {
            Thread thread = new Thread(new ThreadFilosofo(i, mesa, nomes[i]), "Filosofo-" + nomes[i]);
            thread.start();
        }
    }
}
