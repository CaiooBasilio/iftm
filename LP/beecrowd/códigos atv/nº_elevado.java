import java.util.Scanner;

public class Main
{
    public static void main (String[] args) {
        Scanner v = new Scanner(System.in);
        
        double n = 3.14159;
        double raio = v.nextDouble();
        //o elevado é o pow
        double area = n * Math.pow(raio, 2);
        
        System.out.println("A=" + String.format("%.4f", area));
    }
}
