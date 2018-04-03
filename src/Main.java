import java.util.ArrayList;

public class Main
{
    public static void main (String argv[])
    {
        Mundo meuMundo = new Mundo();

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
            Aleatorio random = new Aleatorio();
            System.out.printf( "\33[0m Caminhoes = %d | Carros = %d | Motos = %d\n", caminhoes.size(), carros.size(), motos.size());

            for(int i = 0; i < caminhoes.size(); i++)
            {
                meuMundo.insereNoMundo(caminhoes.get(i).getX(), caminhoes.get(i).getY(), 5);
                caminhoes.get(i).move();
            }

            for(int i = 0; i < carros.size(); i++)
            {
                meuMundo.insereNoMundo(carros.get(i).getX(), carros.get(i).getY(), 4);
                carros.get(i).move();
            }

            for(int i = 0; i < motos.size(); i++)
            {
                meuMundo.insereNoMundo(motos.get(i).getX(), motos.get(i).getY(), 3);
                motos.get(i).move();
            }

            meuMundo.desenhaMundo();
            meuMundo.pausaMundo();
            meuMundo.voltaComeco();
            meuMundo.reiniciaMundo();

        }

    }
}
