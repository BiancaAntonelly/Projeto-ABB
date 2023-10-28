public class ArvoreBB {
	public static No raiz = null;
	public static int quantidadeDeNos = 0;

	public static boolean inserir(No no) {
		raiz = inserirRecursivo(raiz, no);
		return raiz != null;
	}

	private static No inserirRecursivo(No noAtual, No novoNo) {
		if (noAtual == null) {
			System.out.println(novoNo.valor + " adicionado");
			quantidadeDeNos++;
			return novoNo;
		}

		if (novoNo.valor == noAtual.valor) {
			System.out.println(novoNo.valor + " já está na árvore, não pode ser inserido");
		} else if (novoNo.valor < noAtual.valor) {
			noAtual.noEsquerdo = inserirRecursivo(noAtual.noEsquerdo, novoNo);
		} else {
			noAtual.noDireito = inserirRecursivo(noAtual.noDireito, novoNo);
		}

		return noAtual;
	}



}
