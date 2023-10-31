import java.util.ArrayList;
import java.util.List;

public class ArvoreBB {
	public static No raiz = null;
	public static int quantidadeDeNos = 0;
	List<No> arvore = new ArrayList<>();

	public void inserirNo(No noNovo, No noAtual) {
		if (noAtual == null) {
			noAtual = raiz;
		}

		if (noNovo.getValor() == noAtual.getValor()) {
			System.out.println(noNovo.getValor() + " já está na árvore, não pode ser inserido");
		} else if (noNovo.getValor()< noAtual.getValor()) {
			if (noAtual.getNoEsquerdo() != null) {
				inserirNo(noNovo, noAtual.getNoEsquerdo());
			} else {
				noAtual.setNoEsquerdo(noNovo);
				arvore.add(noNovo);
			}
		} else if (noNovo.getValor() > noAtual.getValor()) {
			 if(noAtual.getNoDireito() != null) {
				inserirNo(noNovo, noAtual.getNoDireito());
			 } else {
				noAtual.setNoDireito(noNovo);
				arvore.add(noNovo);
			 }
		}
	}

	private static void atualizarQuantidades(List<No> elementosFilhos, List<String> lado, String direcao) {
		for (int i = 0; i < elementosFilhos.size(); i++) {
			if (lado.get(i).equals(direcao)) {
				elementosFilhos.get(i).setQuantidadeDeNosAEsquerda(1);
			} else {
				elementosFilhos.get(i).setQuantidadeDeNosADireita(1);
			}
		}
	}

	public static int enesimoElemento(int enesimo) {
		if (raiz == null || enesimo <= 0 || enesimo > raiz.quantidadeTotalDeFilhos()) {
			System.out.println(raiz.quantidadeTotalDeFilhos());
			System.out.println("O 'n' excede o número de nós da árvore");
			return -1;
		}

		return enesimoElementoRecursivo(raiz, enesimo);
	}

	private static int enesimoElementoRecursivo(No no, int enesimo) {
		if (no.getNoEsquerdo() != null) {
			int qtdNosEsquerda = no.getNoEsquerdo().quantidadeTotalDeFilhos();
			if (qtdNosEsquerda + 1 == enesimo) {
				return no.getValor();
			} else if (qtdNosEsquerda + 1 > enesimo) {
				return enesimoElementoRecursivo(no.getNoEsquerdo(), enesimo);
			} else {
				return enesimoElementoRecursivo(no.getNoDireito(), enesimo - qtdNosEsquerda - 1);
			}
		} else {
			if (enesimo == 1) {
				return no.getValor();
			} else {
				return enesimoElementoRecursivo(no.getNoDireito(), enesimo - 1);
			}
		}
	}

	public static int mediana() {
		int nosTotais = raiz.quantidadeTotalDeFilhos();
		int valorMediana;

		if (nosTotais % 2 != 0) {
			int posicaoMediana = ((nosTotais + 1) / 2);
			valorMediana = enesimoElemento(posicaoMediana);
		} else {
			int posicaoMediana1 = nosTotais / 2;
			int posicaoMediana2 = nosTotais / 2 + 1;
			int valor1 = enesimoElemento(posicaoMediana1);
			int valor2 = enesimoElemento(posicaoMediana2);
			valorMediana = (valor1 + valor2) / 2;
		}
		return valorMediana;
	}

	public static int media() {
		int nosTotais = raiz.quantidadeTotalDeFilhos();
		int soma = calcularSoma(raiz);

		if (nosTotais > 0) {
			int valorMedia = soma / nosTotais;
			return valorMedia;
		} else {
			return 0;
		}
	}

	private static int calcularSoma(No no) {
		if (no == null) {
			return 0;
		}

		int somaEsquerda = calcularSoma(no.getNoEsquerdo());
		int somaDireita = calcularSoma(no.getNoDireito());

		return somaEsquerda + no.getValor() + somaDireita;
	}

	public static String cheiaOuNaoCheia(No raiz) {
		if (raiz == null) {
			return "A árvore é cheia";
		}

		if (raiz.getNoEsquerdo() == null && raiz.getNoDireito() == null) {
			return "A árvore é cheia";
		}

		if ((raiz.getNoEsquerdo() != null) && (raiz.getNoDireito() != null)) {
			String resultadoEsquerdo = cheiaOuNaoCheia(raiz.getNoEsquerdo());
			String resultadoDireito = cheiaOuNaoCheia(raiz.getNoDireito());

			if (resultadoEsquerdo.equals("A árvore é cheia") && resultadoDireito.equals("A árvore é cheia")) {
				return "A árvore é cheia";
			}
		}

		return "A árvore não é cheia";
	}
    
	public void imprimirArvore() {
		for(No no: arvore) {
			System.out.println(no.getValor());
		}
	}
}
