package ucb.programacionii.inventario.infrastructure;

import java.util.ArrayList;
import java.util.Random;
import ucb.programacionii.inventario.domain.Persona;
import ucb.programacionii.inventario.domain.PersonaRepository;


public class PersonaRepositoryImpl implements PersonaRepository{

    private final ArrayList<Persona> personas = new ArrayList();
    
    @Override
    public Persona get(int id) throws Exception{
        for(Persona persona : personas){
            if(persona.getId() == id){
                return persona;
            }
        }
        throw new Exception("Objeto no econtrado");
    }

    @Override
    public int nextIdentity() {
        Random rnd = new Random();
        return rnd.nextInt();
    }

    @Override
    public boolean store(Persona persona) {
        
        for(Persona p : personas){
            if(p.getId() == persona.getId()){
                p.setCi(persona.getCi());
                p.setNombre(persona.getNombre());
                return true;
            }
        }
                
        personas.add(persona);
        return true;
    }

    @Override
    public boolean remove(Persona persona) {
        for(Persona p : personas){
            if(p.getId() == persona.getId()){
                personas.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Persona> search(String criterio) {
        ArrayList<Persona> lista = new ArrayList();
        
        for(Persona p : personas){
           if(p.getNombre().contains(criterio)){
               lista.add(p);
           }
        }   
        
        return lista;
    }

    @Override
    public ArrayList<Persona> getAll() {
        ArrayList<Persona> lista = new ArrayList();
        
        for(Persona p : personas){
           lista.add(p);
        }   
        
        return lista;
    }
    
}
