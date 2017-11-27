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

public class TesteView {
	@Mock private UMTCTR umtmock;
	@Mock private CLOUD cloudmock;
	@Mock private ARP arp1mock;
	@Mock private ARP arp2mock;
	@Mock private Position p1mock;
	@Mock private Position p2mock;
	
	private GCS gcs1;
	private GCS gcs2;
	private GCS gcs3;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		gcs1 = new GCS("Joao", cloudmock, arp1mock);
		gcs2 = new GCS("Luiz", cloudmock, arp2mock);
		
	}
	
	// Exemplos semelhantes ao da Main da questão anterior
	
	 	   // Método move deve chamar o método move de ARP que estaria implementado
	@Test  // para mover o respectivo ARP
	public void MethodMoveChamaMethodARP() {
		gcs1.move(3, 4);
		
		Mockito.verify(arp1mock, Mockito.times(1)).move(3, 4);
		// É válido notar que o print 
	}
	
	@Test //Ao receber corretamente um SAInfo de CLOUD, GCS deve mostra-los corretamente
	public void GCSDeveMostrarARPdeSAInfo() {
		HashMap<ARP, Position> sainfoteste = new HashMap<>();
		sainfoteste.put(arp1mock, p1mock);
		sainfoteste.put(arp2mock, p2mock);
		
		//Supondo mesmo caso da main da Questão anterior, onde apenas esses dois estavam no range.
		Mockito.when(cloudmock.getSAInfo(arp1mock)).thenReturn(sainfoteste);
		Mockito.when(arp1mock.getName()).thenReturn("Joao");
		Mockito.when(arp2mock.getName()).thenReturn("Luiz");
		
		gcs1.update(cloudmock, Mockito.any());
		assertEquals("ARPs no range de 50km dos seguintes GCSs: Joao Luiz", gcs1.showARPinRange());
	}
}
