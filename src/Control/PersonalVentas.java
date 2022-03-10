package Control;

public class PersonalVentas {

    private String nombrePersonalVentas;
    private int cantidadVentas;
    private double netoAcumulado;

    public PersonalVentas(String nombrePersonalVentas, int cantidadVentas, double netoAcumulado) {
        this.nombrePersonalVentas = nombrePersonalVentas;
        this.cantidadVentas = cantidadVentas;
        this.netoAcumulado = netoAcumulado;
    }

    public PersonalVentas() {
    }

    public String getNombrePersonalVentas() {
        return nombrePersonalVentas;
    }

    public void setNombrePersonalVentas(String nombrePersonalVentas) {
        this.nombrePersonalVentas = nombrePersonalVentas;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public double getNetoAcumulado() {
        return netoAcumulado;
    }

    public void setNetoAcumulado(double netoAcumulado) {
        this.netoAcumulado = netoAcumulado;
    }

   
}
