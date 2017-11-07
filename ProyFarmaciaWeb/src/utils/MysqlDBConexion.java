package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDBConexion {
	public static Connection getConexion() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_farmacia2017?useSSL=false", "root", "mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	public static void cerrarConexion(Connection cn, PreparedStatement pstm, ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
			if(pstm != null){
				pstm.close();
			}
			if(cn != null){
				cn.close();
			}
		} catch (SQLException e) {
			System.out.println("Error al cerrar la base de datos.\n"+e);
		}
	}
}
