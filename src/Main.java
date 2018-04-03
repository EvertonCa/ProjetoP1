import java.util.Scanner;

public class Main
{
    public static void main (String argv[])
    {
        Scanner teclado = new Scanner(System.in);
        Aleatorio random = new Aleatorio();

        System.out.printf("%d", random.getNumero());
    }
}
