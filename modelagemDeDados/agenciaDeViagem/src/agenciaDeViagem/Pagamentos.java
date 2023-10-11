package agenciaDeViagem;

public class Pagamentos {
    private int idPagamento;
    private double valorPago;
    private String destinoPago;
    private int idCliente;

    public Pagamentos() {
    }

    public Pagamentos(int idPagamento, double valorPago, String destinoPago, int idCliente) {
        this.idPagamento = idPagamento;
        this.valorPago = valorPago;
        this.destinoPago = destinoPago;
        this.idCliente = idCliente;
    }

    // Métodos getters e setters

    public int getIdPagamento() {
        return idPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getDestinoPago() {
        return destinoPago;
    }

    public int getIdCliente() {
        return idCliente;
    }
}
