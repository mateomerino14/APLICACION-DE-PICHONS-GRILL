import java.util.HashMap;
import java.util.ArrayList;

public class Cliente extends Usuario{
    private String direccion;
    private String NIT;
    private Menu menu; //Registrar a parte
    private Carrito carrito; //Registrar a parte
    private ArrayList<Pedido> historialPedidos;
    private double saldo;
    private String bancoAsociado;
    private int numeroTarjeta; 
    private int CVV;

    public Cliente(String nombre, String telefono, String direccion, String NIT, double saldo,
    String bancoAsociado, int numeroTarjeta, int CVV){
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.NIT = NIT;
        historialPedidos = new ArrayList<Pedido>();
        this.saldo = saldo;
        this.bancoAsociado = bancoAsociado;
        this.numeroTarjeta = numeroTarjeta;
        this.CVV = CVV;
    }

    public String getDireccion(){
        return direccion;
    }

    public String getNIT(){
        return NIT;
    }
    
    public String getBancoAsociado(){
        return bancoAsociado;
    }
    
    public int getNroTarjeta(){
        return numeroTarjeta;
    }
    
    public int getCVV(){
        return CVV;
    }

    public void setDireccion(String nuevaDireccion){
        direccion = nuevaDireccion;
    }

    public void setNIT(String nuevoNIT){
        NIT = nuevoNIT;
    }
    
    public void setMenu(Menu nuevoMenu){
        menu = nuevoMenu;
    }
    
    public void setCarrito(Carrito nuevoCarrito){
        carrito = nuevoCarrito;
    }
    
    public void consultarFiltrosMenu(){
        System.out.println("----------- Opciones para visualizar Menu -----------");
        System.out.println("Opcion No. 1: Menu completo");
        System.out.println("Opcion No. 2: seccion de platillos");
        System.out.println("Opcion No. 3: seccion de bebidas");
    }

    public String verMenuFiltros(int nroOpcion){
        String res;
        if(nroOpcion == 1){
            menu.mostrarMenuCompleto();
            res = "Menu completo impreso.";
        }else if(nroOpcion == 2){
            menu.mostrarPlatos();
            res = "Menu de platillos impreso.";
        }else if(nroOpcion == 3){
            menu.mostrarBebidas();
            res = "Menu de bebidas impreso.";
        }else{
            res = "La opcion ingresada no es valida, o es incorrecta.";
        }
        return res;
    }

    public String verDetallesProduto(int id){
        String res;
        if(menu.idValido(id)){
            Producto producto = menu.getProductoMenu(id);
            if(producto instanceof Plato){
                Plato plato = (Plato)(producto);
                plato.mostrarDetalles();
            }else if(producto instanceof Bebida){
                Bebida bebida = (Bebida)(producto);
                bebida.mostrarDetalles();
            }else{
                producto.mostrarDetalles();
            }
            res = "Detalles de " + producto.getNombreProducto() + " impresos.";
        }else{
            res = "Producto no encontrado en el menu principal.";
        }
        return res;
    }

    public String agregarProductoCarrito(int id, int cantidad){
        String res;
        if(menu.idValido(id)){
            Producto productoActual = menu.getProductoMenu(id);
            if(!productoActual.getNombreProducto().equals("")){
                carrito.agregarProducto(productoActual, cantidad);
                if(productoActual instanceof Plato){
                    res = "El plato ha sido registrado en el carrito exitosamente.";
                }else if(productoActual instanceof Bebida){
                    res = "La bebida ha sido registrada en el carrito exitosamente.";
                }else{
                    res = "El producto ha sido registrado en el carrito exitosamente.";
                }
            }else{
                res = "No se ha podido registrar producto en el carrito.";
            }
        }else{
            res = "No se ha podido registrar producto en el carrito, el producto que desea agregar no existe.";
        }
        return res;
    }

    public String quitarProductoCarrito(int id){
        String res;
        if(menu.idValido(id)){
            if(!carrito.esVacio()){
                Producto productoActual = menu.getProductoMenu(id);
                if(carrito.getProductosCarrito().containsKey(productoActual)){
                    if(!productoActual.getNombreProducto().equals("")){
                        carrito.quitarProducto(productoActual);
                        if(productoActual instanceof Plato){
                            res = "El plato que ha seleccionado, ha sido retirado del carrito.";
                        }else if(productoActual instanceof Bebida){
                            res = "La bebida que ha seleccionado, ha sido retirada del carrito.";
                        }else{
                            res = "El producto que ha seleccionado, ha sido retirado del carrito.";
                        }
                    }else{
                        res = "No se ha podido retirar del carrito el producto seleccionado.";
                    }
                }else{
                    res = "No es posible quitar el producto solicitado, no existe en el carrito.";
                }
            }else{
                res = "No es posible quitar productos, el carrito esta vacio, agregue productos.";
            }
        }else{
            res = "No se ha podido retirar el producto del carrito, el producto que desea retirar no existe.";
        }
        return res;
    }

