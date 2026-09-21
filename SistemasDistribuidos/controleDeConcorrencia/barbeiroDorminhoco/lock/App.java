package barbeiro.lock;

public class App {
    public static void main(String[] args) throws InterruptedException {

        LockBarbearia barbearia = new LockBarbearia(5);
        new Thread(new ThreadBarbeiro(barbearia), "Barbeiro").start();

        int numero = 1;
        while (true) {
            String nome = "Cliente " + numero++;
            new Thread(new ThreadCliente(barbearia, nome), nome).start();
            Thread.sleep(500 + (long) (Math.random() * 700));
        }
    }
}
