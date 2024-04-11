
package ucb.programacionii.inventario.domain;

import java.util.Random;


public class Persona {

    private int id;
    private int ci;
    private String nombre;
    
    public Persona(int id, int ci, 
            String nombre){
        this.id = id;
        this.ci = ci;
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public static int getNextId(){
        Random rnd = new Random();
        return rnd.nextInt();
    }
}
