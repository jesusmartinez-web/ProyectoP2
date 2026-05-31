
package Repositorios;

import Clases.Model.Alumno;
import java.util.HashMap;
import java.util.Map;

public class RepositorioAlumno implements RepositorioBase<Alumno> {
    
    public static Map<String, Alumno> alumnos = new HashMap<>();

    @Override
    public void anhadir(Alumno alumno) {
        alumnos.put(alumno.getNroDeDocumento(), alumno);
    }

    @Override
    public void listar() {
    System.out.printf("%-30s | %-20s | %-12s | %-12s %n", 
                      "NOMBRE COMPLETO", "FACULTAD", "DOCUMENTO", "TELEFONO");
    System.out.println("--------------------------------------------------------------------------------");
    for (Alumno alu : alumnos.values()) {
        System.out.printf("%-30s | %-20s | %-12s | %-12s %n", 
            alu.getNombreCompleto(), 
            alu.getFacultadPerteneciente(), 
            alu.getNroDeDocumento(), 
            alu.getTelefono());
        }
    }
    
    @Override
    public void borrar(Alumno alumno) {
        alumnos.remove(alumno.getNroDeDocumento());
        
        
    }


    
    
}
