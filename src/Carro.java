public class Carro extends Veiculo
{
    ///construtor padrão com número de passageiros aleatório
    public Carro()
    {
        ///passa dados para o construtor padrão de veiculos
        super(2, "azul");
        Aleatorio random = new Aleatorio();
        numPassageiros = random.randomizePassageiros();
    }

    protected int numPassageiros;
}
