public class Colisoes
{
    public Colisoes() //construtor padrão
    {
        tipos = new String[30][60]; //nova matriz de 30x60 para armazenar os tipos de veiculos
        id = new int[30][60]; //nova matriz de 30x60 para armazenar as IDs dos veiculos

        for (int i = 0; i < 30; i++) //inicializa as duas matrizes como vazias
        {
            for (int j = 0; j < 60; j++)
            {
                tipos[i][j] = "empty";
                id[i][j] = 0;
            }
        }
    }

    public String getTipo(int i, int j) //retorna o tipo que esta nas coordenadas entradas
    {
        return tipos[i][j];
    }

    public int getID(int i, int j) //retorna a ID que esta nas coordenadas entradas
    {
        return id[i][j];
    }

    public void ocupado(int i, int j, String tipo, int ID) // popula a coordenada entrada com o tipo e ID desejado
    {
        tipos[i][j] = tipo;
        id[i][j] = ID;
    }

    public void restaura(int i, int j) //restaura a coordenada entrada como padrão vazio
    {
        tipos[i][j] = "empty";
        id[i][j] = 0;
    }

    protected String tipos[][];
    protected int id[][];
}
