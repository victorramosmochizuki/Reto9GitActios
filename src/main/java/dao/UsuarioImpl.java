package dao;

import DTO.UsuarioDTO;
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
import model.Usuario;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class UsuarioImpl extends Conexion {

    public void crear(Usuario usu) throws Exception {
        String sql = "Insert into Usuario"
                + "(IDARE, NOMUSU, APEUSU, DNIUSU, CORREO, SEXUSU, TELUSU, TIPUSU, ESTUSU)"
                + " values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, usu.getIDARE());
            ps.setString(2, usu.getNOMUSU());
            ps.setString(3, usu.getAPEUSU());
            ps.setString(4, usu.getDNIUSU());
            ps.setString(5, usu.getCORREO());
            ps.setString(6, usu.getSEXUSU());
            ps.setString(7, usu.getTELUSU());
            ps.setString(8, usu.getTIPUSU());
            ps.setString(9, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en insert UsuDAO " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificar(Usuario usu) throws Exception {
        String sql = "update Usuario set "
                + " IDARE=?, NOMUSU=?, APEUSU=?, DNIUSU=?, CORREO=?, SEXUSU=?, TELUSU=?, TIPUSU=?, ESTUSU=? where IDUSU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, usu.getIDARE());
            ps.setString(2, usu.getNOMUSU());
            ps.setString(3, usu.getAPEUSU());
            ps.setString(4, usu.getDNIUSU());
            ps.setString(5, usu.getCORREO());
            ps.setString(6, usu.getSEXUSU());
            ps.setString(7, usu.getTELUSU());
            ps.setString(8, usu.getTIPUSU());
            ps.setString(9, "ACTIVO");
            ps.setInt(10, usu.getIDUSU());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en modificar UsuDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificarEst(Usuario usu) throws Exception {
        String sql = "update Usuario set"
                + " ESTUSU = 'INACTIVO' where IDUSU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, usu.getIDUSU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar UsuDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public List<UsuarioDTO> listar() throws Exception {
        List<UsuarioDTO> listado = new ArrayList<>();
        UsuarioDTO pro;
        String sql = " select USUARIO.IDUSU, USUARIO.NOMUSU, USUARIO.APEUSU, USUARIO.DNIUSU, USUARIO.CORREO, USUARIO.SEXUSU, USUARIO.TELUSU, USUARIO.TIPUSU, USUARIO.ESTUSU, AREA.IDARE, AREA.NOMARE from USUARIO\n"
                + " inner join AREA ON AREA.IDARE = USUARIO.IDARE ORDER BY NOMUSU";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pro = new UsuarioDTO();
                pro.setIDUSU(rs.getInt("IDUSU"));
                pro.setNOMUSU(rs.getString("NOMUSU"));
                pro.setAPEUSU(rs.getString("APEUSU"));
                pro.setDNIUSU(rs.getString("DNIUSU"));
                pro.setCORREO(rs.getString("CORREO"));
                pro.setSEXUSU(rs.getString("SEXUSU"));
                pro.setTELUSU(rs.getString("TELUSU"));
                pro.setTIPUSU(rs.getString("TIPUSU"));
                pro.setESTUSU(rs.getString("ESTUSU"));
                pro.setIDARE(rs.getInt("IDARE"));
                pro.setArea(rs.getString("NOMARE"));
                listado.add(pro);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en la lisa ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

    public void eliminar(Integer IDUSU) throws Exception {
        String sql = "delete from Usuario where IDUSU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDUSU);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en eliminar Usuario" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void REPORTE_PDF_USUARIO(Map parameters) throws JRException, IOException, Exception {
        conectar();
//        System.out.println(parameters.get("NOMMAR"));
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("vistas/Reportes/report/USUARIO.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.conectar());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=Boleta de Usuario.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

}
