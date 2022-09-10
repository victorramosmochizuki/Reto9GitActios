package Services;

import DTO.SoftwareDTO;
import dao.SoftwareImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Software;

public class SoftwareServiceImpl implements SoftwareService {

    SoftwareImpl dao = new SoftwareImpl();

    @Override
    public void crear(SoftwareDTO softwareDTO) {
        Software sof = new Software();
        sof.setIDSOF(softwareDTO.getIDSOF());
        sof.setSOFTWARE(softwareDTO.getSOFTWARE());
        sof.setINIGAR(softwareDTO.getINIGAR());
        sof.setFINGAR(softwareDTO.getFINGAR());
        sof.setESTSOF(softwareDTO.getESTSOF());
        sof.setIDDETEQU(softwareDTO.getIDDETEQU());
        try {
            dao.crear(sof);
        } catch (Exception ex) {
            Logger.getLogger(AdquisicionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(SoftwareDTO softwareDTO) {
        Software sof = new Software();
        sof.setIDSOF(softwareDTO.getIDSOF());
        sof.setSOFTWARE(softwareDTO.getSOFTWARE());
        sof.setINIGAR(softwareDTO.getINIGAR());
        sof.setFINGAR(softwareDTO.getFINGAR());
        sof.setESTSOF(softwareDTO.getESTSOF());
        sof.setIDDETEQU(softwareDTO.getIDDETEQU());
        try {
            dao.modificar(sof);
        } catch (Exception ex) {
            Logger.getLogger(AdquisicionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEstado(Integer IDSOF) {
        Software sof = new Software();
        sof.setIDSOF(IDSOF);
        sof.setESTSOF("INACTIVO");
        try {
            dao.modificarEst(sof);
        } catch (Exception ex) {
            Logger.getLogger(AdquisicionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer IDSOF) {
        Software sof = new Software();
        sof.setIDSOF(IDSOF);
        try {
            dao.eliminar(sof.getIDSOF());
        } catch (Exception ex) {
            Logger.getLogger(AdquisicionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<SoftwareDTO> listar() throws Exception {
        return dao.listar();
    }
}
