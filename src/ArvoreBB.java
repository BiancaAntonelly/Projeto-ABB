public class ArvoreBB {
	private No raiz = null;
	private int quantidadeDeNos = 0;

	public ArvoreBB (No raiz){
		this.raiz = raiz;
	}

	public No getRaiz (){
		return raiz;
	}

	public void inserirNo(No noNovo, No noAtual) {
			if (noNovo.getValor() == noAtual.getValor()) {
				System.out.println(noNovo.getValor() + " já está na árvore, não pode ser inserido");
			} else if (noNovo.getValor()< noAtual.getValor()) {
				if (noAtual.getNoEsquerdo() != null) {
					inserirNo(noNovo, noAtual.getNoEsquerdo());
				} else {
					noAtual.setNoEsquerdo(noNovo);
					noAtual.setQuantidadeDeNosAEsquerda(noAtual.getQuantidadeDeNosAEsquerda() + 1);
				}
			} else if (noNovo.getValor() > noAtual.getValor()) {
				if(noAtual.getNoDireito() != null) {
					inserirNo(noNovo, noAtual.getNoDireito());
				} else {
					noAtual.setNoDireito(noNovo);
					noAtual.setQuantidadeDeNosADireita(noAtual.getQuantidadeDeNosADireita() + 1);
				}
			}
	}

	public No buscaNo(int valor, No noAtual) {
		 if (valor == noAtual.getValor()){
          return noAtual;
        } 

		if(valor < noAtual.getValor()) {
			if(noAtual.getNoEsquerdo() != null) {
				return buscaNo(valor, noAtual.getNoEsquerdo());
			}
			return null;
		} else {
			if(noAtual.getNoDireito() != null) {
				return buscaNo(valor, noAtual.getNoDireito());
			}
			return null;
		}
	}

	public void imprimirArvore(No no) {
		if (no.getNoEsquerdo() != null) {
			imprimirArvore(no.getNoEsquerdo());
		} 

		if (no.getNoDireito() != null) {
			imprimirArvore(no.getNoDireito());
		}

		System.out.println("Nó: "+ no.getValor());
	}

	public int enesimoElemento(int enesimo) {
		if (raiz == null || enesimo <= 0 || enesimo > raiz.quantidadeTotalDeFilhos()) {
			System.out.println(raiz.quantidadeTotalDeFilhos());
			System.out.println("O 'n' excede o número de nós da árvore");
			return -1;
		}

		return enesimoElementoRecursivo(raiz, enesimo);
	}

	private int enesimoElementoRecursivo(No no, int enesimo) {
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

	public int mediana() {
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

	public int media() {
		int nosTotais = raiz.quantidadeTotalDeFilhos();
		int soma = calcularSoma(raiz);

		if (nosTotais > 0) {
			int valorMedia = soma / nosTotais;
			return valorMedia;
		} else {
			return 0;
		}
	}

	private int calcularSoma(No no) {
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

	public String preOrdem(No no) {
		String resultado = "";
		
		if(no != null){
			resultado += " " + Integer.toString(no.getValor());
			
			if(no.getNoEsquerdo() != null) {
				resultado += preOrdem(no.getNoEsquerdo());
			}

			if (no.getNoDireito() != null) {
			 	resultado += preOrdem(no.getNoDireito());
			}
		} 
		
		return resultado;
	}
}
