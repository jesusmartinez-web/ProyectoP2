
package Repositorios;
import Clases.Model.Libro;
import java.util.HashMap;
import java.util.Map;

public class RepositorioLibros implements RepositorioBase<Libro>{
    
    public static Map<Integer, Libro> libros = new HashMap<>();
    private static int sgteId = 1;

    @Override
    public void anhadir(Libro libro) {
        libro.setId(sgteId++);
        libros.put(libro.getId(), libro);
    }

    @Override
    public void borrar(Libro libro) {
        libros.remove(libro.getId());
    }
    
    

    @Override
    public void listar() {
        System.out.printf("%-20s | %-15s | %-10s %n", "TITULO", "AUTOR", "ANHO");
        System.out.println("------------------------------------------------------------");

        for (Libro libro : libros.values()) {
            System.out.printf("%-20s | %-15s | %-10s %n", libro.getTitulo(), libro.getAutor(), libro.getAnhoDePublicacion());
    
        }
        
 
    }   

}
