import java.util.ArrayList;

public class Main
{
    public static void main (String argv[])
    {
        Mundo meuMundo = new Mundo();

        ArrayList <Carro> carros = new ArrayList<>();
        ArrayList <Caminhao> caminhoes = new ArrayList<>();
        ArrayList <Moto> motos = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            carros.add(new Carro());
            caminhoes.add(new Caminhao());
            motos.add(new Moto());
        }

        while (true)
        {
            Colisoes detectorDeColisao = new Colisoes();

            int i;

            System.out.printf( "\33[0m Caminhoes(cinza) = %d | Carros(azul) = %d | Motos(marrom) = %d                    \n",
                    caminhoes.size() ,carros.size(), motos.size());

            //detecta colisoes entre caminhoes e outros veiculos e os exclui seguindo as regras de colisao.
            for(i = 0; i < caminhoes.size(); i++)
            {
                int x = caminhoes.get(i).getX();
                int y = caminhoes.get(i).getY();

                if(detectorDeColisao.getTipo(x, y).equals("empty"))
                {
                    detectorDeColisao.ocupado(x, y, "caminhao", i);
                }
                else
                {
                    if(detectorDeColisao.getTipo(x, y).equals("caminhao"))
                    {
                        caminhoes.remove(i);
                        detectorDeColisao.ajusta("caminhao", i);
                        caminhoes.remove(detectorDeColisao.getIndice(x, y));
                        detectorDeColisao.ajusta("caminhao", detectorDeColisao.getIndice(x, y));
                        detectorDeColisao.restaura(x, y);
                        i=0;
                    }
                    else if(detectorDeColisao.getTipo(x, y).equals("carro"))
                    {
                        carros.remove(detectorDeColisao.getIndice(x, y));
                        detectorDeColisao.ocupado(x, y, "caminhao", i);
                    }

                    else if(detectorDeColisao.getTipo(x, y).equals("moto"))
                    {
                        motos.remove(detectorDeColisao.getIndice(x, y));
                        detectorDeColisao.ocupado(x, y, "caminhao", i);
                    }
                }
            }

            //detecta colisoes entre carros e outros veiculos e os exclui seguindo as regras de colisao.
            for(i = 0; i < carros.size(); i++)
            {
                int x = carros.get(i).getX();
                int y = carros.get(i).getY();

                if(detectorDeColisao.getTipo(x, y).equals("empty"))
                {
                    detectorDeColisao.ocupado(x, y, "carro", i);
                }
                else
                {
                    if(detectorDeColisao.getTipo(x, y).equals("caminhao"))
                    {
                        carros.remove(i);
                        detectorDeColisao.ajusta("carro", i);
                        i=0;
                    }
                    else if(detectorDeColisao.getTipo(x, y).equals("carro"))
                    {
                        carros.remove(i);
                        detectorDeColisao.ajusta("carro", i);
                        carros.remove(detectorDeColisao.getIndice(x, y));
                        detectorDeColisao.ajusta("carro", detectorDeColisao.getIndice(x, y));
                        detectorDeColisao.restaura(x, y);
                        i=0;
                    }

                    else if(detectorDeColisao.getTipo(x, y).equals("moto"))
                    {
                        motos.remove(detectorDeColisao.getIndice(x, y));
                        detectorDeColisao.ocupado(x, y, "carro", i);
                    }
                }
            }

            //detecta colisoes entre motos e outros veiculos e os exclui seguindo as regras de colisao.
            for(i = 0; i < motos.size(); i++)
            {
                int x = motos.get(i).getX();
                int y = motos.get(i).getY();

                if(detectorDeColisao.getTipo(x, y).equals("empty"))
                {
                    detectorDeColisao.ocupado(x, y, "moto", i);
                }
                else
                {
                    if(detectorDeColisao.getTipo(x, y).equals("caminhao"))
                    {
                        motos.remove(i);
                        detectorDeColisao.ajusta("moto", i);
                        i=0;
                    }
                    else if(detectorDeColisao.getTipo(x, y).equals("carro"))
                    {
                        motos.remove(i);
                        detectorDeColisao.ajusta("moto", i);
                        i=0;
                    }

                    else if(detectorDeColisao.getTipo(x, y).equals("moto"))
                    {
                        motos.remove(i);
                        detectorDeColisao.ajusta("moto", i);
                        motos.remove(detectorDeColisao.getIndice(x, y));
                        detectorDeColisao.ajusta("moto", detectorDeColisao.getIndice(x, y));
                        detectorDeColisao.restaura(x, y);
                        i=0;
                    }
                }
            }

            int contadorDeNovos;

            // popula o mundo de caminhoes, conta quantos novos devem ser criados e move os existentes
            contadorDeNovos = 0;
            for (i = 0; i < caminhoes.size(); i++)
            {
                meuMundo.insereNoMundo(caminhoes.get(i).getX(), caminhoes.get(i).getY(), 5);
                caminhoes.get(i).move();

                if (meuMundo.getLocalizacao(caminhoes.get(i).getX(), caminhoes.get(i).getY()) == 2)
                {
                    if (!caminhoes.get(i).getFabrica())
                    {
                        caminhoes.get(i).dentroDaFabrica();
                        contadorDeNovos++;
                    }
                }
                else
                    caminhoes.get(i).foraDaFabrica();
            }

            // cria os novos caminhoes
            for (i=0; i < contadorDeNovos; i++)
            {
                caminhoes.add(new Caminhao());
            }

            // popula o mundo de carros, conta quantos novos devem ser criados e move os existentes
            contadorDeNovos = 0;
            for(i = 0; i < carros.size(); i++)
            {
                meuMundo.insereNoMundo(carros.get(i).getX(), carros.get(i).getY(), 4);
                carros.get(i).move();

                if (meuMundo.getLocalizacao(carros.get(i).getX(), carros.get(i).getY()) == 2)
                {
                    if (!carros.get(i).getFabrica())
                    {
                        carros.get(i).dentroDaFabrica();
                        contadorDeNovos++;
                    }
                }
                else
                    carros.get(i).foraDaFabrica();
            }

            // cria os novos carros
            for (i=0; i < contadorDeNovos; i++)
            {
                carros.add(new Carro());
            }

            // popula o mundo de motos, conta quantos novos devem ser criados e move os existentes
            contadorDeNovos = 0;
            for(i = 0; i < motos.size(); i++)
            {
                meuMundo.insereNoMundo(motos.get(i).getX(), motos.get(i).getY(), 3);
                motos.get(i).move();

                if (meuMundo.getLocalizacao(motos.get(i).getX(), motos.get(i).getY()) == 2)
                {
                    if (!motos.get(i).getFabrica())
                    {
                        motos.get(i).dentroDaFabrica();
                        contadorDeNovos++;
                    }
                }
                else
                    motos.get(i).foraDaFabrica();
            }

            // cria as novas motos
            for (i=0; i < contadorDeNovos; i++)
            {
                motos.add(new Moto());
            }

            meuMundo.desenhaMundo();
            meuMundo.pausaMundo();
            meuMundo.voltaComeco();
            meuMundo.reiniciaMundo();

        }

    }
}
