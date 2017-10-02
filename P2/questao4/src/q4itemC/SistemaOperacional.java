package q4itemC;

import java.util.Iterator;

public class SistemaOperacional {
	private IImpressora _impressora;
	private Calculadora _calculadora;
	private RelatorioDespesas _relatorioDesp;
	
	public SistemaOperacional() {
		_impressora = this.getDriverImpressao(getTipoImpressora());
		_calculadora = new Calculadora();
		_relatorioDesp = new RelatorioDespesas();
	}
	
	public String getTipoImpressora() {
		return "Tipo";
	}
	
	public IImpressora getDriverImpressao(String tipo) {
		if(tipo == "Jato") {
			return new ImpressoraJato();
		}
		else if (tipo == "Laser") {
			return new ImpressoraLaser();
		}
		else return null;
	}
	
	public void imprimirRelatorio(Iterator<Despesa> despesas) {
		float totalDespesa = _calculadora.calcularDespesas(despesas);
		_relatorioDesp.imprimirRelatorio(totalDespesa, _impressora);
	}
}
