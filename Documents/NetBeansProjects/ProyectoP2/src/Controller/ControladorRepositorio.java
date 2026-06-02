
package Controller;
import Clases.Model.Alumno;
import Clases.Model.Libro;
import Clases.Model.Prestamo;
import Repositorios.*;
import java.util.Scanner;
import View.*;


public class ControladorRepositorio {
    
    static Scanner sc = new Scanner(System.in);
    public static int seleccion;
    public static String aCambiar;
    
    public static RepositorioAlumno repositorioAlumnos = new RepositorioAlumno();
    
    public static RepositorioLibros repositorioLibros = new RepositorioLibros();
    
    public static RepositorioPrestamos repositorioPrestamos = new RepositorioPrestamos();
  
    public static void editarAlumno(String cedula){
        
        Alumno alumno = RepositorioAlumno.alumnos.get(cedula);
        System.out.println("---Alumno: "+ alumno.getNombreCompleto() +"---");
        System.out.println("Dime que quieres cambiar: ");
        System.out.println("1- Nombre");
        System.out.println("2- Número de Documento");
        System.out.println("3- Email");
        System.out.println("4- Teléfono");
        System.out.println("5- Fecha de Nacimiento");
        System.out.println("6- Facultad Perteneciente");
        seleccion = sc.nextInt();
        sc.nextLine();
        switch(seleccion){
            case 1:
                System.out.println("Cambiaras "+alumno.getNombreCompleto()+" por: ");
                aCambiar = sc.nextLine();
                alumno.setNombreCompleto(aCambiar);
                break;
            case 2:
                System.out.println("Cambiaras "+alumno.getNroDeDocumento()+" por: ");
                aCambiar = sc.nextLine();
                alumno.setNroDeDocumento(aCambiar);
                break;
            case 3:
                System.out.println("Cambiaras "+alumno.getEmail()+" por: ");
                aCambiar = sc.nextLine();
                alumno.setEmail(aCambiar);
                break;
            case 4:
                System.out.println("Cambiaras "+alumno.getTelefono()+" por: ");
                aCambiar = sc.nextLine();
                alumno.setTelefono(aCambiar);
                break;
            case 5:
                System.out.println("Cambiaras "+alumno.getFechaDeNacimiento()+" por: ");
                aCambiar = sc.nextLine();
                alumno.setFechaDeNacimiento(aCambiar);
                break;
            case 6:
                System.out.println("Cambiaras "+alumno.getFacultadPerteneciente()+" por: ");
                aCambiar = sc.nextLine();
                alumno.setFacultadPerteneciente(aCambiar);
                break;
            default:
                Menus.opcionInvalida();
                break;
        }
    }
    
    public static void editarLibro(String titulo){
        Libro libro = RepositorioLibros.libros.get(titulo);
        System.out.println("---Libro: "+ libro.getTitulo() +"---");
        System.out.println("Dime que quieres cambiar: ");
        System.out.println("1- Título");
        System.out.println("2- Editorial");
        System.out.println("3- Año de Publicación");
        System.out.println("4- Autor");
        seleccion = sc.nextInt();
        sc.nextLine();
        switch(seleccion){
            case 1:
                System.out.println("Cambiaras "+libro.getTitulo()+" por: ");
                aCambiar = sc.nextLine();
                libro.setTitulo(aCambiar);
                break;
            case 2:
                System.out.println("Cambiaras "+libro.getEditorial()+" por: ");
                aCambiar = sc.nextLine();
                libro.setEditorial(aCambiar);
                break;
            case 3:
                System.out.println("Cambiaras "+libro.getAnhoDePublicacion()+" por: ");
                aCambiar = sc.nextLine();
                libro.setAnhoDePublicacion(aCambiar);
                break;
            case 4:
                System.out.println("Cambiaras "+libro.getAutor()+" por: ");
                aCambiar = sc.nextLine();
                libro.setAutor(aCambiar);
                break;
            default:
                Menus.opcionInvalida();
                break;
        }
    }
    
    public static void editarPrestamo(int id){
        Prestamo prestamo = RepositorioPrestamos.prestamos.get(id);
        System.out.println("---Préstamo de: "+ prestamo.getAlumno() +"---");
        System.out.println("Dime que quieres cambiar: ");
        System.out.println("1- Alumno");
        System.out.println("2- Libros");
        System.out.println("3- Fecha de Préstamo");
        System.out.println("4- Fecha de Devolución Pactada");
        System.out.println("5- Fecha Devuelta");
        seleccion = sc.nextInt();
        sc.nextLine();
        switch(seleccion){
            case 1:
                System.out.println("Cambiaras "+prestamo.getAlumno()+" por: ");
                aCambiar = sc.nextLine();
                prestamo.setAlumno(aCambiar);
                break;
            case 2:
                System.out.println("Cambiando la lista de libros actuales.");
                System.out.println("Ingrese los nuevos libros uno por uno (escriba 'fin' para terminar): ");
                
                prestamo.getLibros().clear(); 
                
                while(true) {
                    aCambiar = sc.nextLine();
                    if(aCambiar.equalsIgnoreCase("fin")) {
                        break; 
                    }
                    prestamo.agregarLibro(aCambiar);
                    System.out.println("Libro agregado a la modificación. Ingrese otro o escriba 'fin':");
                }
                break;
            case 3:
                System.out.println("Cambiaras "+prestamo.getFechaDePrestamo()+" por: ");
                aCambiar = sc.nextLine();
                prestamo.setFechaDePrestamo(aCambiar);
                break;
            case 4:
                System.out.println("Cambiaras "+prestamo.getFechaDevolucion()+" por: ");
                aCambiar = sc.nextLine();
                prestamo.setFechaDevolucion(aCambiar);
                break;
            case 5:
                System.out.println("Cambiaras "+prestamo.getFechaDevuelta()+" por: ");
                aCambiar = sc.nextLine();
                prestamo.setFechaDevuelta(aCambiar);
                break;
            default:
                Menus.opcionInvalida();
                break;
        }
        prestamo.verificarVencimiento();
    }
    
    public static void borrarTodo(String menuSeleccionado){
        switch(menuSeleccionado){
            case "Alumno":
                RepositorioAlumno.alumnos.clear();
                break;
            case "Libro": 
                RepositorioLibros.libros.clear();
                break;
            case "Prestamo": 
                RepositorioPrestamos.prestamos.clear();
                break;
    }   
  }
    
    
}
