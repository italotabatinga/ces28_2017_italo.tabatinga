package test_questao4_p1;
import questao4_p1.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Matchers;

@SuppressWarnings("deprecation")
public class ControladorPTC_Test {

	@Mock private Sensor _sensormock;
	@Mock private PainelCondutor _condutormock;
	@Mock private Datacenter _datacentermock;
	
	private ControladorPTC _controladorptc;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Before
    public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		_controladorptc = new ControladorPTC(_sensormock, _datacentermock, _condutormock);
	}
	
	@Test // Item A
	public void itemA_InitControladorPTCtest() {
		assertNotNull(_controladorptc);
	}

	@Test // Item B
	public void itemB_TremNaoEstaNoCruzamento() {
		Mockito.when(_sensormock.isCruzamento()).thenReturn(false);
		
		_controladorptc.run();
		
		Mockito.verify(_condutormock, Mockito.times(1)).imprimirAviso(Matchers.anyString(), Matchers.eq(1));
		Mockito.verify(_datacentermock, Mockito.times(1)).gerarRelatorio(Matchers.anyString());
	}
	
	@Test // Item C
	public void itemC_TremNoCruzamentoVelocidadeMaior100CondutorTrue() {
		Mockito.when(_sensormock.isCruzamento()).thenReturn(true);
		Mockito.when(_sensormock.getVelocidade()).thenReturn(120.0);
		Mockito.when(_condutormock.imprimirAviso("Velocidade alta", 1)).thenReturn(true);
		
		_controladorptc.run();
		
		assertTrue(_controladorptc.enviaMsgPrioritariaPainel("Velocidade alta", _condutormock));
	}
	
	@Test // Item D
	public void itemD_TremNoCruzamentoVelocidadeMenor100CondutorFalse() {
		//thrown.expect(InterruptedException.class);
		
		Mockito.when(_sensormock.isCruzamento()).thenReturn(true);
		Mockito.when(_sensormock.getVelocidade()).thenReturn(10.0);
		Mockito.when(_condutormock.imprimirAviso("Velocidade Baixa", 1)).thenReturn(false);
		
		_controladorptc.run();
		
		assertFalse(_controladorptc.enviaMsgPrioritariaPainel("Velocidade Baixa", _condutormock));
		Mockito.verify(_condutormock, Mockito.times(1)).aceleraVelocidadeTrem(20);
	}
}
