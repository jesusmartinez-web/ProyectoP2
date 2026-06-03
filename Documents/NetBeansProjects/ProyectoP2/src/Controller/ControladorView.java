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
    public static void agregarAlumno(String nombreCompleto, String nroDoc, String email, 
                                     String telf, String fechaNac, String facultad) {
       Alumno alumno = new Alumno();
       alumno.setNombreCompleto(nombreCompleto);
       alumno.setNroDeDocumento(nroDoc);
       alumno.setEmail(email);
       alumno.setTelefono(telf);
       alumno.setFechaDeNacimiento(fechaNac);
       alumno.setFacultadPerteneciente(facultad);

       ControladorRepositorio.repositorioAlumnos.anhadir(alumno);

       javax.swing.JOptionPane.showMessageDialog(null, "Alumno creado correctamente!");
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