package tarea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewMain {

    public static void main(String[] args) {
        // Cargar las mesas desde el archivo CSV
        RegistroElectoral.cargarMesasDesdeArchivo("C:\\Users\\Ignacio\\Desktop\\Cosas e universidad\\Proye\\Tarea\\build\\classes\\tarea\\mesas.csv");

        try (BufferedReader lector = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Ingrese su RUT (sin puntos y con guion):");
            String rut = lector.readLine();

            // Buscar la mesa de votación para el RUT dado
            String mesaVotacion = RegistroElectoral.buscarMesaPorRut(rut);
            if (mesaVotacion != null) {
                System.out.println("Usted debe votar en la mesa: " + mesaVotacion);
            } else {
                System.out.println("Usted no está registrado para votar.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el RUT: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
