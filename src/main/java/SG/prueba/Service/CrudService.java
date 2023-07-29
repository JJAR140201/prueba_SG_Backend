package SG.prueba.Service;

import java.util.List;

public interface CrudService<T> {

    public List<T> listarTodos();

    public T listarPorId(Long id);

    public void registrar(T entidad);

    public void actualizar(T entidad);

    public void eliminar(Long id);
}
