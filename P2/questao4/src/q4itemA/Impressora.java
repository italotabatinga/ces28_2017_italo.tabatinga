package q4itemA;

public class Impressora {
	public void imprimir(String conteudo) {
		if (conteudo==null) {
			throw new IllegalArgumentException("conteudo nulo");
		}
		else 
			System.out.println(conteudo);
	}
}
