package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Tipo_Movimiento;

public class Tipo_MovimientoImpl extends Conexion implements Tipo_MovimientoDao {

    @Override
    public void registrar(Tipo_Movimiento tim) throws Exception {
        String sql = "insert into Tipo_Movimiento"
                + "(TIPMOV, ESTTIP) VALUES (?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, tim.getTIPMOV());
            ps.setString(2, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en registrar TimDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void modificar(Tipo_Movimiento tim) throws Exception {
        String sql = "update Tipo_Movimiento set"
                + " TIPMOV=?, ESTTIP=? where IDTIPMOV=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, tim.getTIPMOV());
            ps.setString(2, "ACTIVO");
            ps.setInt(3, tim.getIDTIPMOV());
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
    public void modificarEst(Tipo_Movimiento tim) throws Exception {
        String sql = "update Tipo_Movimiento set"
                + " ESTTIP = 'INACTIVO' where IDTIPMOV=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, tim.getIDTIPMOV());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en ModificarEst TipDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    @Override
    public void eliminar(Integer IDTIPMOV) throws Exception {
        String sql = "delete from Tipo_Movimiento where IDTIPEQU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, IDTIPMOV);
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
    public List<Tipo_Movimiento> listar() throws Exception {
        List<Tipo_Movimiento> listado = new ArrayList<>();
        Tipo_Movimiento tim;
        String sql = "select * from Tipo_Movimiento WHERE ESTTIP = 'ACTIVO'";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                tim = new Tipo_Movimiento();
                tim.setIDTIPMOV(rs.getInt("IDTIPMOV"));
                tim.setTIPMOV(rs.getString("TIPMOV"));
                tim.setESTTIP(rs.getString("ESTTIP"));
                listado.add(tim);
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
}
