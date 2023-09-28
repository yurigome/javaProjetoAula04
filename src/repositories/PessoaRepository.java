package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import entities.Pessoa;

public class PessoaRepository {
	
	public void create(Pessoa pessoa) throws Exception{

//parâmetros para conexão com o banco de dados

		
		String driver="org.postgresql.Driver";
		String url ="jdbc:postgresql://localhost:5433/bd_projetoaula04";
		String user="postgres";
		String password="coti";
		
		// abrindo conexão com o banco de dados
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		
		PreparedStatement statement = connection.prepareStatement("Insert into pessoa(id, nome, cpf) values (?,?,?)");
		
		statement.setObject(1,pessoa.getId());
		statement.setString(2,pessoa.getNome());
		statement.setString(3, pessoa.getCpf());
		
		statement.execute();
		
		connection.close();		
		
	}

}
