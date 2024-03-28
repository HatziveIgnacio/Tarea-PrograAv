import java.io.*;


public class main {
    
    public static void main(String[] args ) throws IOException {


        BufferedReader lector = new BufferedReader( new InputStreamReader( System.in ) );

        Persona personauno = new Persona();
        System.out.print("Ingrese Nombre : ");
        String nombre = lector.readLine();

        System.out.print("Ingrese rut : ");
        String rut = lector.readLine();

        System.out.print("Ingrese el codigo de su Mesa : ");
        String mesa = lector.readLine();

        personauno.setPersona(nombre, rut, mesa);
        
        System.out.println("\n"+ " - " + personauno.getNombre() + " - " + personauno.getRut() + " - " + personauno.getMesa() );

        // ABRIA QUE CREAR UN MAPA DE MESAS, FILTRANDO POR EL CODIGO DE CADA MESA, ANALIZAR. SOLAMENTE ESTOY CREANDO LAS CLASES PARA LUEGO HACER MAIN COMPLETO
    }



}

/* Ver como "Sincronizar"  Mesas/personas, IDEAS: 
     - Hacer un mapa con los codigos de las mesas, asi sincronizar las mesas con arrayList de las personas que votan en ese lugar (no tengo claridad si es lo que necesitamos-buscamos)
    


    Cosas a ver:
      - Arraylist en las mesas de las personas que votan en ella.
      - Analizar constructores de las clases
 */