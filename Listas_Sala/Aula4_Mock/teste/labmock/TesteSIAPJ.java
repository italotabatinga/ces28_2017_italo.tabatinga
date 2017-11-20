package labmock;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TesteSIAPJ {
	@InjectMocks private SIAPJ siapj;
	
	@Mock private IServicoEmail emailMock;
	@Mock private IServicoDB dbMock;
	@Mock private IValidatorProcesso validatorMock;
	@Mock private IProcesso proc1;
	@Mock private IProcesso proc2;
	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		siapj = new SIAPJ(emailMock, dbMock, validatorMock);
	}
	
	@Test
	public void testaInicializacaoSIAPJ() {
		//testamos o processo criando dummys dos parametros de siapj
		Assert.assertNotNull(siapj);
	}
	
	@Test
	public void testaCriarReclamacao() throws SQLException{
		Mockito.when(validatorMock.validaProcesso(proc1)).thenReturn(true);
		Mockito.when(validatorMock.validaProcesso(proc2)).thenReturn(false);
		
		siapj.criaReclamacao(proc1);
		Mockito.verify(dbMock, Mockito.times(1)).persisteProcesso(proc1);
		Mockito.verify(emailMock, Mockito.times(1)).sendEmail(proc1.getEmail(), "Processo aceito");
		
		siapj.criaReclamacao(proc2);
		Mockito.verify(emailMock, Mockito.times(1)).sendEmail(proc2.getEmail(), "Existem erros em seu processo");
	}
	
	
}