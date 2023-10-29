import java.io.*;
import java.util.Scanner;

public class Main {
    public static void arvoreEntrada(String caminhoArquivo) {
        try {
            Scanner sc = new Scanner(new File(caminhoArquivo));
            sc.useDelimiter(" ");

            while (sc.hasNext()) {
                int linha = Integer.parseInt(sc.next());
                ArvoreBB.inserir(new No(linha));
            }

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
        arvoreEntrada("C:\\Users\\bianc\\OneDrive\\Documentos\\GitHub\\Projeto EDB\\src\\arquivostxt\\abb");
        comandosdeEntrada("C:\\Users\\bianc\\OneDrive\\Documentos\\GitHub\\Projeto EDB\\src\\arquivostxt\\arquivoEntrada");

    }
}


