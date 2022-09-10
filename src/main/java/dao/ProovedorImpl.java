package dao;

import static dao.Conexion.conectar;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import model.Proovedor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class ProovedorImpl extends Conexion implements ProovedorDao {

    @Override
    public void registrar(Proovedor pro) throws Exception {
        String sql = "insert into Proovedor"
                + "(RAZSOC, NOMCOM, RUC, VENDEDOR, EMAIL, NUMPRO, ESTPRO) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pro.getRAZSOC());
            ps.setString(2, pro.getNOMCOM());
            ps.setString(3, pro.getRUC());
            ps.setString(4, pro.getVENDEDOR());
            ps.setString(5, pro.getEMAIL());
            ps.setString(6, pro.getNUMPRO());
            ps.setString(7, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en registrar ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificar(Proovedor pro) throws Exception {
        String sql = "update Proovedor set"
                + " RAZSOC=?, NOMCOM=?, RUC=?, VENDEDOR=?, EMAIL=?, NUMPRO=?, ESTPRO=? where IDPRO=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, pro.getRAZSOC());
            ps.setString(2, pro.getNOMCOM());
            ps.setString(3, pro.getRUC());
            ps.setString(4, pro.getVENDEDOR());
            ps.setString(5, pro.getEMAIL());
            ps.setString(6, pro.getNUMPRO());
            ps.setString(7, "ACTIVO");
            ps.setInt(8, pro.getIDPRO());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }
    

    @Override
    public void modificarEst(Proovedor pro) throws Exception {
        String sql = "update Proovedor set"
                + " ESTPRO = 'INACTIVO' where IDPRO=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, pro.getIDPRO());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void eliminar(Integer IDPRO) throws Exception {
        String sql = "delete from Proovedor where IDPRO=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDPRO);
            ps.executeUpdate();
            ps.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en eliminar ProDao" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public List<Proovedor> listar() throws Exception {
        List<Proovedor> listado = new ArrayList<>();
        Proovedor pro;
        String sql = "select * from Proovedor order by RAZSOC";
        try {
           Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pro = new Proovedor();
                pro.setIDPRO(rs.getInt("IDPRO"));
                pro.setRAZSOC(rs.getString("RAZSOC"));
                pro.setNOMCOM(rs.getString("NOMCOM"));
                pro.setRUC(rs.getString("RUC"));
                pro.setVENDEDOR(rs.getString("VENDEDOR"));
                pro.setEMAIL(rs.getString("EMAIL"));
                pro.setNUMPRO(rs.getString("NUMPRO"));               
                pro.setESTPRO(rs.getString("ESTPRO"));
                listado.add(pro);
            } 
            rs.close();
            st.close();
        } catch (Exception e){
          System.out.println("Error en la lisa ProDAO" + e.getMessage());  
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }
    
        //METODO REPORTE_PDF_ALUMNO PARA LA DESCARGA
    public void REPORTE_PDF_BOLETA(Map parameters) throws JRException, IOException, Exception {
        conectar();
//        System.out.println(parameters.get("IDARE"));
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("vistas/Reportes/report/Proovedor.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.conectar());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=REPORTES_PROVEEDORES.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }
    
}
