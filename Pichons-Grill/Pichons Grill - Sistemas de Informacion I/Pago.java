public abstract class Pago{
    protected int idPago;
    protected Pedido pedido;
    
    public Pago(Pedido pedido){
        this.pedido = pedido;
    }
    
    public void setIdPago(int id){
        this.idPago = id;
    }
    
    public int getIdPago(){
        return idPago;
    }
    
    public Pedido getPedido(){
        return pedido;
    }
}