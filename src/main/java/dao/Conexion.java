package dao;

import java.sql.Connection;

import java.sql.DriverManager;

public class Conexion {

    public static Connection cnx = null;

    public static Connection conectar() throws Exception {
        String user = "tisoptec";
        String pwd = "tisoptec2020";
        String url = "jdbc:sqlserver://35.238.5.63;databaseName=isoptec";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);

        } catch (Exception e) {
            System.out.println("Error de conexion");
        }
        return cnx;
    }

    public static void cerrarCnx() throws Exception {
        if (Conexion.cnx != null) {
            cnx.close();
        }
    }
}
