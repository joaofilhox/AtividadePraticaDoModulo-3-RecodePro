package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import agenciaDeViagem.Pagamentos;
import br.com.jdbc.ConexaoSql;




public class PagamentosDAO {
	
	public void criarPagamento(Pagamentos pagamentos, Connection connection) {
		PreparedStatement statement = null;
		
		try {
			connection = ConexaoSql.obterConexao();
			String sql = "INSERT INTO Pagamentos (idPagamento, valorPago, destinoPago, idCliente) VALUES (?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, pagamentos.getIdPagamento());
			statement.setString(2, pagamentos.getValorPago());
			statement.setString(3, pagamentos.getDestinoPago());
			statement.setString(4, pagamentos.getIdCliente());
			statement.executeUpdate();
			System.out.println("Pagamento Cadastrado com sucesso!");
		} catch (Exception ex) {
			System.out.println("Pagamento não cadastrado!" + ex.getMessage());
		}
	}
	
	public Pagamentos lerPagamento(int idPagamento, Connection connection) {
	    String sql = "SELECT * FROM Pagamentos WHERE idPagamento = ?";
	     Pagamentos pagamentos = null;

	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, idPagamento);
	        ResultSet result = statement.executeQuery();
	        if (result.next()) {
	        	pagamentos = new Pagamentos(
	                result.getInt("idPagamento"),
	                result.getString("valorPago"),
	                result.getString("destinoPago"),
	                result.getString("idCliente")
	            );

	            System.out.println(pagamentos.toString());
	        }
	    } catch (SQLException ex) {
	        System.out.println("Erro ao ler pagamento: " + ex.getMessage());
	    } finally {
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException ex) {
	            System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
	        }
	    }

	    return pagamentos;
	}


	public void atualizarPagamento(Pagamentos pagamentos, int idPagamento, Connection connection) {
		String sql = "UPDATE Pagamentos SET valorPago = ?, destinoPago = ?, idCliente = ? WHERE idPagamento = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, pagamentos.getValorPago());
			statement.setString(2, pagamentos.getDestinoPago());
			statement.setString(3, pagamentos.getIdCliente());
			statement.setInt(4, idPagamento);
			statement.executeUpdate();
			System.out.println("Pagamento atualizado!!");
		} catch (Exception ex) {
			System.out.println("Erro ao atualizar Pagamento!!" + ex.getMessage());
		}
	}

	public void deletarPagamento(int idPagamento, Connection connection){
		String sql = "DELETE FROM Pagamentos WHERE idPagamento = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, idPagamento);
			statement.executeUpdate();
			System.out.println("Pagamento deletado!");
		} catch (Exception ex) {
			System.out.println("Pagamento não deletado!" + ex.getMessage());
		}
	}


}

