package q4itemC;

public class RelatorioDespesas {
	public void imprimirRelatorio(float totalDespesa, IImpressora impressora) {
		String conteudo = "Relat�rio de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);
	
		impressora.imprimir(conteudo);
	}
}