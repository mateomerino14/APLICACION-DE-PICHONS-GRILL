import java.util.*;

public class Menu{
    private ArrayList<Producto> productos;
    private final int limiteSuperior;
    private HashMap<String, ArrayList<Producto>> platillos;
    private ArrayList<String> categoriaPlatillos;
    private ArrayList<Bebida> bebidasGaseosas;
    private ArrayList<Bebida> bebidasNaturales;
    private ArrayList<Bebida> listaBebidas;

    public Menu(){
        productos = new ArrayList<Producto>();
        limiteSuperior = 999;
        platillos=new HashMap<String, ArrayList<Producto>>();
        bebidasGaseosas=new ArrayList<Bebida>();
        bebidasNaturales=new ArrayList<Bebida>();
        listaBebidas=new ArrayList<Bebida>();
        categoriaPlatillos=new ArrayList<String>();
    }

    public int getLimiteSuperior(){
        return limiteSuperior;
    }

    public ArrayList<Producto> getProductos(){
        return productos;
    }

    public HashMap<String, ArrayList<Producto>> obtenerPlatos(){
        return platillos;
    }

    public String registrarProducto(Producto producto){
        String res;
        if(productos.isEmpty()){
            productos.add(producto);
            res=imprimirMensajes(producto);
        }else{
            int ultimoId = productos.get(productos.size()-1).getIdProducto();
            producto.setIdProducto(ultimoId + 1);
            if(idValido(producto.getIdProducto()) && !productos.contains(producto)){
                productos.add(producto);
                res=imprimirMensajes(producto);
            }else{
                if(producto instanceof Plato){
                    res = "El plato no ha podido ser registrado en el menu.";
                }else if(producto instanceof Bebida){
                    res = "La bebida no ha podido ser registrada en el menu.";
                }else{
                    res = "El producto no ha podido ser registrado en el menu.";
                }
            }
        }
        return res;
    }

    private void organizarPlatoCategoria(Producto producto){
        Plato platilloNuevo=(Plato)producto;
        String clave=platilloNuevo.getCategoria();  
        if(platillos.containsKey(clave)){
            platillos.get(clave).add(platilloNuevo);
        }else{
            ArrayList<Producto> nuevaLista=new ArrayList<Producto>();
            nuevaLista.add(platilloNuevo);
            platillos.put(clave,nuevaLista);
            categoriaPlatillos.add(clave);
        }
    }

    private void organizarBebidas(){
        if(!productos.isEmpty()){
            for(Producto producto:productos){
                if(producto instanceof Bebida){
                    Bebida bebidaActual=(Bebida) producto;
                    if(bebidaActual.esNatural()){
                        bebidasNaturales.add(bebidaActual);
                    }else{
                        bebidasGaseosas.add(bebidaActual);
                    }
                }
            } 
        }
    }

    private String imprimirMensajes(Producto producto){
        String res;
        if(producto instanceof Plato){
            organizarPlatoCategoria(producto);
            res = "El plato ha sido registrado al menu con exito.";
        }else if(producto instanceof Bebida){
            res = "La bebida ha sido registrada al menu con exito.";
        }else{
            res = "El producto ha sido registrado al menu con exito.";
        }
        return res;
    }

    public void mostrarPlatos(){
        String propiedad;
        System.out.println("--------PLATILLOS--------");
        for (Map.Entry<String, ArrayList<Producto>> entry : platillos.entrySet()) {
            String clave = entry.getKey(); 
            ArrayList<Producto> listaProductos = entry.getValue(); 
            System.out.println("Categoría: " + clave);
            for (Producto producto : listaProductos) {
                propiedad=producto.getIdProducto()+"";
                System.out.println("Id: " +propiedad);
                propiedad=producto.getNombreProducto();
                System.out.println("Nombre: " +propiedad);
                propiedad=producto.getPrecio()+" Bs";
                System.out.println("Precio: " +propiedad);
            }
        }
    }

    public void mostrarBebidas(){
        organizarBebidas();
        String propiedad="";
        generarListaBebidas();
        System.out.println("--------BEBIDAS--------");
        System.out.println("NATURALES :");
        for(Bebida bebidaActual:listaBebidas){
            if(bebidaActual.esNatural()){
                imprimirDetallesBebidas(bebidaActual);
            }
        }
        System.out.println("GASEOSAS:");
        for(Bebida bebidaActual:listaBebidas){
            if(!bebidaActual.esNatural()){
                imprimirDetallesBebidas(bebidaActual);
            }
        }
        bebidasNaturales=new ArrayList<Bebida>();
        bebidasGaseosas=new ArrayList<Bebida>();
        listaBebidas=new ArrayList<Bebida>();
    }

    private void imprimirDetallesBebidas(Bebida bebidaActual){
        String propiedad;
        propiedad=bebidaActual.getIdProducto()+"";
        System.out.println("Id: " +propiedad);
        propiedad=bebidaActual.getNombreProducto();
        System.out.println("Nombre: " +propiedad);
        propiedad=bebidaActual.getPrecio()+" Bs";
        System.out.println("Precio: " +propiedad);
        propiedad=bebidaActual.getMls()+" ml";
        System.out.println("Ml: " +propiedad);
        propiedad=bebidaActual.getMarca();
        System.out.println("Marca: " +propiedad); 
    }

    private void generarListaBebidas(){
        for(Bebida bebidaActual1: bebidasNaturales){
            listaBebidas.add(bebidaActual1);
        }
        for(Bebida bebidaActual2:bebidasGaseosas){
            listaBebidas.add(bebidaActual2);
        }
    }
    
    public void mostrarMenuCompleto(){
        for(Producto productoActual: productos){
            String atributo = productoActual.getIdProducto() + "";
            System.out.println("Id: " + atributo);
            atributo = productoActual.getNombreProducto();
            System.out.println("Nombre: " + atributo);
            atributo = productoActual.getPrecio() + " Bs.";
            System.out.println("Precio: " + atributo);
            atributo = productoActual.getDescripcion();
            System.out.println("Descripcion: " + atributo);
            if(productoActual instanceof Plato){
                Plato plato = (Plato)(productoActual);
                atributo = plato.getCategoria();
                System.out.println("Categoria: " + atributo);
            }else{
                Bebida bebida = (Bebida)(productoActual);
                if(bebida.esNatural()){
                    System.out.println("Tipo de Bebida: Natural");
                }else{
                    System.out.println("Tipo de Bebida: Gaseosa");
                }
                atributo = bebida.getMarca();
                System.out.println("Marca: " + atributo);
                atributo = bebida.getMls() + " ml";
                System.out.println("Cantidad: " + atributo);
            }
        }
    }
    
    public boolean idValido(int id){
        boolean res;
        res = (id <= limiteSuperior && id >= 0);
        return res;
    }
    
    public Producto getProductoMenu(int id){
        Producto res;
        if(idValido(id)){
            Producto productoActual = new Producto();
            for(int i = 0; i < productos.size(); i++){
                if(id == productos.get(i).getIdProducto()){
                    productoActual = productos.get(i);
                }
            }
            res = productoActual;
        }else{
           res = null; 
        }
        return res;
    }
}