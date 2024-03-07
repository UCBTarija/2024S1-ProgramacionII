package pkg01clases;

public class Rectangulo {

    public int lado1;
    public int lado2;

    public Rectangulo(int a, int b) {
        this.lado1 = a;
        this.lado2 = b;
    }

    public void dibujar() {
        String linea;

        for (int i = 0; i < lado1; i++) {
            linea = "";
            for (int j = 0; j < lado2; j++) {
                linea = linea + "*";
            }
            System.out.println(linea);
        }
    }

}
