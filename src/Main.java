import java.io.*;
import java.util.Scanner;

public class Main {
    public static void comandosdeEntrada(String abbEntrada, String caminhoArquivo) {
        try {
            Scanner sc = new Scanner(new File(abbEntrada));
            sc.useDelimiter(" ");
            No no = new No(Integer.parseInt(sc.next()));
            ArvoreBB arvoreBB = new ArvoreBB(no);

            while (sc.hasNext()) {
                int linha = Integer.parseInt(sc.next());
                arvoreBB.inserirNo(new No(linha), no);
            }
            sc.close();

            File comandos = new File(caminhoArquivo);
            FileReader leitura = new FileReader(comandos);
            BufferedReader bufferedReader = new BufferedReader(leitura);
            String linha = "";

            while ((linha = bufferedReader.readLine()) != null) {
                String[] entrada = new String[2];
                entrada[0] = linha;
                if (linha.contains(" ")) {
                    entrada = linha.split(" ");
                }
                switch (entrada[0]) {
                    case "ENESIMO":
                        System.out.println(arvoreBB.enesimoElemento(Integer.parseInt(entrada[1])));
                        break;
                    case "MEDIANA":
                        System.out.println("Mediana: " + arvoreBB.mediana());
                        break;
                    case "MEDIA":
                        System.out.println(arvoreBB.media());
                        break;
                    case "CHEIA":
                        System.out.println(arvoreBB.cheiaOuNaoCheia(arvoreBB.getRaiz()));
                        break;
                    case "COMPLETA": 
                        System.out.println(arvoreBB.ehCompleta(arvoreBB.getRaiz()));
                        break;
                    case "PREORDEM": 
                        System.out.println(arvoreBB.preOrdem(arvoreBB.getRaiz()));
                        break;
                    case "INSIRA":
                        arvoreBB.inserirNo(new No(Integer.parseInt(entrada[1])), no);
                        break;
                    case "BUSCAR":
                        No k = arvoreBB.buscaNo(Integer.parseInt(entrada[1]), no);
                        if(k != null) {
                            System.out.println("O nó com valor "+ k.getValor() + " existe na árvore");
                        } else {
                             System.out.println("O nó não existe na árvore");
                        }
                        break;
                    case "REMOVA":
                       arvoreBB.remover(Integer.parseInt(entrada[1]), arvoreBB.getRaiz());
                       break;
                    case "IMPRIMA":
                        if (entrada[1].equals("1")) {
                            ArvoreBB.imprimirBarras(arvoreBB.getRaiz(), 25, 0);
                        } else if (entrada[1].equals("2")) {
                            System.out.println(ArvoreBB.imprimirParenteses(arvoreBB.getRaiz()));
                        }
                        break;
                    case "POSICAO":
                        ArvoreBB.posicao(arvoreBB.getRaiz(), Integer.parseInt(entrada[1]));
                        break;
                    default:
                        break;
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("O arquivo de entrada de dados não foi encontrado");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro de leitura do arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        comandosdeEntrada("C:\\Users\\v_mar\\Desktop\\projetoedb\\Projeto-ABB\\src\\arquivostxt\\abb",
                "C:\\Users\\v_mar\\Desktop\\projetoedb\\Projeto-ABB\\src\\arquivostxt\\arquivoEntrada");
    }
}