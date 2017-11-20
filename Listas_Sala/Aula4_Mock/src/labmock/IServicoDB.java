package labmock;

import java.sql.SQLException;

public interface IServicoDB {
	public void getDBConnection() throws ClassNotFoundException, SQLException;
	public int persisteProcesso(IProcesso proc) throws SQLException;
}
