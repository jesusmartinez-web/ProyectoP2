package Controller;

import View.VentanaPrincipal;
import Clases.Model.*;
import Repositorios.*;
import java.util.Collection;

public class ControladorView {

    public static void controlMenuPrincipal() {
        java.awt.EventQueue.invokeLater(() -> {
            VentanaPrincipal v = new VentanaPrincipal();
            v.setVisible(true);
        });
    }

    // Alumnos
    public static void agregarAlumno(Alumno a) {
        ControladorRepositorio.repositorioAlumnos.anhadir(a);
    }

    public static Collection<Alumno> obtenerAlumnos() {
        return RepositorioAlumno.alumnos.values();
    }

    public static void borrarAlumno(Alumno a) {
        ControladorRepositorio.repositorioAlumnos.borrar(a);
    }

    // Libros 
    public static void agregarLibro(Libro l) {
        ControladorRepositorio.repositorioLibros.anhadir(l);
    }

    public static Collection<Libro> obtenerLibros() {
        return RepositorioLibros.libros.values();
    }

    public static void borrarLibro(Libro l) {
        ControladorRepositorio.repositorioLibros.borrar(l);
    }

    // Prestamos 
    public static void agregarPrestamo(Prestamo p) {
        ControladorRepositorio.repositorioPrestamos.anhadir(p);
    }

    public static Collection<Prestamo> obtenerPrestamos() {
        return RepositorioPrestamos.prestamos.values();
    }

    public static void borrarPrestamo(Prestamo p) {
        ControladorRepositorio.repositorioPrestamos.borrar(p);
    }
}