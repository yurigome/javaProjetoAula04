package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import entities.Pessoa;
import factories.ConnectionFactory;

public class PessoaRepository {
	public void create(Pessoa pessoa) throws Exception {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("insert into pessoa(id, nome, cpf) values(?,?,?)");
		statement.setObject(1, pessoa.getId());
		statement.setString(2, pessoa.getNome());
		statement.setString(3, pessoa.getCpf());
		statement.execute();
		connection.close();
	}

	public void update(Pessoa pessoa) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("update pessoa set nome=?, cpf=? where id=?");
		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getCpf());
		statement.setObject(3, pessoa.getId());
		statement.execute();

		connection.close();
	}

	public void delete(UUID id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from pessoa where id=?");
		statement.setObject(1, id);
		statement.execute();

		connection.close();
	}

	public List<Pessoa> getAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from pessoa order by nome");
		ResultSet resultSet = statement.executeQuery();

		List<Pessoa> lista = new ArrayList<Pessoa>();

		while (resultSet.next()) {

			Pessoa pessoa = new Pessoa();
			pessoa.setId((UUID) resultSet.getObject("id"));
			pessoa.setNome(resultSet.getString("nome"));
			pessoa.setCpf(resultSet.getString("cpf"));

			lista.add(pessoa);
		}

		connection.close();
		return lista;
	}

}
