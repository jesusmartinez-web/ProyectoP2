package Controller;
import Clases.Model.*;
import static Controller.ControladorMenu.menuSeleccionado;
import static Controller.ControladorRepositorio.repositorioAlumnos;
import static Controller.ControladorRepositorio.repositorioLibros;
import static Controller.ControladorRepositorio.repositorioPrestamos;
import View.Menus;
import java.util.Scanner;

public class ControladorModelos {
    static Scanner sc = new Scanner(System.in);
    static String aCargar;
    
    public static void cargarDatos(String seleccion){
        switch(seleccion){
            case "Libro":{
                Libro libro = new Libro();
                Menus.pedirTitulo(menuSeleccionado);
                aCargar = sc.nextLine();
                libro.setTitulo(aCargar);
                Menus.pedirEditorial(menuSeleccionado);
                aCargar = sc.nextLine();
                libro.setEditorial(aCargar);
                Menus.pedirAnho(menuSeleccionado);
                aCargar = sc.nextLine();
                libro.setAnhoDePublicacion(aCargar);
                Menus.pedirAutor(menuSeleccionado);
                aCargar = sc.nextLine();
                libro.setAutor(aCargar);
                repositorioLibros.anhadir(libro);           
                break;
            }
            case "Alumno":{
                Alumno alumno = new Alumno();
                Menus.pedirNombre(menuSeleccionado);
                aCargar = sc.nextLine();
                alumno.setNombreCompleto(aCargar);
                Menus.pedirDocumento(menuSeleccionado);
                aCargar = sc.nextLine();
                alumno.setNroDeDocumento(aCargar);
                Menus.pedirEmail(menuSeleccionado);
                aCargar = sc.nextLine();
                alumno.setEmail(aCargar);
                Menus.pedirTelefono(menuSeleccionado);
                aCargar = sc.nextLine();
                alumno.setTelefono(aCargar);
                Menus.pedirFechaNacimiento(menuSeleccionado);
                aCargar = sc.nextLine();
                alumno.setFechaDeNacimiento(aCargar);
                Menus.pedirFacultad(menuSeleccionado);
                aCargar = sc.nextLine();
                alumno.setFacultadPerteneciente(aCargar);
                repositorioAlumnos.anhadir(alumno);
                break;
            }
            case "Prestamo":{
                Prestamo prestamo = new Prestamo();
                Menus.pedirAlumnoPrestamo(menuSeleccionado);
                aCargar = sc.nextLine();
                prestamo.setAlumno(aCargar);
                Menus.pedirLibrosPrestamo(menuSeleccionado);
                while(true) {
                    aCargar = sc.nextLine();
                    if(aCargar.equalsIgnoreCase("fin")) {
                        break;
                    }
                    prestamo.agregarLibro(aCargar);
                    System.out.println("Libro agregado. Ingrese otro o escriba 'fin':");
                }
                Menus.pedirFechaPrestamo(menuSeleccionado);
                aCargar = sc.nextLine();
                prestamo.setFechaDePrestamo(aCargar);
                Menus.pedirFechaDevolucion(menuSeleccionado);
                aCargar = sc.nextLine();
                prestamo.setFechaDevolucion(aCargar);
                
                prestamo.verificarVencimiento();
                repositorioPrestamos.anhadir(prestamo);
                break;
            }
        
        }
    }
    
    
    
    
    
}
