package Clases.Model;

public class Alumno {
    private String nombreCompleto;
    private String nroDeDocumento;
    private String email;
    private String telefono;
    private String fechaDeNacimiento;
    private String facultadPerteneciente;


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNroDeDocumento() {
        return nroDeDocumento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setNroDeDocumento(String nroDeDocumento) {
        this.nroDeDocumento = nroDeDocumento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setFacultadPerteneciente(String facultadPerteneciente) {
        this.facultadPerteneciente = facultadPerteneciente;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getFacultadPerteneciente() {
        return facultadPerteneciente;
    }


}
