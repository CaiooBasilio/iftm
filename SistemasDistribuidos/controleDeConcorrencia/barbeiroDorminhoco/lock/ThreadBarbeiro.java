package barbeiro.lock;

public class ThreadBarbeiro implements Runnable {

    private final LockBarbearia barbearia;

    public ThreadBarbeiro(LockBarbearia barbearia) {
        this.barbearia = barbearia;
    }

    @Override
    public void run() {
        try {
            while (true) {
                barbearia.atenderProximo();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Barbeiro: fim do expediente.");
        }
    }
}
