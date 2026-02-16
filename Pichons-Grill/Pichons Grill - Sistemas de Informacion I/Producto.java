import java.util.ArrayList;

public class Producto{
    protected int idProducto;
    protected String nombreProducto;
    protected double precio;
    protected String descripcion;
    protected String imagen;
    
    public Producto(){
        idProducto = 0;
        nombreProducto = "";
        precio = 0;
        descripcion = "";
        imagen = "";
    }
    
    public Producto(String nombreProducto, double precio, String descripcion, String imagen){
        this.idProducto = 0;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public int getIdProducto(){
        return idProducto;
    }
    
    public String getNombreProducto(){
        return nombreProducto;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getImagen(){
        return imagen;
    }
    
    public void setIdProducto(int nuevoId){
       idProducto = nuevoId; 
    }
    
    public void mostrarDetalles(){
        System.out.println("Id: " + idProducto);
        System.out.println("Nombre: " + nombreProducto);
        System.out.println("Precio: " + precio + " Bs.");
        System.out.println("Descripcion: " + descripcion);
    }
}