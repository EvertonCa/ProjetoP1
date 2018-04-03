public class Caminhao extends Veiculo
{
    public Caminhao()
    {
        super(1, "cinza");
        Aleatorio random = new Aleatorio();
        capacidadeCarga = random.randomizeCarga();
    }

    protected int capacidadeCarga;
}
