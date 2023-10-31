import java.io.*;
import java.util.Scanner;

import javax.swing.text.html.StyleSheet;

public class Main {
    public static void arvoreEntrada(String caminhoArquivo) {
        ArvoreBB arvoreBB = new ArvoreBB();
        try {
            Scanner sc = new Scanner(new File(caminhoArquivo));
            sc.useDelimiter(" ");
            No no = new No(Integer.parseInt(sc.next()));

            while (sc.hasNext()) {
                int linha = Integer.parseInt(sc.next());
                arvoreBB.inserirNo(new No(linha), no);
            }

            arvoreBB.imprimirArvore();

            System.out.println(no.getValor());

            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("O arquivo não foi encontrado: " + caminhoArquivo);
        }
    }

   public static void comandosdeEntrada(String caminhoArquivo) {
        try {
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
                        System.out.println(ArvoreBB.enesimoElemento(Integer.parseInt(entrada[1])));
                        break;
                    case "MEDIANA":
                        System.out.println(ArvoreBB.mediana());
                        break;
                    case "MEDIA":
                        System.out.println(ArvoreBB.media());
                        break;
                    case "CHEIA":
                        System.out.println(ArvoreBB.cheiaOuNaoCheia(ArvoreBB.raiz));
                        break;
                    default:
                        break;
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("O arquivo não foi encontrado: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Ocorreu um erro de leitura do arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        arvoreEntrada("C:\\Users\\v_mar\\Desktop\\ProjetoABB\\Projeto-ABB\\src\\arquivostxt\\abb");
        comandosdeEntrada("C:\\Users\\v_mar\\Desktop\\ProjetoABB\\Projeto-ABB\\src\\arquivostxt\\abb");

    }
}


