package Controller;

import DTO.UsuarioDTO;
import Services.UsuarioServiceImpl;
import dao.UsuarioImpl;
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

@Named(value = "usuarioC")
@SessionScoped
public class UsuarioC implements Serializable {

    UsuarioServiceImpl usuarioServiceImpl = new UsuarioServiceImpl();
    private List<UsuarioDTO> listUsuarioDTO = new ArrayList<>();
    private UsuarioDTO usuarioDTO = new UsuarioDTO();
    private UsuarioDTO seleccionado = new UsuarioDTO();

    public UsuarioC() {
    }

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
            usuarioServiceImpl.crear(usuarioDTO);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    //DESCARGAR REPORTE DE VENTA
    public void REPORTE_PDF_USUARIO(String CodigoUsuario) throws Exception {
        System.out.println("aSDASDSA");
        System.out.println(CodigoUsuario);
        UsuarioImpl usuarioImpl = new UsuarioImpl();
        try {
            Map<String, Object> parameters = new HashMap();
//            HashMap parameters = new HashMap(); // Libro de parametros    
            parameters.put(null, CodigoUsuario); //Insertamos un parametro
            usuarioImpl.REPORTE_PDF_USUARIO(parameters); //Pido exportar Reporte con los parametros
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() {
        try {
            usuarioServiceImpl.modificar(seleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Integer IDUSU) {
        try {
            usuarioServiceImpl.modificarEstado(IDUSU);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Integer IDUSU) {
        try {
            System.out.println("No llega");
            usuarioServiceImpl.eliminar(IDUSU);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminacion", "Eliminado con exito"));
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            listUsuarioDTO = new ArrayList<>();
            listUsuarioDTO = usuarioServiceImpl.listar();
        } catch (Exception e) {

        }
    }

    public List<UsuarioDTO> getListUsuarioDTO() {
        return listUsuarioDTO;
    }

    public void setListUsuarioDTO(List<UsuarioDTO> listUsuarioDTO) {
        this.listUsuarioDTO = listUsuarioDTO;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }

    public UsuarioDTO getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(UsuarioDTO seleccionado) {
        this.seleccionado = seleccionado;
    }

}
