package tests;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import model.UMTCTR;
import presenter.CLOUD;
import presenter.Position;
import view.ARP;
import view.GCS;

public class TesteModel {
	@Mock private GCS gcs1mock;
	@Mock private GCS gcs2mock;
	@Mock private CLOUD cloudmock;
	@Mock private ARP arp1mock;
	@Mock private ARP arp2mock;
	@Mock private Position p1mock;
	@Mock private Position p2mock;
	
	private UMTCTR umtctr;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		umtctr = UMTCTR.getInstance();
		
		Mockito.when(p1mock.distance(p1mock)).thenReturn(0.0);
		Mockito.when(p1mock.distance(p2mock)).thenReturn(80.0);
		Mockito.when(p2mock.distance(p2mock)).thenReturn(0.0);
		Mockito.when(p2mock.distance(p1mock)).thenReturn(80.0);
	}
	// Primeiros 2 testes mostram a resposta de 5.c
	@Test // Teste que mostra que umtctr foi instanciado corretamente
	public void AssertUMTCTRNotNull() {
		assertNotNull(umtctr);
	}
	
	@Test // Teste que mostrar que s� existe uma inst�ncia de UMTCTR
	public void ExisteApenasUmaInstancia() {
		UMTCTR umtctr2;
		umtctr2 = UMTCTR.getInstance();
		
		assertEquals(umtctr, umtctr2);
	}
	
	@Test // Teste para mostrar que o update da vari�vel allinfo � feito corretamente
	public void UpdateDoHashMapAllInfo() {
		HashMap<ARP, Position> allinfoTeste = new HashMap<>();
		allinfoTeste.put(arp1mock, p1mock);
		allinfoTeste.put(arp2mock, p2mock);
		
		umtctr.updateAllInfo(allinfoTeste);
		assertEquals(allinfoTeste,umtctr.getAllInfo());
	}
	
	@Test // Teste para mostrar que o processamento das dist�ncias � feito corretamente
	public void RetornaSAInfoParaCadaARP() {
		HashMap<ARP, Position> allinfoTeste = new HashMap<>();
		allinfoTeste.put(arp1mock, p1mock);
		allinfoTeste.put(arp2mock, p2mock);
		umtctr.updateAllInfo(allinfoTeste);
		
		HashMap<ARP, Position> sainfoTeste = new HashMap<>();
		sainfoTeste.put(arp1mock, p1mock);
		// Para os valores de dist�ncia entre os pontos p1mock e p2mock
		// definidos em @Before, temos que o �nico ARP presente no range de 
		// arp1mock � ele mesmo, ent�o o HashMap deve conter apenas ele.
		assertEquals(sainfoTeste, umtctr.getSAInfo(arp1mock));
	}
}
