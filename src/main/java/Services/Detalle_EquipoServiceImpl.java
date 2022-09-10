package Services;

import DTO.Detalle_EquipoDTO;
import dao.Detalle_EquipoImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Detalle_Equipo;

public class Detalle_EquipoServiceImpl implements Detalle_EquipoService {

    Detalle_EquipoImpl dao = new Detalle_EquipoImpl();

    @Override
    public void crear(Detalle_EquipoDTO detalle_EquipoDTO) {
        Detalle_Equipo det = new Detalle_Equipo();
        det.setIDDETEQU(detalle_EquipoDTO.getIDDETEQU());
        det.setNROSER(detalle_EquipoDTO.getNROSER());
        det.setDETEQU(detalle_EquipoDTO.getDETEQU());
        det.setCOLEQU(detalle_EquipoDTO.getCOLEQU());
        det.setGARINI(detalle_EquipoDTO.getGARINI());
        det.setGARFIN(detalle_EquipoDTO.getGARFIN());
        det.setPRECIO(detalle_EquipoDTO.getPRECIO());
        det.setESTDET("ACTIVO");
        det.setIDADQ(detalle_EquipoDTO.getIDADQ());
        det.setIDUSU(detalle_EquipoDTO.getIDUSU());
        det.setIDEQU(detalle_EquipoDTO.getIDEQU());
        try {
            dao.crear(det);
        } catch (Exception ex) {
            Logger.getLogger(Detalle_EquipoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(Detalle_EquipoDTO detalle_EquipoDTO) {
        Detalle_Equipo det = new Detalle_Equipo();
        det.setIDDETEQU(detalle_EquipoDTO.getIDDETEQU());
        det.setNROSER(detalle_EquipoDTO.getNROSER());
        det.setDETEQU(detalle_EquipoDTO.getDETEQU());
        det.setCOLEQU(detalle_EquipoDTO.getCOLEQU());
        det.setGARINI(detalle_EquipoDTO.getGARINI());
        det.setGARFIN(detalle_EquipoDTO.getGARFIN());
        det.setPRECIO(detalle_EquipoDTO.getPRECIO());
        det.setESTDET("ACTIVO");
        det.setIDADQ(detalle_EquipoDTO.getIDADQ());
        det.setIDUSU(detalle_EquipoDTO.getIDUSU());
        det.setIDEQU(detalle_EquipoDTO.getIDEQU());
        try {
            dao.modificar(det);
        } catch (Exception ex) {
            Logger.getLogger(Detalle_EquipoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEstado(Integer IDDETEQU) {
        Detalle_Equipo det = new Detalle_Equipo();
        det.setIDDETEQU(IDDETEQU);
        det.setESTDET("INACTIVO");
        try {
            dao.modificarEst(det);
        } catch (Exception ex) {
            Logger.getLogger(Detalle_EquipoServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public List<Detalle_EquipoDTO> listar() throws Exception {
        return dao.listar();
    }

}
