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
                String region = datos[3]; // Se agrega la región
                agregarPersona(nombre, rut, codigoMesa, region); // Se pasa la región al método agregarPersona
            }
        } catch (IOException e) {
            System.err.println("Error al cargar las mesas desde el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static String[] buscarMesaPorRut(String rut) {
        System.out.println("Buscando RUT: " + rut);
        String[] resultado = new String[2]; // Array para almacenar el código de la mesa y la región
        for (Mesa mesa : mesas.values()) {
            Persona persona = mesa.getPersona(rut);
            if (persona != null) {
                System.out.println("RUT encontrado en la mesa: " + mesa.getCodigo());
                resultado[0] = mesa.getCodigo(); // Almacena el código de la mesa
                resultado[1] = persona.getRegion(); // Almacena la región
                return resultado;
            }
        }
        System.out.println("RUT no encontrado en ninguna mesa.");
        return null;
    }
    
    public static void agregarPersona(String nombre, String rut, String codigoMesa, String region) {
        Mesa mesa = mesas.get(codigoMesa);
        if (mesa == null) {
            mesa = new Mesa(codigoMesa);
            mesas.put(codigoMesa, mesa);
        }
        Persona persona = new Persona();
        persona.setPersona(nombre, rut, codigoMesa, region); // Se pasa la región como parámetro
        mesa.addPersona(persona);
    }
    
    public static String buscarPersonasPorRegion(String region) {
    StringBuilder resultado = new StringBuilder();
    boolean personasEncontradas = false;
    for (Mesa mesa : mesas.values()) {
        for (Persona persona : mesa.getPersonas()) {
            if (persona.getRegion().equalsIgnoreCase(region)) {
                if (!personasEncontradas) {
                    resultado.append("Personas registradas en la región ").append(region).append(":\n");
                    personasEncontradas = true;
                }
                resultado.append("Nombre: ").append(persona.getNombre()).append(", RUT: ").append(persona.getRut()).append(", Mesa: ").append(mesa.getCodigo()).append("\n");
            }
        }
    }
    if (!personasEncontradas) {
        resultado.append("Ingrese la region de esta manera especifica (Región de Valparaíso) ");
    }
    return resultado.toString();
}
}
