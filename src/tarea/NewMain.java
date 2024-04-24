package tarea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewMain {

    public static void main(String[] args) {
        // Cargar las mesas desde el archivo CSV
        RegistroElectoral.cargarMesasDesdeArchivo("C:\\Users\\Ignacio\\Desktop\\Cosas e universidad\\Proye\\Tarea\\build\\classes\\tarea\\mesas.csv");
        boolean continuar = true;
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(System.in))) {
            while (continuar) {
                System.out.println("Menú:");
                System.out.println("1. Buscar persona registrada");
                System.out.println("2. Buscar por región");
                System.out.println("3. Eliminar persona registrada");
                System.out.println("4. Lista de personas por mesa");
                System.out.println("5. Salir");
                System.out.println("Seleccione una opción:");
                String opcion = lector.readLine();

                switch (opcion) {
                    case "1":
                        System.out.println("Ingrese su RUT (sin puntos y con guion):");
                        String rut = lector.readLine();
                        // Buscar la mesa de votación para el RUT dado
                        String mesaVotacion = RegistroElectoral.buscarMesaPorRut(rut);
                        if (mesaVotacion != null) {
                            System.out.println("Usted debe votar en la mesa: " + mesaVotacion);
                        } else {
                            System.out.println("Usted no está registrado para votar.");
                        }
                        break;
                    case "2":
                        // Implementación para buscar por región
                        break;
                    case "3":
                        // Implementación para eliminar persona registrada
                        break;
                    case "4":
                        // Implementación para lista de personas por mesa
                        break;
                    case "5":
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer la entrada del usuario: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
