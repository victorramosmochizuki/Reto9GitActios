package Controller;

import dao.AreaImpl;
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
import model.Area;

@Named(value = "areaC")
@SessionScoped
public class AreaC implements Serializable {

    private AreaImpl daos;
    private Area areas;
    private List<Area> areases;
    private List<Area> listare;
    private Area seleccionado;

    @PostConstruct
    public void onInit() {

        try {
            listar();
            listar();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AreaC() {
        areas = new Area();
        seleccionado = new Area();
        daos = new AreaImpl();
    }

    public void registrar() {
        try {
            daos.registrar(areas);
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
            daos.modificar(areas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Area a) {
        try {
            a.setESTARE("INACTIVO");
            daos.modificarEst(a);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivar", "Inactivado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }
    
    
    public void eliminar(Integer IDARE) {
        try {
            System.out.println("No llega");
            daos.eliminar(IDARE);
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
            areases = new ArrayList<>();
            areases = daos.listar();
        } catch (Exception e) {
        }
    }


    //DESCARGAR REPORTE DE VENTA
    public void REPORTE_PDF_VENTA(int CodigoVent) throws Exception {
//        System.out.println("aSDASDSA");
//        System.out.println(CodigoVent);
        AreaImpl areaImpl = new AreaImpl();
        try {
            Map<String, Object> parameters = new HashMap();
//            HashMap parameters = new HashMap(); // Libro de parametros  
            parameters.put(null, CodigoVent); //Insertamos un parametro
            areaImpl.REPORTE_PDF_BOLETA(parameters); //Pido exportar Reporte con los parametros
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        daos = new AreaImpl();
    }

    public List<Area> getListare() {
        return listare;
    }

    public void setListare(List<Area> listare) {
        this.listare = listare;
    }

    public AreaImpl getDaos() {
        return daos;
    }

    public void setDaos(AreaImpl daos) {
        this.daos = daos;
    }

    public Area getAreas() {
        return areas;
    }

    public void setAreas(Area areas) {
        this.areas = areas;
    }

    public List<Area> getAreases() {
        return areases;
    }

    public void setAreases(List<Area> areases) {
        this.areases = areases;
    }

    public Area getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Area seleccionado) {
        this.seleccionado = seleccionado;
    }

}
