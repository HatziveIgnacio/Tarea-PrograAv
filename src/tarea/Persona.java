package tarea;

public class Persona {
    private String nombre;
    private String rut;
    private String mesaVoto; // Mesa de votación a la que está asignada
    private String region; // Nueva entrada para la región

    // Métodos para establecer y obtener los datos de la persona
    public void setPersona(String nombre, String rut, String mesaVoto, String region) {
        this.nombre = nombre;
        this.rut = rut;
        this.mesaVoto = mesaVoto;
        this.region = region;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getMesa() {
        return mesaVoto;
    }

    public String getRegion() {
        return region;
    }
}
