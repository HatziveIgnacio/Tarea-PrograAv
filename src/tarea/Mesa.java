package tarea;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private String codigo;
    private List<Persona> personas;

    public Mesa(String codigo) {
        this.codigo = codigo;
        this.personas = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void addPersona(Persona persona) {
        personas.add(persona);
    }

    public Persona getPersona(String rut) {
        for (Persona persona : personas) {
            if (persona.getRut().equals(rut)) {
                return persona;
            }
        }
        return null;
    }

    public void removePersona(String rut) {
        personas.removeIf(persona -> persona.getRut().equals(rut));
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public boolean contienePersonas() {
        return !personas.isEmpty();
    }
}