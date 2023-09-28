package controller;

import java.util.Scanner;
import java.util.UUID;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {

	public void cadastrarPessoa() {
		
		Scanner scanner= new Scanner(System.in);
		
		try {
			
			System.out.print("\nCADASTRO DE PESSOA:\n ");
			
			Pessoa pessoa = new Pessoa();
			pessoa.setId(UUID.randomUUID());
			
			System.out.print("Nome da pessoa: ");
			pessoa.setNome(scanner.nextLine());
			
			System.out.print("Cpf:");
			pessoa.setCpf(scanner.nextLine());
			
			PessoaRepository pessoaRepository = new PessoaRepository();
			
			pessoaRepository.create(pessoa);
			
			System.out.print("Pessoa cadastrada com sucesso!");
			
		}
		
		catch(Exception e){
			
			System.out.print("Falha ao cadastrar " + e.getMessage());
			
		}
		
		finally{
			
			scanner.close();
		}		
		
		
		
	}
	
	
	
	
	
	
	
	
}
