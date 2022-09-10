package dao;

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
import model.Area;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class AreaImpl extends Conexion implements AreaDao {

    @Override
    public void registrar(Area are) throws Exception {
        String sql = "insert into Area"
                + "(NOMARE, ESTARE) values (?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, are.getNOMARE());
            ps.setString(2, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en registrar AreDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificar(Area are) throws Exception {
        String sql = "update Area set"
                + " NOMARE=?, ESTARE=? where IDARE=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, are.getNOMARE());
            ps.setString(2, "ACTIVO");
            ps.setInt(3, are.getIDARE());
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
    public void modificarEst(Area are) throws Exception {
        String sql = "update Area set"
                + " ESTARE = 'INACTIVO' where IDARE=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, are.getIDARE());
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
    public void eliminar(Integer IDARE) throws Exception {
        String sql = "delete from Area where IDARE=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDARE);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en eliminar Area" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public List<Area> listar() throws Exception {
        List<Area> listado = new ArrayList<>();
        Area are;
        String sql = "SELECT * FROM AREA ORDER BY NOMARE";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                are = new Area();
                are.setIDARE(rs.getInt("IDARE"));
                are.setNOMARE(rs.getString("NOMARE"));
                are.setESTARE(rs.getString("ESTARE"));
                listado.add(are);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la lisa AreDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

    public List<Area> listarI() throws Exception {
        List<Area> listado = new ArrayList<>();
        Area are;
        String sql = "SELECT * FROM AREA ORDER BY NOMARE";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                are = new Area();
                are.setIDARE(rs.getInt("IDARE"));
                are.setNOMARE(rs.getString("NOMARE"));
                are.setESTARE(rs.getString("ESTARE"));
                listado.add(are);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la lisa AreDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

    //METODO REPORTE_PDF_ALUMNO PARA LA DESCARGA
    public void REPORTE_PDF_BOLETA(Map parameters) throws JRException, IOException, Exception {
        conectar();
//        System.out.println(parameters.get("IDARE"));
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("vistas/Reportes/report/Area.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.conectar());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=REPORTES_Area.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

    @Override
    public void ActivarEst(Area are) throws Exception {
        String sql = "update Area set"
                + " ESTARE = 'ACTIVO' where IDARE=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, are.getIDARE());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Activar Area" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

}
