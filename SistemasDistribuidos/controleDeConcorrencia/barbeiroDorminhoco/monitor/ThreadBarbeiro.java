package barbeiro.monitor;

public class ThreadBarbeiro implements Runnable {

    private final MonitorBarbearia barbearia;

    public ThreadBarbeiro(MonitorBarbearia barbearia) {
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
