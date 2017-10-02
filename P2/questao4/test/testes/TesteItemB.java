package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import q4itemA.*;

public class TesteItemB {

	@Mock private Impressora impressora;
	
	private RelatorioDespesas _relatoriodesp ;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		_relatoriodesp = new RelatorioDespesas();
	}

	@Test
	public void testeRelatorioDespesa() {
		float totalDespesa = 16.0f;
		String msg = "Relatório de Despesas"+ "\n Total das despesas:" + totalDespesa;
		Mockito.doNothing().when(impressora).imprimir(msg);
		
		_relatoriodesp.imprimirRelatorio(totalDespesa, impressora);
		
		Mockito.verify(impressora).imprimir(msg);
	}

}
