import java.util.concurrent.ThreadLocalRandom;

public class Aleatorio
{
    public Aleatorio()
    {
        Randomize();
    }

    public void Randomize()
    {
        int random = ThreadLocalRandom.current().nextInt(1,5);
        numero = random;
    }

    public int getNumero()
    {
        return numero;
    }

    protected int numero;
}
