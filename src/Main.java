import java.io.*;
import java.util.Scanner;

import javax.swing.text.html.StyleSheet;

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
                        System.out.println(arvoreBB.mediana());
                        break;
                    case "MEDIA":
                        System.out.println(arvoreBB.media());
                        break;
                    case "CHEIA":
                        System.out.println(arvoreBB.cheiaOuNaoCheia(arvoreBB.getRaiz()));
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
        comandosdeEntrada("C:\\Users\\vanessa.silva.700\\Desktop\\projetoedb2\\Projeto-ABB\\src\\arquivostxt\\abb", "C:\\Users\\vanessa.silva.700\\Desktop\\projetoedb2\\Projeto-ABB\\src\\arquivostxt\\arquivoEntrada");
    }
}