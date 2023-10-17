package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import agenciaDeViagem.Cliente;
import br.com.jdbc.ConexaoSql;

public class ClienteDAO {
	
	//private Connection connection;

	
	
	public void criarCliente(Cliente cliente, Connection connection) {
		PreparedStatement statement = null;
		
		try {
			connection = ConexaoSql.obterConexao();
			String sql = "INSERT INTO Cliente (idCliente, nomeCliente, cpfCliente, enderecoCliente, telefoneCliente, emailCliente) VALUES (?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, cliente.getIdCliente());
			statement.setString(2, cliente.getNomeCliente());
			statement.setString(3, cliente.getCpfCliente());
			statement.setString(4, cliente.getEnderecoCliente());
			statement.setString(5, cliente.getTelefoneCliente());
			statement.setString(6, cliente.getEmailCliente());
			statement.executeUpdate();
			System.out.println("Cliente Cadastrado com sucesso!");
		} catch (Exception ex) {
			System.out.println("Cliente não cadastrado!" + ex.getMessage());
		}
	}

	public Cliente lerCliente(int idCliente, Connection connection) {
	    String sql = "SELECT * FROM Cliente WHERE idCliente = ?";
	    Cliente cliente = null;

	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setInt(1, idCliente);
	        ResultSet result = statement.executeQuery();
	        if (result.next()) {
	            cliente = new Cliente(
	                result.getInt("idCliente"),
	                result.getString("nomeCliente"),
	                result.getString("cpfCliente"),
	                result.getString("enderecoCliente"),
	                result.getString("telefoneCliente"),
	                result.getString("emailCliente")
	            );

	            System.out.println(cliente.toString());
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

	    return cliente;
	}


	public void atualizarCliente(Cliente cliente, int idCliente, Connection connection) {
		String sql = "UPDATE Cliente SET nomeCliente = ?, cpfCliente = ?, enderecoCliente = ?, telefoneCliente = ?, emailCliente = ? WHERE idCliente = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, cliente.getNomeCliente());
			statement.setString(2, cliente.getCpfCliente());
			statement.setString(3, cliente.getEnderecoCliente());
			statement.setString(4, cliente.getTelefoneCliente());
			statement.setString(5, cliente.getEmailCliente());
			statement.setInt(6, idCliente);
			statement.executeUpdate();
			System.out.println("Cliente atualizado!!");
		} catch (Exception ex) {
			System.out.println("Erro ao atualizar cliente!!" + ex.getMessage());
		}
	}

	public void deletarCliente(int idCliente, Connection connection){
		String sql = "DELETE FROM Cliente WHERE idCliente = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, idCliente);
			statement.executeUpdate();
			System.out.println("Cliente deletado!");
		} catch (Exception ex) {
			System.out.println("Cliente não deletado!" + ex.getMessage());
		}
	}
}
