package agenciaDeViagem;

import java.util.Scanner;

public class PacotesDeInteresse {
	
    private int idPacoteDeViagens;
    private String destinos;
    private String precos;
    private String idCliente;

    public PacotesDeInteresse() {
    }

    public PacotesDeInteresse(int idPacoteDeViagens, String destinos, String precos, String idCliente) {
        this.idPacoteDeViagens = idPacoteDeViagens;
        this.destinos = destinos;
        this.precos = precos;
        this.idCliente = idCliente;
    }
    
    public PacotesDeInteresse(String destinos, String preco, String idCliente2) {
        this.destinos = destinos;
        this.precos = preco;
        this.idCliente = idCliente2;
    }

    public int getIdPacoteDeViagens() {
        return idPacoteDeViagens;
    }

    public String getDestinos() {
        return destinos;
    }

    public String getPrecos() {
        return precos;
    }

    public String getIdCliente() {
        return idCliente;
    }
    
    @Override
	public String toString() {
		return "Cliente{" + "idPacoteDeViagem = " + idPacoteDeViagens + ", Destino = '" + destinos + '\'' + ", Preço = '"
				+ precos + '\'' + ", idCliente = '" + idCliente + '\'' + '}';
	}

	
	public PacotesDeInteresse novoPacoteDeInteresse(Scanner scanner) {
	    System.out.println("Digite o destino:");
	    String destino = scanner.nextLine();

	    System.out.println("Digite o preço do destino:");
	    String preco = scanner.nextLine();

	    System.out.println("Digite o ID de um cliente cadastrado:");
	    String idCliente = scanner.nextLine();

	    return new PacotesDeInteresse(destino, preco, idCliente);
	}

}
