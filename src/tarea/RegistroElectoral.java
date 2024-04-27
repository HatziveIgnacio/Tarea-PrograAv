package tarea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistroElectoral {
    private static Map<String, Mesa> mesas = new HashMap<>();

    public static Map<String, Mesa> getMesas() {
        return mesas;
    }

    public static void cargarMesasDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(", ");
                String nombre = datos[0];
                String rut = datos[1];
                String codigoMesa = datos[2];
                agregarPersona(nombre, rut, codigoMesa);
            }
        } catch (IOException e) {
            System.err.println("Error al cargar las mesas desde el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void agregarPersona(String nombre, String rut, String codigoMesa) {
        Mesa mesa = mesas.get(codigoMesa);
        if (mesa == null) {
            mesa = new Mesa(codigoMesa);
            mesas.put(codigoMesa, mesa);
        }
        Persona persona = new Persona();
        persona.setPersona(nombre, rut, codigoMesa);
        mesa.addPersona(persona);
    }

    public static String buscarMesaPorRut(String rut) {
        System.out.println("Buscando RUT: " + rut);
        for (Mesa mesa : mesas.values()) {
            Persona persona = mesa.getPersona(rut);
            if (persona != null) {
                System.out.println("RUT encontrado en la mesa: " + mesa.getCodigo());
                return mesa.getCodigo();
            }
        }
        System.out.println("RUT no encontrado en ninguna mesa.");
        return null;
    }
}
