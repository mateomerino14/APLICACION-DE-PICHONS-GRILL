import java.util.*;
import java.time.LocalDateTime;

public class Cajero extends Usuario{
    protected String idCajero;
    protected Caja caja; //Registrar a Parte
    protected ArrayList<Repartidor> listaRepartidores;
    protected ArrayList<Pedido> pedidosPendientes;
    
    public Cajero(String nombre, String telefono, String idCajero, Caja caja){
        this.idCajero = idCajero;
        this.nombre = nombre;
        this.telefono = telefono;
        //this.caja = caja;
        this.listaRepartidores = new ArrayList<Repartidor>();
        this.caja = caja;
        this.pedidosPendientes = caja.getPedidosPendientes();
    }
        
    public void designarCaja(Caja caja){
        this.caja = caja;
    }
    
    public String getIdCajero(){
        return idCajero;
    }
    
    public void setIdCajero(String nuevoId){
        idCajero=nuevoId;
    }
    
    public void verPagosDelDia(){
        caja.verPagosDelDia();
    }
    
    public void verContactosDelCliente(){
        caja.verContactosDelCliente();
    }
    
    public void agregarRepartidor(Repartidor repartidor){
        listaRepartidores.add(repartidor);
    }
    
    public void asignarPedidoRepartidor(){
        for(Repartidor repartidorActual: listaRepartidores){
            if(repartidorActual.getEstado().equals("Disponible.")){
                Pedido pedidoReciente = pedidosPendientes.get(0);
                repartidorActual.recibirPedido(pedidoReciente);
                pedidosPendientes.remove(0);
                repartidorActual.setEstado("Ocupado.");
            }
        }
    }
    
    public void notificarRepartidor(){
        String mensaje = "Usted tiene un nuevo pedido";
        String destinatario = caja.repartidores.get(0).getNombre();
        LocalDateTime fecha = LocalDateTime.now();
        Pedido pedido = caja.getPedidosPendientes().get(0);
        Notificacion notificacion = new Notificacion(mensaje, getNombre(),destinatario, fecha, pedido);
        caja.getPedidosPendientes().remove(0);
    }
    
    public ArrayList<Pedido> ordenarPedidosPorCompletadosPendientes(){
        return null;
    }
}