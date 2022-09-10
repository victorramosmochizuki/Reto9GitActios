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
import model.Marca;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class MarcaImpl extends Conexion implements MarcaDao {

    @Override
    public void registrar(Marca mar) throws Exception {
        String sql = "insert into Marca"
                + "(NOMMAR,ESTMAR) values (?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, mar.getNOMMAR());
            ps.setString(2, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en registrar MarDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificar(Marca mar) throws Exception {
        String sql = "update Marca set"
                + " NOMMAR=?, ESTMAR=? where IDMAR=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, mar.getNOMMAR());
            ps.setString(2, "ACTIVO");
            ps.setInt(3, mar.getIDMAR());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar MarDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificarEst(Marca mar) throws Exception {
        String sql = "update Marca set"
                + " ESTMAR = 'INACTIVO' where IDMAR=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, mar.getIDMAR());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar MarDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void eliminar(Integer IDMAR) throws Exception {
       String sql = "delete from Marca where IDMAR=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDMAR);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en eliminarMarDao" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public List<Marca> listar() throws Exception {
        List<Marca> listado = new ArrayList<>();
        Marca mar;
        String sql = "select * from marca order by NOMMAR";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                mar = new Marca();
                mar.setIDMAR(rs.getInt("IDMAR"));
                mar.setNOMMAR(rs.getString("NOMMAR"));
                mar.setESTMAR(rs.getString("ESTMAR"));
                listado.add(mar);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la lisa MarDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

    //METODO REPORTE_PDF_ALUMNO PARA LA DESCARGA
    public void REPORTE_PDF_BOLETA(Map parameters) throws JRException, IOException, Exception {
        conectar();
//        System.out.println(parameters.get("IDARE"));
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("vistas/Reportes/report/Marca.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.conectar());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=REPORTES_MARCA.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

}
