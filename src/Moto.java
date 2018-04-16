public class Moto extends Veiculo
{
    ///construtor padrão com tipo da moto aleatória
    public Moto()
    {
        ///chama construtor padrão da classe pai
        super(3, "marrom");
        Aleatorio random = new Aleatorio();
        tipo = random.randomizeTipo();
    }

    protected String tipo;
}
