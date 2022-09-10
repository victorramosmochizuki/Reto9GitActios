package dao;

import DTO.SoftwareDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Software;

public class SoftwareImpl extends Conexion {

    public void crear(Software sof) throws Exception {

        String sql = "Insert into Software"
                + "(IDDETEQU, SOFTWARE, INIGAR, FINGAR, ESTSOF)"
                + "values(?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, sof.getIDDETEQU());
            ps.setString(2, sof.getSOFTWARE());
            ps.setString(3, new Timestamp(sof.getINIGAR().getTime()).toString());
            ps.setString(4, new Timestamp(sof.getFINGAR().getTime()).toString());
            ps.setString(5, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en insert Software " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificar(Software sof) throws Exception {
        String sql = "update Software set"
                + " IDDETEQU=?, SOFTWARE=?, INIGAR=?, FINGAR=?, ESTSOF=? where IDSOF=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, sof.getIDDETEQU());
            ps.setString(2, sof.getSOFTWARE());
            ps.setString(3, new Timestamp(sof.getINIGAR().getTime()).toString());
            ps.setString(4, new Timestamp(sof.getFINGAR().getTime()).toString());
            ps.setString(5, "ACTIVO");
            ps.setInt(6, sof.getIDSOF());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en modificar Software" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificarEst(Software sof) throws Exception {
        String sql = "update Software set"
                + " ESTSOF = 'INACTIVO' where IDSOF=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, sof.getIDSOF());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en ModificarEst Software" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void eliminar(Integer IDSOF) throws Exception {
        String sql = "delete from Software where IDSOF=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDSOF);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en eliminar AdqDao" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public List<SoftwareDTO> listar() throws Exception {
        List<SoftwareDTO> listado = new ArrayList<>();
        SoftwareDTO sof;
        String sql = "select SOFTWARE.IDSOF, SOFTWARE.SOFTWARE, SOFTWARE.INIGAR, SOFTWARE.FINGAR, SOFTWARE.ESTSOF, DETALLE_EQUIPO.IDDETEQU, DETALLE_EQUIPO.NROSER  from SOFTWARE\n"
                + "inner join DETALLE_EQUIPO on DETALLE_EQUIPO.IDDETEQU = SOFTWARE.IDDETEQU";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                sof = new SoftwareDTO();
                sof.setIDSOF(rs.getInt("IDSOF"));
                sof.setSOFTWARE(rs.getString("SOFTWARE"));
                sof.setINIGAR(rs.getDate("INIGAR"));
                sof.setFINGAR(rs.getDate("FINGAR"));
                sof.setESTSOF(rs.getString("ESTSOF"));
                sof.setIDDETEQU(rs.getInt("IDDETEQU"));
                sof.setDetalle(rs.getString("NROSER"));
                listado.add(sof);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error en la lista Software " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }
}
