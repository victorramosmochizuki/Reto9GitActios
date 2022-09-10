package Controller;

import dao.Tipo_MovimientoImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Tipo_Movimiento;

@Named(value = "tipo_Movimiento")
@SessionScoped
public class Tipo_MovimientoC implements Serializable {

    private Tipo_MovimientoImpl dao;
    private Tipo_Movimiento tmovimiento;
    private List<Tipo_Movimiento> tmovimientos;
    private Tipo_Movimiento seleccionado;

    @PostConstruct
    public void onInit() {

        try {
            listar();
            listar();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Tipo_MovimientoC() {
        tmovimiento = new Tipo_Movimiento();
        seleccionado = new Tipo_Movimiento();
        dao = new Tipo_MovimientoImpl();
    }

    public void registrar() {
        try {
            dao.registrar(tmovimiento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            dao.modificar(tmovimiento);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Tipo_Movimiento tim) {
        try {
            tim.setESTTIP("INACTIVO");
            dao.modificarEst(tim);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Integer IDTIPMOV) {
        try {
            System.out.println("No llega");
            dao.eliminar(IDTIPMOV);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminacion", "Eliminado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void listar() {
        try {
            tmovimientos = new ArrayList<>();
            tmovimientos = dao.listar();
        } catch (Exception e) {

        }
    }

    public void limpiar() {
        dao = new Tipo_MovimientoImpl();
    }

    public Tipo_MovimientoImpl getDao() {
        return dao;
    }

    public void setDao(Tipo_MovimientoImpl dao) {
        this.dao = dao;
    }

    public Tipo_Movimiento getTmovimiento() {
        return tmovimiento;
    }

    public void setTmovimiento(Tipo_Movimiento tmovimiento) {
        this.tmovimiento = tmovimiento;
    }

    public List<Tipo_Movimiento> getTmovimientos() {
        return tmovimientos;
    }

    public void setTmovimientos(List<Tipo_Movimiento> tmovimientos) {
        this.tmovimientos = tmovimientos;
    }

    public Tipo_Movimiento getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Tipo_Movimiento seleccionado) {
        this.seleccionado = seleccionado;
    }

}
