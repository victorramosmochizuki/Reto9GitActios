package dao;

import java.util.List;
import model.Area;

public interface AreaDao {

    void registrar(Area gen) throws Exception;

    void modificar(Area gen) throws Exception;

    void modificarEst(Area gen) throws Exception;
    
    void ActivarEst(Area gen) throws Exception;

    void eliminar(Integer IDARE) throws Exception;

    List<Area> listar() throws Exception;

}
