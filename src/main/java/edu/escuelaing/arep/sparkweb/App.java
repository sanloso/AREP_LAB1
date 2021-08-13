package edu.escuelaing.arep.sparkweb;
import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("la aplicacion esta cargando…");
        get("/hello", (req, res) -> "Hello World");
    }
}
