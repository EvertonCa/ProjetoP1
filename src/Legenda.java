public class Legenda
{
    ///Exibe o mundo sem nenhum veiculo, indicando as fabricas (é exibido por 5 segundos)
    public void exibeLegenda()
    {
        Mundo meuMundo = new Mundo();

        meuMundo.desenhaMundo();

        for(int i = 0; i < 27; i++)
        {
            voltaCarro();
        }

        System.out.printf("\33[7;31m \33[7;30m                \33[7;32m FABRICA\33[0m");
        System.out.printf("\n\n\n\n\n\n\n\n\n");
        System.out.printf("\33[7;31m \33[7;30m                                  \33[7;32mFABRICA\33[0m");
        System.out.printf("\n\n\n\n\n\n\n\n\n");
        System.out.printf("\33[7;31m \33[7;30m            \33[7;32m  FABRICA\33[0m");
        System.out.printf("\n\n\n\n\n\n\n\n");

        pausaLegenda();
        voltaComecoLegenda();

    }

    ///volta o carro do terminal uma linha acima
    public void voltaCarro()
    {
        System.out.printf("\33[A");
    }

    ///pausa a execução do programa por 5 segundos
    public void pausaLegenda()
    {
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) { }
    }

    ///volta o carro para o inicio do mapa
    public void voltaComecoLegenda()
    {
        for (int i = 0; i < 30; i++)
        {
            System.out.printf("\33[A");
        }
    }
}
