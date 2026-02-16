import java.util.*;

public class Repartidor extends Usuario implements Cloneable{
    private ArrayList<Pedido> pedidosCompletos;
    private ArrayList<Pedido> pedidosPendientes;
    private Pedido pedidoProgreso;
    private String estado;

    public Repartidor(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
        pedidosCompletos = new ArrayList<Pedido>();
        pedidosPendientes = new ArrayList<Pedido>();
        estado = "Disponible.";
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String nuevoEstado){
        estado = nuevoEstado;
    }

    public void verDetallesPedidoPendiente(){
        String direccion = "Reducto";
        double total = 0;
        if(!pedidosPendientes.isEmpty()){
            String metodoPago;
            Pedido pedidoPrioritario = pedidosPendientes.get(0);
            if(pedidoPrioritario.getTipoPago().equals("Efectivo.")){
                metodoPago = "Efectivo";  
            }else{
                if(pedidoPrioritario.getTipoPago().equals("QR.")){
                    metodoPago = "QR";  
                }else{
                    metodoPago = "Tarjeta de Credito"; 
                }
            }
            String detalle;
            System.out.println("PEDIDO PENDIENTE");
            Pedido pedidoActual = pedidoPrioritario;
            detalle=pedidoActual.getIdPedido()+"";
            System.out.println("PEDIDO: "+detalle);
            System.out.println("Direccion: "+direccion);
            ArrayList<Producto> productos=pedidoActual.getProductos();
            ArrayList<Integer> cantidades=pedidoActual.getCantidades();
            for(int i=0;i<productos.size();i++){
                Producto producto=productos.get(i);
                detalle=producto.getNombreProducto();
                System.out.println("Producto :"+detalle);
                int cantidad=cantidades.get(i);
                detalle=cantidad+"";
                System.out.println("Cantidad :"+cantidad);
                double precio=producto.getPrecio();
                double subTotal=precio*cantidad;
                detalle=subTotal+"";
                System.out.println("SubTotal :"+detalle);
                total+=subTotal;
            }
            System.out.println("TOTAL: "+total);
        }else{
            System.out.println("No hay pedidos pendientes");
        }
    }

    public void marcarPedidoCompletado(){
        if(pedidoProgreso!=null){
            pedidosCompletos.add(pedidoProgreso);
            pedidoProgreso=null;
        }
    }

    public void marcarPedidoProgreso(){
        if(!pedidosPendientes.isEmpty()){
            pedidoProgreso = pedidosPendientes.get(0);
            pedidosPendientes.remove(0);
        }
    }

    public void notificarCliente(){
        System.out.println("Su pedido ha llegado");
    }

    public void notificarCaja(){
        System.out.println("Se completo el pedido pendiente");
    }

    public Pedido getPedidoEnProgresoActual(){
        return pedidoProgreso;
    }

    public void pedidosCompletados(){
        System.out.println("------PEDIDOS COMPLETADOS------");
        String direccion = "Reducto";
        double total = 0;
        if(!pedidosCompletos.isEmpty()){
            String metodoPago;
            for(Pedido pedidoPrioritario: pedidosCompletos){
                if(pedidoPrioritario.getTipoPago().equals("Efectivo.")){
                    metodoPago = "Efectivo";  
                }else{
                    if(pedidoPrioritario.getTipoPago().equals("QR.")){
                        metodoPago = "QR";  
                    }else{
                        metodoPago = "Tarjeta de Credito"; 
                    }
                }
                String detalle;
                Pedido pedidoActual = pedidoPrioritario;
                detalle=pedidoActual.getIdPedido()+"";
                System.out.println("PEDIDO: "+detalle);
                System.out.println("Direccion: "+direccion);
                ArrayList<Producto> productos=pedidoActual.getProductos();
                ArrayList<Integer> cantidades=pedidoActual.getCantidades();
                for(int i=0;i<productos.size();i++){
                    Producto producto=productos.get(i);
                    detalle=producto.getNombreProducto();
                    System.out.println("Producto :"+detalle);
                    int cantidad=cantidades.get(i);
                    detalle=cantidad+"";
                    System.out.println("Cantidad :"+cantidad);
                    double precio=producto.getPrecio();
                    double subTotal=precio*cantidad;
                    detalle=subTotal+"";
                    System.out.println("SubTotal :"+detalle);
                    total+=subTotal;
                }
                System.out.println("TOTAL: "+total);
                System.out.println("");
                System.out.println("");
                System.out.println("");
            }  
        }else{
            System.out.println("No hay ningun pedidoCompleto");
        }
    }
    
    public void recibirPedido(Pedido pedido){
        
    }
}