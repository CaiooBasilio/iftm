import java.util.Scanner; 

public class Main 
{
    public static void main (String[] args) {
    Scanner s = new Scanner(System.in);
        
        int N = s.nextInt();
        
        //uso a % para alterar o número de N, para ser a sobra da div da cédula
        int cem = N/100;
        N = N % 100;
        
        //o mesmo no ultimo
       int cin = N/50;
       N = N % 50;
       
       int vin = N/20;
       N = N %20;
       
       int dez = N/10; 
       N = N % 10;
       
       int fiv = N/5;
       N = N % 5;
       
       int dos = N/2;
       N = N % 2;
       
       int um = N/1;
       N = N%1;
       
       System.out.println(N)
       System.out.printf("%d nota(s) de R$ 100,00\n", cem);
       System.out.printf("%d nota(s) de R$ 50,00\n", cin);
       System.out.printf("%d nota(s) de R$ 20,00\n", vin);
       System.out.printf("%d nota(s) de R$ 10,00\n", dez);
       System.out.printf("%d nota(s) de R$ 5,00\n", fiv);
       System.out.printf("%d nota(s) de R$ 2,00\n", dos);
       System.out.printf("%d nota(s) de R$ 1,00\n", um);
    }
}
