public class TarjetaCredito extends Pago{
    private int numero;
    private int CVV;
    private String titular;
    private String bancoEmisor;
    private String direccionFacturacion;
    
    public TarjetaCredito(Pedido pedido){
        super(pedido);
    }
    
    public void registrarDatos(int numero, int CVV, String titular, String bancoEmisor, String direccion){
        this.numero = numero;
        this.CVV = CVV;
        this.titular = titular;
        this.bancoEmisor = bancoEmisor;
        this.direccionFacturacion = direccion;
    }
    
    public String getTitular(){
        return titular;
    }
    
    public String getBancoTitular(){
        return bancoEmisor;
    }
    
    public String getDireccionFacturacion(){
        return direccionFacturacion;
    }
}