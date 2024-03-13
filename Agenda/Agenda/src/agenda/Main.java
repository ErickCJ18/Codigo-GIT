package agenda;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda miAgenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            displayMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    addContact(miAgenda, scanner);
                    break;
                case 2:
                    deleteContact(miAgenda, scanner);
                    break;
                case 3:
                    searchContact(miAgenda, scanner);
                    break;
                case 4:
                    showAllContacts(miAgenda);
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1) Agregar contacto");
        System.out.println("2) Eliminar contacto");
        System.out.println("3) Buscar contacto");
        System.out.println("4) Mostrar todos los contactos");
        System.out.println("5) Salir");
        System.out.print("Elige una opción: ");
    }

    private static void addContact(Agenda miAgenda, Scanner scanner) {
        System.out.println("------ Añadir Contacto ------");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contacto nuevoContacto = new Contacto(nombre, telefono, email);
        miAgenda.addContact(nuevoContacto);

        System.out.println("Contacto agregado con éxito.");
    }

    private static void deleteContact(Agenda miAgenda, Scanner scanner) {
        System.out.println("------ Eliminar Contacto ------");
        System.out.print("Nombre del contacto a eliminar: ");
        String nombreEliminar = scanner.nextLine();

        Contacto contactoEliminar = miAgenda.searchContact(nombreEliminar);

        if (contactoEliminar != null) {
            miAgenda.deleteContact(contactoEliminar);
            System.out.println("Contacto eliminado con éxito.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void searchContact(Agenda miAgenda, Scanner scanner) {
        System.out.println("------ Buscar Contacto ------");
        System.out.print("Nombre del contacto a buscar: ");
        String nombreBuscar = scanner.nextLine();

        Contacto contactoBuscar = miAgenda.searchContact(nombreBuscar);

        if (contactoBuscar != null) {
            System.out.println("Contacto encontrado:");
            System.out.println(contactoBuscar);
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    private static void showAllContacts(Agenda miAgenda) {
        System.out.println("------ Mostrar Contactos ------");
        System.out.println("Todos los contactos:");
        miAgenda.showContact();
    }
}
