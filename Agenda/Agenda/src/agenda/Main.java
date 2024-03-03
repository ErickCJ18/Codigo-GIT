package agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instanciar un objeto de la clase Agenda
        Agenda miAgenda = new Agenda();

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            // Mostrar menú
            System.out.println("Menú:");
            System.out.println("1) Añadir contacto");
            System.out.println("2) Eliminar contacto");
            System.out.println("3) Buscar contacto");
            System.out.println("4) Mostrar todos los contactos");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");
            
            // Leer la opción del usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    // Añadir contacto
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(nombre, telefono, email);
                    miAgenda.agregarContacto(nuevoContacto);

                    System.out.println("Contacto agregado con éxito.");
                    break;
                case 2:
                    // Eliminar contacto
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();

                    Contacto contactoEliminar = miAgenda.buscarContactoPorNombre(nombreEliminar);

                    if (contactoEliminar != null) {
                        miAgenda.eliminarContacto(contactoEliminar);
                        System.out.println("Contacto eliminado con éxito.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 3:
                    // Buscar contacto
                    System.out.print("Nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();

                    Contacto contactoBuscar = miAgenda.buscarContactoPorNombre(nombreBuscar);

                    if (contactoBuscar != null) {
                        System.out.println("Contacto encontrado:");
                        System.out.println(contactoBuscar);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 4:
                    // Mostrar todos los contactos
                    System.out.println("Todos los contactos:");
                    miAgenda.mostrarTodosLosContactos();
                    break;
                case 0:
                    // Salir del programa
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 0);

        // Cerrar el scanner al salir del programa
        scanner.close();
    }
}