package q4itemA;

public class RelatorioDespesas {
	public void imprimirRelatorio(float totalDespesa, Impressora impressora) {
		String conteudo = "Relatório de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);
	
		impressora.imprimir(conteudo);
	}
}