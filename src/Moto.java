public class Moto extends Veiculo
{
    public Moto()
    {
        super(3, "marrom");
        Aleatorio random = new Aleatorio();
        tipo = random.randomizeTipo();
    }

    protected String tipo;
}
