package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import agenciaDeViagem.Pagamentos;
import br.com.jdbc.ConexaoSql;
import dao.PagamentosDAO;

public class testeCrudPagamento {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			PagamentosDAO pagamentosDAO = new PagamentosDAO();
			Connection connection = ConexaoSql.obterConexao();

			Pagamentos pagamentos = new Pagamentos(); 
			int id;

			System.out.println("Escolha uma opção:");
			System.out.println("1 - Criar Pagamento");
			System.out.println("2 - Ler Pagamentos");
			System.out.println("3 - Atualizar Pagamentos");
			System.out.println("4 - Deletar Pagamento");
			System.out.println("5 - Sair");

			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				scanner.nextLine();
				pagamentos = pagamentos.novoPagamento(scanner);
				pagamentosDAO.criarPagamento(pagamentos, connection);
				break;
			case 2:
				System.out.println("Digite o ID do pagamento que deseja ler:");
			    id = scanner.nextInt();
			    pagamentos = pagamentosDAO.lerPagamento(id, connection);
				break;
			case 3:
				System.out.println("Digite o id do pagamento que você deseja atualizar:");
				id = scanner.nextInt();
				scanner.nextLine();
				pagamentos = pagamentos.novoPagamento(scanner);
				pagamentosDAO.atualizarPagamento(pagamentos, id, connection);
				break;
			case 4:
				System.out.println("Digite o id do pagamento que você quer deletar.");
				id = scanner.nextInt();
				pagamentosDAO.deletarPagamento(id, connection);
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
