import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        // Cargar las mesas de votación desde el archivo CSV
        Map<String, List<Mesa>> mesasPorComuna = cargarMesasDesdeArchivo("mesas.csv");

        // Solicitar información de la persona
        System.out.print("Ingrese Nombre : ");
        String nombre = lector.readLine();

        System.out.print("Ingrese rut : ");
        String rut = lector.readLine();

        System.out.print("Ingrese la comuna de residencia: ");
        String comuna = lector.readLine();

        // Verificar si hay mesas asignadas a esa comuna
        List<Mesa> mesasEnComuna = mesasPorComuna.getOrDefault(comuna, Collections.emptyList());

        // Asignar la persona a la primera mesa disponible en la comuna
        Mesa mesaAsignada = mesasEnComuna.isEmpty() ? null : mesasEnComuna.get(0);

        // Crear la persona y mostrar la información
        Persona personaUno = new Persona();
        personaUno.setPersona(nombre, rut, mesaAsignada != null ? mesaAsignada.getCodigo() : "Sin Asignar");

        System.out.println("\nNombre: " + personaUno.getNombre());
        System.out.println("RUT: " + personaUno.getRut());
        System.out.println("Comuna de Residencia: " + comuna);
        System.out.println("Mesa de Votación Asignada: " + (mesaAsignada != null ? mesaAsignada.getCodigo() : "No Asignada"));
    }

    // Método para cargar las mesas de votación desde un archivo CSV
    public static Map<String, List<Mesa>> cargarMesasDesdeArchivo(String nombreArchivo) throws IOException {
        Map<String, List<Mesa>> mesasPorComuna = new HashMap<>();
        BufferedReader lectorArchivo = new BufferedReader(new FileReader(nombreArchivo));
        String linea;
        while ((linea = lectorArchivo.readLine()) != null) {
            String[] partes = linea.split(",");
            String codigoMesa = partes[0];
            String comuna = partes[1];
            Mesa mesa = new Mesa();
            mesa.setMesa(codigoMesa);
            mesasPorComuna.computeIfAbsent(comuna, k -> new ArrayList<>()).add(mesa);
        }
        lectorArchivo.close();
        return mesasPorComuna;
    }
}

/* Ver como "Sincronizar"  Mesas/personas, IDEAS: 
     - Hacer un mapa con los codigos de las mesas, asi sincronizar las mesas con arrayList de las personas que votan en ese lugar (no tengo claridad si es lo que necesitamos-buscamos)
    


    Cosas a ver:
      - Arraylist en las mesas de las personas que votan en ella.
      - Analizar constructores de las clases
 */
/* Ver como "Sincronizar"  Mesas/personas, IDEAS: 
     - Hacer un mapa con los codigos de las mesas, asi sincronizar las mesas con arrayList de las personas que votan en ese lugar (no tengo claridad si es lo que necesitamos-buscamos)
    


    Cosas a ver:
      - Arraylist en las mesas de las personas que votan en ella.
      - Analizar constructores de las clases
 */