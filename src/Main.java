import java.util.ArrayList;

public class Main
{
    public static void main (String argv[])
    {
        Mundo novoMundo = new Mundo();

        ArrayList <Carro> carros = new ArrayList<>();
        ArrayList <Caminhao> caminhoes = new ArrayList<>();
        ArrayList <Moto> motos = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            carros.add(new Carro());
            caminhoes.add(new Caminhao());
            motos.add(new Moto());
        }

        while (true)
        {
            System.out.printf( "Caminhoes = %d | Carros = %d | Motos = %d\n", caminhoes.size(), carros.size(), motos.size());


        }

    }
}
