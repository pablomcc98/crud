
package Interfaces;

import java.util.List;

public interface CrudService <T> {
    
    public boolean add(T entity);
    public List listar();
    public T list(int id);
    public boolean edit(T entity);
    public boolean eliminar (int id);

}
