public class Moto extends Veiculo
{
    public Moto() //construtor padrão com tipo da moto aleatória
    {
        super(3, "marrom"); //chama construtor padrão da classe pai
        Aleatorio random = new Aleatorio();
        tipo = random.randomizeTipo();
    }

    protected String tipo;
}
