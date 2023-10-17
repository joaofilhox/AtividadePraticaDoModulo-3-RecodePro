package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import br.com.jdbc.ConexaoSql;
import dao.ClienteDAO;
import agenciaDeViagem.Cliente;

public class testeCrudCliente {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			ClienteDAO clienteDAO = new ClienteDAO();
			Connection connection = ConexaoSql.obterConexao();

			Cliente cliente = new Cliente(); 
			int id;

			System.out.println("Escolha uma opção:");
			System.out.println("1 - Criar Cliente");
			System.out.println("2 - Ler Cliente");
			System.out.println("3 - Atualizar Cliente");
			System.out.println("4 - Deletar Cliente");
			System.out.println("5 - Sair");

			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				scanner.nextLine();
				cliente = cliente.novoCliente(scanner);
				clienteDAO.criarCliente(cliente, connection);
				break;
			case 2:
				System.out.println("Digite o ID do cliente que deseja ler:");
			    id = scanner.nextInt();
			    cliente = clienteDAO.lerCliente(id, connection);
				break;
			case 3:
				System.out.println("Digite o id do cliente que você deseja atualizar:");
				id = scanner.nextInt();
				scanner.nextLine();
				cliente = cliente.novoCliente(scanner);
				clienteDAO.atualizarCliente(cliente, id, connection);
				break;
			case 4:
				System.out.println("Digite o id do cliente que você quer deletar.");
				id = scanner.nextInt();
				clienteDAO.deletarCliente(id, connection);
				break;
			case 5:
				System.out.println("Você saiu do programa!");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

			connection.close(); 
		} catch (SQLException e) {
			System.out.println("Não foi possível conectar no banco de dados");
			e.printStackTrace();
		}
	}
}
