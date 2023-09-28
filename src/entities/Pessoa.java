package entities;

import java.util.UUID;

public class Pessoa {

	private UUID Id;
	private String Cpf;
	private String Nome;

	public Pessoa() {

	}

	public Pessoa(UUID id, String cpf, String nome) {
		super();
		Id = id;
		Cpf = cpf;
		Nome = nome;
	}

	public UUID getId() {
		return Id;
	}

	public void setId(UUID id) {
		Id = id;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

}
