import java.util.Scanner;

public class Main
{
    public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
    
        String nome = s.nextLine();
        double SF = s.nextDouble();
        double VE = s.nextDouble();
        double total = (VE * 0.15) + SF;
        
        System.out.printf("TOTAL = R$ %.2f\n", total);
    }
}
