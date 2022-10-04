import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Teste {
    public static void gravaArquivoCsv(ListaObj<Musico> lista,
                                       String nomeArq) {
        FileWriter arq = null; //objeto que representa o arquivo de gravação
        Formatter saida = null; //objeto usado para gravar no arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv"; //Acrescenta a extensão .csv ao nome do arquivo

        //Bloco para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq); // cria ou abre o arquivo
            saida = new Formatter(arq);
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Musico m = lista.getElemento(i);
                saida.format("%d;%s;%s;%.2f;%.2f\n",m.getId(),m.getNome(),m.getEstiloMusical(),m.getHorasTocadas(),m.getValorHoraTocada());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao tentar gravar arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try{
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null; //objeto que representa o arquivo de ler
        Scanner entrada = null;//objeto usado para ler o arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        //Bloco para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }
        //Bloco para ler o arquivo
        try {
            System.out.printf("%-6s %-14s %10s %-7s %-6s \n", "IDENTIFICADOR", "NOME", "ESTILO MUSICAL", "HORAS TOCADAS", "VALOR HORAS TOCADAS");
            while (entrada.hasNext()) {
                int id = entrada.nextInt();
                String nome = entrada.next();
                String estiloMusical = entrada.next();
                Double horasTocadas = entrada.nextDouble();
                Double valorHoraTocada = entrada.nextDouble();
                System.out.printf("%06d %13s %12s %23.2f %19.2f \n", id, nome, estiloMusical, horasTocadas, valorHoraTocada);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try{
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        Integer opcao = 0;
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNl = new Scanner(System.in);
        System.out.println("Bem vindo ao spotify!");


        ListaObj<Musico> musicoListaObj = new ListaObj<>(10);

        do {
            System.out.println("Escolha a opção desejada: (Digite 1, 2 ou 3)");
            System.out.println("1 - Adicionar um Músico");
            System.out.println("2 - Exibir Músicos cadastrados");
            System.out.println("3 - Sair");
            System.out.println("4 - Gravar CSV");
            System.out.println("5 - Ler CSV");
            opcao = leitor.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite o identificador:");
                    int id = leitor.nextInt();

                    System.out.println("Digite o nome:");
                    String nome = leitorNl.nextLine();

                    System.out.println("Digite o estilo musical dele:");
                    String estiloMusical = leitorNl.nextLine();

                    System.out.println("Digite a quantidade de horas que ele tocou:");
                    Double horasTocadas = leitor.nextDouble();

                    System.out.println("Digite o valor da hora tocada do músico:");
                    Double valorHoraTocada = leitor.nextDouble();


                    musicoListaObj.adiciona(new Musico(id,nome,estiloMusical,horasTocadas, valorHoraTocada));

                    System.out.println("Músico Adicionado!");
                    break;
                case 2:
                    System.out.println("");
                    System.out.printf("%-6s %-14s %10s %-7s %-6s \n", "IDENTIFICADOR", "NOME", "ESTILO MUSICAL", "HORAS TOCADAS", "VALOR HORAS TOCADAS");
                    for (int i = 0; i < musicoListaObj.getTamanho(); i++){
                        Musico m = musicoListaObj.getElemento(i);
                        System.out.printf("%06d %13s %12s %23.2f %19.2f\n", m.getId(),m.getNome(), m.getEstiloMusical(), m.getHorasTocadas(), m.getValorHoraTocada());
                    }
                    System.out.printf("");
                    break;
                case 3:
                    System.out.println("Obrigada por utilizar :)");
                    break;
                case 4:
                    System.out.println("Músicos cadastrados no arquivo");
                    gravaArquivoCsv(musicoListaObj, "musico");
                    break;
                case 5:
                    leExibeArquivoCsv("musico");
                    break;
                default:
                    System.out.println("Opção digitada inválida");
                    break;


        }
    } while (opcao != 3);
}}
