package Controller;

import dao.ProovedorImpl;
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
import model.Proovedor;

@Named(value = "proovedorC")
@SessionScoped
public class ProovedorC implements Serializable {

    private ProovedorImpl daos;
    private Proovedor proovedors;
    private List<Proovedor> provedorses;
    private Proovedor seleccionado;

    @PostConstruct
    public void onInit() {

        try {
            listar();
            listar();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ProovedorC() {
        proovedors = new Proovedor();
        seleccionado = new Proovedor();
        daos = new ProovedorImpl();
    }
    
        //DESCARGAR REPORTE DE VENTA
    public void REPORTE_PDF_VENTA(int CodigoVent) throws Exception {
//        System.out.println("aSDASDSA");
//        System.out.println(CodigoVent);
        ProovedorImpl areaImpl = new ProovedorImpl();
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
            daos.registrar(proovedors);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void eliminar(Integer IDPRO) {
        try {
            System.out.println("No llega");
            daos.eliminar(IDPRO);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminar", "Eliminado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void modificar() {
        try {
            daos.modificar(proovedors);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Proovedor p) {
        try {
            p.setESTPRO("INACTIVO");
            daos.modificarEst(p);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            provedorses = new ArrayList<>();
            provedorses = daos.listar();
        } catch (Exception e) {

        }
    }

    public void limpiar() {
        daos = new ProovedorImpl();
    }

    public ProovedorImpl getDaos() {
        return daos;
    }

    public void setDaos(ProovedorImpl daos) {
        this.daos = daos;
    }

    public Proovedor getProvedors() {
        return proovedors;
    }

    public void setProvedors(Proovedor provedors) {
        this.proovedors = provedors;
    }

    public List<Proovedor> getProvedorses() {
        return provedorses;
    }

    public void setProvedorses(List<Proovedor> provedorses) {
        this.provedorses = provedorses;
    }

    public Proovedor getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Proovedor seleccionado) {
        this.seleccionado = seleccionado;
    }

}
