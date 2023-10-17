package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import agenciaDeViagem.PacotesDeInteresse;
import br.com.jdbc.ConexaoSql;
import dao.PacotesDeInteresseDAO;

public class testeCrudPacotesDeInteresse {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			PacotesDeInteresseDAO pacotesDeInteresseDAO = new PacotesDeInteresseDAO();
			Connection connection = ConexaoSql.obterConexao();

			PacotesDeInteresse pacotesDeInteresse = new PacotesDeInteresse();
			int id;

			System.out.println("Escolha uma opção:");
			System.out.println("1 - Criar Pacote de viagem");
			System.out.println("2 - Ler Pacote de viagem");
			System.out.println("3 - Atualizar Pacote de viagem");
			System.out.println("4 - Deletar Pacote de viagem");
			System.out.println("5 - Sair");

			int opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				scanner.nextLine();
				pacotesDeInteresse = pacotesDeInteresse.novoPacoteDeInteresse(scanner);
				pacotesDeInteresseDAO.criarPacoteDeViagem(pacotesDeInteresse, connection);
				break;
			case 2:
				System.out.println("Digite o ID do pacote de viagem que deseja ler:");
			    id = scanner.nextInt();
			    pacotesDeInteresse = pacotesDeInteresseDAO.lerPacoteDeViagem(id, connection);
				break;
			case 3:
				System.out.println("Digite o id do pacote de viagem que você deseja atualizar:");
				id = scanner.nextInt();
				scanner.nextLine();
				pacotesDeInteresse = pacotesDeInteresse.novoPacoteDeInteresse(scanner);
				pacotesDeInteresseDAO.atualizarPacoteDeViagem(pacotesDeInteresse, id, connection);
				break;
			case 4:
				System.out.println("Digite o id do pacote de viagem que você quer deletar.");
				id = scanner.nextInt();
				pacotesDeInteresseDAO.deletarPacoteDeViagem(id, connection);
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
