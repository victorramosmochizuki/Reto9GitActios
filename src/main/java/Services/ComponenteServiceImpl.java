package Services;

import DTO.ComponenteDTO;
import dao.ComponenteImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Componente;

public class ComponenteServiceImpl implements ComponenteService {

    ComponenteImpl dao = new ComponenteImpl();

    @Override
    public void crear(ComponenteDTO componenteDTO) {
        Componente com = new Componente();
        com.setIDCOM(componenteDTO.getIDCOM());
        com.setCLAVE(componenteDTO.getCLAVE());
        com.setVALOR(componenteDTO.getVALOR());
        com.setESTCOM(componenteDTO.getESTCOM());
        com.setIDDETEQU(componenteDTO.getIDDETEQU());
        try {
            dao.crear(com);
        } catch (Exception ex) {
            Logger.getLogger(ComponenteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar(ComponenteDTO componenteDTO) {
        Componente com = new Componente();
        com.setIDCOM(componenteDTO.getIDCOM());
        com.setCLAVE(componenteDTO.getCLAVE());
        com.setVALOR(componenteDTO.getVALOR());
        com.setESTCOM(componenteDTO.getESTCOM());
        com.setIDDETEQU(componenteDTO.getIDDETEQU());
        try {
            dao.modificar(com);
        } catch (Exception ex) {
            Logger.getLogger(ComponenteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEstado(Integer IDCOM) {
        Componente com = new Componente();
        com.setIDCOM(IDCOM);
        com.setESTCOM("INACTIVO");
        try {
            dao.modificarEst(com);
        } catch (Exception ex) {
            Logger.getLogger(AdquisicionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Integer IDCOM) {
        Componente com = new Componente();
        com.setIDCOM(IDCOM);
        try {
            dao.eliminar(IDCOM);
        } catch (Exception ex) {
            Logger.getLogger(ComponenteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ComponenteDTO> listar() throws Exception {

        return dao.listar();

    }

}
