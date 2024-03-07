package poo;


public class Animal extends Object{
    
    
    private String nombre;
    public int patas;
    
    public void comer(){
        System.out.println("Animal comieno...");
    }
    
    public int getPatas(){
        return this.patas;
    }
    
    public void setPatas(int value) throws RuntimeException{
        if(value != 2){
            throw new RuntimeException("Patas Fuera de rango");
        }
        this.patas = value;
    }
    
    public String getNombre(){
        return "Mi nombbre es " + this.nombre;
    }
    
    public void setNombre(String value) throws Exception{
        if(value.length() > 10){
            throw new Exception("Fuera de rango");
        }
        this.nombre = value;
        
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
