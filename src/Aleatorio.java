import java.util.concurrent.ThreadLocalRandom;

public class Aleatorio
{
    public Aleatorio()
    {
        randomizeDefault();
    }

    public void randomizeDefault()
    {
        numero = ThreadLocalRandom.current().nextInt(1,5);
    }

    public int randomize30()
    {
        numero = ThreadLocalRandom.current().nextInt(0,30);
        return numero;
    }

    public int randomize60()
    {
        numero = ThreadLocalRandom.current().nextInt(0,60);
        return numero;
    }

    public int randomizePassageiros()
    {
        numero = ThreadLocalRandom.current().nextInt(1,6);
        return numero;
    }

    public int randomizeCarga()
    {
        numero = ThreadLocalRandom.current().nextInt(10000,30001);
        return numero;
    }

    public String randomizeTipo()
    {
        int random;
        random = ThreadLocalRandom.current().nextInt(0,3);

        switch (random)
        {
            case 0: {
                return "Esportiva";
            }

            case 1: {
                return "Estradeira";
            }

            default: {
                return "Dia-a-Dia";
            }
        }
    }

    public int getNumero()
    {
        return numero;
    }

    protected int numero;
}
