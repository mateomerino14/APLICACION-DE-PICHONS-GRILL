import java.util.ArrayList;

public class Usuario{
    protected String nombre;
    protected ArrayList<String> contrasenas;
    protected String telefono;
    
    public String getNombre(){
        return nombre;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }
    
    public void setTelefono(String nuevoTelefono){
        telefono = nuevoTelefono;
    }
    
    public void agregarContrasena(){
        //PRUEBITAPOL
    }
}