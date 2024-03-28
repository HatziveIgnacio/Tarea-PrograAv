
public class Mesa {
    private int cantVotantes = 0; // VER COMO IR AUMENTANDO
    private String Codigo; // 
    //private Persona[] Votantes; // cambiar a arraylist para que sea dinamico

    public void setMesa(String codigo) {
        Codigo = codigo;
    }

    public void addPersona(Persona persona){
        cantVotantes++; // FALTA VER PARA ASIGNAR MEMORIA EN EL ARRAY DINAMICO, AUMENTAR TAMANO ARRAY EN ESTA FUNCION.
        //Votantes[cantVotantes] = persona; // ARRAYLIST CAMBIAR 

    }

    public void setCantVotantes(int cantVotantes) {
        this.cantVotantes = cantVotantes;
    }

    public int getCantVotantes() {
        return cantVotantes;
    }

    public String getCodigo() {
        return Codigo;
    }

    /*
    public Persona[] getVotantes() { // ARRAYLIST CAMBIAR 
        return Votantes;
    }
    */

}