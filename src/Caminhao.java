public class Caminhao extends Veiculo
{
    public Caminhao() //construtor padrão com capacidade de carga aleatória
    {
        super(1, "cinza"); //chama construtor padrão da classe pai
        Aleatorio random = new Aleatorio();
        capacidadeCarga = random.randomizeCarga();
    }

    protected int capacidadeCarga;
}
