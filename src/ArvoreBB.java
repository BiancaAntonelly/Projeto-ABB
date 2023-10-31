import java.util.LinkedList;
import java.util.List;

public class ArvoreBB {

	public static No raiz = null;
	public static int quantidadeDeNos = 0;

	public static boolean inserir(No no) {
		if (raiz == null) {
			raiz = no;
			quantidadeDeNos++;
			System.out.println(no.valor + " adicionado");
			return true;
		}

		No atual = raiz;
		List<No> elementosFilhos = new LinkedList<>();
		List<String> lado = new LinkedList<>();

		while (true) {
			if (no.valor == atual.valor) {
				System.out.println(no.valor + " já está na árvore, não pode ser inserido");
				return false;
			} else if (no.valor < atual.valor) {
				lado.add("esquerdo");
				elementosFilhos.add(atual);
				if (atual.noEsquerdo == null) {
					atual.noEsquerdo = no;
					quantidadeDeNos++;
					System.out.println(no.valor + " adicionado");
					atualizarQuantidades(elementosFilhos, lado, "esquerdo");
					return true;
				} else {
					atual = atual.noEsquerdo;
				}
			} else {
				lado.add("direito");
				elementosFilhos.add(atual);
				if (atual.noDireito == null) {
					atual.noDireito = no;
					quantidadeDeNos++;
					System.out.println(no.valor + " adicionado");
					atualizarQuantidades(elementosFilhos, lado, "direito");
					return true;
				} else {
					atual = atual.noDireito;
				}
			}
		}
	}

	private static void atualizarQuantidades(List<No> elementosFilhos, List<String> lado, String direcao) {
		for (int i = 0; i < elementosFilhos.size(); i++) {
			if (lado.get(i).equals(direcao)) {
				elementosFilhos.get(i).quantidadeDeNosAEsquerda++;
			} else {
				elementosFilhos.get(i).quantidadeDeNosADireita++;
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
		if (no.noEsquerdo != null) {
			int qtdNosEsquerda = no.noEsquerdo.quantidadeTotalDeFilhos();
			if (qtdNosEsquerda + 1 == enesimo) {
				return no.valor;
			} else if (qtdNosEsquerda + 1 > enesimo) {
				return enesimoElementoRecursivo(no.noEsquerdo, enesimo);
			} else {
				return enesimoElementoRecursivo(no.noDireito, enesimo - qtdNosEsquerda - 1);
			}
		} else {
			if (enesimo == 1) {
				return no.valor;
			} else {
				return enesimoElementoRecursivo(no.noDireito, enesimo - 1);
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

		int somaEsquerda = calcularSoma(no.noEsquerdo);
		int somaDireita = calcularSoma(no.noDireito);

		return somaEsquerda + no.valor + somaDireita;
	}

	public static String cheiaOuNaoCheia(No raiz) {
		if (raiz == null) {
			return "A árvore é cheia";
		}

		if (raiz.noEsquerdo == null && raiz.noDireito == null) {
			return "A árvore é cheia";
		}

		if ((raiz.noEsquerdo != null) && (raiz.noDireito != null)) {
			String resultadoEsquerdo = cheiaOuNaoCheia(raiz.noEsquerdo);
			String resultadoDireito = cheiaOuNaoCheia(raiz.noDireito);

			if (resultadoEsquerdo.equals("A árvore é cheia") && resultadoDireito.equals("A árvore é cheia")) {
				return "A árvore é cheia";
			}
		}

		return "A árvore não é cheia";
	}


}

