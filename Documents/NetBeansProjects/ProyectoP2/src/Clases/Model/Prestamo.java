package Clases.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    
    private String alumno;
    private List<String> libros = new ArrayList<>();
    private LocalDate fechaDePrestamo;
    private LocalDate fechaDevolucion;
    private LocalDate fechaDevuelta;
    private int id;
    private boolean vencido=false;

    public boolean isVencido() {
        return vencido;
    }

    public void setVencido(boolean vencido) {
        this.vencido = vencido;
    }
    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public List<String> getLibros() {
        return libros;
    }

    public void setLibros(List<String> libros) {
        this.libros = libros;
    }
    
    public void agregarLibro(String Libro){
        this.libros.add(Libro);
    }

    public LocalDate getFechaDePrestamo() {
        return fechaDePrestamo;
    }

    public void setFechaDePrestamo(String fechaDePrestamo) {
        this.fechaDePrestamo = LocalDate.parse(fechaDePrestamo);
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = LocalDate.parse(fechaDevolucion);
    }

    public LocalDate getFechaDevuelta() {
        return fechaDevuelta;
    }

    public void setFechaDevuelta(String fechaDevuelta) {
        this.fechaDevuelta = LocalDate.parse(fechaDevuelta);
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String verificarVencimiento() {
        if (fechaDevuelta != null) {
        // Si ya se devolvió, miramos si se devolvió tarde
            if (fechaDevuelta.isAfter(fechaDevolucion)) {
                setVencido(true);
                return "Si";
            } else {
                setVencido(false);
                return "No";
            }
        } else {
            // Si NO se ha devolvido aún, comparamos la fecha de devolución con el día de HOY
            if (LocalDate.now().isAfter(fechaDevolucion)) {
                setVencido(true);
                return "Si";
            } else {
                setVencido(false);
                return "No";
            }
        }
    }
}


