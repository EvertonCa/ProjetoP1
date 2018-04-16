import java.util.ArrayList;

public class Main
{
    public static void main (String argv[])
    {
        Mundo meuMundo = new Mundo(); //cria o objeto mundo

        ArrayList <Carro> carros = new ArrayList<>(); //novo vetor dinâmico para armazenar os carros
        ArrayList <Caminhao> caminhoes = new ArrayList<>(); //novo vetor dinâmico para armazenar os caminhões
        ArrayList <Moto> motos = new ArrayList<>(); //novo vetor dinâmico para armazenar as motos

        //vetor que salva a quantidade de objetos apagados. Slot 0 = caminhoes, slot 1 = carros, slot 2 = motos
        int apagados[] = {0, 0, 0};
        int criados[] = {10, 10, 10};

        for (int i = 0; i < 10; i++) //cria 10 carros, caminhões e motos
        {
            carros.add(new Carro());
            caminhoes.add(new Caminhao());
            motos.add(new Moto());
        }

        while (true) //loop infinito
        {
            Colisoes detectorDeColisao = new Colisoes(); //cria um novo objeto detector de colisões
            ArrayList <Integer>  vetorIDs = new ArrayList<>(); //cria um novo vetor dinâmico para armazenar as IDs a serem apagadas

            int i;

            //imprime a quantidade de caminhões, carros e motos no mundo atualmente
            System.out.printf("|----------------------------------------------------------|\n");
            System.out.printf("|                VEICULOS ATUALMENTE NO MAPA               |\n");
            System.out.printf("| Caminhoes \33[7;37m  \33[0m  = %d | Carros \33[7;34m  \33[0m  = %d | " +
                            "Motos \33[7;33m  \33[0m  = %d                    \n",caminhoes.size() ,carros.size(), motos.size());
            System.out.printf("|----------------------------------------------------------|\n");

            //detecta colisões entre caminhões e outros veiculos e armazena os IDS dos objetos a serem apagados.
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

            //detecta colisões entre carros e outros veiculos e armazena os IDS dos objetos a serem apagados.
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

            //detecta colisões entre motos e outros veiculos e armazena os IDS dos objetos a serem apagados.
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

            //apaga todos os objetos com as IDs salvas na lista de colisões
            while (!vetorIDs.isEmpty())
            {
                int idParaBuscar = vetorIDs.get(0);

                for(i = 0; i < motos.size(); i++)
                {
                    if (motos.get(i).getId() == idParaBuscar)
                    {
                        motos.remove(i);
                        vetorIDs.remove(0);
                        apagados[2]++;
                        break;
                    }
                }

                for(i = 0; i < carros.size(); i++)
                {
                    if (carros.get(i).getId() == idParaBuscar)
                    {
                        carros.remove(i);
                        vetorIDs.remove(0);
                        apagados[1]++;
                        break;
                    }
                }

                for(i = 0; i < caminhoes.size(); i++)
                {
                    if (caminhoes.get(i).getId() == idParaBuscar)
                    {
                        caminhoes.remove(i);
                        vetorIDs.remove(0);
                        apagados[0]++;
                        break;
                    }
                }
            }

            int contadorDeNovos;

            // popula o mundo de caminhões, conta quantos novos devem ser criados e move os existentes
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

            // cria os novos caminhões
            for (i=0; i < contadorDeNovos; i++)
            {
                caminhoes.add(new Caminhao());
                criados[0]++;
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
                criados[1]++;
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
                criados[2]++;
            }

            meuMundo.desenhaMundo(); //desenha o mundo no console

            System.out.printf("|----------------------------------------------------------|\n");
            System.out.printf("|                    Veiculos APAGADOS                     |\n");
            System.out.printf("|      Caminhoes = %d | Carros = %d | Motos = %d                \n",
                    apagados[0] ,apagados[1], apagados[2]);
            System.out.printf("|                    Veiculos CRIADOS                      |\n");
            System.out.printf("|      Caminhoes = %d | Carros = %d | Motos = %d                \n",
                    criados[0] ,criados[1], criados[2]);
            System.out.printf("|----------------------------------------------------------|\n");

            meuMundo.pausaMundo(); //pausa o console pelo tempo determinado
            meuMundo.voltaComeco(); //volta o cursor para o começo do console
            meuMundo.reiniciaMundo(); //reinicia a matriz do mundo.

        }

    }
}
