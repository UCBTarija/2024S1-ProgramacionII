package ucb.programacionii.inventario.domain;

import java.util.ArrayList;

public interface PersonaRepository {
    
    public Persona get(int id) throws Exception;
    
    public int nextIdentity();
    
    public boolean store(Persona persona);
    
    public boolean remove(Persona persona);
    
    public ArrayList<Persona> search(String criterio);
    
    public ArrayList<Persona> getAll();
}
