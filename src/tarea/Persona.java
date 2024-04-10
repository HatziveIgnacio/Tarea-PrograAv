
package tarea;

public class Persona {
    private String nombre;
    private String rut;
    private String mesaVoto; // Mesa de votación a la que está asignada

    // Método para establecer los datos de la persona
    public void setPersona(String nombre, String rut, String mesaVoto) {
        this.nombre = nombre;
        this.rut = rut;
        this.mesaVoto = mesaVoto;
    }

    // Método para obtener el nombre de la persona
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el RUT de la persona
    public String getRut() {
        return rut;
    }

    // Método para obtener la mesa de votación a la que está asignada la persona
    public String getMesa() {
        return mesaVoto;
    }
}
