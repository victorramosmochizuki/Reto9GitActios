package Controller;

import DTO.ComponenteDTO;
import Services.ComponenteServiceImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "componenteC")
@SessionScoped
public class ComponenteC implements Serializable {

    ComponenteServiceImpl componenteServiceImpl = new ComponenteServiceImpl();
    private List<ComponenteDTO> listComponenteDTO = new ArrayList<>();
    private ComponenteDTO componenteDTO = new ComponenteDTO();
    private ComponenteDTO seleccionado = new ComponenteDTO();

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
            componenteServiceImpl.crear(componenteDTO);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            componenteServiceImpl.modificar(seleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Integer IDEQU) {
        try {
            System.out.println("No llega");
            componenteServiceImpl.eliminar(IDEQU);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminacion", "Eliminado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

    public void modificarEstado(Integer IDCOM) {
        try {
            componenteServiceImpl.modificarEstado(IDCOM);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            listComponenteDTO = new ArrayList<>();
            listComponenteDTO = componenteServiceImpl.listar();
        } catch (Exception e) {

        }
    }

    public ComponenteC() {

    }

    public List<ComponenteDTO> getListEquipoDTO() {
        return listComponenteDTO;
    }

    public void setListEquipoDTO(List<ComponenteDTO> listEquipoDTO) {
        this.listComponenteDTO = listEquipoDTO;
    }

    public ComponenteDTO getComponenteDTO() {
        return componenteDTO;
    }

    public void setComponenteDTO(ComponenteDTO componenteDTO) {
        this.componenteDTO = componenteDTO;
    }

    public ComponenteDTO getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(ComponenteDTO seleccionado) {
        this.seleccionado = seleccionado;
    }

}
