package barbeiro.monitor;

public class ThreadCliente implements Runnable {

    private final MonitorBarbearia barbearia;
    private final String nome;

    public ThreadCliente(MonitorBarbearia barbearia, String nome) {
        this.barbearia = barbearia;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            barbearia.cortarCabelo(nome);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(nome + " foi interrompido.");
        }
    }
}
