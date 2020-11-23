
package proyectoalgoritmomc;

/**
 * @author Deiter Zamora
 **/
public class LCDE_Inventario {
    private NodoInventario Cabecera;
   
    public LCDE_Inventario(){
       Cabecera = null;
    }
    
    public boolean esVacia(){
        return Cabecera == null;
    }
    
    public void Insertar(Inventario Inventario){
        NodoInventario nuevo = new NodoInventario();
        nuevo.setInventario(Inventario);
        if(esVacia()){
           Cabecera = nuevo;
           nuevo.setAtras(Cabecera);
           nuevo.setSig(Cabecera);
       } else {
           nuevo.setAtras(Cabecera.getAtras());
           nuevo.setSig(Cabecera);
           Cabecera.getAtras().setSig(nuevo);
           Cabecera.setAtras(nuevo);
       }
    }
    
    public int Tamaño(){
        int con = 0;
        NodoInventario aux = Cabecera;
        do{
            con++;
            aux = aux.getSig();
        } while(aux!=Cabecera);
        return con;
    }
    
    public int ObtCoPelicula(int Proc){
        int ap = 0;
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            for(int c = 0; c < Proc; c++){
                ap = aux.getInventario().getCodigoPelciula();
                aux = aux.getSig();
            }
        }
        return ap;
    }
    
    public void OrdenarA_Z(){
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            do{
                if(aux.getInventario().getNombrePelicula().compareToIgnoreCase(aux.getSig().getInventario().getNombrePelicula())<0){
                    Inventario auxIN = aux.getInventario();
                    aux.setInventario(aux.getSig().getInventario());
                    aux.getSig().setInventario(auxIN);
                }
                aux = aux.getSig();
            } while(aux!=Cabecera);
            do{
                System.out.println(aux.getInventario().toString());
                aux = aux.getSig();
            } while(aux!=Cabecera);
        }
    }
    
    public String BuscarNombrePelicula(int CodigoPelicula){
        String NombrePelicula = "";
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            do{
                if(aux.getInventario().getCodigoPelciula()==CodigoPelicula){
                    NombrePelicula = aux.getInventario().getNombrePelicula();
                } 
                aux = aux.getSig();
            } while(aux!=Cabecera);
        } else{
            System.out.println("No existe datos para mostrar");
        }
        return NombrePelicula;
    }
    
    public boolean Existe(int CodigoPelicula){
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            do{
                if(aux.getInventario().getCodigoPelciula()==CodigoPelicula){
                    return true;
                } 
                aux = aux.getSig();
            } while(aux!=Cabecera);
        } else{
            System.out.println("No existe datos");
        }
        return false;
    }
    
    public double BuscarValor(int CodigoPelicula){
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            do{
                if(aux.getInventario().getCodigoPelciula()==CodigoPelicula){
                    return aux.getInventario().getValor();
                } 
                aux = aux.getSig();
            } while(aux!=Cabecera);
        } else{
            System.out.println("No existe datos");
        }
        return 0;
    }
    
    public int BuscarStock(int CodigoPelicula){
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            do{
                if(aux.getInventario().getCodigoPelciula()==CodigoPelicula){
                    return aux.getInventario().getStock();
                } 
                aux = aux.getSig();
            } while(aux!=Cabecera);
        } else{
            System.out.println("No existe datos");
        }
        return 0;
    }
    
    public void EliminarPelicula(int CodigoPelicula){
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            do{
                if(aux.getInventario().getCodigoPelciula()==CodigoPelicula){
                    aux.getAtras().setSig(aux.getSig());
                    aux.getSig().setAtras(aux.getAtras());
                    if(aux==Cabecera){
                        Cabecera = aux.getSig();
                    } 
                    if(aux==Cabecera){
                        Cabecera = null;
                    }
                    return;
                } else{
                aux = aux.getSig();
                }
            } while(aux!=Cabecera);
            if(aux.getInventario().getCodigoPelciula()!=CodigoPelicula){
                System.out.println("No se encontro la pelicula que desea eliminar");
            }
        } else{
            System.out.println("No existe datos para eliminar");
        }
        Cabecera = Cabecera.getSig();
    }
    
    public void Actualizar(int CodigoPelicula, int Stock, double Valor, String Genero, String OP){
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            do{
                if(aux.getInventario().getCodigoPelciula()==CodigoPelicula){
                    switch(OP){
                        case "Stock":
                                aux.getInventario().setStock(Stock);
                            break;
                        case "Valor":
                                aux.getInventario().setValor(Valor);
                            break;
                        case "Genero":
                                aux.getInventario().setGenero(Genero);
                            break;
                        case "All":
                                aux.getInventario().setStock(Stock);
                                aux.getInventario().setValor(Valor);
                                aux.getInventario().setGenero(Genero);
                            break;
                        default:
                                System.out.println("ERROR!! AL ACTUALIZAR");
                            break;
                        }
                    }
                aux=aux.getSig();
            } while(aux!=Cabecera);
        } else{
            System.out.println("No existe datos ingresados");
        }
    }
    
    public void RestarStock(int CodigoPelicula){
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            do{
                if(aux.getInventario().getCodigoPelciula()==CodigoPelicula){
                    aux.getInventario().setStock(aux.getInventario().getStock() - 1);
                } 
                aux=aux.getSig();
            } while(aux!=Cabecera);
        } else{
            System.out.println("No existe datos ingresados");
        }
    }
    
    public void PeliculaVendidas(int CodigoPelicula){
        if(!esVacia()){
            NodoInventario aux = Cabecera;
            do{
                if(aux.getInventario().getCodigoPelciula()==CodigoPelicula){
                    System.out.println(aux.getInventario().toString());
                }
                aux = aux.getSig();
            } while(aux!=Cabecera);
        } else{
            System.out.println("No existe datos ingresados");
        }
    }
}