public class Efectivo extends Pago{
    private Repartidor repartidor;
    
    public Efectivo(Pedido pedido){
        super(pedido);
    }
    
    public void asignarRepartidor(Repartidor repartidor){
        this.repartidor = repartidor;
    }
    
    public Repartidor getRepartidor(){
        return repartidor;
    }
    
    public double getTotal(){
        return pedido.getTotal();
    }
}