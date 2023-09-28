package controller;

import java.util.Scanner;
import java.util.UUID;

import entities.Pessoa;
import repositories.PessoaRepository;

public class PessoaController {

	public void cadastrarPessoa() {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("\nCADASTRO DE PESSOA:\n");

			Pessoa pessoa = new Pessoa();
			pessoa.setId(UUID.randomUUID());

			System.out.print("INFORME O NOME....: ");
			pessoa.setNome(scanner.nextLine());

			System.out.print("INFORME O CPF.....: ");
			pessoa.setCpf(scanner.nextLine());

			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoaRepository.create(pessoa);

			System.out.println("\nPessoa cadastrada com sucesso!");
		} catch (Exception e) {
			System.out.println("\nFalha ao cadastrar: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	public void atualizarPessoa() {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("\nEDIÇÃO DE PESSOA:\n");

			Pessoa pessoa = new Pessoa();

			System.out.print("INFORME O ID......: ");
			pessoa.setId(UUID.fromString(scanner.nextLine()));

			System.out.print("INFORME O NOME....: ");
			pessoa.setNome(scanner.nextLine());

			System.out.print("INFORME O CPF.....: ");
			pessoa.setCpf(scanner.nextLine());

			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoaRepository.update(pessoa);

			System.out.println("\nPessoa atualizada com sucesso!");
		} catch (Exception e) {
			System.out.println("\nFalha ao atualizar: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	public void excluirPessoa() {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("\nEXCLUSÃO DE PESSOA:\n");

			System.out.print("INFORME O ID......: ");
			UUID id = UUID.fromString(scanner.nextLine());

			PessoaRepository pessoaRepository = new PessoaRepository();
			pessoaRepository.delete(id);

			System.out.println("\nPessoa excluída com sucesso!");
		} catch (Exception e) {
			System.out.println("\nFalha ao excluir: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

	public void consultarPessoa() {

		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("\nCONSULTA DE PESSOAS:\n");

			PessoaRepository pessoaRepository = new PessoaRepository();

			// percorrendo cada pessoa obtida da consulta (lista)
			for (Pessoa pessoa : pessoaRepository.getAll()) {

				System.out.println("ID....: " + pessoa.getId());
				System.out.println("NOME..: " + pessoa.getNome());
				System.out.println("CPF...: " + pessoa.getCpf());
				System.out.println("...");
			}

		} catch (Exception e) {
			System.out.println("\nFalha ao consultar: " + e.getMessage());
		} finally {
			scanner.close();
		}
	}

}
