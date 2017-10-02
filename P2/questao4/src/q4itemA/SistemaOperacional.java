package q4itemA;

import java.util.Iterator;

public class SistemaOperacional {
	private Impressora _impressora;
	private Calculadora _calculadora;
	private RelatorioDespesas _relatorioDesp;
	
	public SistemaOperacional() {
		_impressora = this.getDriverImpressao();
		_calculadora = new Calculadora();
		_relatorioDesp = new RelatorioDespesas();
	}
	
	public Impressora getDriverImpressao() {
		return new Impressora();
	}
	
	public void imprimirRelatorio(Iterator<Despesa> despesas) {
		float totalDespesa = _calculadora.calcularDespesas(despesas);
		_relatorioDesp.imprimirRelatorio(totalDespesa, _impressora);
	}
}
