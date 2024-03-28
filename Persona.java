
public class Persona {
    private String nombre;
    private String rut;
    private String mesaVoto;
    private String voto;

    public void setPersona(String nombre, String rut, String mesaVoto ) {
        this.nombre = nombre;
        this.rut = rut;
        this.mesaVoto = mesaVoto;
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

    public String getVoto() {
        return voto;
    }


    
}