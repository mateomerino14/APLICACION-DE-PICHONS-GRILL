import java.util.*;
import java.time.LocalDateTime;
import java.util.UUID.*;

public class Carrito{
    private HashMap<Producto, Integer> productosCarrito;
    private double total;
    private final int cantidadProductosLimite;
    private Pedido pedido;
    private Caja caja;

    public Carrito(){
        productosCarrito = new HashMap<Producto, Integer>();
        total = 0.0;
        cantidadProductosLimite = 99;
        pedido = new Pedido();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if(productosCarrito.containsKey(producto) && validarCantidad(cantidad)){
            int cantidadActual = productosCarrito.get(producto);
            productosCarrito.put(producto, cantidadActual + cantidad);
        }else{
            productosCarrito.put(producto, cantidad);
        }
        actualizarTotal();
    }

    public void quitarProducto(Producto producto){
        if(productosCarrito.containsKey(producto)){
            productosCarrito.remove(producto);
            //int cantidad=productosCarrito.get(producto);
            //total=-producto.getPrecio()*cantidad;
            actualizarTotal();
        }
    }

    public void modificarCantidad(Producto producto, int nuevaCantidad){
        if(productosCarrito.containsKey(producto)) {
            if(validarCantidad(nuevaCantidad)) {
                productosCarrito.put(producto, nuevaCantidad);
            }
            actualizarTotal();
        }
    }
    
    public void sumarCantidadProducto(Producto producto){
        if(productosCarrito.containsKey(producto)){
            int cantidadActual = productosCarrito.get(producto);
            if(validarCantidad(cantidadActual)){
                productosCarrito.put(producto, cantidadActual + 1);
            }
            actualizarTotal();
        }
    }
    
    public void restarCantidadProducto(Producto producto){
        if(productosCarrito.containsKey(producto)){
            int cantidadActual = productosCarrito.get(producto);
            if(validarCantidad(cantidadActual)){
                if(cantidadActual == 0){
                    quitarProducto(producto);
                }else{
                    productosCarrito.put(producto, cantidadActual - 1);
                }
            }
            actualizarTotal();
        }
    }
    
    public void vaciarCarrito(){
        if(!esVacio()){
            productosCarrito.clear();
            total = 0.0;
        }
    }

    public void finalizarPedido(Cliente cliente){
        pedido.asociarCliente(cliente);
        pedido.registrarPedido(this);
        vaciarCarrito();
        cliente.registrarHistorialPedido(pedido);
        caja.getPedidosPendientes().add(pedido);
        caja.getClientes().add(cliente);
        String clienteActual = cliente.getNombre();
        String mensaje = "Un nuevo pedido ha sido solicitado por el cliente: " + clienteActual + ".";
        LocalDateTime fechaEmision = LocalDateTime.now(); 
        Notificacion notificacionCaja = new Notificacion(mensaje, clienteActual, caja.verNombreCajero(), fechaEmision, pedido);
        caja.recibirNotificacionCliente(notificacionCaja);
    }
    
    public void pagarPedido(int nroOpcion, double monto, Cliente cliente){
        if(nroOpcion == 1){
            Efectivo pago = new Efectivo(pedido);
            pedido.setTipoPago("Efectivo."); //booleano esEnEfectivo
            pedido.cambiarEstado("Pagado.");
            caja.agregarPago(pago);
        }else if(nroOpcion == 2){
            QR pago = new QR(pedido);
            LocalDateTime fechaHoy = LocalDateTime.now();
            LocalDateTime fechaManana = fechaHoy.plusDays(1);
            UUID uuid = UUID.randomUUID();
            String imagen = uuid.toString();
            String banco = cliente.getBancoAsociado();
            pago.crearQR(fechaHoy, fechaManana, monto, imagen, banco);
            pedido.setTipoPago("QR.");
            pedido.cambiarEstado("Pagado.");
            caja.agregarPago(pago);
        }else if(nroOpcion == 3){
            TarjetaCredito pago = new TarjetaCredito(pedido);
            int numeroTarjeta = cliente.getNroTarjeta();
            int CVV = cliente.getCVV();
            String titular = cliente.getNombre();
            String banco = cliente.getBancoAsociado();
            String direccion = cliente.getDireccion();
            pago.registrarDatos(numeroTarjeta, CVV, titular, banco, direccion);
            pedido.setTipoPago("Tarjeta de Credito.");
            pedido.cambiarEstado("Pagado.");
            caja.agregarPago(pago);
        }else if(nroOpcion == 4){
            vaciarCarrito();
            pedido.cambiarEstado("Cancelado.");
        }
    }

    private void actualizarTotal(){
        total = 0.0;
        for(Map.Entry<Producto, Integer> entry : productosCarrito.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            total += producto.getPrecio() * cantidad;
        }
    }

    public void mostrarCarrito(){
        System.out.println("--------CARRITO--------");
        for(Map.Entry<Producto, Integer> entry : productosCarrito.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            System.out.println("Producto: " + producto.getNombreProducto());
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio Unitario: " + producto.getPrecio() + " Bs");
            System.out.println("Subtotal: " + (producto.getPrecio() * cantidad) + " Bs");
            System.out.println();
        }
        System.out.println("Total: " + total + " Bs");
    }
    
    public void vincularConCaja(Caja cajaRelacionada){
        caja = cajaRelacionada;
    }

    public HashMap<Producto, Integer> getProductosCarrito(){
        return productosCarrito;
    }

    public double getTotal(){
        return total;
    } 
    
    public boolean esVacio(){
        boolean res;
        res = (total == 0.0);
        return res;
    }
    
    public boolean validarCantidad(int cantidad){
        boolean res;
        res = (cantidad <= cantidadProductosLimite && cantidad >= 0);
        return res;
    }
    
    public int getCantidadProductoLimite(){
        return cantidadProductosLimite;
    }
}