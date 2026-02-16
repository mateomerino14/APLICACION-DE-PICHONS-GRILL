import java.util.*;
import java.time.LocalDateTime;

public class Pedido{
    private static int idContador = 1;
    private int idPedido;
    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;
    private double total;
    private String estado;
    private LocalDateTime fecha;
    private Cliente cliente;
    private String tipoPago;

    public Pedido() {
        this.idPedido = idContador++;
        this.productos = new ArrayList<Producto>();
        this.cantidades = new ArrayList<Integer>();
        this.total = 0.0;
        this.estado = "Pendiente";
        fecha = LocalDateTime.now();
        this.cliente = null;
        this.tipoPago = "";
    }

    public void registrarPedido(Carrito carrito) {
        this.productos.clear();
        this.cantidades.clear();
        for(Map.Entry<Producto, Integer> entry : carrito.getProductosCarrito().entrySet()) {
            this.productos.add(entry.getKey());
            this.cantidades.add(entry.getValue());
        }
        this.total = carrito.getTotal();
        carrito.vaciarCarrito();
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void mostrarPedido() {
        System.out.println("--------PEDIDO #" + idPedido + "--------");
        System.out.println("Fecha: " + fecha);
        for(int i = 0; i < productos.size(); i++){
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            System.out.println("Producto: " + producto.getNombreProducto());
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio Unitario: " + producto.getPrecio() + " Bs");
            System.out.println("Subtotal: " + (producto.getPrecio() * cantidad) + " Bs");
            System.out.println();
        }
        System.out.println("Total: " + total + " Bs");
        System.out.println("Estado: " + estado);
    }
    
    public void asociarCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setTipoPago(String nuevoTipoPago){
        tipoPago = nuevoTipoPago;
    }
    
    public String getTipoPago(){
        return tipoPago;
    }
}