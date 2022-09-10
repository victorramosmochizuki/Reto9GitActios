package Services;

import DTO.EquipoDTO;
import dao.EquipoImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Equipo;

public class EquipoServiceImpl implements EquipoService {

    EquipoImpl dao = new EquipoImpl();

    @Override
    public void crear(EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo.setIDEQU(equipoDTO.getIDEQU());
        equipo.setMODEQU(equipoDTO.getMODEQU());
        equipo.setESTEQU(equipoDTO.getESTEQU());
        equipo.setIDMAR(equipoDTO.getIDMAR());
        equipo.setIDTIPEQU(equipoDTO.getIDTIPEQU());
        try {
            dao.crear(equipo);
        } catch (Exception ex) {
            Logger.getLogger(EquipoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificar(EquipoDTO equipoDTO) {
        Equipo equipo = new Equipo();
        equipo.setIDEQU(equipoDTO.getIDEQU());
        equipo.setMODEQU(equipoDTO.getMODEQU());
        equipo.setESTEQU(equipoDTO.getESTEQU());
        equipo.setIDMAR(equipoDTO.getIDMAR());
        equipo.setIDTIPEQU(equipoDTO.getIDTIPEQU());
        try {
            dao.modificar(equipo);
        } catch (Exception ex) {
            Logger.getLogger(EquipoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void eliminar(EquipoDTO equipoDTO) {
//        Equipo equipo = new Equipo();
//        equipo.setIDEQU(equipoDTO.getIDEQU());
//        try{
//            dao.eliminar(equipo.getIDEQU());
//        } catch (Exception ex){
//            Logger.getLogger(EquipoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public List<EquipoDTO> listar() throws Exception {

        return dao.listar();

    }

    public void modificarEstado(Integer IDEQU) {
        Equipo equipo = new Equipo();
        equipo.setIDEQU(IDEQU);
        equipo.setESTEQU("INACTIVO");
        try {
            dao.ModificarEst(equipo);
        } catch (Exception ex) {
            Logger.getLogger(EquipoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer IDEQU) {
        Equipo equipo = new Equipo();
        equipo.setIDEQU(IDEQU);
        try {
            dao.eliminar(equipo.getIDEQU());
        } catch (Exception ex) {
            Logger.getLogger(EquipoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
