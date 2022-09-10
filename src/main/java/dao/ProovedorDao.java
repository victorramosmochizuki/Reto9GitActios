package dao;

import java.util.List;
import model.Proovedor;

public interface ProovedorDao {

    void registrar(Proovedor gen) throws Exception;

    void modificar(Proovedor gen) throws Exception;

    void modificarEst(Proovedor gen) throws Exception;

    void eliminar(Integer IDPRO) throws Exception;

    List<Proovedor> listar() throws Exception;
}
