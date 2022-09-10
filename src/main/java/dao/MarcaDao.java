package dao;

import java.util.List;
import model.Marca;

public interface MarcaDao {

    void registrar(Marca gen) throws Exception;

    void modificar(Marca gen) throws Exception;

    void modificarEst(Marca gen) throws Exception;

    void eliminar(Integer IDMAR) throws Exception;

    List<Marca> listar() throws Exception;
}
