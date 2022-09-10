package Controller;

import DTO.AdquisicionDTO;
import Services.AdquisicionServiceImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "adquisicionC")
@SessionScoped
public class AdquisicionC implements Serializable {

    AdquisicionServiceImpl adquisicionServiceImpl = new AdquisicionServiceImpl();
    private List<AdquisicionDTO> listAdquisicionDTO = new ArrayList<>();
    private AdquisicionDTO adquisicionDTO = new AdquisicionDTO();
    private AdquisicionDTO seleccionado = new AdquisicionDTO();

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
            adquisicionServiceImpl.crear(adquisicionDTO);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            adquisicionServiceImpl.modificar(seleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Integer IDADQ) {
        try {
            adquisicionServiceImpl.modificarEstado(IDADQ);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }
    
    public void eliminar(Integer IDADQ) {
        try {
            System.out.println("No llega");
            adquisicionServiceImpl.eliminar(IDADQ);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminacion", "Eliminado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            listAdquisicionDTO = new ArrayList<>();
            listAdquisicionDTO = adquisicionServiceImpl.listar();
        } catch (Exception e) {

        }
    }

    public AdquisicionC() {
    }

    public List<AdquisicionDTO> getListAdquisicionDTO() {
        return listAdquisicionDTO;
    }

    public void setListAdquisicionDTO(List<AdquisicionDTO> listAdquisicionDTO) {
        this.listAdquisicionDTO = listAdquisicionDTO;
    }

    public AdquisicionDTO getAdquisicionDTO() {
        return adquisicionDTO;
    }

    public void setAdquisicionDTO(AdquisicionDTO adquisicionDTO) {
        this.adquisicionDTO = adquisicionDTO;
    }

    public AdquisicionDTO getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(AdquisicionDTO seleccionado) {
        this.seleccionado = seleccionado;
    }

}
