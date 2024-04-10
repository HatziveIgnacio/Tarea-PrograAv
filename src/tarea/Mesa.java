
package tarea;

import java.io.*;
import java.util.*;
// TEST
public class Mesa {
    private int cantVotantes = 0;
    private String codigo;
    private Map<String, Persona> votantes;

    public void setMesa(String codigo) {
        this.codigo = codigo;
        this.votantes = new HashMap<>();
    }

    public void addPersona(Persona persona) {
        votantes.put(persona.getRut(), persona); // Agregar la persona al mapa de votantes usando su RUT como clave
        cantVotantes++; // Incrementar la cantidad de votantes
    }

    public Persona getPersona(String rut) {
        return votantes.get(rut); // Obtener una persona por su RUT
    }

    public void removePersona(String rut) {
        votantes.remove(rut); // Eliminar una persona del mapa de votantes
        cantVotantes--; // Decrementar la cantidad de votantes
    }

    public int getCantVotantes() {
        return cantVotantes;
    }

    public String getCodigo() {
        return codigo;
    }

    // Método para guardar las mesas en un archivo CSV
    public void guardarMesasEnArchivo(String nombreArchivo) throws IOException {
        try (PrintWriter escritor = new PrintWriter(new FileWriter(nombreArchivo))) {
            // Escribir cada votante en el archivo CSV
            for (Map.Entry<String, Persona> entry : votantes.entrySet()) {
                Persona persona = entry.getValue();
                escritor.println(persona.getNombre() + "," + persona.getRut() + "," + codigo);
            }
        }
    }

    // Método para cargar las mesas desde un archivo CSV
    public void cargarMesasDesdeArchivo(String nombreArchivo) throws IOException {
        votantes.clear(); // Limpiar mapa antes de cargar nuevas mesas
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            // Leer cada línea del archivo CSV
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                String rut = partes[1];
                // Se asume que la mesa se asigna al leer del archivo
                if (partes.length >= 3 && partes[2].equals(codigo)) {
                    Persona persona = new Persona();
                    persona.setPersona(nombre, rut, codigo);
                    addPersona(persona); // Agregar la persona a la mesa actual
                }
            }
        }
    }
}
