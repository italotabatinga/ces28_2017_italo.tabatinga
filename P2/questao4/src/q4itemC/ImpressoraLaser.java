package q4itemC;

public class ImpressoraLaser implements IImpressora {
	public void imprimir(String conteudo) {
		if (conteudo==null) {
			throw new IllegalArgumentException("conteudo nulo");
		}
		else 
			System.out.println(conteudo);
	}
}
