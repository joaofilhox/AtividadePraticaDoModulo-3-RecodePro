package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import agenciaDeViagem.PacotesDeInteresse;
import br.com.jdbc.ConexaoSql;

public class PacotesDeInteresseDAO {

	public void criarPacoteDeViagem(PacotesDeInteresse pacotesDeInteresse, Connection connection) {
		PreparedStatement statement = null;
		
		try {
			connection = ConexaoSql.obterConexao();
			String sql = "INSERT INTO Pacotes_de_Interesse (idPacoteDeViagens, destinos, precos, idCliente) VALUES (?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pacotesDeInteresse.getIdPacoteDeViagens());
			statement.setString(2, pacotesDeInteresse.getDestinos());
			statement.setString(3, pacotesDeInteresse.getPrecos());
			statement.setString(4, pacotesDeInteresse.getIdCliente());
			statement.executeUpdate();
			System.out.println("Pacote de viagem Cadastrado com sucesso!");
		} catch (Exception ex) {
			System.out.println("Pacote de viagem não cadastrado!" + ex.getMessage());
		}
	}
		public PacotesDeInteresse lerPacoteDeViagem(int idPacoteDeViagens, Connection connection) {
		    String sql = "SELECT * FROM Pacotes_de_Interesse WHERE idPacoteDeViagens = ?";
		     PacotesDeInteresse pacotesDeInteresse = null;

		    try (PreparedStatement statement = connection.prepareStatement(sql)) {
		        statement.setInt(1, idPacoteDeViagens);
		        ResultSet result = statement.executeQuery();
		        if (result.next()) {
		        	pacotesDeInteresse = new PacotesDeInteresse(
		                result.getInt("idPacoteDeViagens"),
		                result.getString("destinos"),
		                result.getString("precos"),
		                result.getString("idCliente")
		            );

		            System.out.println(pacotesDeInteresse.toString());
		        }
		    } catch (SQLException ex) {
		        System.out.println("Erro ao ler cliente: " + ex.getMessage());
		    } finally {
		        try {
		            if (connection != null) {
		                connection.close();
		            }
		        } catch (SQLException ex) {
		            System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
		        }
		    }

		    return pacotesDeInteresse;
		}


		public void atualizarPacoteDeViagem(PacotesDeInteresse pacotesDeInteresse, int idPacoteDeViagens, Connection connection) {
			String sql = "UPDATE Pacotes_de_Interesse SET destinos = ?, precos = ?, idCliente = ? WHERE idPacoteDeViagens = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, pacotesDeInteresse.getDestinos());
				statement.setString(2, pacotesDeInteresse.getPrecos());
				statement.setString(3, pacotesDeInteresse.getIdCliente());
				statement.setInt(4, idPacoteDeViagens);
				statement.executeUpdate();
				System.out.println("Pacote de interesse atualizado!!");
			} catch (Exception ex) {
				System.out.println("Erro ao atualizar Pacote de interesse!!" + ex.getMessage());
			}
		}

		public void deletarPacoteDeViagem(int idPacoteDeViagens, Connection connection){
			String sql = "DELETE FROM Pacotes_de_Interesse WHERE idPacoteDeViagens = ?";
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setInt(1, idPacoteDeViagens);
				statement.executeUpdate();
				System.out.println("Pacote de viagem deletado!");
			} catch (Exception ex) {
				System.out.println("Pacote de viagem não deletado!" + ex.getMessage());
			}
		}

   
}
