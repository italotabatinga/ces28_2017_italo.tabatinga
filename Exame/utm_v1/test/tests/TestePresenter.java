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

public class TestePresenter {
	@Mock private UMTCTR umtmock;
	@Mock private GCS gcs1mock;
	@Mock private GCS gcs2mock;
	@Mock private ARP arp1mock;
	@Mock private ARP arp2mock;
	@Mock private Position p1mock;
	@Mock private Position p2mock;
	private CLOUD cloud;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		cloud = new CLOUD(umtmock);
		cloud.addObserver(gcs1mock);
		cloud.addObserver(gcs2mock);
		
		Mockito.when(arp1mock.getPosition()).thenReturn(p1mock);
		Mockito.when(arp2mock.getPosition()).thenReturn(p2mock);
	}

	@Test // Teste mostra que o método UpdateAllInfo é chamado corretamente para o umtctr
	public void testMethodUpdateAllInfo() {
		cloud.updateAllInfo();
		Mockito.verify(umtmock, Mockito.times(1)).updateAllInfo(Mockito.any());
	}
	
	@Test // Teste mostra que o método getSAInfo é chamado corretamente para o umtctr
	public void testMethodgetSAInfo() {
		cloud.getSAInfo(arp1mock);
		Mockito.verify(umtmock, Mockito.times(1)).getSAInfo(arp1mock);
	}

	@Test // Teste que mostra que adiciona/atualiza corretamente um ARP no seu HashMap
	public void testUpdateHashMap() {
		cloud.updatePosition(arp1mock);
		cloud.updatePosition(arp2mock);
		
		HashMap<ARP, Position> allinfoTeste = new HashMap<>();
		allinfoTeste.put(arp1mock, p1mock);
		allinfoTeste.put(arp2mock, p2mock);
		
		assertEquals(allinfoTeste, cloud.getAllInfo());
	}
	
	@Test // Teste que mostra que o método update dos observers foram chamadso corretamente
	public void testCloudChamaUpdate() {
		cloud.updatePosition(arp1mock);
		cloud.updatePosition(arp2mock);
		
		//O método é chamado duas vezes dado que quando são dados 2 updates todos os 
		// observadores devem ser notificados
		Mockito.verify(gcs1mock, Mockito.times(2)).update(Mockito.eq(cloud), Mockito.any());
	}
}
