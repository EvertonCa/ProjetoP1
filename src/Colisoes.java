public class Colisoes
{
    public Colisoes()
    {
        tipos = new String[30][60];
        indices = new int[30][60];

        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < 60; j++)
            {
                tipos[i][j] = "empty";
                indices[i][j] = -1;
            }
        }
    }

    public String getTipo(int i, int j)
    {
        return tipos[i][j];
    }

    public int getIndice(int i, int j)
    {
        return indices[i][j];
    }

    public void ocupado(int i, int j, String tipo, int indice)
    {
        tipos[i][j] = tipo;
        indices[i][j] = indice;
    }

    public void restaura(int i, int j)
    {
        tipos[i][j] = "empty";
        indices[i][j] = -1;
    }

    public void ajusta( String tipo, int indice)
    {
        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < 60; j++)
            {
                if(tipos[i][j].equals(tipo) && indices[i][j] > indice)
                    indices[i][j]--;
            }
        }
    }

    protected String tipos[][];
    protected int indices[][];
}
