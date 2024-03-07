package poo;

public class Main {

    public static void main(String[] args) {
        /* Animal animal = new Animal();
        try {
            animal.setNombre("Layca cccccc");
            System.out.println(animal.getNombre());
            animal.setPatas(3);
            
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Runtime Error",
                    JOptionPane.ERROR_MESSAGE
            );
            //e.printStackTrace();        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "General Error",
                    JOptionPane.ERROR_MESSAGE
            );
            //e.printStackTrace();
        }
        System.out.println("Fin");
         */

        Animal animal = new Animal();
        
        try {
            animal.setNombre("Violeta");
            System.out.println(animal);
        }catch(Exception e){}
        
        Mamifero mamifero = new Mamifero();
        Ave ave = new Ave();

        alimentar(animal);
        alimentar(mamifero);
        alimentar(ave);

    }

    public static void alimentar(Animal animal) {
        animal.comer();
    }
}
