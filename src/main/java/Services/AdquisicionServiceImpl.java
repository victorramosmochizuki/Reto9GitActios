package Services;

import DTO.AdquisicionDTO;
import dao.AdquisicionImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Adquisicion;

public class AdquisicionServiceImpl implements AdquisicionService {

    AdquisicionImpl dao = new AdquisicionImpl();

    @Override
    public void crear(AdquisicionDTO adquisicionDTO) {
        Adquisicion adq = new Adquisicion();
        adq.setIDADQ(adquisicionDTO.getIDADQ());
        adq.setCANTIDAD(adquisicionDTO.getCANTIDAD());
        adq.setFECCOM(adquisicionDTO.getFECCOM());
        adq.setFECADQ(adquisicionDTO.getFECADQ());
        adq.setESTADQ(adquisicionDTO.getESTADQ());
        adq.setCODADQ(adquisicionDTO.getCODADQ());
        adq.setIDPRO(adquisicionDTO.getIDPRO());
        try {
            dao.crear(adq);
        } catch (Exception ex) {
            Logger.getLogger(AdquisicionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(AdquisicionDTO adquisicionDTO) {
        Adquisicion adq = new Adquisicion();
        adq.setIDADQ(adquisicionDTO.getIDADQ());
        adq.setCANTIDAD(adquisicionDTO.getCANTIDAD());
        adq.setFECCOM(adquisicionDTO.getFECCOM());
        adq.setFECADQ(adquisicionDTO.getFECADQ());
        adq.setESTADQ(adquisicionDTO.getESTADQ());
        adq.setCODADQ(adquisicionDTO.getCODADQ());
        adq.setIDPRO(adquisicionDTO.getIDPRO());
        try {
            dao.modificar(adq);
        } catch (Exception ex) {
            Logger.getLogger(AdquisicionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarEstado(Integer IDADQ) {
        Adquisicion adq = new Adquisicion();
        adq.setIDADQ(IDADQ);
        adq.setESTADQ("INACTIVO");
        try{
            dao.modificarEst(adq);
        }  catch (Exception ex) {
            Logger.getLogger(AdquisicionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<AdquisicionDTO> listar() throws Exception {
        return dao.listar();
    }

    public void eliminar(Integer IDADQ) {
        Adquisicion adq = new Adquisicion();
        adq.setIDADQ(IDADQ);
        try {
            dao.eliminar(adq.getIDADQ());
        } catch (Exception ex) {
            Logger.getLogger(AdquisicionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
