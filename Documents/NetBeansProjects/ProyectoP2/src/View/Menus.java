
package View;

public class Menus {
    
    public static void mostrarMenuPrincipal(){
        System.out.println("Opciones:");
        System.out.println("1- Gestion de Libros");
        System.out.println("2- Gestion de Alumnos");
        System.out.println("3- Gestion de Prestamos ");
        System.out.println("4- Salir");
        System.out.println("Ingrese su opcion: ");
    }
    public static void mostrarSubMenu(String menuSeleccionado){
        System.out.println("---Haz Seleecionado "+ menuSeleccionado+"---");
        System.out.println("1- Crear un " + menuSeleccionado);
        System.out.println("2- Gestion de "+ menuSeleccionado);
        System.out.println("3- Borrar un " +menuSeleccionado);
        System.out.println("4- Listar "+menuSeleccionado+"s");
        if("Prestamo".equals(menuSeleccionado)){
            System.out.println("5- Devolver prestamo");
            System.out.println("6- Salir");
        }else{
        System.out.println("5- Salir");
        }
        System.out.println("Ingrese su opcion: ");
        
       
    }
    
    //Apartado alumno
    
    public static void pedirNombre(String menuSeleccionado){
        System.out.println("Ingrese el nombre del "+menuSeleccionado+": ");
    }
    public static void pedirDocumento(String menuSeleccionado) {
        System.out.println("Ingrese el Nro. de Documento del " + menuSeleccionado + ": ");
    }

    public static void pedirEmail(String menuSeleccionado) {
        System.out.println("Ingrese el email del " + menuSeleccionado + ": ");
    }

    public static void pedirTelefono(String menuSeleccionado) {
        System.out.println("Ingrese el telefono del " + menuSeleccionado + ": ");
    }

    public static void pedirFechaNacimiento(String menuSeleccionado) {
        System.out.println("Ingrese la fecha de nacimiento del " + menuSeleccionado + " (AAAA-MM-DD): ");
    }

    public static void pedirFacultad(String menuSeleccionado) {
        System.out.println("Ingrese la facultad a la que pertenece el " + menuSeleccionado + ": ");
    }
    
    //Apartado Libro
    
    public static void pedirTitulo(String menuSeleccionado) {
        System.out.println("Ingrese el titulo del " + menuSeleccionado + ": ");
    }

    public static void pedirEditorial(String menuSeleccionado) {
        System.out.println("Ingrese la editorial del " + menuSeleccionado + ": ");
    }

    public static void pedirAnho(String menuSeleccionado) {
        System.out.println("Ingrese el anho de publicacion del " + menuSeleccionado + ": ");
    }

    public static void pedirAutor(String menuSeleccionado) {
        System.out.println("Ingrese el autor del " + menuSeleccionado + ": ");
    }
    
    //Apartado Prestamos
    
    public static void pedirAlumnoPrestamo(String menuSeleccionado) {
        System.out.println("Ingrese el documento del alumno para el " + menuSeleccionado + ": ");
    }

    public static void pedirLibrosPrestamo(String menuSeleccionado) {
        System.out.println("Ingrese los titulos de los libros para el " + menuSeleccionado);
    }

    public static void pedirFechaPrestamo(String menuSeleccionado) {
        System.out.println("Ingrese la fecha de prestamo del " + menuSeleccionado + " (AAAA-MM-DD): ");
        System.out.println("Obs: debe estar en el formato mencionado, usted debe incluir los guiones!");
    }

    public static void pedirFechaDevolucion(String menuSeleccionado) {
        System.out.println("Ingrese la fecha de devolucion pactada del " + menuSeleccionado + " (AAAA-MM-DD): ");
    }

    public static void pedirFechaDevuelta(String menuSeleccionado) {
        System.out.println("Ingrese la fecha real en la que se devolvio el " + menuSeleccionado + " (AAAA-MM-DD): ");
    }
    public static void seleccionarModificarOBorrar(String menuSeleccionado){
        System.out.println("1- Modificar Datos de un "+ menuSeleccionado);
        System.out.println("2- ---Eliminar todos---");
    }
    
    public static void pedirId(){
        System.out.println("Dame el id del libro: ");
        System.out.println("Obs: si no sabe el id, liste los prestamos y vea cual es");
    }
    
    public static void borrado(){
        System.out.println("Borrado !");
    }
    
    public static void opcionInvalida(){
        System.out.println("Opcion invalida!");
    }
    
}



