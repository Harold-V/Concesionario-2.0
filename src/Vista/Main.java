package Vista;

import Control.Carro;
import java.util.Scanner;
import Control.Concesionario;
import Control.Gerente;
import Control.PersonalVentas;
import java.util.ArrayList;

public class Main {

    private static final Menus menus = new Menus();
    private static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<Concesionario> concesionarioMain = new ArrayList<>();
    private static final Gerente gerente = new Gerente();

    public void escribirEncabezado(String prmcadena) {
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("" + prmcadena);
        System.out.println("───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public void limpiarPantalla() {
        for (int i = 0; i < 15; i++) {
            System.out.println("\n");
        }
    }

    public void esperarTecla() {
        escribirEncabezado("Presione Enter para Continuar...");
        scanner.nextLine();
    }

    public void imprimirCarrito() {
        Concesionario concesionario = concesionarioMain.get(0);
        menus.carrito(concesionario.getNombreConcesionario(), concesionario.getAdministrador().getNombreGerente());
    }

    public void agregarNombreCyG() {
        String nombreConcesionario, nombreGerente;
        if (concesionarioMain.isEmpty()) {
            do {
                escribirEncabezado("Indique el Nombre del Concesionario: ");
                nombreConcesionario = scanner.nextLine();
                if (nombreConcesionario.equals("")) {
                    nombreConcesionario = null;
                } else {
                    nombreConcesionario = nombreConcesionario;
                    break;
                }
                escribirEncabezado("!Debes Indicar el Nombre del Concesionario¡");
            } while (nombreConcesionario == null);
            do {
                escribirEncabezado("Indique el Nombre del Gerente: ");
                nombreGerente = scanner.nextLine();
                if (nombreGerente.equals("")) {
                    nombreGerente = null;
                } else {
                    nombreGerente = nombreGerente;
                    break;
                }
                escribirEncabezado("!Debes Indicar el Nombre del Gerente¡");
            } while (nombreGerente == null);
            limpiarPantalla();
            Gerente administrador = new Gerente(nombreGerente);
            Concesionario concesionario = new Concesionario(nombreConcesionario, administrador);
            concesionarioMain.add(concesionario);
            escribirEncabezado("Se ha Añadido el nombre del Concesionario: " + concesionario.getNombreConcesionario());
            escribirEncabezado("Se ha Añadido el nombre del Gerente: " + concesionario.getAdministrador().getNombreGerente());
            esperarTecla();
        } else {
            escribirEncabezado("El Concesionario y el Gerente ya Tienen Asignados sus Respectivos Nombres.");
            esperarTecla();
        }
    }

    public void modificarConcesionario() {
        limpiarPantalla();
        escribirEncabezado("Modificar Nombre del Concesionario.");
        if (concesionarioMain.isEmpty()) {
            escribirEncabezado("No Existe Ningun Nombre de Concesionario Registrado.");
            esperarTecla();
        } else {
            Concesionario concesionario = concesionarioMain.get(0);
            escribirEncabezado("El Nombre del Concesionario Actual es: " + concesionario.getNombreConcesionario());
            escribirEncabezado("Ingrese el Nuevo Nombre Del Concesionario: ");
            String newNombreConcesionario = scanner.nextLine();
            limpiarPantalla();
            escribirEncabezado("¿Esta Seguro que Desea Modificar el Nombre de " + concesionario.getNombreConcesionario() + " a " + newNombreConcesionario + "? Si/No");
            String opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                limpiarPantalla();
                concesionario.setNombreConcesionario(newNombreConcesionario);
                escribirEncabezado("El Nombre del Concesionario fue Modificado a " + concesionario.getNombreConcesionario());
                esperarTecla();
            } else {
                limpiarPantalla();
                escribirEncabezado("No se Modifico el nombre del Concesionario.");
                esperarTecla();
            }
        }
    }

