package factories;

import java.sql.Connection;
import java.sql.DriverManager;

// classe para fabricar as conexoes com o banco de dados

public class ConnectionFactory {

	public  static Connection getConnection() throws Exception {

		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5433/bd_projetoaula04";
		String user = "postgres";
		String password = "coti";

		// abrindo conexão com o banco de dados
		Class.forName(driver);
		return DriverManager.getConnection(url, user, password);

	}

}
