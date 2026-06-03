package Controller;
import Clases.Model.*;
import static Controller.ControladorRepositorio.repositorioAlumnos;
import static Controller.ControladorRepositorio.repositorioLibros;
import static Controller.ControladorRepositorio.repositorioPrestamos;
import java.util.Scanner;

public class ControladorModelos {
    static Scanner sc = new Scanner(System.in);
    static String aCargar;
    
    public static void cargarDatos(String seleccion){
        switch(seleccion){
            case "Libro":{
                Libro libro = new Libro();
                aCargar = sc.nextLine();
                libro.setTitulo(aCargar);
                aCargar = sc.nextLine();
                libro.setEditorial(aCargar);
                aCargar = sc.nextLine();
                libro.setAnhoDePublicacion(aCargar);
                aCargar = sc.nextLine();
                libro.setAutor(aCargar);
                repositorioLibros.anhadir(libro);           
                break;
            }
            case "Alumno":{
                Alumno alumno = new Alumno();
                aCargar = sc.nextLine();
                alumno.setNombreCompleto(aCargar);
                aCargar = sc.nextLine();
                alumno.setNroDeDocumento(aCargar);
                aCargar = sc.nextLine();
                alumno.setEmail(aCargar);
                aCargar = sc.nextLine();
                alumno.setTelefono(aCargar);
                aCargar = sc.nextLine();
                alumno.setFechaDeNacimiento(aCargar);
                aCargar = sc.nextLine();
                alumno.setFacultadPerteneciente(aCargar);
                repositorioAlumnos.anhadir(alumno);
                break;
            }
            case "Prestamo":{
                Prestamo prestamo = new Prestamo();
                aCargar = sc.nextLine();
                prestamo.setAlumno(aCargar);
                while(true) {
                    aCargar = sc.nextLine();
                    if(aCargar.equalsIgnoreCase("fin")) {
                        break;
                    }
                    prestamo.agregarLibro(aCargar);
                }
                aCargar = sc.nextLine();
                prestamo.setFechaDePrestamo(aCargar);
                aCargar = sc.nextLine();
                prestamo.setFechaDevolucion(aCargar);
                prestamo.verificarVencimiento();
                repositorioPrestamos.anhadir(prestamo);
                break;
            }
        }
    }
}