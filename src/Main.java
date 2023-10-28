import java.io.File;
import java.io.FileNotFoundException;
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
    public static void main(String[] args) {
        arvoreEntrada("C:\\Users\\bianc\\OneDrive\\Documentos\\GitHub\\Projeto EDB\\src\\arquivostxt\\abb");
    }
}


