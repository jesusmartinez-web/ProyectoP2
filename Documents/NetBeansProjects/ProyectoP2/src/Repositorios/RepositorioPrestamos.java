package Repositorios;

import Clases.Model.Prestamo;
import java.util.HashMap;
import java.util.Map;

public class RepositorioPrestamos implements RepositorioBase<Prestamo> {
    
    public static Map<Integer, Prestamo> prestamos = new HashMap<>(); 
    
    
    
    public static int sgteId=0;
    

    @Override
    public  void anhadir(Prestamo aAnhadir) {
        
        prestamos.put(sgteId, aAnhadir);
        aAnhadir.setId(sgteId);
        sgteId++;
    }

    @Override
    public void listar() {
        System.out.printf("%-20s | %-25s | %-15s |%-10s |%-10s %n", "ALUMNO", "LIBROS", "FECHA PRESTAMO","VENCIDO","ID");
        System.out.println("---------------------------------------------------------------------------------------------");
        
        for (Prestamo prestamo : prestamos.values()) {
            // Unimos la lista de libros
            String librosUnidos = String.join(", ", prestamo.getLibros()); 
            
            System.out.printf("%-20s | %-25s | %-15s |%-10s |%-25d %n", 
                prestamo.getAlumno(), 
                librosUnidos, 
                prestamo.getFechaDePrestamo(),
                prestamo.verificarVencimiento(),
                prestamo.getId());
        }
    }

    @Override
    public void borrar(Prestamo aBorrar) {
        prestamos.remove(aBorrar.getId());
    }
    
    public void informeDeVencidos() {
        System.out.println("\n--- INFORME DE PRÉSTAMOS VENCIDOS ---");
        System.out.printf("%-20s | %-25s | %-15s |%-10s %n", "ALUMNO", "LIBROS", "FECHA PACTADA", "ID");
        System.out.println("-------------------------------------------------------------------------------");
    
        for (Prestamo prestamo : prestamos.values()) {
            prestamo.verificarVencimiento(); 
            if (prestamo.isVencido()) {
                String librosUnidos = String.join(", ", prestamo.getLibros());
                
                System.out.printf("%-20s | %-25s | %-15s |%-10d %n", 
                    prestamo.getAlumno(), 
                    librosUnidos,
                    prestamo.getFechaDevolucion(), 
                    prestamo.getId());
            }
        }
    }
}