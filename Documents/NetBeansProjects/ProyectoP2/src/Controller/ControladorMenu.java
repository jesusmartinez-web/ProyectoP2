package Controller;

import Repositorios.RepositorioAlumno;
import Repositorios.RepositorioLibros;
import Repositorios.RepositorioPrestamos;
import View.*;
import java.util.Scanner;

public class ControladorMenu {
    static Scanner sc = new Scanner(System.in);
    static int opcion;
    static public String menuSeleccionado;
    public static boolean activo = true;
    
   
    
    public static String controlMenuPrincipal(){ 
        Menus.mostrarMenuPrincipal();
        opcion = sc.nextInt();
            switch(opcion){
                case 1: return "Libro";
                case 2: return "Alumno";
                case 3: return "Prestamo";
                case 4: System.out.println("Cerrando Programa, Hasta luego!");
                        activo = false;
                        return null;
                
                
                default: Menus.opcionInvalida();return null;
            }
        }
    public static void controlSubmenus(String menu){
        if(menu !=null){
            menuSeleccionado=menu;
            Menus.mostrarSubMenu(menu);
            opcion = sc.nextInt();
        }
    }
    
    
    public static void controlOpciones(String menuSeleccionado){
        
        switch(opcion){
            
            case 1: {
                ControladorModelos.cargarDatos(menuSeleccionado);
                break;
            }
            case 2: {
                Menus.seleccionarModificarOBorrar(menuSeleccionado);
                int aux = sc.nextInt();
                switch(aux){
                    case 1:{
                        switch(menuSeleccionado){
                            case "Libro":{
                                Menus.pedirTitulo(menuSeleccionado);
                                String titulo = sc.nextLine();
                                ControladorRepositorio.editarLibro(titulo);
                                break;
                            }
                            case "Alumno": {
                                Menus.pedirDocumento(menuSeleccionado);
                                String documento = sc.nextLine();
                                ControladorRepositorio.editarAlumno(documento);
                                break;
                            }
                            case "Prestamo":{
                                Menus.pedirId();
                                int id = sc.nextInt();
                                ControladorRepositorio.editarPrestamo(id);
                                break;
                            }
                                    
                        }
                        Menus.pedirDocumento(menuSeleccionado);
                        String cedula = sc.nextLine();
                        ControladorRepositorio.editarAlumno(cedula);
                        break;
                        
                    }
                    case 2:{
                        ControladorRepositorio.borrarTodo(menuSeleccionado);
                        Menus.borrado();
                        break;
                    }
                    
                    
                    
                    default: Menus.opcionInvalida();
                    
           
                }
            }
            case 3:{
                
                switch(menuSeleccionado){
                    case "Prestamo":
                        Menus.pedirId();
                        int auxId = sc.nextInt();
                        ControladorRepositorio.repositorioPrestamos.borrar(RepositorioPrestamos.prestamos.get(auxId));
                        break;
                    case "Alumno":
                        Menus.pedirDocumento(menuSeleccionado);
                        String documento = sc.nextLine();
                        ControladorRepositorio.repositorioAlumnos.borrar(RepositorioAlumno.alumnos.get(documento));
                        break;
                    case "Libro":{
                        Menus.pedirTitulo(menuSeleccionado);
                        String titulo = sc.nextLine();
                        ControladorRepositorio.repositorioLibros.borrar(RepositorioLibros.libros.get(titulo));
                        break;
                    }
                             
                }
                break;
        }
            case 4:{
                switch(menuSeleccionado){
                    case "Prestamo":{
                        ControladorRepositorio.repositorioPrestamos.listar();
                        break;}
                    case "Alumno":{
                        ControladorRepositorio.repositorioAlumnos.listar();
                        break;}
                        
                    case "Libro":{
                        ControladorRepositorio.repositorioLibros.listar();
                        break;}
                    
      
                 }
                break;
            }
            case 5:{
                if(menuSeleccionado.equals("Prestamo")){
                    Menus.pedirId();
                    int auxId = sc.nextInt();
                    ControladorRepositorio.repositorioPrestamos.borrar(RepositorioPrestamos.prestamos.get(auxId));
                    break;
                }else
                    controlSubmenus(menuSeleccionado);
            break;    
            }   
    }
    }
    public void ejecutar(){
                
        do{
            
            ControladorMenu.controlSubmenus(ControladorMenu.controlMenuPrincipal());
            ControladorMenu.controlOpciones(menuSeleccionado);
            
            
        }while(activo);
        
        
    }
    
}
    
