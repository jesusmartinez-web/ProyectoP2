package Clases.Model;

public class Libro {
    
    private int id;
    private String titulo;
    private String editorial;
    private String anhoDePublicacion;
    private String autor;
    private boolean disponible = true;

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAnhoDePublicacion() {
        return anhoDePublicacion;
    }

    public void setAnhoDePublicacion(String anhoDePublicacion) {
        this.anhoDePublicacion = anhoDePublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
}
