package Controller;

import View.VentanaPrincipal;
import Clases.Model.*;
import Repositorios.*;

public class ControladorView {

    public static void controlMenuPrincipal() {
        java.awt.EventQueue.invokeLater(() -> {
            VentanaPrincipal v = new VentanaPrincipal();
            v.setVisible(true);
        });
    }

    // Alumnos
    public static boolean agregarAlumno(String nombreCompleto, String nroDoc, String email, String telf, String fechaNac, String facultad) {
        if (RepositorioAlumno.alumnos.containsKey(nroDoc)) {
            javax.swing.JOptionPane.showMessageDialog(null,
                "Ya existe un alumno con el documento: " + nroDoc +
                "\nCambiá el número de documento para continuar.",
                "Documento duplicado",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }

        Alumno alumno = new Alumno();
        alumno.setNombreCompleto(nombreCompleto);
        alumno.setNroDeDocumento(nroDoc);
        alumno.setEmail(email);
        alumno.setTelefono(telf);
        alumno.setFechaDeNacimiento(fechaNac);
        alumno.setFacultadPerteneciente(facultad);

        ControladorRepositorio.repositorioAlumnos.anhadir(alumno);
        javax.swing.JOptionPane.showMessageDialog(null, "Alumno creado correctamente!");
        return true;
    }

    public static java.util.Collection<Alumno> obtenerAlumnos() {
        return RepositorioAlumno.alumnos.values();
    }

    public static Clases.Model.Alumno buscarAlumno(String nroDoc) {
        Clases.Model.Alumno alumno = RepositorioAlumno.alumnos.get(nroDoc);
        if (alumno == null) {
            javax.swing.JOptionPane.showMessageDialog(null,
                "No se encontró alumno con el documento: " + nroDoc,
                "Alumno no encontrado",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        }
        return alumno;
    }

    public static boolean editarAlumno(String docOriginal, String nroDocNuevo, String nombre, String email,
                                       String telf, String fechaNac, String facultad) {
        Clases.Model.Alumno alumno = RepositorioAlumno.alumnos.get(docOriginal);
        if (alumno == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "No se encontró el alumno original.");
            return false;
        }

        if (!docOriginal.equals(nroDocNuevo)) {
            if (RepositorioAlumno.alumnos.containsKey(nroDocNuevo)) {
                javax.swing.JOptionPane.showMessageDialog(null,
                    "El número de documento '" + nroDocNuevo + "' ya está asignado a otro alumno.",
                    "Documento Duplicado",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        alumno.setNombreCompleto(nombre);
        alumno.setNroDeDocumento(nroDocNuevo);
        alumno.setEmail(email);
        alumno.setTelefono(telf);
        alumno.setFechaDeNacimiento(fechaNac);
        alumno.setFacultadPerteneciente(facultad);

        if (!docOriginal.equals(nroDocNuevo)) {
            RepositorioAlumno.alumnos.remove(docOriginal);
            RepositorioAlumno.alumnos.put(nroDocNuevo, alumno);
        }

        javax.swing.JOptionPane.showMessageDialog(null, "Alumno actualizado correctamente!");
        return true;
    }

    // Libros
    public static void agregarLibro(String titulo, String editorial, String autor, String anho) {
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setEditorial(editorial);
        libro.setAutor(autor);
        libro.setAnhoDePublicacion(anho);
        ControladorRepositorio.repositorioLibros.anhadir(libro);
        javax.swing.JOptionPane.showMessageDialog(null, "Libro creado correctamente!");
    }

    public static java.util.Collection<Libro> obtenerLibros() {
        return RepositorioLibros.libros.values();
    }

    public static Clases.Model.Libro buscarLibro(String idStr) {
        try {
            int id = Integer.parseInt(idStr.trim());
            for (Clases.Model.Libro l : RepositorioLibros.libros.values()) {
                if (l.getId() == id) return l;
            }
            javax.swing.JOptionPane.showMessageDialog(null,
                "No se encontró libro con el ID: " + id,
                "Libro no encontrado", javax.swing.JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                "El ID debe ser un número.", "ID inválido",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    public static boolean editarLibro(int id, String titulo, String editorial,
                                       String autor, String anho) {
        for (Clases.Model.Libro l : RepositorioLibros.libros.values()) {
            if (l.getId() == id) {
                l.setTitulo(titulo);
                l.setEditorial(editorial);
                l.setAutor(autor);
                l.setAnhoDePublicacion(anho);
                javax.swing.JOptionPane.showMessageDialog(null, "Libro actualizado correctamente!");
                return true;
            }
        }
        javax.swing.JOptionPane.showMessageDialog(null, "No se encontró el libro.");
        return false;
    }

    public static java.util.Collection<Clases.Model.Libro> obtenerLibrosDisponibles() {
        java.util.List<Clases.Model.Libro> disponibles = new java.util.ArrayList<>();
        for (Clases.Model.Libro libro : RepositorioLibros.libros.values()) {
            if (libro.isDisponible()) {
                disponibles.add(libro);
            }
        }
        return disponibles;
    }

    public static void marcarLibrosNoDisponibles(java.util.List<String> titulosLibros) {
        for (Clases.Model.Libro libro : RepositorioLibros.libros.values()) {
            if (titulosLibros.contains(libro.getTitulo())) {
                libro.setDisponible(false);
            }
        }
    }

    public static void liberarLibros(java.util.List<String> titulosLibros) {
        for (Clases.Model.Libro libro : RepositorioLibros.libros.values()) {
            if (titulosLibros.contains(libro.getTitulo())) {
                libro.setDisponible(true);
            }
        }
    }

    // Prestamos
    public static void agregarPrestamo(String alumno, String librosTexto, String fechaPrestamo, String fechaDevolucion) {
        Prestamo prestamo = new Prestamo();
        prestamo.setAlumno(alumno);
        java.util.List<String> listaLibros = new java.util.ArrayList<>();
        for (String libro : librosTexto.split(",")) {
            String titulo = libro.trim();
            prestamo.agregarLibro(titulo);
            listaLibros.add(titulo);
        }
        prestamo.setFechaDePrestamo(fechaPrestamo);
        prestamo.setFechaDevolucion(fechaDevolucion);
        ControladorRepositorio.repositorioPrestamos.anhadir(prestamo);
        ControladorView.marcarLibrosNoDisponibles(listaLibros);
        javax.swing.JOptionPane.showMessageDialog(null, "Préstamo creado correctamente!");
    }

    public static java.util.Collection<Prestamo> obtenerPrestamos() {
        return RepositorioPrestamos.prestamos.values();
    }

    public static boolean devolverPrestamo(int idPrestamo, String fechaDevuelta) {
        Clases.Model.Prestamo prestamo = RepositorioPrestamos.prestamos.get(idPrestamo);
        if (prestamo == null) {
            javax.swing.JOptionPane.showMessageDialog(null,
                "No existe un préstamo con ID: " + idPrestamo,
                "No encontrado", javax.swing.JOptionPane.WARNING_MESSAGE);
            return false;
        }
        prestamo.setFechaDevuelta(fechaDevuelta);
        prestamo.verificarVencimiento();
        liberarLibros(prestamo.getLibros());
        javax.swing.JOptionPane.showMessageDialog(null, "Devolución registrada correctamente!");
        return true;
    }
}