    public void modificarGerente() {
        limpiarPantalla();
        escribirEncabezado("Modificar Nombre del Gerente.");
        if (concesionarioMain.isEmpty()) {
            escribirEncabezado("No Existe Ningun Nombre de Gerente Registrado.");
            esperarTecla();
        } else {
            Concesionario concesionario = concesionarioMain.get(0);
            escribirEncabezado("El Nombre del Gerente Actual es: " + concesionario.getAdministrador().getNombreGerente());
            escribirEncabezado("Ingrese el Nuevo Nombre Del Gerente: ");
            String newNombreGerente = scanner.nextLine();
            limpiarPantalla();
            escribirEncabezado("¿Esta Seguro que Desea Modificar el Nombre de " + concesionario.getAdministrador().getNombreGerente() + " a " + newNombreGerente + "? Si/No");
            String opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                limpiarPantalla();
                gerente.setNombreGerente(newNombreGerente);
                concesionario.setAdministrador(gerente);
                escribirEncabezado("El Nombre del Gerente fue Modificado a " + concesionario.getAdministrador().getNombreGerente());
                esperarTecla();
            } else {
                limpiarPantalla();
                escribirEncabezado("No se Modifico el nombre del Gerente.");
                esperarTecla();
            }
        }
    }

    public void agregarPersonalVentas() {
        Concesionario concesionario = concesionarioMain.get(0);
        limpiarPantalla();
        String nombrePersonalVentas, varAgregar;
        escribirEncabezado("Agregar Nombre del Personal de Ventas.");
        do {
            do {
                escribirEncabezado("Indique el Nombre del Vendedor: ");
                nombrePersonalVentas = scanner.nextLine();
                if (nombrePersonalVentas.equals("")) {
                    nombrePersonalVentas = null;
                } else {
                    nombrePersonalVentas = nombrePersonalVentas;
                    break;
                }
                escribirEncabezado("!Debes Indicar el Nombre del Personal de Ventas¡");
            } while (nombrePersonalVentas == null);
            limpiarPantalla();
            PersonalVentas personaActual = new PersonalVentas(nombrePersonalVentas, 0, 0);
            concesionario.addPersonal(personaActual);
            escribirEncabezado("Se ha Añadido el nombre del Nuevo Personal de Ventas: " + personaActual.getNombrePersonalVentas());
            escribirEncabezado("Desea Agregar otro Personal de Ventas? Si/No");
            varAgregar = scanner.nextLine();
        } while (varAgregar.equalsIgnoreCase("Si"));
    }

    public void modificarPersonalVentas() {
        limpiarPantalla();
        Concesionario concesionario = concesionarioMain.get(0);
        ArrayList<PersonalVentas> personalVentas = concesionario.getListaPersonas();
        escribirEncabezado("Modificar Nombre del Personal .");
        if (personalVentas.isEmpty()) {
            escribirEncabezado("No Existe Ningun Personal Ventas Registrado.");
            esperarTecla();
        } else {
            imprimirPersonalVentas();
            escribirEncabezado("Seleccione el Personal de Ventas que Desea Modificar.");
            int opcion = scanner.nextInt() - 1;
            scanner.nextLine();
            if (opcion >= personalVentas.size()) {
                escribirEncabezado("El Personal Ventas Seleccionado No Existe.");
                esperarTecla();
            } else {
                escribirEncabezado("El Nombre del Personal Ventas Actual es: " + personalVentas.get(opcion).getNombrePersonalVentas());
                escribirEncabezado("Ingrese el Nuevo Nombre Del Personal Ventas: ");
                String newNombrePersonalVentas = scanner.nextLine();
                limpiarPantalla();
                escribirEncabezado("¿Esta Seguro que Desea Modificar el Nombre de " + personalVentas.get(opcion).getNombrePersonalVentas() + " a " + newNombrePersonalVentas + "? Si/No");
                String opcion1 = scanner.nextLine();
                if (opcion1.equalsIgnoreCase("si")) {
                    limpiarPantalla();
                    personalVentas.get(opcion).setNombrePersonalVentas(newNombrePersonalVentas);
                    escribirEncabezado("El Nombre del Personal de Ventas fue Modificado a: " + newNombrePersonalVentas);
                    esperarTecla();
                } else {
                    limpiarPantalla();
                    escribirEncabezado("No se Modifico el Nombre del Personal de Ventas.");
                    esperarTecla();
                }
            }
        }
    }

    public void imprimirPersonalVentas() {
        Concesionario concesionario = concesionarioMain.get(0);
        ArrayList<PersonalVentas> personalVentas = concesionario.getListaPersonas();
        if (personalVentas.isEmpty()) {
            escribirEncabezado("La lista del Personal de Ventas esta Vacia.");
        } else {
            escribirEncabezado("Lista de Personal de Ventas:");
            for (int i = 0; i < personalVentas.size(); i++) {
                PersonalVentas personalventas = personalVentas.get(i);
                escribirEncabezado((i + 1) + ". Nombre: " + personalventas.getNombrePersonalVentas());
            }
        }
    }

    public void imprimirVentasDelPersonal() {
        Concesionario concesionario = concesionarioMain.get(0);
        ArrayList<PersonalVentas> personalVentas = concesionario.getListaPersonas();
        if (personalVentas.isEmpty()) {
            escribirEncabezado("La lista del Personal de Ventas esta Vacia.");
        } else {
            escribirEncabezado("Lista de Personal de Ventas:");
            for (int i = 0; i < personalVentas.size(); i++) {
                PersonalVentas personalventas = personalVentas.get(i);
                escribirEncabezado((i + 1) + ". Nombre del Vendedor: " + personalventas.getNombrePersonalVentas() + "\n   Cantidad de Ventas Realizadas: " + personalventas.getCantidadVentas() + "\n   Acumulado de Ventas Realizadas: " + personalventas.getNetoAcumulado());
            }
        }
    }

    public void eliminarPersonalVentas() {
        Concesionario concesionario = concesionarioMain.get(0);
        ArrayList<PersonalVentas> personalVentas = concesionario.getListaPersonas();
        String varEliminar;
        escribirEncabezado("Eliminar Personal Ventas");
        do {
            if (personalVentas.isEmpty()) {
                escribirEncabezado("No Existe Ningun Personal de Ventas Registrado.");
                esperarTecla();
                break;
            } else {
                imprimirPersonalVentas();
                escribirEncabezado("Seleccione el Personal de Venta que Desea Eliminar: ");
                int opcion = scanner.nextInt() - 1;
                scanner.nextLine();
                if (opcion >= personalVentas.size()) {
                    escribirEncabezado("El Personal de Venta Seleccionado No Existe.");
                } else {
                    escribirEncabezado("Se Eliminara un Personal de Venta: " + personalVentas.get(opcion).getNombrePersonalVentas() + ", Desea Continuar? Si/No");
                    String varContinuar = scanner.nextLine();
                    if (varContinuar.equalsIgnoreCase("si")) {
                        concesionario.borrarPersonal(opcion);
                    } else {
                        escribirEncabezado("No se Elimino el Personal de Venta.");
                    }
                    escribirEncabezado("El Personal de Venta fue Eliminado.");
                }
            }
            escribirEncabezado("Desea Eliminar otro Personal de Venta? Si/No");
            varEliminar = scanner.nextLine();
        } while (varEliminar.equalsIgnoreCase("si"));
    }

    public void agregarCarroAlInventario() {
        Concesionario concesionario = concesionarioMain.get(0);
        String marcaCarro, modeloCarro, varAgregar, precio;
        long precioCarro;
        limpiarPantalla();
        escribirEncabezado("Agregar Carro Nuevo al Inventario.");
        escribirEncabezado("Para Agregar un Carro Nuevo, Escriba la Marca, Modelo y Precio del Carro");
        do {
            do {
                escribirEncabezado("Indique la Marca: ");
                marcaCarro = scanner.nextLine();
                if (marcaCarro.equals("")) {
                    marcaCarro = null;
                } else {
                    marcaCarro = marcaCarro;
                    break;
                }
                escribirEncabezado("!Debes Indicar la Marca del Carro¡");
            } while (marcaCarro == null);
            do {
                escribirEncabezado("Indique el Modelo: ");
                modeloCarro = scanner.nextLine();
                if (modeloCarro.equals("")) {
                    modeloCarro = null;
                } else {
                    modeloCarro = modeloCarro;
                    break;
                }
                escribirEncabezado("!Debes Indicar el Modelo del Carro¡");
            } while (modeloCarro == null);
            do {
                escribirEncabezado("Indique el Precio : ");
                precio = scanner.nextLine();
                if (precio.equals("")) {
                    precioCarro = 0;
                } else {
                    precioCarro = Long.parseLong(precio);
                    break;
                }
                escribirEncabezado("!Debes Indicar el Precio del Carro¡");
            } while (precioCarro == 0);
            Carro carro = new Carro(marcaCarro, modeloCarro, precioCarro);
            concesionario.addCarro(carro);
            limpiarPantalla();
            escribirEncabezado("Se ha Añadido el Carro al Inventario.");
            escribirEncabezado("Desea Agregar otro Carro? Si/No");
            varAgregar = scanner.nextLine();
        } while (varAgregar.equalsIgnoreCase("si"));
    }

    public void imprimirCarrosDisponibles() {
        Concesionario concesionario = concesionarioMain.get(0);
        ArrayList<Carro> carros = concesionario.getListaCarrosDisponibles();
        if (carros.isEmpty()) {
            escribirEncabezado("La lista de Carros Disponibles esta Vacia.");
        } else {
            escribirEncabezado("Lista de Carros Disponibles:");
            for (int i = 0; i < carros.size(); i++) {
                Carro carro = carros.get(i);
                System.out.println((i + 1) + ". " + carro.getMarcaCarro() + " " + carro.getModeloCarro() + " Precio: $" + carro.getPrecioCarro());
            }
        }
    }

    public void modificarCarrosDisponibles() {
        String opcionModificar, opcionModificarUno;
        Concesionario concesionario = concesionarioMain.get(0);
        ArrayList<Carro> carros = concesionario.getListaCarrosDisponibles();
        limpiarPantalla();
        escribirEncabezado("Modificar Carros Disponibles.");
        if (carros.isEmpty()) {
            escribirEncabezado("No hay Carros Disponibles para Modificar.");
            esperarTecla();
        } else {
            do {
                imprimirCarrosDisponibles();
                escribirEncabezado("Seleccione el Carro que Desea Modificar: ");
                int opcion = scanner.nextInt() - 1;
                scanner.nextLine();
                if (opcion >= carros.size()) {
                    escribirEncabezado("El Carro Seleccionado No Existe.");
                    esperarTecla();
                } else {
                    do {
                        escribirEncabezado("Que Desea Modificar\n1. Marca.\n2. Modelo.\n3. Precio.");
                        String actualizarCarro = scanner.nextLine();
                        if (actualizarCarro.equalsIgnoreCase("Marca") || actualizarCarro.equalsIgnoreCase("1")) {
                            limpiarPantalla();
                            escribirEncabezado("La Marca Actual del Carro es: " + carros.get(opcion).getMarcaCarro());
                            escribirEncabezado("Ingrese la Nueva Marca del Carro Seleccionado: ");
                            String newMarcaCarro = scanner.nextLine();
                            limpiarPantalla();
                            escribirEncabezado("¿Esta Seguro que Desea Modificar La Marca de " + carros.get(opcion).getMarcaCarro() + " a " + newMarcaCarro + "? Si/No");
                            String opcionCarro = scanner.nextLine();
                            if (opcionCarro.equalsIgnoreCase("si")) {
                                limpiarPantalla();
                                carros.get(opcion).setMarcaCarro(newMarcaCarro);
                                escribirEncabezado("La Marca del Carro fue Codificada a: " + newMarcaCarro);
                                esperarTecla();
                            }
                        }
                        if (actualizarCarro.equalsIgnoreCase("Modelo") || actualizarCarro.equalsIgnoreCase("2")) {
                            limpiarPantalla();
                            escribirEncabezado("El Modelo Actual del Carro es: " + carros.get(opcion).getModeloCarro());
                            escribirEncabezado("Ingrese el Nuevo Modelo del Carro Seleccionado: ");
                            String newModeloCarro = scanner.nextLine();
                            limpiarPantalla();
                            escribirEncabezado("¿Esta Seguro que Desea Modificar el Modelo de " + carros.get(opcion).getMarcaCarro() + " " + carros.get(opcion).getModeloCarro() + " a " + carros.get(opcion).getMarcaCarro() + " " + newModeloCarro + "? Si/No");
                            String opcionModelo = scanner.nextLine();
                            if (opcionModelo.equalsIgnoreCase("si")) {
                                limpiarPantalla();
                                carros.get(opcion).setModeloCarro(newModeloCarro);
                                escribirEncabezado("El Modelo del Carro fue Modificado a: " + carros.get(opcion).getMarcaCarro() + " " + newModeloCarro);
                                esperarTecla();
                            }
                        }
                        if (actualizarCarro.equalsIgnoreCase("Precio") || actualizarCarro.equalsIgnoreCase("3")) {
                            limpiarPantalla();
                            escribirEncabezado("El Precio Actual del Carro es: $" + carros.get(opcion).getPrecioCarro());
                            escribirEncabezado("Ingrese el nuevo Precio del Carro seleccionado: ");
                            Long newPrecioCarro = scanner.nextLong();
                            limpiarPantalla();
                            escribirEncabezado("¿Esta Seguro que Desea Modificar el Precio de: $" + carros.get(opcion).getPrecioCarro() + " a $" + newPrecioCarro + "? Si/No");
                            String opcionPrecio = scanner.nextLine();
                            scanner.nextLine();
                            if (opcionPrecio.equalsIgnoreCase("si")) {
                                limpiarPantalla();
                                carros.get(opcion).setPrecioCarro(newPrecioCarro);
                                escribirEncabezado("El Precio del Carro fue Modificado a: $" + newPrecioCarro);
                                esperarTecla();
                            }
                        }
                        escribirEncabezado("¿Desea Modificar otra Caracteristica del Carro Seleccionado? Si/No");
                        opcionModificarUno = scanner.nextLine();
                    } while (opcionModificarUno.equalsIgnoreCase("si"));
                }
                limpiarPantalla();
                escribirEncabezado("¿Desea Modificar otro Carro? Si/No");
                opcionModificar = scanner.nextLine();
            } while (opcionModificar.equalsIgnoreCase("si"));

        }
    }

    public void eliminarCarro() {
        limpiarPantalla();
        String varEliminar;
        Concesionario concesionario = concesionarioMain.get(0);
        ArrayList<Carro> carros = concesionario.getListaCarrosDisponibles();
        escribirEncabezado("Eliminar Carros.");
        do {
            if (carros.isEmpty()) {
                escribirEncabezado("No Existe Ningun Carro Registrado.");
                esperarTecla();
                break;
            } else {
                imprimirCarrosDisponibles();
                escribirEncabezado("Seleccione el Carro que Desea Elimar:");
                int opcion = scanner.nextInt() - 1;
                scanner.nextLine();
                if (opcion >= carros.size()) {
                    escribirEncabezado("El Carro Seleccionado No Existe.");
                    esperarTecla();
                } else {
                    limpiarPantalla();
                    escribirEncabezado("Se Eliminara el Carro: " + carros.get(opcion).getMarcaCarro() + " " + carros.get(opcion).getModeloCarro() + " Precio: " + carros.get(opcion).getPrecioCarro() + " Desea Continuar? Si/No");
                    String varContinuar = scanner.nextLine();
                    if (varContinuar.equalsIgnoreCase("si")) {
                        concesionario.borrarCarro(opcion);
                        escribirEncabezado("El Carro fue Eliminado.");
                    } else {
                        escribirEncabezado("No se Elimino el Carro.");
                    }
                }
            }
            escribirEncabezado("Desea Eliminar otro Carro? Si/No");
            varEliminar = scanner.nextLine();
        } while (varEliminar.equalsIgnoreCase("si"));
    }

    public void realizarCompra() {
        int acumuladoVentaPersonaActual;
        double aculumadoNetoPersonaActual;
        Concesionario concesionario = concesionarioMain.get(0);
        ArrayList<Carro> carros = concesionario.getListaCarrosDisponibles();
        ArrayList<PersonalVentas> personalVentas = concesionario.getListaPersonas();
        ArrayList<Carro> carrosVendidos = concesionario.getListaCarrosVendidos();
        limpiarPantalla();
        escribirEncabezado("Realizar Venta.");
        if (personalVentas.isEmpty()) {
            escribirEncabezado("No hay Personal De Venta Disponible en el Momento Para Registrar Su Compra.");
            esperarTecla();
        } else {
            if (carros.isEmpty()) {
                escribirEncabezado("No hay Carros En el Inventario, ¡Regrese Pronto!");
                esperarTecla();
            } else {
                limpiarPantalla();
                imprimirPersonalVentas();
                escribirEncabezado("Seleccione el Vendedor que desea que lo Atienda.");
                int opcionVenta = scanner.nextInt() - 1;
                if (opcionVenta >= personalVentas.size()) {
                    escribirEncabezado("El Vendedor Seleccionado No Existe.");
                    esperarTecla();
                } else {
                    limpiarPantalla();
                    escribirEncabezado("El Vendedor que lo Atendera es: " + personalVentas.get(opcionVenta).getNombrePersonalVentas());
                    imprimirCarrosDisponibles();
                    escribirEncabezado("Seleccione el Carro que Desea Comprar.");
                    int opcionCarro = scanner.nextInt() - 1;
                    scanner.nextLine();
                    if (opcionCarro >= carros.size()) {
                        escribirEncabezado("El Carro Seleccionado No Existe.");
                        esperarTecla();
                    } else {
                        limpiarPantalla();
                        escribirEncabezado("Usted Comprara el Carro: " + carros.get(opcionCarro).getMarcaCarro() + " " + carros.get(opcionCarro).getModeloCarro() + " Por un Precio de: $" + carros.get(opcionCarro).getPrecioCarro() + "\nDesea Continuar con la Compra? Si/No");
                        String varContinuar = scanner.nextLine();
                        if (varContinuar.equalsIgnoreCase("si")) {
                            Carro carroVendido = new Carro(carros.get(opcionCarro).getMarcaCarro(), carros.get(opcionCarro).getModeloCarro(), carros.get(opcionCarro).getPrecioCarro());
                            PersonalVentas vendedorActual = concesionario.getListaPersonas().get(opcionVenta);
                            acumuladoVentaPersonaActual = vendedorActual.getCantidadVentas();
                            vendedorActual.setCantidadVentas(acumuladoVentaPersonaActual + 1);
                            aculumadoNetoPersonaActual = vendedorActual.getNetoAcumulado();
                            vendedorActual.setNetoAcumulado(aculumadoNetoPersonaActual + carros.get(opcionCarro).getPrecioCarro());
                            concesionario.addCarroVendido(carroVendido);
                            escribirEncabezado("¡FELICIDADES POR LA COMPRA DE SU: " + carros.get(opcionCarro).getMarcaCarro() + " " + carros.get(opcionCarro).getModeloCarro());
                            esperarTecla();
                            concesionario.borrarCarro(opcionCarro);
                        } else {
                            escribirEncabezado("No se Realizo la Compra, ¡Regrese Pronto!");
                            esperarTecla();
                        }
                    }
                }
            }

        }
    }

    public void imprimirVentasTotales() {
        Concesionario concesionario = concesionarioMain.get(0);
        ArrayList<Carro> carrosVendidos = concesionario.getListaCarrosVendidos();
        int total = 0;
        limpiarPantalla();
        if (carrosVendidos.isEmpty()) {
            escribirEncabezado("No Se a Vendido Ningun Carro");
            esperarTecla();
        } else {
            escribirEncabezado("Lista de Carros Vendidos ");
            for (int i = 0; i < carrosVendidos.size(); i++) {
                Carro carro = carrosVendidos.get(i);
                System.out.println((i + 1) + ". " + carro.getMarcaCarro() + " " + carro.getModeloCarro() + " Precio: $" + carro.getPrecioCarro());
            }
            for (int j = 0; j < carrosVendidos.size(); j++) {
                Carro carro = carrosVendidos.get(j);
                total += carro.getPrecioCarro();
            }
            escribirEncabezado("Total de Carros Vendidos: " + carrosVendidos.size() + "\nIngresos Totales: " + total);
            esperarTecla();
        }
    }

    public static void main(String[] args) {
        menus.interfazConcesionario();
        menus.imprimirMenu();
    }
}
