public class Carro extends Veiculo
{
    public Carro()
    {
        super(2, "azul");
        Aleatorio random = new Aleatorio();
        numPassageiros = random.randomizePassageiros();
    }

    protected int numPassageiros;
}
