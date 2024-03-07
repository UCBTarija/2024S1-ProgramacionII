package pkg01clases;

public class Cuadrado {

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
       

}
