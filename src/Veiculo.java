public class Veiculo
{
    public Veiculo(int velocidade, String cor)
    {
        this.cor = cor;
        this.velocidade = velocidade;
        Aleatorio random = new Aleatorio();
        x = random.randomize30();
        y = random.randomize60();
        foraDaFabrica();
        id = random.randomizeID();
    }

    public void dentroDaFabrica()
    {
        fabrica = true;
    }

    public void foraDaFabrica()
    {
        fabrica = false;
    }

    public void move()
    {
        Aleatorio random = new Aleatorio();
        int direcao = random.randomizeDirecao();

        switch (direcao)
        {
            case 1: //move para a direita
            {
                x = (x + velocidade) % 30;
                break;
            }

            case 2: //move para a esquerda
            {
                x = (x - velocidade);
                if(x == -1)
                    x = 29;
                else if(x == -2)
                    x = 28;
                else if(x == -3)
                    x = 27;
                break;
            }

            case 3: //move para baixo
            {
                y = (y + velocidade) % 60;
                break;
            }

            case 4: //move para cima
            {
                y = (y - velocidade);
                if(y == -1)
                    y = 59;
                else if(y == -2)
                    y = 58;
                else if(y == -3)
                    y = 57;
                break;
            }
        }
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public boolean getFabrica()
    {
        return fabrica;
    }

    public int getId()
    {
        return id;
    }

    protected int x, y, velocidade, id;
    protected boolean fabrica;
    protected String cor;
}
