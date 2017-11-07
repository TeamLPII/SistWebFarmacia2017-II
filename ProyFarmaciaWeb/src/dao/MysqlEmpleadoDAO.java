package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.EmpleadoDTO;
import interfaces.EmpleadoDAO;
import utils.MysqlDBConexion;

public class MysqlEmpleadoDAO implements EmpleadoDAO {
	
	private final String OBTENERLISTA = "SELECT * FROM Empleado";
	private final String OBTENEREMPLEADO = "SELECT * FROM Empleado WHERE idEmpleado=?";
	private final String OBTENERUSUARIO = "SELECT * FROM Empleado WHERE Usuario=? AND Clave=?";
	private final String ELIMINAREMPLEADO = "DELETE FROM Empleado WHERE idEmpleado=?";
	private final String ACTUALIZAREMPLEADO = "UPDATE Empleado SET Nombre=?, PrimerApellido=?, SegundoApellido=?, "
			+ "FechaNacimiento=?, FechaIngreso=?, Usuario=?, Clave=?, IdCargo=?, Telefono=? WHERE IdEmpleado=?";
	private final String INSERTAREMPLEADO = "INSERT INTO Empleado "
			+ "(Nombre, PrimerApellido, SegundoApellido, FechaNacimiento, FechaIngreso, Usuario, Clave, IdCargo, Telefono)"
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	@Override
	public List<EmpleadoDTO> listarEmpleados() {
		MysqlCargoDAO cargo = new MysqlCargoDAO();
		List<EmpleadoDTO> lista = new ArrayList<>();
		EmpleadoDTO empleado = null;
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(OBTENERLISTA);
			rs = pstm.executeQuery();
			
			while(rs.next()){
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
				
				lista.add(empleado);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al listar empleados.");
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return lista;
	}

	@Override
	public EmpleadoDTO buscarEmpleado(int id) {
		MysqlCargoDAO cargo = new MysqlCargoDAO();
		EmpleadoDTO empleado = null;
		
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(OBTENEREMPLEADO);
			pstm.setInt(1, id);
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
			System.out.println("Error al buscar: \n"+e);
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return empleado;
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
			System.out.println("Error al buscar usuario.\n"+e);
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return empleado;
	}

	@Override
	public int registrarEmpleado(EmpleadoDTO obj) {
		int estado = -1;
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(INSERTAREMPLEADO);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getPrimerAp());
			pstm.setString(3, obj.getSegundoAp());
			pstm.setString(4, obj.getFechaNac().toString());
			pstm.setString(5, obj.getFechaIngreso().toString());
			pstm.setString(6, obj.getUsuario());
			pstm.setString(7, obj.getClave());
			pstm.setInt(8, obj.getCargo().getIdCargo());
			pstm.setString(9, obj.getTelefono());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al insertar.\n"+e);
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return estado;
	}

	@Override
	public int actualizarEmpleado(EmpleadoDTO obj) {
		int estado = -1;
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(ACTUALIZAREMPLEADO);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getPrimerAp());
			pstm.setString(3, obj.getSegundoAp());
			pstm.setString(4, obj.getFechaNac().toString());
			pstm.setString(5, obj.getFechaIngreso().toString());
			pstm.setString(6, obj.getUsuario());
			pstm.setString(7, obj.getClave());
			pstm.setInt(8, obj.getCargo().getIdCargo());
			pstm.setString(9, obj.getTelefono());
			pstm.setInt(10, obj.getIdEmpleado());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al actualizar.\n"+e);
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return estado;
	}

	@Override
	public int eliminarEmpleado(int id) {
		int estado = -1;
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(ELIMINAREMPLEADO);
			pstm.setInt(1, id);
			estado = pstm.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al eliminar.\n"+e);
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return estado;
	}

}
