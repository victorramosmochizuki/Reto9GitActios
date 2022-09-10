package Controller;

import dao.Tipo_EquipoImpl;
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
import model.Tipo_Equipo;

@Named(value = "tipo_EquipoC")
@SessionScoped
public class Tipo_EquipoC implements Serializable {

    private Tipo_EquipoImpl dao;
    private Tipo_Equipo tequipo;
    private List<Tipo_Equipo> tequipos;
    private Tipo_Equipo seleccionado;

    @PostConstruct
    public void onInit() {

        try {
            listar();
            listar();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Tipo_EquipoC() {
        tequipo = new Tipo_Equipo();
        seleccionado = new Tipo_Equipo();
        dao = new Tipo_EquipoImpl();
    }
    
        //DESCARGAR REPORTE DE VENTA
    public void REPORTE_PDF_VENTA(int CodigoVent) throws Exception {
//        System.out.println("aSDASDSA");
//        System.out.println(CodigoVent);
        Tipo_EquipoImpl areaImpl = new Tipo_EquipoImpl();
        try {
            Map<String, Object> parameters = new HashMap();
//            HashMap parameters = new HashMap(); // Libro de parametros  
            parameters.put(null, CodigoVent); //Insertamos un parametro
            areaImpl.REPORTE_PDF_BOLETA(parameters); //Pido exportar Reporte con los parametros
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrar() {
        try {
            dao.registrar(tequipo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void eliminar(Integer IDTIPEQU) {
        try {
            System.out.println("No llega");
            dao.eliminar(IDTIPEQU);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminacion", "Eliminado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void modificar() {
        try {
            dao.modificar(tequipo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Tipo_Equipo tip) {
        try {
            tip.setESTEQU("INACTIVO");
            dao.modificarEst(tip);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            tequipos = new ArrayList<>();
            tequipos = dao.listar();
        } catch (Exception e) {

        }
    }

    public void limpiar() {
        dao = new Tipo_EquipoImpl();
    }

    public Tipo_EquipoImpl getDao() {
        return dao;
    }

    public void setDao(Tipo_EquipoImpl dao) {
        this.dao = dao;
    }

    public Tipo_Equipo getTequipo() {
        return tequipo;
    }

    public void setTequipo(Tipo_Equipo tequipo) {
        this.tequipo = tequipo;
    }

    public List<Tipo_Equipo> getTequipos() {
        return tequipos;
    }

    public void setTequipos(List<Tipo_Equipo> tequipos) {
        this.tequipos = tequipos;
    }

    public Tipo_Equipo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Tipo_Equipo seleccionado) {
        this.seleccionado = seleccionado;
    }

}
