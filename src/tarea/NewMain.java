/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Ignacio
 */
public class NewMain {

    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        // Crear un objeto para manejar las mesas y personas
        RegistroElectoral registroElectoral = new RegistroElectoral();

        // Agregar algunas mesas y personas de ejemplo
        registroElectoral.agregarMesa("A123");
        registroElectoral.agregarMesa("B123");
        registroElectoral.agregarPersona("Ignacio Layana", "21307959-K", "A123");
        registroElectoral.agregarPersona("Alvaro Del Pino", "12345678-9", "B123");

        // Solicitar el RUT de la persona
        System.out.println("Ingrese su RUT (sin puntos y con guion):");
        String rut = lector.readLine();

        // Buscar la mesa de votación para el RUT dado
        String mesaVotacion = registroElectoral.buscarMesaPorRut(rut);
        if (mesaVotacion != null) {
            System.out.println("Usted debe votar en la mesa: " + mesaVotacion);
        } else {
            System.out.println("Usted no está registrado para votar.");
        }

        lector.close();
    }


}


