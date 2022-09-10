package dao;

import DTO.Detalle_EquipoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Detalle_Equipo;

public class Detalle_EquipoImpl extends Conexion {

    public void crear(Detalle_Equipo det) throws Exception {

        String sql = "Insert into Detalle_Equipo"
                + "(IDADQ, IDUSU, IDEQU, NROSER, DETEQU, COLEQU, GARINI, GARFIN, PRECIO, ESTDET)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, det.getIDADQ());
            ps.setInt(2, det.getIDUSU());
            ps.setInt(3, det.getIDEQU());
            ps.setString(4, det.getNROSER());
            ps.setString(5, det.getDETEQU());
            ps.setString(6, det.getCOLEQU());
            ps.setString(7, new Timestamp(det.getGARINI().getTime()).toString());
            ps.setString(8, new Timestamp(det.getGARFIN().getTime()).toString());
            ps.setDouble(9, det.getPRECIO());
            ps.setString(10, "ACTIVO");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en insert DetDAO " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }

    }

    public void modificar(Detalle_Equipo det) throws Exception {
        String sql = "update Detalle_Equipo set"
                + " IDADQ=?, IDUSU=?, IDEQU=?, NROSER=?, DETEQU=?, COLEQU=?, GARINI=?, GARFIN=?, PRECIO=?, ESTDET=? where IDDETEQU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, det.getIDADQ());
            ps.setInt(2, det.getIDUSU());
            ps.setInt(3, det.getIDEQU());
            ps.setString(4, det.getNROSER());
            ps.setString(5, det.getDETEQU());
            ps.setString(6, det.getCOLEQU());
            ps.setString(7, new Timestamp(det.getGARINI().getTime()).toString());
            ps.setString(8, new Timestamp(det.getGARFIN().getTime()).toString());
            ps.setDouble(9, det.getPRECIO());
            ps.setString(10, "ACTIVO");
            ps.setInt(11, det.getIDDETEQU());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error en modificar DetDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public void modificarEst(Detalle_Equipo det) throws Exception {
        String sql = "update Detalle_Equipo set"
                + " ESTDET = 'INACTIVO' where IDDETEQU=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, det.getIDDETEQU());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en Modificar DetDAO" + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
    }

    public List<Detalle_EquipoDTO> listar() throws Exception {
        List<Detalle_EquipoDTO> listado = new ArrayList<>();
        Detalle_EquipoDTO det;
        String sql = "SELECT DETALLE_EQUIPO.IDDETEQU, DETALLE_EQUIPO.NROSER, DETALLE_EQUIPO.DETEQU, DETALLE_EQUIPO.COLEQU, DETALLE_EQUIPO.GARINI, DETALLE_EQUIPO.GARFIN, DETALLE_EQUIPO.PRECIO, DETALLE_EQUIPO.ESTDET, ADQUISICION.IDADQ, ADQUISICION.CODADQ, USUARIO.IDUSU, USUARIO.DNIUSU, EQUIPO.IDEQU, EQUIPO.MODEQU FROM DETALLE_EQUIPO\n"
                + "INNER JOIN ADQUISICION ON ADQUISICION.IDADQ = DETALLE_EQUIPO.IDADQ\n"
                + "INNER JOIN USUARIO ON USUARIO.IDUSU = DETALLE_EQUIPO.IDUSU\n"
                + "INNER JOIN EQUIPO ON EQUIPO.IDEQU = DETALLE_EQUIPO.IDEQU WHERE DETALLE_EQUIPO.ESTDET = 'ACTIVO'";
        try {
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                det = new Detalle_EquipoDTO();
                det.setIDDETEQU(rs.getInt("IDDETEQU"));
                det.setNROSER(rs.getString("NROSER"));
                det.setDETEQU(rs.getString("DETEQU"));
                det.setCOLEQU(rs.getString("COLEQU"));
                det.setGARINI(rs.getDate("GARINI"));
                det.setGARFIN(rs.getDate("GARFIN"));
                det.setPRECIO(rs.getDouble("PRECIO"));
                det.setESTDET(rs.getString("ESTDET"));
                det.setIDADQ(rs.getInt("IDADQ"));
                det.setAdquisicion(rs.getString("CODADQ"));
                det.setIDUSU(rs.getInt("IDUSU"));
                det.setUsuario(rs.getString("DNIUSU"));
                det.setIDEQU(rs.getInt("IDEQU"));
                det.setEquipo(rs.getString("MODEQU"));

                listado.add(det);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error en la lista DetDao " + e.getMessage());
        } finally {
            this.cerrarCnx();
        }
        return listado;

    }

}
