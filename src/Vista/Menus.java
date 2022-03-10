package Vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {

    private final Scanner scanner = new Scanner(System.in);
    private final Main main = new Main();

    public void carrito(String nombreConcesionario, String administrador) {
        System.out.println("                      ___..............._");
        System.out.println("             __.. ' _'.\"\"\"\"\"\"\\\\\"\"\"\"\"\"\"\"- .`-");
        System.out.println(" ______.-'         (_) |      \\\\           ` \\\\`-. _");
        System.out.println("/_       --------------'-------\\\\---....______\\\\__`.`  -..___");
        System.out.println("| T      _.----._           Xxx|x...           |          _.._`--. _");
        System.out.println("| |    .' ..--.. `.         XXX|XXXXXXXXXxx==  |       .'.---..`.     -._");
        System.out.println("\\_j   /  /  __  \\  \\        XXX|XXXXXXXXXXX==  |      / /  __  \\ \\        `-.");
        System.out.println(" _|  |  |  /  \\  |  |       XXX|\"\"'            |     / |  /  \\  | |          |");
        System.out.println("|__\\_j  |  \\__/  |  L__________|_______________|_____j |  \\__/  | L__________J");
        System.out.println("     `'\\ \\      / ./__________________________________\\ \\      / /___________\\");
        System.out.println("        `.`----'.'                                     `.`----'.'");
        System.out.println("          `\"\"\"\"'                                         `\"\"\"\"'");
        main.escribirEncabezado("CONCESIONARIO: " + nombreConcesionario + "\nGERENTE: " + administrador);
    }

    public void interfazConcesionario() {
        main.escribirEncabezado("BIENVENIDO A CREAR SU CONCESIONARIO.");
        System.out.println("                      ___..............._");
        System.out.println("             __.. ' _'.\"\"\"\"\"\"\\\\\"\"\"\"\"\"\"\"- .`-");
        System.out.println(" ______.-'         (_) |      \\\\           ` \\\\`-. _");
        System.out.println("/_       --------------'-------\\\\---....______\\\\__`.`  -..___");
        System.out.println("| T      _.----._           Xxx|x...           |          _.._`--. _");
        System.out.println("| |    .' ..--.. `.         XXX|XXXXXXXXXxx==  |       .'.---..`.     -._");
        System.out.println("\\_j   /  /  __  \\  \\        XXX|XXXXXXXXXXX==  |      / /  __  \\ \\        `-.");
        System.out.println(" _|  |  |  /  \\  |  |       XXX|\"\"'            |     / |  /  \\  | |          |");
        System.out.println("|__\\_j  |  \\__/  |  L__________|_______________|_____j |  \\__/  | L__________J");
        System.out.println("     `'\\ \\      / ./__________________________________\\ \\      / /___________\\");
        System.out.println("        `.`----'.'                                     `.`----'.'");
        System.out.println("          `\"\"\"\"'                                         `\"\"\"\"'");
        main.agregarNombreCyG();
    }

    public void imprimirMenu() {
        main.limpiarPantalla();
        boolean varSalir = false;
        int varOpcion;
        while (!varSalir) {
            main.limpiarPantalla();
            main.imprimirCarrito();
            main.escribirEncabezado("MENU PRINCIPAL");
            System.out.println("1. Concesionario.\n2. Personal de Ventas.\n3. Automoviles.\n4. Realizar una Compra.\n5. Salir.");
            try {
                main.escribirEncabezado("Seleccione la Opcion de su Preferencia: ");
                varOpcion = scanner.nextInt();
                switch (varOpcion) {
                    case 1 ->
                        imprimirMenuConcesionario();
                    case 2 ->
                        imprimirMenuPersonalVentas();
                    case 3 ->
                        imprimirMenuCarros();
                    case 4 ->
                        main.realizarCompra();
                    case 5 ->
                        varSalir = true;
                    default ->
                        main.escribirEncabezado("Los Valores Indicados no Concuerdan, Digite Nuevamente la Opcion.");
                }
            } catch (InputMismatchException ime) {
                main.limpiarPantalla();
                main.escribirEncabezado("Debe Indicar Solo Numeros. Presione Enter Para Continuar.");
                scanner.nextLine();
                scanner.nextLine();

            }
        }
        main.escribirEncabezado("El Programa ha Terminado.");
        main.escribirEncabezado("Programa realizado por Harold Andres Velasquez Tobar y Carlos Mario Vivas García.");
    }

    public void imprimirMenuConcesionario() {
        int i = 0;
        do {
            main.limpiarPantalla();
            main.imprimirCarrito();
            main.escribirEncabezado("MENU CONCESIONARIO");
            main.escribirEncabezado("1. Modificar Nombre del Concesionario. \n2. Modificar Nombre del Gerente. \n3. Ventas del Concesionario. \n4. Atras...");
            try {
                main.escribirEncabezado("Seleccione la Opcion de su Preferencia: ");
                int varOpcion = scanner.nextInt();
                switch (varOpcion) {
                    case 1 ->
                        main.modificarConcesionario();
                    case 2 ->
                        main.modificarGerente();
                    case 3 ->
                        main.imprimirVentasTotales();
                    case 4 ->
                        i++;
                    default -> {
                        main.limpiarPantalla();
                        main.escribirEncabezado(varOpcion + " No Es Una Opcion, Presione Enter Para Continuar");
                        scanner.nextLine();
                        scanner.nextLine();
                    }
                }
            } catch (InputMismatchException ime) {
                main.limpiarPantalla();
                main.escribirEncabezado("Debe Indicar Solo Numeros. Presione Enter Para Continuar.");
                scanner.nextLine();
                scanner.nextLine();
            }
        } while (i == 0);
    }

    public void imprimirMenuPersonalVentas() {
        int i = 0;
        do {
            main.limpiarPantalla();
            main.imprimirCarrito();
            main.escribirEncabezado("MENU PERSONAL DE VENTAS");
            main.escribirEncabezado("1. Agregar Personal de Ventas.\n2. Mostrar el Personal Y Sus Ventas.\n3. Modificar Personal de Ventas.\n4. Eliminar Personal de Venta \n5. Atras");
            try {
                main.escribirEncabezado("Seleccione la Opcion de su Preferencia: ");
                int varOpcion = scanner.nextInt();
                switch (varOpcion) {
                    case 1 ->
                        main.agregarPersonalVentas();
                    case 2 -> {
                        main.imprimirVentasDelPersonal();
                        main.esperarTecla();
                    }
                    case 3 ->
                        main.modificarPersonalVentas();
                    case 4 ->
                        main.eliminarPersonalVentas();
                    case 5 ->
                        i++;
                    default -> {
                        main.limpiarPantalla();
                        main.escribirEncabezado(varOpcion + " No Es Una Opcion, Presione Enter Para Continuar");
                        scanner.nextLine();
                        scanner.nextLine();
                    }
                }
            } catch (InputMismatchException ime) {
                main.limpiarPantalla();
                main.escribirEncabezado("Debe Indicar Solo Numeros. Presione Enter Para Continuar.");
                scanner.nextLine();
                scanner.nextLine();
            }
        } while (i == 0);
    }

    public void imprimirMenuCarros() {
        int i = 0;
        do {
            main.limpiarPantalla();
            main.imprimirCarrito();
            main.escribirEncabezado("MENU CARROS");
            main.escribirEncabezado("1. Agregar Carros al Inventario.\n2. Imprimir Carros Disponibles.\n3. Modificar Carros Disponibles.\n4. Eliminar Carros Disponibles.\n5. Atras...");
            try {
                main.escribirEncabezado("Seleccione la Opcion de su Preferencia: ");
                int varOpcion = scanner.nextInt();
                switch (varOpcion) {
                    case 1 ->
                        main.agregarCarroAlInventario();
                    case 2 -> {
                        main.imprimirCarrosDisponibles();
                        main.esperarTecla();
                    }
                    case 3 ->
                        main.modificarCarrosDisponibles();
                    case 4 ->
                        main.eliminarCarro();
                    case 5 ->
                        i++;
                    default -> {
                        main.limpiarPantalla();
                        main.escribirEncabezado(varOpcion + " No Es Una Opcion, Presione Enter Para Continuar");
                        scanner.nextLine();
                        scanner.nextLine();
                    }
                }
            } catch (InputMismatchException ime) {
                main.limpiarPantalla();
                main.escribirEncabezado("Debe Indicar Solo Numeros. Presione Enter Para Continuar.");
                scanner.nextLine();
                scanner.nextLine();
            }
        } while (i == 0);
    }

}
