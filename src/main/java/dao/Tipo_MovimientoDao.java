package dao;

import java.util.List;
import model.Tipo_Movimiento;

public interface Tipo_MovimientoDao {

    void registrar(Tipo_Movimiento gen) throws Exception;

    void modificar(Tipo_Movimiento gen) throws Exception;

    void modificarEst(Tipo_Movimiento gen) throws Exception;

    void eliminar(Integer IDTIPMOV) throws Exception;

    List<Tipo_Movimiento> listar() throws Exception;

}
