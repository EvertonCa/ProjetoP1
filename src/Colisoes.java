public class Colisoes
{
    public Colisoes()
    {
        tipos = new String[30][60];
        id = new int[30][60];

        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < 60; j++)
            {
                tipos[i][j] = "empty";
                id[i][j] = 0;
            }
        }
    }

    public String getTipo(int i, int j)
    {
        return tipos[i][j];
    }

    public int getID(int i, int j)
    {
        return id[i][j];
    }

    public void ocupado(int i, int j, String tipo, int ID)
    {
        tipos[i][j] = tipo;
        id[i][j] = ID;
    }

    public void restaura(int i, int j)
    {
        tipos[i][j] = "empty";
        id[i][j] = 0;
    }

    protected String tipos[][];
    protected int id[][];
}
