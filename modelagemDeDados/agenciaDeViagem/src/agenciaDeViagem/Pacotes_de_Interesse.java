package agenciaDeViagem;

public class Pacotes_de_Interesse {
	
    private int idPacoteDeViagens;
    private String destinos;
    private double precos;
    private int idCliente;

    public Pacotes_de_Interesse() {
    }

    public Pacotes_de_Interesse(int idPacoteDeViagens, String destinos, double precos, int idCliente) {
        this.idPacoteDeViagens = idPacoteDeViagens;
        this.destinos = destinos;
        this.precos = precos;
        this.idCliente = idCliente;
    }

    // Métodos getters e setters

    public int getIdPacoteDeViagens() {
        return idPacoteDeViagens;
    }

    public String getDestinos() {
        return destinos;
    }

    public double getPrecos() {
        return precos;
    }

    public int getIdCliente() {
        return idCliente;
    }
}
