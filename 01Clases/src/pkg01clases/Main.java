package pkg01clases;

public class Main {

    public static void main(String[] args) {
        Cuadrado c = new Cuadrado("4");
        c.dibujar();


        Cuadrado d = Cuadrado.fromString("12345");
        d.dibujar();
        
        Rectangulo r = new Rectangulo(3, 4);
        r.dibujar();
        
    }
    
}
