
package Repositorios;


public interface RepositorioBase<M> {
    
    void anhadir(M aAnhadir);
    
    void listar();
    
    void borrar(M aBorrar);  
    
}
