package dao;

import DTO.AdquisicionDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Adquisicion;

public class AdquisicionImpl extends Conexion {

    public void crear(Adquisicion adq) throws Exception {

        String sql = "Insert into Adquisicion"
                + "(IDPRO, CANTIDAD, FECCOM, FECADQ, CODADQ, ESTADQ)"
                + "values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, adq.getIDPRO());
            ps.setInt(2, adq.getCANTIDAD());
            ps.setString(3, new Timestamp(adq.getFECCOM().getTime()).toString());
            ps.setString(4, new Timestamp(adq.getFECADQ().getTime()).toString());
            ps.setString(5, adq.getCODADQ());
            ps.setString(6, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en insert AdqDAO " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificar(Adquisicion adq) throws Exception {
        String sql = "update Adquisicion set"
                + " IDPRO=?, CANTIDAD=?, FECCOM=?, FECADQ=?, CODADQ=?, ESTADQ=? where IDADQ=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, adq.getIDPRO());
            ps.setInt(2, adq.getCANTIDAD());
            ps.setString(3, new Timestamp(adq.getFECCOM().getTime()).toString());
            ps.setString(4, new Timestamp(adq.getFECADQ().getTime()).toString());
            ps.setString(5, adq.getCODADQ());
            ps.setString(6, "ACTIVO");
            ps.setInt(7, adq.getIDADQ());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en modificar AdqDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificarEst(Adquisicion adq) throws Exception {
        String sql = "update Adquisicion set"
                + " ESTADQ = 'INACTIVO' where IDADQ=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, adq.getIDADQ());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar ProDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void eliminar(Integer IDADQ) throws Exception {
        String sql = "delete from Adquisicion where IDADQ=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDADQ);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en eliminar AdqDao" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public List<AdquisicionDTO> listar() throws Exception {
        List<AdquisicionDTO> listado = new ArrayList<>();
        AdquisicionDTO adq;
        String sql = "select adquisicion.idadq, adquisicion.cantidad, adquisicion.feccom, adquisicion.fecadq, adquisicion.estadq,adquisicion.CODADQ, PROOVEDOR.IDPRO, PROOVEDOR.RAZSOC from adquisicion\n"
                + "inner join proovedor on proovedor.IDPRO = adquisicion.IDPRO order by CODADQ";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                adq = new AdquisicionDTO();
                adq.setIDADQ(rs.getInt("IDADQ"));
                adq.setCANTIDAD(rs.getInt("CANTIDAD"));
                adq.setFECCOM(rs.getDate("FECCOM"));
                adq.setFECADQ(rs.getDate("FECADQ"));
                adq.setESTADQ(rs.getString("ESTADQ"));
                adq.setCODADQ(rs.getString("CODADQ"));
                adq.setIDPRO(rs.getInt("IDPRO"));
                adq.setProovedor(rs.getString("RAZSOC"));
                listado.add(adq);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error en la lista AdqDao " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;
    }

}
