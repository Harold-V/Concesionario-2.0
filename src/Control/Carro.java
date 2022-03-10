package Control;

public class Carro {

    private String marcaCarro;
    private String modeloCarro;
    private double precioCarro;

    public Carro(String marcaCarro, String modeloCarro, double precioCarro) {
        this.marcaCarro = marcaCarro;
        this.modeloCarro = modeloCarro;
        this.precioCarro = precioCarro;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public void setMarcaCarro(String marcaCarro) {
        this.marcaCarro = marcaCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public double getPrecioCarro() {
        return precioCarro;
    }

    public void setPrecioCarro(Long precioCarro) {
        this.precioCarro = precioCarro;
    }



}
