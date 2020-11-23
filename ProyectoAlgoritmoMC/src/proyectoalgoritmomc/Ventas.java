
package proyectoalgoritmomc;

import java.util.Date;

/**
 * @author Deiter Zamora
 **/
public class Ventas {
    
    private int CodigoCliente;
    private String FechaVenta;
    private int CodigoPelicula;
    private double Valor;
    
    public Ventas(int CodigoCliente, String FechaVenta, int CodigoPelicula, double Valor){
        this.CodigoCliente = CodigoCliente;
        this.FechaVenta = FechaVenta;
        this.CodigoPelicula = CodigoPelicula;
        this.Valor = Valor;
    }
    
    public void setCodigoCliente(int CodigoCliente){
        this.CodigoCliente = CodigoCliente;
    }
    
    public void setFechaVenta(String FechaVenta){
        this.FechaVenta = FechaVenta;
    }
    
    public void setCodigoPelicula(int CodigoPelicula){
        this.CodigoPelicula = CodigoPelicula;
    }
    
    public void setValor(double Valor){
        this.Valor = Valor;
    }
    
    public int getCodigoCliente(){
        return CodigoCliente;
    }
    
    public String getFechaVenta(){
        return FechaVenta;
    }
    
    public int getCodigoPelicula(){
        return CodigoPelicula;
    }
    
    public double getValor(){
        return Valor;
    }
    
    @Override
    public String toString(){
        LCDE_Inventario in = new LCDE_Inventario();
        String datos = "----------------------------------------------------"
                + "Codigo cliente: "+getCodigoCliente()+"\n"
                + "Fecha: "+getFechaVenta()+"\n"
                + "Codigo pelicula: "+getCodigoPelicula()+"\n"
                + "Nombre pelicula: "+in.BuscarNombrePelicula(getCodigoPelicula())+"\n"
                + "Valor: "+getValor()+"\n"
                + "---------------------------------------------------";
        return datos;
    }
}