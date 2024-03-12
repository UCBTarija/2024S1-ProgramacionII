package pkg01clases;

public abstract class Figura {
    
    public String nombre;
    
    public abstract void dibujar();
    
    public void imprimirNombre(){
        System.out.println(nombre);
    }
    
}
