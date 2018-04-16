public class Veiculo
{
    ///construtor padrão
    public Veiculo(int velocidade, String cor)
    {
        ///define a cor
        this.cor = cor;
        ///define a velocidade
        this.velocidade = velocidade;
        ///cria um objeto aleatorio
        Aleatorio random = new Aleatorio();
        ///randomiza a posição X
        x = random.randomize30();
        ///randomiza a posição Y
        y = random.randomize60();
        ///define o objeto como fora da fabrica
        foraDaFabrica();
        ///cria um ID aleatório
        id = random.randomizeID();
    }

    ///define o objeto como dentro da fabrica
    public void dentroDaFabrica()
    {
        fabrica = true;
    }

    ///define o objeto como fora da fabrica
    public void foraDaFabrica()
    {
        fabrica = false;
    }

    ///move o objeto para uma direção aleatória (direita, esquerda, cima ou baixo), respeitando sua velocidade
    public void move()
    {
        Aleatorio random = new Aleatorio();
        int direcao = random.randomizeDirecao();

        switch (direcao)
        {
            ///move para a direita
            case 1:
            {
                x = (x + velocidade) % 30;
                break;
            }

            ///move para a esquerda
            case 2:
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

            ///move para baixo
            case 3:
            {
                y = (y + velocidade) % 60;
                break;
            }

            ///move para cima
            case 4:
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

    ///volta a posição X
    public int getX()
    {
        return x;
    }

    ///volta a posição Y
    public int getY()
    {
        return y;
    }

    ///volta o boleano fabrica (true para dentro e false para fora)
    public boolean getFabrica()
    {
        return fabrica;
    }

    ///volta a ID do objeto
    public int getId()
    {
        return id;
    }

    protected int x, y, velocidade, id;
    protected boolean fabrica;
    protected String cor;
}
