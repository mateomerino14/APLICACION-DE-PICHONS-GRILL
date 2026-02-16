import java.util.ArrayList;

public class Aplicacion{
    private static Menu menu;
    private static Carrito carrito;
    
    public static void Main(String[] args){
        String mensaje = ""; //eliminar
        
        setProductos();
        
        carrito = new Carrito();
        Caja caja = new Caja();
        
        Cajero cajero = new Cajero("pendego", "12345678", "0", caja);
        caja.designarNuevoCajero(cajero); // Se relacionan los 2
        
        
        //id cliente 0
        Cliente cliente = new Cliente("nom", "telf", "dir", "NIT", 150.0, "banco", 1234, 666);

        
        cliente.setCarrito(carrito);
        cliente.setMenu(menu);
        

        
        carrito.vincularConCaja(caja);
        
        /** Platos
         * 0.Costilla de Novillo
         * 1.Bife de Ternera
         * 2.Chorizo Parrillero tipo Pollo
         * 3.Brochetas de res al Gril
         * 4.Arroz
         * 5.Patatas fritas
         * 6.Ensalada mixta
         * 7.Cocacola
         * 8.Fanta
         * 9.Jugo de Naranja
         */
                
        mensaje += cliente.agregarProductoCarrito(0, 1) + " \n";
        mensaje += cliente.agregarProductoCarrito(1, 1) + " \n";
        mensaje += cliente.agregarProductoCarrito(5, 1) + " \n";
        mensaje += cliente.agregarProductoCarrito(9, 2) + " \n";
        System.out.println(mensaje);
        
        mensaje += cliente.pagarPedido(1, cliente.verMontoTotal());
        System.out.println(mensaje);
    }
    
    public Menu getMenu(){
        return menu;
    }
    
    public Carrito getCliente(){
        return carrito;
    }
    
    private static void setProductos(){
        menu = new Menu();
        
        Plato platillo1 = new Plato("Costilla de Novillo", 60.0, "jugosa costila de novillo", "novillo.jpg", "Carnes");
        Plato platillo2 = new Plato("Bife de Ternera", 40.0, "crujiente bife de ternera", "bife.jpg", "Carnes");
        Plato platillo3 = new Plato("Cestita de chorizo Parrillero tipo Pollo", 50.0, "", "chorizo.jpg", "Carnes");
        Plato platillo4 = new Plato("Brochetas de res al Gril", 35.0, "brochetas de acompañamiento", "brocheta.jpg", "Carnes");
        Plato platillo5 = new Plato("Arroz", 12.0, "arroz blanco", "arroz.jpg", "Guarniciones");
        Plato platillo6 = new Plato("Patatas fritas", 10.0, "deliciosas patatas fritas", "img", "Guarniciones");
        Plato platillo7 = new Plato("Ensalada mixta", 15.0, "ensaladas fresca para acompañar", "img", "Guarniciones");
        
        menu.registrarProducto(platillo1);
        menu.registrarProducto(platillo2);
        menu.registrarProducto(platillo3);
        menu.registrarProducto(platillo4);
        menu.registrarProducto(platillo5);
        menu.registrarProducto(platillo6);
        menu.registrarProducto(platillo7);
        
        Bebida bebida8 = new Bebida("Coca-Cola", 15.0, "Cocacola fria familiar", "coke.jpg", 3000, "Coca-Cola", false);
        Bebida bebida9 = new Bebida("Fanta", 12.0, "Fanta refrescante", "fanta.jpg", 1500, "Fanta", false);
        Bebida bebida10 = new Bebida("Jugo de Naranja", 8.0, "Natural y sano", "naranja.jpg", 500, "Del Valle", true);
        
        menu.registrarProducto(bebida8);
        menu.registrarProducto(bebida9);
        menu.registrarProducto(bebida10);
    }
}
