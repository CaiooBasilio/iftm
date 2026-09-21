package barbeiro.lock;

public class ThreadCliente implements Runnable {

    private final LockBarbearia barbearia;
    private final String nome;

    public ThreadCliente(LockBarbearia barbearia, String nome) {
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
