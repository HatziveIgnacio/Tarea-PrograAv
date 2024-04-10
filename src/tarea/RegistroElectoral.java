package tarea;

import java.util.HashMap;
import java.util.Map;
import tarea.Mesa;
import tarea.Persona;

public class RegistroElectoral {
    private Map<String, Mesa> mesas;

    public RegistroElectoral() {
        this.mesas = new HashMap<>();
    }

    public void agregarMesa(String codigo) {
        Mesa mesa = new Mesa();
        mesa.setMesa(codigo);
        mesas.put(codigo, mesa);
    }

    public void agregarPersona(String nombre, String rut, String codigoMesa) {
        Mesa mesa = mesas.get(codigoMesa);
        if (mesa != null) {
            Persona persona = new Persona();
            persona.setPersona(nombre, rut, codigoMesa);
            mesa.addPersona(persona);
        }
    }

    public String buscarMesaPorRut(String rut) {
        for (Mesa mesa : mesas.values()) {
            if (mesa.getPersona(rut) != null) {
                return mesa.getCodigo();
            }
        }
        return null;
    }
}

