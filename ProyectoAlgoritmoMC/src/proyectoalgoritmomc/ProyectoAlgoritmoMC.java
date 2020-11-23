
package proyectoalgoritmomc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Deiter Zamora
 **/
public class ProyectoAlgoritmoMC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Date fecha = new Date();
        SimpleDateFormat forfec = new SimpleDateFormat("dd/MM/YYYY");
        Inventario in = new Inventario(0, "", 0, 0.0, "");
        Ventas ve = new Ventas(0,"",0,0.0);
        LCDE_Inventario lcdein = new LCDE_Inventario();
        LCDE_Ventas lcdeve = new LCDE_Ventas();
        String Nom_Peli = "", Gene;
        int op = 0, c = 0, p = 0, CodigoPelicula, Stock;
        double Val;
        do {
            System.out.println("***********************MENÚ************************\n"
                    + "1. Ingresar película\n"
                    + "2. Consultas\n"
                    + "3. Eliminar\n"
                    + "4. Venta\n"
                    + "5. Actualización\n"
                    + "6. Terminar");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("*****************INGRESAR PELÍCULA*****************");
                    System.out.println("Ingrese el nombre de la película");
                    sc.nextLine();
                    Nom_Peli = sc.nextLine();
                    System.out.println("Ingrese el stock");
                    Stock = sc.nextInt();
                    System.out.println("Ingrese el valor");
                    Val = sc.nextDouble();
                    System.out.println("Ingrese el genero");
                    Gene = sc.next();
                    c++;
                    in = new Inventario(c, Nom_Peli, Stock, Val, Gene);
                    lcdein.Insertar(in);
                    System.out.println("***************************************************\n");
                    break;
                case 2:
                    int opcon = 0;
                    do {
                        System.out.println("*********************CONSULTAS*********************\n"
                                + "1. 5 Películas más vendidas\n"
                                + "2. 5 Películas menos vendidas\n"
                                + "3. Stock de películas\n"
                                + "4. Ventas del día\n"
                                + "5. Regresar");
                        opcon = sc.nextInt();
                        switch (opcon) {
                            case 1:int a[][] = new int[lcdein.Tamaño()][2];
                                int proc = 1;
                                for(int i = 0; i < lcdein.Tamaño(); i++){
                                    a[i][0] = lcdeve.Conteo(lcdein.ObtCoPelicula(proc));
                                    a[i][1] = lcdein.ObtCoPelicula(proc);
                                    proc++;
                                }
                                for(int i = 0; i < lcdein.Tamaño(); i++){
                                    for(int j = i + 1; j < lcdein.Tamaño(); j++){
                                        if(a[i][0] < a[j][0]){
                                            int aux = a[i][0];
                                            a[i][0] = a[j][0];
                                            a[j][0] = aux;
                                            aux = a[i][1];
                                            a[i][1] = a[j][1];
                                            a[j][1] = aux;
                                        }
                                    }
                                }
                                System.out.println("*************5 PELÍCULAS MAS VENDIDAS**************");
                                for(int i = 0; i < 5 && i < lcdein.Tamaño(); i++){
                                    lcdein.PeliculaVendidas(a[i][1]);
                                }
                                System.out.println("***************************************************\n");
                                break;
                            case 2:
                                int b[][] = new int[lcdein.Tamaño()][2];
                                int procb = 1;
                                for(int i = 0; i < lcdein.Tamaño(); i++){
                                    b[i][0] = lcdeve.Conteo(lcdein.ObtCoPelicula(procb));
                                    b[i][1] = lcdein.ObtCoPelicula(procb);
                                    procb++;
                                }
                                for(int i = 0; i < lcdein.Tamaño(); i++){
                                    for(int j = i + 1; j < lcdein.Tamaño(); j++){
                                        if(b[i][0] > b[j][0]){
                                            int aux = b[i][0];
                                            b[i][0] = b[j][0];
                                            b[j][0] = aux;
                                            aux = b[i][1];
                                            b[i][1] = b[j][1];
                                            b[j][1] = aux;
                                        }
                                    }
                                }
                                System.out.println("*************5 PELÍCULAS MENOS VENDIDAS************");
                                for(int i = 0; i < 5 && i < lcdein.Tamaño(); i++){
                                    lcdein.PeliculaVendidas(b[i][1]);
                                }
                                System.out.println("***************************************************\n");
                                break;
                            case 3:
                                    lcdein.OrdenarA_Z();
                                break;
                            case 4:
                                    lcdeve.VentaDia(forfec.format(fecha));
                                break;
                            case 5:
                                System.out.println("REGRESANDO...");
                                break;
                            default:
                                System.out.println("ERROR!! LA OPCION INGRESADA ES INEXISTEN, VUELVA A INTENTARLO");
                                break;
                        }
                    } while (opcon != 5);
                    break;
                case 3:
                        System.out.println("*****************ELIMINAR PELÍCULA*****************");
                        System.out.println("Ingrese el codigo de la pelicula que desea eliminar");
                        CodigoPelicula = sc.nextInt();
                        if(lcdein.Existe(CodigoPelicula)==true){
                            lcdein.EliminarPelicula(CodigoPelicula);
                        } else{
                            System.out.println("ERROR!! EL CÓDIGO INGRESADO NO EXISTE NI PERTENECE A NINGUNA PELÍCULA");
                        }
                        System.out.println("****************************************************\n");
                    break;
                case 4:
                        System.out.println("******************VENDER PELÍCULA******************");
                        System.out.println("Inserte el codigo de la pelicula que desea usar");
                        CodigoPelicula = sc.nextInt();
                        if(lcdein.Existe(CodigoPelicula)==true){
                            if(lcdein.BuscarStock(CodigoPelicula)>=1){
                                p++;
                                    lcdein.RestarStock(CodigoPelicula);
                                ve = new Ventas(p, forfec.format(fecha), CodigoPelicula, lcdein.BuscarValor(CodigoPelicula));
                                lcdeve.Insertar(ve);
                            } else{
                                System.out.println("ERROR!! PELÍCULA CON STOCK AGOTADO");
                            }
                        } else{
                            System.out.println("ERROR!! EL CÓDIGO INGRESADO NO EXISTE NI PERTENECE A NINGUNA PELÍCULA");
                        }
                        System.out.println("***************************************************\n");
                    break;
                case 5:
                        System.out.println("*****************ACTUALIZAR PEÍCULA*****************");
                        System.out.println("Ingrese el código de la película que desea actualizar");
                        CodigoPelicula = sc.nextInt();
                        if(lcdein.Existe(CodigoPelicula)==true){
                            int opac = 0;
                            do{
                                System.out.println("+++ELIGA EL CAMPO QUE DESEA ACTUALIZAR+++\n"
                                        + "1. Actualizar Stock -- Película "+lcdein.BuscarNombrePelicula(CodigoPelicula)+"\n"
                                        + "2. Actualizar Valor -- Película "+lcdein.BuscarNombrePelicula(CodigoPelicula)+"\n"
                                        + "3. Actualizar Genero -- Película "+lcdein.BuscarNombrePelicula(CodigoPelicula)+"\n"
                                        + "4. Actualizar todo -- Película "+lcdein.BuscarNombrePelicula(CodigoPelicula)+"\n"
                                        + "5. Regresar");
                                opac = sc.nextInt();
                                switch(opac){
                                    case 1:
                                            System.out.println("Ingrese el nuevo stock");
                                            Stock = sc.nextInt();
                                            lcdein.Actualizar(CodigoPelicula, Stock, 0, "", "Stock");
                                        break;
                                    case 2:
                                            System.out.println("Ingrese el nuevo valor");
                                            Val = sc.nextDouble();
                                            lcdein.Actualizar(CodigoPelicula, 0, Val, "", "Valor");
                                        break;
                                    case 3:
                                            System.out.println("Ingrese el nuevo genero");
                                            Gene = sc.next();
                                            lcdein.Actualizar(CodigoPelicula, 0, 0, Gene, "Genero");
                                        break;
                                    case 4:
                                            System.out.println("Ingrese el nuevo stock");
                                            Stock = sc.nextInt();
                                            System.out.println("Ingrese el nuevo valor");
                                            Val = sc.nextDouble();
                                            System.out.println("Ingrese el nuevo genero");
                                            Gene = sc.next();
                                            lcdein.Actualizar(CodigoPelicula, Stock, Val, Gene, "All");
                                        break;
                                    case 5:
                                            System.out.println("REGRESANDO...");
                                        break;
                                    default:
                                            System.out.println("ERROR!! LA OPCIÓN INGRESADA ES INEXISTENTE, VUELVA A INTENTARLO");
                                        break;
                                }
                            } while(opac!=5);
                        } else{
                            System.out.println("ERROR!! EL CÓDIGO INGRESADO NO EXISTE NI PERTENECE A NINGUNA PELÍCULA");
                        }
                        System.out.println("***************************************************\n");
                    break;
                case 6:
                        System.out.println("TERMINANDO");
                    break;
                default:
                        System.out.println("ERROR!! LA OPCIÓN INGRESADA ES INEXISTEN, VUELVA A INTENTARLO");
                    break;
            }
        } while (op != 6);
        System.out.println("***************************************************");
    }
}