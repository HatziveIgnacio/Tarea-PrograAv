package tarea;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Mesa {
    private String codigo;
    private Map<String, Persona> personas;

    public Mesa(String codigo) {
        this.codigo = codigo;
        this.personas = new HashMap<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void addPersona(Persona persona) {
        personas.put(persona.getRut(), persona);
    }

    public Persona getPersona(String rut) {
        return personas.get(rut);
    }

    public void removePersona(String rut) {
        personas.remove(rut);
    }

    public Collection<Persona> getPersonas() {
        return personas.values();
    }

    // Método para verificar si el mapa de personas contiene valores
    public boolean contienePersonas() {
        return !personas.isEmpty();
    }
}
