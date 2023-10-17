package agenciaDeViagem;


import java.util.Scanner;

public class Pagamentos {
    private int idPagamento;
    private String valorPago;
    private String destinoPago;
    private String idCliente;

    public Pagamentos() {
    }

    public Pagamentos( String valorPago, String destinoPago, String idCliente) {
        this.valorPago = valorPago;
        this.destinoPago = destinoPago;
        this.idCliente = idCliente;
    }  
    
    public Pagamentos( int idPagamento, String valorPago, String destinoPago, String idCliente) {
        this.idPagamento = idPagamento;
    	this.valorPago = valorPago;
        this.destinoPago = destinoPago;
        this.idCliente = idCliente;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public String getValorPago() {
        return valorPago;
    }

    public String getDestinoPago() {
        return destinoPago;
    }

    public String getIdCliente() {
        return idCliente;
    }
    
    @Override
   	public String toString() {
    	return "Cliente{" + "idPacoteDeViagem = " + idPagamento + ", Valor pago = '" + valorPago + '\'' + ", Destino pago = '"
				+ destinoPago + '\'' + ", idCliente = '" + idCliente + '\'' + '}';
   	}
    
    
	public Pagamentos novoPagamento(Scanner scanner) {
		
		System.out.println("Digite o valor pago");
		String valor = scanner.nextLine();
		
		System.out.println("Digite seu destino pago");
		String destino = scanner.nextLine();

		System.out.println("Digite o seu id de cliente");
		String idCliente = scanner.nextLine();
		
		

		return new Pagamentos(valor, destino, idCliente);
	}
	
}
