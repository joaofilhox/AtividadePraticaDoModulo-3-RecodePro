package agenciaDeViagem;

import java.util.Scanner;

public class Cliente {

	private int idCliente;
	private String nomeCliente;
	private String cpfCliente;
	private String enderecoCliente;
	private String telefoneCliente;
	private String emailCliente;

	public Cliente() {
	}

	public Cliente(int idCliente, String nomeCliente, String cpfCliente, String enderecoCliente, String telefoneCliente,
			String emailCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.enderecoCliente = enderecoCliente;
		this.telefoneCliente = telefoneCliente;
		this.emailCliente = emailCliente;
	}
	
	public Cliente( String nomeCliente, String cpfCliente, String enderecoCliente, String telefoneCliente,
             String emailCliente) {

		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.enderecoCliente = enderecoCliente;
		this.telefoneCliente = telefoneCliente;
		this.emailCliente = emailCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	@Override
	public String toString() {
		return "Cliente{" + "idCliente = " + idCliente + ", nomeCliente = '" + nomeCliente + '\'' + ", cpfCliente = '"
				+ cpfCliente + '\'' + ", enderecoCliente = '" + enderecoCliente + '\'' + ", telefoneCliente = '"
				+ telefoneCliente + '\'' + ", emailCliente = '" + emailCliente + '\'' + '}';
	}

	
	public Cliente novoCliente(Scanner scanner) {
	    System.out.println("Digite o nome do cliente:");
	    String nome = scanner.nextLine();

	    System.out.println("Digite o CPF do cliente:");
	    String cpf = scanner.nextLine();

	    System.out.println("Digite o endereço do cliente:");
	    String endereco = scanner.nextLine();

	    System.out.println("Digite o telefone do cliente:");
	    String telefone = scanner.nextLine();

	    System.out.println("Digite o email do cliente:");
	    String email = scanner.nextLine();

	    return new Cliente(nome, cpf, endereco, telefone, email);
	}


}
