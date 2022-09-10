package dao;

import DTO.ComponenteDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Componente;

public class ComponenteImpl extends Conexion {

    public void crear(Componente com) throws Exception {
        String sql = "Insert into Componente"
                + "(IDDETEQU, CLAVE, VALOR, ESTCOM)"
                + " values(?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, com.getIDDETEQU());
            ps.setString(2, com.getCLAVE());
            ps.setString(3, com.getVALOR());
            ps.setString(4, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en insert ComDAO " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificar(Componente com) throws Exception {
        String sql = "update Componente set"
                + " IDDETEQU=?, CLAVE=?, VALOR=?, ESTCOM=? where IDCOM=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, com.getIDDETEQU());
            ps.setString(2, com.getCLAVE());
            ps.setString(3, com.getVALOR());
            ps.setString(4, "ACTIVO");
            ps.setInt(5, com.getIDCOM());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en modificar ComDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificarEst(Componente com) throws Exception {
        String sql = "update Componente set"
                + " ESTCOM = 'INACTIVO' where IDCOM=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, com.getIDCOM());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en ModificarEst ComDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public List<ComponenteDTO> listar() throws Exception {
        List<ComponenteDTO> listado = new ArrayList<>();
        ComponenteDTO com;
        String sql = "select COMPONENTE.IDCOM, COMPONENTE.CLAVE, COMPONENTE.VALOR, COMPONENTE.ESTCOM, DETALLE_EQUIPO.IDDETEQU, DETALLE_EQUIPO.NROSER from COMPONENTE\n"
                + "inner join DETALLE_EQUIPO on DETALLE_EQUIPO.IDDETEQU = COMPONENTE.IDDETEQU";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                com = new ComponenteDTO();
                com.setIDCOM(rs.getInt("IDCOM"));
                com.setCLAVE(rs.getString("CLAVE"));
                com.setVALOR(rs.getString("VALOR"));
                com.setESTCOM(rs.getString("ESTCOM"));
                com.setIDDETEQU(rs.getInt("IDDETEQU"));
                com.setDetalle(rs.getString("NROSER"));
                listado.add(com);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error en la lista ComDao " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

    public void eliminar(Integer IDCOM) throws Exception {
        String sql = "delete from Componente where IDCOM=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDCOM);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en eliminar ComDao" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

}
