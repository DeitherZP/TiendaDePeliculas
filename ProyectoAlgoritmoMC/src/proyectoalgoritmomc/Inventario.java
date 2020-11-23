
package proyectoalgoritmomc;

/**
 * @author Deiter Zamora
 **/
public class Inventario {
    
    private int CodigoPelicula;
    private String NombrePelicula;
    private int Stock;
    private double Valor;
    private String Genero;
    
    public Inventario(int CodigoPelicula, String NombrePelicula, int Stock, double Valor, String Genero){
        this.CodigoPelicula = CodigoPelicula;
        this.NombrePelicula = NombrePelicula;
        this.Stock = Stock;
        this.Valor = Valor;
        this.Genero = Genero;
    }
    
    public void setCodigoPelicula(int CodigoPelicula){
        this.CodigoPelicula = CodigoPelicula;
    }
    
    public void setNombrePelicula(String NombrePelicula){
        this.NombrePelicula = NombrePelicula;
    }
    
    public void setStock(int Stock){
        this.Stock = Stock;
    }
    
    public void setValor(double Valor){
        this.Valor = Valor;
    }
    
    public void setGenero(String Genero){
        this.Genero = Genero;
    }
    
    public int getCodigoPelciula(){
        return CodigoPelicula;
    }
    
    public String getNombrePelicula(){
        return NombrePelicula;
    }
    
    public int getStock(){
        return Stock;
    }
    
    public double getValor(){
        return Valor;
    }
    
    public String getGenero(){
        return Genero;
    }
    
    @Override
    public String toString(){
        String datos = "---------------------------------------------------\n"
                + "Codigo pelicula: "+getCodigoPelciula()+"\n"
                + "Nombre pelicula: "+getNombrePelicula()+"\n"
                + "Stock: "+getStock()+"\n"
                + "Valor: "+getValor()+"\n"
                + "Genero: "+getGenero()+"\n"
                + "---------------------------------------------------";
        return datos;
    }
}