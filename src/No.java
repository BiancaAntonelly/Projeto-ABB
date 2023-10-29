public class No {
	public int valor;
	public No noEsquerdo;
	public No noDireito;
	public Integer raiz = 1;
	public Integer quantidadeDeNosAEsquerda = 0;
	public Integer quantidadeDeNosADireita = 0;

	public Integer quantidadeTotalDeFilhos() {
		return quantidadeDeNosADireita + quantidadeDeNosAEsquerda + raiz;
	}

	No(int valor) {
		this.valor = valor;
		this.noEsquerdo = null;
		this.noDireito = null;
	}
}
