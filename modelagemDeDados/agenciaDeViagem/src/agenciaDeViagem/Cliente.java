package agenciaDeViagem;

public class Cliente {

	    private int idCliente;
	    private String nomeCliente;
	    private String cpfCliente;
	    private String enderecoCliente;
	    private String telefoneCliente;
	    private String emailCliente;

	    public Cliente() {
	    }

	    public Cliente(int idCliente, String nomeCliente, String cpfCliente, String enderecoCliente, String telefoneCliente, String emailCliente) {
	        this.idCliente = idCliente;
	        this.nomeCliente = nomeCliente;
	        this.cpfCliente = cpfCliente;
	        this.enderecoCliente = enderecoCliente;
	        this.telefoneCliente = telefoneCliente;
	        this.emailCliente = emailCliente;
	    }

	    // Métodos getters e setters

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
	}



