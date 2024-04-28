package tarea;

import java.util.Collection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class NewMain {

    public static void main(String[] args) {
        // Cargar las mesas desde el archivo CSV
        RegistroElectoral.cargarMesasDesdeArchivo("C:\\Users\\Ignacio\\Desktop\\Cosas e universidad\\Proye\\mesas.csv");
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
                        String[] mesaYRegion = RegistroElectoral.buscarMesaPorRut(rut);
                        if (mesaYRegion != null) {
                            System.out.println("Usted debe votar en la mesa: " + mesaYRegion[0] + ", en la " + mesaYRegion[1]);
                        } else {
                            System.out.println("Usted no está registrado para votar.");
                        }
                        break;
                    case "2":
                        System.out.println("Ingrese el nombre de la región: (Ejemplo de entada: Región de Valparaíso)"); // SE DEBE INGRESAR DE ESTA FORNA: Región de Valparaíso
                        String region = lector.readLine();
                        RegistroElectoral.buscarPersonasPorRegion(region);
                        break;
                    case "3":
                        System.out.println("Ingrese el RUT de la persona a eliminar (sin puntos y con guion):");
                        String rutEliminar = lector.readLine();
                        boolean personaEliminada = false;
                        Map<String, Mesa> mesas = RegistroElectoral.getMesas();
                        for (Mesa mesa : mesas.values()) {
                            Persona persona = mesa.getPersona(rutEliminar);
                            if (persona != null) {
                                mesa.removePersona(rutEliminar);
                                personaEliminada = true;
                                break; // Persona encontrada y eliminada, salir del bucle
                            }
                        }
                        if (personaEliminada) {
                            System.out.println("La persona con RUT " + rutEliminar + " fue eliminada correctamente.");
                        } else {
                            System.out.println("La persona con RUT " + rutEliminar + " no se encontró en ninguna mesa.");
                        }
                        break;
                    case "4":
                        System.out.println("Ingrese el código de la mesa:");
                        String codigoMesa = lector.readLine();
                        Mesa mesaSeleccionada = RegistroElectoral.getMesas().get(codigoMesa);
                        if (mesaSeleccionada != null) {
                            System.out.println("Lista de personas en la mesa " + codigoMesa + ":");
                            Collection<Persona> personas = mesaSeleccionada.getPersonas();
                            if (!personas.isEmpty()) {
                                for (Persona persona : personas) {
                                    System.out.println("Nombre: " + persona.getNombre() + ", RUT: " + persona.getRut());
                                }
                            } else {
                                System.out.println("No hay personas registradas en la mesa " + codigoMesa + ".");
                            }
                        } else {
                            System.out.println("La mesa con código " + codigoMesa + " no existe.");
                        }
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
