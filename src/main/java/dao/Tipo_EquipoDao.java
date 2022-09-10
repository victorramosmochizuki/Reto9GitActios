package dao;

import java.util.List;
import model.Tipo_Equipo;

public interface Tipo_EquipoDao {

    void registrar(Tipo_Equipo gen) throws Exception;

    void modificar(Tipo_Equipo gen) throws Exception;

    void modificarEst(Tipo_Equipo gen) throws Exception;

    void eliminar(Integer IDARE) throws Exception;

    List<Tipo_Equipo> listar() throws Exception;
}
