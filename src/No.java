public class No {
	public int valor;
	public No noEsquerdo;
	public No noDireito;
	public Integer quantidadeDeNosAEsquerda = 0;
	public Integer quantidadeDeNosADireita = 0;


	No(int valor) {
		this.valor = valor;
		this.noEsquerdo = null;
		this.noDireito = null;
	}
}
