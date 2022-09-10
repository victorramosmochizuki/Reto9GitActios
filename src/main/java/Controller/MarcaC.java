package Controller;

import dao.MarcaImpl;
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
import model.Marca;

@Named(value = "marcaC")
@SessionScoped
public class MarcaC implements Serializable {

    private MarcaImpl daos;
    private Marca marcas;
    private List<Marca> marcases;
    private Marca seleccionado;

    @PostConstruct
    public void onInit() {

        try {
            listar();
            listar();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public MarcaC() {
        marcas = new Marca();
        seleccionado = new Marca();
        daos = new MarcaImpl();
    }

    public void registrar() {
        try {
            daos.registrar(marcas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Registrado con exito"));
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void eliminar(Integer IDMAR) {
        try {
            System.out.println("No llega");
            daos.eliminar(IDMAR);
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
            daos.modificar(marcas);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Modificacion", "Modificado con exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void modificarEstado(Marca m) {
        try {
            m.setESTMAR("INACTIVO");
            daos.modificarEst(m);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Inactivado", "Inactivado con Exito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void listar() {
        try {
            marcases = new ArrayList<>();
            marcases = daos.listar();
        } catch (Exception e) {

        }
    }

    //DESCARGAR REPORTE DE VENTA
    public void REPORTE_PDF_VENTA(int CodigoVent) throws Exception {
//        System.out.println("aSDASDSA");
//        System.out.println(CodigoVent);
        MarcaImpl areaImpl = new MarcaImpl();
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
        daos = new MarcaImpl();
    }

    public MarcaImpl getDaos() {
        return daos;
    }

    public void setDaos(MarcaImpl daos) {
        this.daos = daos;
    }

    public Marca getMarcas() {
        return marcas;
    }

    public void setMarcas(Marca marcas) {
        this.marcas = marcas;
    }

    public List<Marca> getMarcases() {
        return marcases;
    }

    public void setMarcases(List<Marca> marcases) {
        this.marcases = marcases;
    }

    public Marca getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Marca seleccionado) {
        this.seleccionado = seleccionado;
    }

}
