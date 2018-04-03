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
            ArrayList <Integer>  vetorIDs = new ArrayList<>();

            int i;

            System.out.printf( "\33[0m Caminhoes(cinza) = %d | Carros(azul) = %d | Motos(marrom) = %d                    \n",
                    caminhoes.size() ,carros.size(), motos.size());

            //detecta colisoes entre caminhoes e outros veiculos e armazena os IDS.
            for(i = 0; i < caminhoes.size(); i++)
            {
                int x = caminhoes.get(i).getX();
                int y = caminhoes.get(i).getY();
                int ID = caminhoes.get(i).getId();

                if(detectorDeColisao.getTipo(x, y).equals("empty"))
                {
                    detectorDeColisao.ocupado(x, y, "caminhao", ID);
                }
                else
                {
                    if(detectorDeColisao.getTipo(x, y).equals("caminhao"))
                    {
                        vetorIDs.add(detectorDeColisao.getID(x,y));
                        vetorIDs.add(ID);
                        detectorDeColisao.restaura(x,y);
                    }
                    else if(detectorDeColisao.getTipo(x, y).equals("carro"))
                    {
                        vetorIDs.add(detectorDeColisao.getID(x,y));
                        detectorDeColisao.ocupado(x, y, "caminhao", ID);
                    }

                    else if(detectorDeColisao.getTipo(x, y).equals("moto"))
                    {
                        vetorIDs.add(detectorDeColisao.getID(x,y));
                        detectorDeColisao.ocupado(x, y, "caminhao", ID);
                    }
                }
            }

            //detecta colisoes entre carros e outros veiculos e armazena os IDS.
            for(i = 0; i < carros.size(); i++)
            {
                int x = carros.get(i).getX();
                int y = carros.get(i).getY();
                int ID = carros.get(i).getId();

                if(detectorDeColisao.getTipo(x, y).equals("empty"))
                {
                    detectorDeColisao.ocupado(x, y, "carro", ID);
                }
                else
                {
                    if(detectorDeColisao.getTipo(x, y).equals("caminhao"))
                    {
                        vetorIDs.add(ID);
                    }
                    else if(detectorDeColisao.getTipo(x, y).equals("carro"))
                    {
                        vetorIDs.add(detectorDeColisao.getID(x,y));
                        vetorIDs.add(ID);
                        detectorDeColisao.restaura(x,y);
                    }

                    else if(detectorDeColisao.getTipo(x, y).equals("moto"))
                    {
                        vetorIDs.add(detectorDeColisao.getID(x,y));
                        detectorDeColisao.ocupado(x, y, "carro", i);
                    }
                }
            }

            //detecta colisoes entre motos e outros veiculos e armazena os IDS.
            for(i = 0; i < motos.size(); i++)
            {
                int x = motos.get(i).getX();
                int y = motos.get(i).getY();
                int ID = motos.get(i).getId();

                if(detectorDeColisao.getTipo(x, y).equals("empty"))
                {
                    detectorDeColisao.ocupado(x, y, "moto", ID);
                }
                else
                {
                    if(detectorDeColisao.getTipo(x, y).equals("caminhao"))
                    {
                        vetorIDs.add(ID);
                    }
                    else if(detectorDeColisao.getTipo(x, y).equals("carro"))
                    {
                        vetorIDs.add(ID);
                    }

                    else if(detectorDeColisao.getTipo(x, y).equals("moto"))
                    {
                        vetorIDs.add(detectorDeColisao.getID(x,y));
                        vetorIDs.add(ID);
                        detectorDeColisao.restaura(x,y);
                    }
                }
            }

            //apaga todos os objetos com os IDs salvos na lista de colisoes
            while (!vetorIDs.isEmpty())
            {
                int idParaBuscar = vetorIDs.get(0);

                for(i = 0; i < motos.size(); i++)
                {
                    if (motos.get(i).getId() == idParaBuscar)
                    {
                        motos.remove(i);
                        vetorIDs.remove(0);
                        break;
                    }
                }

                for(i = 0; i < carros.size(); i++)
                {
                    if (carros.get(i).getId() == idParaBuscar)
                    {
                        carros.remove(i);
                        vetorIDs.remove(0);
                        break;
                    }
                }

                for(i = 0; i < caminhoes.size(); i++)
                {
                    if (caminhoes.get(i).getId() == idParaBuscar)
                    {
                        caminhoes.remove(i);
                        vetorIDs.remove(0);
                        break;
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

            meuMundo.desenhaMundo(); //desenha o mundo no console
            meuMundo.pausaMundo(); //pausa o console pelo tempo determinado
            meuMundo.voltaComeco(); //volta o cursor para o começo do console
            meuMundo.reiniciaMundo(); //reinicia a matriz do mundo.

        }

    }
}
