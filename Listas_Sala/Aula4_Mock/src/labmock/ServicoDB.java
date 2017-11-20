package labmock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServicoDB implements IServicoDB {

	private Connection conn;
	
	public void getDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:8066/busca","admin", "senha");
		
	}
	
	public int persisteProcesso(IProcesso proc) throws SQLException {
		String statement = "INSERT INTO PROCESSO(id, nomeReclamante, telefone, email)" + "VALUES ('" + proc.getID()
			+ "', '" + proc.getNomeReclamante() + "', '" + proc.getTelefone() + "', '" + proc.getEmail()
			+ "');";
		return conn.createStatement().executeUpdate(statement);
	}
	
}
