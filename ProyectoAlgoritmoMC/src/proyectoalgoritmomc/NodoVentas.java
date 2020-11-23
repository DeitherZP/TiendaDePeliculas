
package proyectoalgoritmomc;

/**
 * @author Deiter Zamora
 **/
public class NodoVentas {
    private Ventas Ventas;
    private NodoVentas Sig, Atras;
    
    public NodoVentas(){
        this.Ventas = null;
        this.Sig = null;
        this.Atras = null;
    }
    
    public void setVentas(Ventas Ventas){
        this.Ventas = Ventas;
    }
    
    public void setSig(NodoVentas Sig){
        this.Sig = Sig;
    }
    
    public void setAtras(NodoVentas Atras){
        this.Atras = Atras;
    }
    
    public Ventas getVentas(){
        return Ventas;
    }
    
    public NodoVentas getSig(){
        return Sig;
    }
    
    public NodoVentas getAtras(){
        return Atras;
    }
}