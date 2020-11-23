
package proyectoalgoritmomc;

/**
 * @author Deiter Zamora
 **/
public class LCDE_Ventas {
    private NodoVentas Cabecera;
    
    public LCDE_Ventas(){
        Cabecera = null;
    }
    
    public boolean esVaciaVentas(){
        return Cabecera == null;
    }
    
    public void Insertar(Ventas Ventas){
        NodoVentas nuevo = new NodoVentas();
        nuevo.setVentas(Ventas);
        if(esVaciaVentas()){
            Cabecera = nuevo;
            nuevo.setAtras(Cabecera);
            nuevo.setSig(Cabecera);
        } else{
            nuevo.setAtras(Cabecera.getAtras());
            nuevo.setSig(Cabecera);
            Cabecera.getAtras().setSig(nuevo);
            Cabecera.setAtras(nuevo);
        }
    }
    
    public void VentaDia(String FechaVenta){
        if(!esVaciaVentas()){
            NodoVentas aux = Cabecera;
            System.out.println("*****************VENTAS DEL DIA "+FechaVenta+"********************");
            do{
                if(aux.getVentas().getFechaVenta().equals(FechaVenta)){
                    System.out.println(aux.getVentas().toString());
                } 
                aux = aux.getSig();
            } while(aux!=Cabecera);
            System.out.println("***************************************************\n");
        } else{
            System.out.println("No existe datos para mostrar");
        }
    }
    
    public int Conteo(int CodigoPelicula){
        int conteo = 0;
        NodoVentas aux = Cabecera;
        do{
            if(aux.getVentas().getCodigoPelicula()==CodigoPelicula){
                conteo++;
            }
            aux = aux.getSig();
        } while(aux!=Cabecera);
        return conteo;
    }
}