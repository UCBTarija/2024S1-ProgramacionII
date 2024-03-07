package pkg01clases;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*Cuadrado c = new Cuadrado("4");
        c.dibujar();


        Cuadrado d = Cuadrado.fromString("12345");
        d.dibujar();
        
        Rectangulo r = new Rectangulo(3, 4);
        r.dibujar();
        System.out.println(r.getPerimetro());*/
        
        ArrayList<Rectangulo> lista = new ArrayList();
        lista.add(new Rectangulo(1,2));
        
        lista.add(new Rectangulo(2,2));
        lista.add(new Rectangulo(2,3));
        lista.add(new Rectangulo(3,1));
        
        System.out.println(lista.size());
        
        for(int i = 0; i < lista.size(); i++){
            Rectangulo a = lista.get(i);
            a.dibujar();            
        }
        
        ArrayList lista2 = new ArrayList();
        lista2.add(new Cuadrado(3));
        lista2.add(new Rectangulo(2,3));
        
        for(int i = 0; i < lista2.size(); i++){
            Object o = lista2.get(i);
            
            if(o instanceof Cuadrado){
                Cuadrado c = (Cuadrado)lista2.get(i);
                c.dibujar();
            }
            
            if(o instanceof Rectangulo){
                Rectangulo c = (Rectangulo)lista2.get(i);
                c.dibujar();
            }
        }
        
        
        
    }
    
}
