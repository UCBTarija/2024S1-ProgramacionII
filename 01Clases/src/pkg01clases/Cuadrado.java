package pkg01clases;

public class Cuadrado implements Figura{

    public int lado;

    public Cuadrado(int a) {
        this.lado = a;
    }

    public Cuadrado(String s) {
        this.lado = Integer.parseInt(s);
    }

    public static Cuadrado fromString(String s) {
        Cuadrado c = new Cuadrado(s.length());
        return c;
    }

    @Override
    public void dibujar() {
        String linea;

        for (int i = 0; i < lado; i++) {
            linea = "";
            for (int j = 0; j < lado; j++) {
                linea = linea + "*";
            }
            System.out.println(linea);
        }
    }
    
    @Override
    public void imprimirNombre(){
        System.out.println("cuadrado");
    }

    public int getArea(){
        return lado * lado;
    }
    
    public int getPerimetro(){
        return lado * 4;
    }
       
    
}
