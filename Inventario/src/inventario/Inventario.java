package inventario;

import java.util.HashMap;

public class Inventario {

    public static void main(String[] args) {
        Producto producto = new Producto();
        producto.id = "001";
        producto.nombre = "Monitor";
        
        Producto producto2 = new Producto();
        producto2.id = "002";
        producto2.nombre = "Teclado";
        
        System.out.println(producto);
        System.out.println(producto2);
        
        
//        int opcion = 20;
//
//        if (opcion == 10) {
//            System.out.println("-10-");
//        } else {
//            if (opcion == 20) {
//                System.out.println("-20-");
//            } else {
//                if (opcion == 30) {
//                    System.out.println("-30-");
//                }
//            }
//        }
//
//        if (opcion == 10) {
//            System.out.println("-10-");
//        } else if (opcion == 20) {
//            System.out.println("-20-");
//        } else if (opcion == 30) {
//            System.out.println("-30-");
//        }
//        
//        switch(opcion){
//            case 10: 
//                System.out.println("-a10-");
//                break;
//            case 20:
//                System.out.println("-b20-");
//                break;
//            case 30:
//                System.out.println("-c30-");
//                
//        }
//        
//        int x = 0;
//        while(x < 10){
//            System.out.println(x);
//            x++;
//        }
//        
//        for(int j  = 0; j < 10; j++){
//            System.out.println(j);
//        }
    }
}
