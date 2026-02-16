public class Bebida extends Producto{
    private int mls;
    private String marca;
    private boolean natural;
    
    public Bebida(String nombreProducto, double precio, String descripcion, String imagen, 
        int mls, String marca, boolean natural){
        super(nombreProducto, precio, descripcion, imagen);
        this.mls = mls;
        this.marca = marca;
        this.natural = natural;
    }
    
    public int getMls(){
        return mls;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public boolean esNatural(){
        return natural;
    }
    
    public void setMls(int nuevosMls){
        mls = nuevosMls;
    }
    
    public void setMarca(String nuevaMarca){
        marca = nuevaMarca;
    }
    
    @Override
    public void mostrarDetalles(){
        System.out.println("Id: " + idProducto);
        System.out.println("Nombre: " + nombreProducto);
        System.out.println("Precio: " + precio + " Bs.");
        System.out.println("Descripcion: " + descripcion);
        if(esNatural()){
            System.out.println("Tipo de Bebida: Natural");
        }else{
            System.out.println("Tipo de Bebida: Gaseosa");
        }
        System.out.println("Marca: " + marca);
        System.out.println("Cantidad: " + mls + " ml.");
    }
}