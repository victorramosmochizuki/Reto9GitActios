package Controller;

import DTO.SoftwareDTO;
import Services.SoftwareServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "softwareC")
@SessionScoped
public class SoftwareC implements Serializable {

    SoftwareServiceImpl softwareServiceImpl = new SoftwareServiceImpl();
    private List<SoftwareDTO> listSoftwareDTO = new ArrayList<>();
    private SoftwareDTO softwareDTO = new SoftwareDTO();
    private SoftwareDTO seleccionado = new SoftwareDTO();

    @PostConstruct
    public void onInit() {

        try {
            listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrar() {
        try {
            softwareServiceImpl.crear(softwareDTO);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            softwareServiceImpl.modificar(seleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Integer IDSOF) {
        try {
            softwareServiceImpl.modificarEstado(IDSOF);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }
    
        public void eliminar(Integer IDSOF) {
        try {
            System.out.println("No llega");
            softwareServiceImpl.eliminar(IDSOF);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminacion", "Eliminado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            listSoftwareDTO = new ArrayList<>();
            listSoftwareDTO = softwareServiceImpl.listar();
        } catch (Exception e) {

        }
    }

    public SoftwareC() {
    }

    public List<SoftwareDTO> getListSoftwareDTO() {
        return listSoftwareDTO;
    }

    public void setListSoftwareDTO(List<SoftwareDTO> listSoftwareDTO) {
        this.listSoftwareDTO = listSoftwareDTO;
    }

    public SoftwareDTO getSoftwareDTO() {
        return softwareDTO;
    }

    public void setSoftwareDTO(SoftwareDTO softwareDTO) {
        this.softwareDTO = softwareDTO;
    }

    public SoftwareDTO getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(SoftwareDTO seleccionado) {
        this.seleccionado = seleccionado;
    }

}
