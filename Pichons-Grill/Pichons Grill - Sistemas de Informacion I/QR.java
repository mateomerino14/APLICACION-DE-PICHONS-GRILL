import java.util.Date;
import java.time.LocalDateTime;

public class QR extends Pago{
    private LocalDateTime fechaEmision;
    private LocalDateTime fechaExpiracion;
    private double monto;
    private String imagenQR;
    private String bancoEmisor;
    
    public QR(Pedido pedido){
        super(pedido);
    }
    
    public void crearQR(LocalDateTime fechaEmision, LocalDateTime fechaExpiracion, double monto, String imagen, String bancoEmisor){
        this.fechaEmision = fechaEmision;
        this.fechaExpiracion = fechaExpiracion;
        this.monto = monto;
        this.imagenQR = imagen;
        this.bancoEmisor = bancoEmisor;
    }
    
    public LocalDateTime getFechaEmision(){
        return fechaEmision;
    }
    
    public LocalDateTime getFechaExpiracion(){
        return fechaExpiracion;
    }
    
    public double getMonto(){
        return monto;
    }
    
    public String getImagenQR(){
        return imagenQR;
    }
    
    public String getBancoEmisor(){
        return bancoEmisor;
    }
}