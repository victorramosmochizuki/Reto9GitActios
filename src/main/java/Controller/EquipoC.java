package Controller;

import DTO.EquipoDTO;
import Services.EquipoServiceImpl;
import dao.EquipoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Equipo;

@Named(value = "equipoC")
@SessionScoped
public class EquipoC implements Serializable {

    EquipoServiceImpl equipoServiceImpl = new EquipoServiceImpl();
    private List<EquipoDTO> listEquipoDTO = new ArrayList<>();
    private EquipoDTO equipoDTO = new EquipoDTO();
    private EquipoDTO seleccionado = new EquipoDTO();

    @PostConstruct
    public void onInit() {

        try {
            listar();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public EquipoC() {
    }

    public void registrar() {
        try {
            equipoServiceImpl.crear(equipoDTO);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            equipoServiceImpl.modificar(seleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

//    public void modificarEstado(Equipo e) {
//        try {
//            e.setESTEQU("INACTIVO");
//            equipoServiceImpl.modificarEstado(seleccionado);
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminacion", "Eliminado con exito"));
//            listar();
//        } catch (Exception e) {
//            System.out.println("Error en modificarC " +e.getMessage());
//        } 
//        
//    }
    public void modificarEstado(Integer IDEQU) {
        try {
            equipoServiceImpl.modificarEstado(IDEQU);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Integer IDEQU) {
        try {
            System.out.println("No llega");
            equipoServiceImpl.eliminar(IDEQU);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminacion", "Eliminado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            listEquipoDTO = new ArrayList<>();
            listEquipoDTO = equipoServiceImpl.listar();
        } catch (Exception e) {

        }
    }
    
    //DESCARGAR REPORTE DE VENTA
    public void REPORTE_PDF_VENTA(int CodigoVent) throws Exception {
//        System.out.println("aSDASDSA");
//        System.out.println(CodigoVent);
        EquipoImpl equipoImpl = new EquipoImpl();
        try {
            Map<String, Object> parameters = new HashMap();
//            HashMap parameters = new HashMap(); // Libro de parametros  
            parameters.put(null, CodigoVent); //Insertamos un parametro
            equipoImpl.REPORTE_EQUIPO(parameters); //Pido exportar Reporte con los parametros
        } catch (Exception e) {
            throw e;
        }
    }

    public List<EquipoDTO> getListEquipoDTO() {
        return listEquipoDTO;
    }

    public void setListEquipoDTO(List<EquipoDTO> listEquipoDTO) {
        this.listEquipoDTO = listEquipoDTO;
    }

    public EquipoDTO getEquipoDTO() {
        return equipoDTO;
    }

    public void setEquipoDTO(EquipoDTO equipoDTO) {
        this.equipoDTO = equipoDTO;
    }

    public EquipoDTO getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(EquipoDTO seleccionado) {
        this.seleccionado = seleccionado;
    }
}
