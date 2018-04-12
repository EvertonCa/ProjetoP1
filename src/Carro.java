public class Carro extends Veiculo
{
    public Carro() //construtor padrão com número de passageiros aleatório
    {
        super(2, "azul"); //passa dados para o construtor padrão de veiculos
        Aleatorio random = new Aleatorio();
        numPassageiros = random.randomizePassageiros(); //
    }

    protected int numPassageiros;
}
