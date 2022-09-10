package Controller;

import DTO.Detalle_EquipoDTO;
import Services.Detalle_EquipoServiceImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Detalle_Equipo;

@Named(value = "detalle_EquipoC")
@SessionScoped
public class Detalle_EquipoC implements Serializable {

    Detalle_EquipoServiceImpl detalle_EquipoServiceImpl = new Detalle_EquipoServiceImpl();
    private List<Detalle_EquipoDTO> listdetalle_EquipoDTO = new ArrayList<>();
    private Detalle_EquipoDTO detalle_EquipoDTO = new Detalle_EquipoDTO();
    private Detalle_EquipoDTO seleccionado = new Detalle_EquipoDTO();

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
            detalle_EquipoServiceImpl.crear(detalle_EquipoDTO);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            detalle_EquipoServiceImpl.modificar(seleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Integer IDDETEQU) {
        try {
            detalle_EquipoServiceImpl.modificarEstado(IDDETEQU);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            listdetalle_EquipoDTO = new ArrayList<>();
            listdetalle_EquipoDTO = detalle_EquipoServiceImpl.listar();
        } catch (Exception e) {

        }
    }

    public Detalle_EquipoC() {
    }

    public List<Detalle_EquipoDTO> getListdetalle_EquipoDTO() {
        return listdetalle_EquipoDTO;
    }

    public void setListdetalle_EquipoDTO(List<Detalle_EquipoDTO> listdetalle_EquipoDTO) {
        this.listdetalle_EquipoDTO = listdetalle_EquipoDTO;
    }

    public Detalle_EquipoDTO getDetalle_EquipoDTO() {
        return detalle_EquipoDTO;
    }

    public void setDetalle_EquipoDTO(Detalle_EquipoDTO detalle_EquipoDTO) {
        this.detalle_EquipoDTO = detalle_EquipoDTO;
    }

    public Detalle_EquipoDTO getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Detalle_EquipoDTO seleccionado) {
        this.seleccionado = seleccionado;
    }

}
