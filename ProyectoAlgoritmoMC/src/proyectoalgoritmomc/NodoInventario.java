
package proyectoalgoritmomc;

/**
 * @author Deiter Zamora
 **/
public class NodoInventario {
    private Inventario Inventario;
    private NodoInventario Sig, Atras;
    
    public NodoInventario(){
        this.Inventario = null;
        this.Sig = null;
        this.Atras = null;
    }
    
    public void setInventario(Inventario Inventario){
        this.Inventario = Inventario;
    }

    public void setSig(NodoInventario Sig){
        this.Sig = Sig;
    }
    
    public void setAtras(NodoInventario Atras){
        this.Atras =Atras;
    }
    
    public Inventario getInventario(){
        return Inventario;
    }

    public NodoInventario getSig(){
        return Sig;
    }
    
    public NodoInventario getAtras(){
        return Atras;
    }
}