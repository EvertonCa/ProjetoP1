public class Caminhao extends Veiculo
{
    ///construtor padrão com capacidade de carga aleatória
    public Caminhao()
    {
        ///chama construtor padrão da classe pai
        super(1, "cinza");
        Aleatorio random = new Aleatorio();
        capacidadeCarga = random.randomizeCarga();
    }

    protected int capacidadeCarga;
}
