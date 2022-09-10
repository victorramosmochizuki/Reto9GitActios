package dao;

import DTO.EquipoDTO;
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
import model.Equipo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class EquipoImpl extends Conexion {

    public void crear(Equipo equ) throws Exception {
        String sql = "Insert into Equipo"
                + "(IDMAR, IDTIPEQU, MODEQU, ESTEQU)"
                + " values(?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, equ.getIDMAR());
            ps.setInt(2, equ.getIDTIPEQU());
            ps.setString(3, equ.getMODEQU());
            ps.setString(4, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en insert EquDAO " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificar(Equipo equ) throws Exception {
        String sql = "update Equipo set"
                + " IDMAR=?, IDTIPEQU=?, MODEQU=?, ESTEQU=? where IDEQU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, equ.getIDMAR());
            ps.setInt(2, equ.getIDTIPEQU());
            ps.setString(3, equ.getMODEQU());
            ps.setString(4, equ.getESTEQU());
            ps.setInt(5, equ.getIDEQU());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en modificar EquDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void eliminar(Integer IDEQU) throws Exception {
        String sql = "delete from Equipo where IDEQU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDEQU);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en eliminar EquDao" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void ModificarEst(Equipo equ) throws Exception {
        String sql = "update Equipo set"
                + " ESTEQU = 'INACTIVO' where IDEQU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, equ.getIDEQU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar EquDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public List<EquipoDTO> listar() throws Exception {
        List<EquipoDTO> listado = new ArrayList<>();
        EquipoDTO equ;
        String sql = " select equipo.idequ, equipo.modequ, equipo.estequ, marca.idmar, marca.NOMMAR, TIPO_EQUIPO.IDTIPEQU, TIPO_EQUIPO.NOMEQU from equipo\n"
                + "inner join Marca on Marca.IDMAR = EQUIPO.IDMAR\n"
                + "inner join TIPO_EQUIPO on TIPO_EQUIPO.IDTIPEQU = EQUIPO.IDTIPEQU order by NOMMAR ";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                equ = new EquipoDTO();
                equ.setIDEQU(rs.getInt("IDEQU"));
                equ.setMODEQU(rs.getString("MODEQU"));
                equ.setESTEQU(rs.getString("ESTEQU"));
                equ.setIDMAR(rs.getInt("IDMAR"));
                equ.setMarca(rs.getString("NOMMAR"));
                equ.setIDTIPEQU(rs.getInt("IDTIPEQU"));
                equ.setTipo(rs.getString("NOMEQU"));
                listado.add(equ);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error en la listaEquDao " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }
    
        public void REPORTE_EQUIPO(Map parameters) throws JRException, IOException, Exception {
        conectar();
//        System.out.println(parameters.get("IDEQU"));
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("vistas/Reportes/report/Equipo.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parameters, this.conectar());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=Reporte.pdf");
        try (ServletOutputStream stream = response.getOutputStream()) {
            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
            stream.flush();
        }
        FacesContext.getCurrentInstance().responseComplete();
    }

}
