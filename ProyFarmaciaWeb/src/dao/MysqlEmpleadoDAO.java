package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import beans.EmpleadoDTO;
import interfaces.EmpleadoDAO;
import utils.MysqlDBConexion;

public class MysqlEmpleadoDAO implements EmpleadoDAO {
	
	private final String OBTENERLISTA = "SELECT * FROM Empleado";
	private final String OBTENEREMPLEADO = "SELECT * FROM Empleado WHERE idEmpleado=?";
	private final String OBTENERUSUARIO = "SELECT * FROM Empleado WHERE Usuario=? AND Clave=?";
	
	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	@Override
	public List<EmpleadoDTO> listarEmpleados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoDTO buscarEmpleado(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpleadoDTO iniciarSesion(String xuser, String xpass) {
		MysqlCargoDAO cargo = new MysqlCargoDAO();
		EmpleadoDTO empleado = null;
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(OBTENERUSUARIO);
			pstm.setString(1, xuser);
			pstm.setString(2, xpass);
			rs = pstm.executeQuery();
			
			if(rs.next()){
				empleado = new EmpleadoDTO();
				empleado.setIdEmpleado(rs.getInt(1));
				empleado.setNombre(rs.getString(2));
				empleado.setPrimerAp(rs.getString(3));
				empleado.setSegundoAp(rs.getString(4));
				empleado.setFechaNac(rs.getDate(5).toLocalDate());
				empleado.setFechaIngreso(rs.getDate(6).toLocalDate());
				empleado.setUsuario(rs.getString(7));
				empleado.setClave(rs.getString(8));
				empleado.setCargo(cargo.buscarCargo(rs.getInt(9)));
				empleado.setTelefono(rs.getString(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al buscar usuario.");
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return empleado;
	}

	@Override
	public int registrarEmpleado(EmpleadoDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarEmpleado(EmpleadoDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarEmpleado(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