    public String modificarProductoCarrito(int id, int cantidad){
        String res;
        if(menu.idValido(id)){
            if(!carrito.esVacio()){
                Producto productoActual = menu.getProductoMenu(id);
                if(carrito.getProductosCarrito().containsKey(productoActual)){
                    if(carrito.validarCantidad(cantidad)){
                        if(!productoActual.getNombreProducto().equals("")){
                            carrito.modificarCantidad(productoActual, cantidad);
                            if(productoActual instanceof Plato){
                                res = "El plato que ha seleccionado, ha sido modificado en cantidad.";
                            }else if(productoActual instanceof Bebida){
                                res = "La bebida que ha seleccionado, ha sido modificada en cantidad.";
                            }else{
                                res = "El producto que ha seleccionado, ha sido modificado en cantidad.";
                            }
                        }else{
                            res = "No se ha podido modificar el producto seleccionado del carrito .";
                        }
                    }else{
                        res = "La cantidad solicitada es invalida";
                    }
                }else{
                    res = "No es posible modificar el producto solicitado, no existe en el carrito.";
                }
            }else{
                res = "No es posible modificar productos, si el carrito esta vacio, agregue productos.";
            }
        }else{
            res = "No se ha podido modificar el producto del carrito, el producto que desea modificar no existe.";
        }
        return res;
    }

    public String sumarCantidadProductoCarrito(int id){
        String res;
        if(menu.idValido(id)){
            if(!carrito.esVacio()){
                Producto productoActual = menu.getProductoMenu(id);
                if(carrito.getProductosCarrito().containsKey(productoActual)){
                    int cantidad = carrito.getProductosCarrito().get(productoActual);
                    if(carrito.validarCantidad(cantidad)){
                        if(!productoActual.getNombreProducto().equals("")){
                            carrito.sumarCantidadProducto(productoActual);
                            if(productoActual instanceof Plato){
                                res = "El plato que ha seleccionado, ha sido modificado en cantidad.";
                            }else if(productoActual instanceof Bebida){
                                res = "La bebida que ha seleccionado, ha sido modificada en cantidad.";
                            }else{
                                res = "El producto que ha seleccionado, ha sido modificado en cantidad.";
                            }
                        }else{
                            res = "No se ha podido modificar el producto seleccionado del carrito .";
                        }
                    }else{
                        res = "La cantidad solicitada supera al limite de 99 productos";
                    }
                }else{
                    res = "No es posible modificar el producto solicitado, no existe en el carrito.";
                }
            }else{
                res = "No es posible modificar productos, si el carrito esta vacio, agregue productos.";
            }
        }else{
            res = "No se ha podido modificar el producto del carrito, el producto que desea modificar no existe.";
        }
        return res;
    }

    public String restarCantidadProductoCarrito(int id){
        String res;
        if(menu.idValido(id)){
            if(!carrito.esVacio()){
                Producto productoActual = menu.getProductoMenu(id);
                if(carrito.getProductosCarrito().containsKey(productoActual)){
                    int cantidad = carrito.getProductosCarrito().get(productoActual);
                    if(!productoActual.getNombreProducto().equals("")){
                        carrito.restarCantidadProducto(productoActual);
                        if(productoActual instanceof Plato){
                            res = "El plato que ha seleccionado, ha sido modificado en cantidad.";
                        }else if(productoActual instanceof Bebida){
                            res = "La bebida que ha seleccionado, ha sido modificada en cantidad.";
                        }else{
                            res = "El producto que ha seleccionado, ha sido modificado en cantidad.";
                        }
                    }else{
                        res = "No se ha podido modificar el producto seleccionado del carrito .";
                    }
                }else{
                    res = "No es posible modificar el producto solicitado, no existe en el carrito.";
                }
            }else{
                res = "No es posible modificar productos, si el carrito esta vacio, agregue productos.";
            }
        }else{
            res = "No se ha podido modificar el producto del carrito, el producto que desea modificar no existe.";
        }
        return res;
    }
    
    public void verContenidoCarrito(){
        carrito.mostrarCarrito();
    }
    
    public double verMontoTotal(){
        double res;
        res = carrito.getTotal();
        return res;
    }
    
    public String cancelarPedido(){
        String res;
        if(!carrito.esVacio()){
            carrito.vaciarCarrito();
            res = "El pedido ha sido cancelado, todos los productos en el carrito han sido eliminados.";
        }else{
            res = "El pedido ha sido cancelado, no se borro ningun producto, porque el carrito estaba vacio.";
        }
        return res;
    }
    
    private void confirmarPedido(){
        carrito.finalizarPedido(this);
    }
    
    public void mostrarMetodosPago(){
        System.out.println();
        System.out.println("--------METODS DE PAGO--------");
        System.out.println("1. Pagar en Efectivo");
        System.out.println("2. Pagar con QR");
        System.out.println("3. Pagar con Tarjeta de Credito");
        System.out.println("4. Cancelar compra");
    }
    
    public String pagarPedido(int nroOpcion, double monto){
        String res;
        if(verificarPagoSaldo(monto) && monto == carrito.getTotal() && !carrito.esVacio()){
            if(nroOpcion <= 3 && nroOpcion >= 1){
                confirmarPedido();
                carrito.pagarPedido(nroOpcion, monto, this);
                saldo -= monto;
                res = "El pedido ha sido pagado con exito.";
            }else if(nroOpcion == 4){
                res = "El pedido ha sido cancelado por completo.";
            }else{
                res = "La introducida elegida no existe.";
            }
        }else if(carrito.esVacio()){
            res = "No es posible pagar un pedido que no contenga productos en el carrito.";
        }
        else{
            res = "No se puede pagar el pedido, monto insuficiente.";
        }
        return res;
    }
    
    public HashMap<Producto, Integer> verProductosCarrito(){
        HashMap<Producto, Integer> res;
        res = carrito.getProductosCarrito();
        return res;
    }
    
    public void registrarHistorialPedido(Pedido pedido){
        historialPedidos.add(pedido);
    }
    
    public boolean verificarPagoSaldo(double monto){
        boolean res;
        res = (monto <= saldo);
        return res;
    }
}