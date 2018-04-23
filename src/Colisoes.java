/**
 *
 *Classe responsável por administrar as colisões entre veiculos no programa
 */

public class Colisoes
{
    ///construtor padrão
    public Colisoes()
    {
        ///nova matriz de 30x60 para armazenar os tipos de veiculos
        tipos = new String[30][60];
        ///nova matriz de 30x60 para armazenar as IDs dos veiculos
        id = new int[30][60];

        ///inicializa as duas matrizes como vazias
        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < 60; j++)
            {
                tipos[i][j] = "empty";
                id[i][j] = 0;
            }
        }
    }

    ///retorna o tipo que está nas coordenadas entradas
    public String getTipo(int i, int j)
    {
        return tipos[i][j];
    }

    ///retorna a ID que está nas coordenadas entradas
    public int getID(int i, int j)
    {
        return id[i][j];
    }

    ///popula a coordenada entrada com o tipo e ID desejado
    public void ocupado(int i, int j, String tipo, int ID)
    {
        tipos[i][j] = tipo;
        id[i][j] = ID;
    }

    //restaura a coordenada entrada como padrão vazio
    public void restaura(int i, int j)
    {
        tipos[i][j] = "empty";
        id[i][j] = 0;
    }

    protected String tipos[][];
    protected int id[][];
}
