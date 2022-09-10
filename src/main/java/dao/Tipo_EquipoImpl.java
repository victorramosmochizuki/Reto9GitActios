package dao;

import static dao.Conexion.conectar;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import model.Tipo_Equipo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Tipo_EquipoImpl extends Conexion implements Tipo_EquipoDao {

    @Override
    public void registrar(Tipo_Equipo tip) throws Exception {
        String sql = "insert into Tipo_Equipo"
                + "(NOMEQU, ESTEQU) values (?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, tip.getNOMEQU());
            ps.setString(2, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en registrar TipDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificar(Tipo_Equipo tip) throws Exception {
        String sql = "update Tipo_Equipo set"
                + " NOMEQU=?, ESTEQU=? where IDTIPEQU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, tip.getNOMEQU());
            ps.setString(2, "ACTIVO");
            ps.setInt(3, tip.getIDTIPEQU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar AreDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificarEst(Tipo_Equipo tip) throws Exception {
        String sql = "update Tipo_Equipo set"
                + " ESTEQU = 'INACTIVO' where IDTIPEQU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, tip.getIDTIPEQU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar TipDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void eliminar(Integer IDTIPEQU) throws Exception {
        String sql = "delete from TIPO_EQUIPO where IDTIPEQU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDTIPEQU);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en eliminar AreDao" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public List<Tipo_Equipo> listar() throws Exception {
        List<Tipo_Equipo> listado = new ArrayList<>();
        Tipo_Equipo tip;
        String sql = "select * from Tipo_Equipo order by NOMEQU";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tip = new Tipo_Equipo();
                tip.setIDTIPEQU(rs.getInt("IDTIPEQU"));
                tip.setNOMEQU(rs.getString("NOMEQU"));
                tip.setESTEQU(rs.getString("ESTEQU"));
                listado.add(tip);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la lista TipDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }
    
        //METODO REPORTE_PDF_ALUMNO PARA LA DESCARGA
    public void REPORTE_PDF_BOLETA(Map parameters) throws JRException, IOException, Exception {
        conectar();
//        System.out.println(parameters.get("IDARE"));
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("vistas/Reportes/report/TipoEquipo.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.conectar());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=REPORTES_TipodeEquipos.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
}
