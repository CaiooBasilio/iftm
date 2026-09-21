package leitoresescritores.lock;

public class App {
    public static void main(String[] args) {

        String[] leitores = {"Ana", "Bruno", "Carla", "Diego"};
        String[] escritores = {"Elisa", "Fábio"};

        LockBaseDeDados base = new LockBaseDeDados();

        for (String nome : leitores) {
            new Thread(new ThreadLeitor(base, "Leitor " + nome), "Leitor-" + nome).start();
        }
        for (String nome : escritores) {
            new Thread(new ThreadEscritor(base, "Escritor " + nome), "Escritor-" + nome).start();
        }
        
    }
}
