import java.util.concurrent.ThreadLocalRandom;

public class Aleatorio
{
    public int randomizeDirecao() //volta um número aleatório entre 1 e 4
    {
        numero = ThreadLocalRandom.current().nextInt(1,5);
        return numero;
    }

    public int randomize30() //volta um número aleatório entre 0 e 30
    {
        numero = ThreadLocalRandom.current().nextInt(0,30);
        return numero;
    }

    public int randomize60() //volta um número aleatório entre 0 e 60
    {
        numero = ThreadLocalRandom.current().nextInt(0,60);
        return numero;
    }

    public int randomizePassageiros() //volta um número aleatório entre 1 e 5
    {
        numero = ThreadLocalRandom.current().nextInt(1,6);
        return numero;
    }

    public int randomizeCarga() //volta um número aleatório entre 10000 e 30000
    {
        numero = ThreadLocalRandom.current().nextInt(10000,30001);
        return numero;
    }

    public int randomizeID() //volta um número aleatório entre 1 e 300000
    {
        int id1 = ThreadLocalRandom.current().nextInt(1,100000);
        int id2 = ThreadLocalRandom.current().nextInt(1,100000);
        int id3 = ThreadLocalRandom.current().nextInt(1,100000);
        return id1+id2+id3;
    }

    public String randomizeTipo() //volta um tipo de moto aleatória
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

    public int getNumero() //volta o numero armazenado no objeto
    {
        return numero;
    }

    protected int numero;
}
