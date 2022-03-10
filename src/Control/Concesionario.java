package Control;

import java.util.ArrayList;

public class Concesionario {

    private String nombreConcesionario;
    private Gerente administrador;

    private final ArrayList<Carro> listaCarrosDisponibles = new ArrayList<>();
    private final ArrayList<Carro> listaCarrosVendidos = new ArrayList<>();
    private final ArrayList<PersonalVentas> listaPersonas = new ArrayList<>();

    public Concesionario(String nombreConcesionario, Gerente administrador) {
        this.nombreConcesionario = nombreConcesionario;
        this.administrador = administrador;
    }

    public Concesionario() {
    }

    public String getNombreConcesionario() {
        return nombreConcesionario;
    }

    public void setNombreConcesionario(String nombreConcesionario) {
        this.nombreConcesionario = nombreConcesionario;
    }

    public Gerente getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Gerente administrador) {
        this.administrador = administrador;
    }

    public void addPersonal(PersonalVentas personal) {
        listaPersonas.add(personal);
    }

    public void borrarPersonal(int PersonalVentas) {
        listaPersonas.remove(PersonalVentas);
    }

     public void borrarCarro(int Carro) {
        listaCarrosDisponibles.remove(Carro);
    }
    public void addCarro(Carro carro) {
        listaCarrosDisponibles.add(carro);
    }

    public void addCarroVendido(Carro carro) {
        listaCarrosVendidos.add(carro);
    }
    
    public ArrayList<PersonalVentas> getListaPersonas() {
        return listaPersonas;
    }

    public ArrayList<Carro> getListaCarrosDisponibles() {
        return listaCarrosDisponibles;
    }

     public ArrayList<Carro> getListaCarrosVendidos() {
        return listaCarrosVendidos;
    }

}
