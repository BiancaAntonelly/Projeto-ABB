public class No {
	private int valor;
	private No noEsquerdo;
	private No noDireito;
	private Integer raiz = 1;
	private Integer quantidadeDeNosAEsquerda = 0;
	private Integer quantidadeDeNosADireita = 0;

	public Integer quantidadeTotalDeFilhos() {
		return quantidadeDeNosADireita + quantidadeDeNosAEsquerda + raiz;
	}

	No() {
	}

	No(int valor) {
		this.valor = valor;
		this.noEsquerdo = null;
		this.noDireito = null;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public No getNoEsquerdo() {
		return noEsquerdo;
	}

	public void setNoEsquerdo(No noEsquerdo) {
		this.noEsquerdo = noEsquerdo;
	}

	public No getNoDireito() {
		return noDireito;
	}

	public void setNoDireito(No noDireito) {
		this.noDireito = noDireito;
	}

	public Integer getRaiz() {
		return raiz;
	}

	public void setRaiz(Integer raiz) {
		this.raiz = raiz;
	}

	public Integer getQuantidadeDeNosAEsquerda() {
		return quantidadeDeNosAEsquerda;
	}

	public void setQuantidadeDeNosAEsquerda(Integer quantidadeDeNosAEsquerda) {
		this.quantidadeDeNosAEsquerda = quantidadeDeNosAEsquerda;
	}

	public Integer getQuantidadeDeNosADireita() {
		return quantidadeDeNosADireita;
	}

	public void setQuantidadeDeNosADireita(Integer quantidadeDeNosADireita) {
		this.quantidadeDeNosADireita = quantidadeDeNosADireita;
	}
}
