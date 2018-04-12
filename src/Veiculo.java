public class Veiculo
{
    public Veiculo(int velocidade, String cor) //construtor padrão
    {
        this.cor = cor; //define a cor
        this.velocidade = velocidade; //define a velocidade
        Aleatorio random = new Aleatorio(); //cria um objeto aleatorio
        x = random.randomize30(); //randomiza a posição X
        y = random.randomize60(); //randomiza a posição Y
        foraDaFabrica(); // define o objeto como fora da fabrica
        id = random.randomizeID(); //cria um ID aleatório
    }

    public void dentroDaFabrica() //define o objeto como dentro da fabrica
    {
        fabrica = true;
    }

    public void foraDaFabrica() //define o objeto como fora da fabrica
    {
        fabrica = false;
    }

    public void move() //move o objeto para uma direção aleatória (direita, esquerda, cima ou baixo), respeitando sua velocidade
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

    public int getX() //volta a posição X
    {
        return x;
    }

    public int getY() //volta a posição Y
    {
        return y;
    }

    public boolean getFabrica() //volta o boleano fabrica (true para dentro e false para fora)
    {
        return fabrica;
    }

    public int getId() //volta a ID do objeto
    {
        return id;
    }

    protected int x, y, velocidade, id;
    protected boolean fabrica;
    protected String cor;
}
