package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ClientesDTO;
import interfaces.ClientesDAO;
import utils.MysqlDBConexion;

public class MysqlClienteDAO implements ClientesDAO {

	@Override
	public List<ClientesDTO> listarClientes() {
		List<ClientesDTO> data = new ArrayList<ClientesDTO>();
		ClientesDTO obj =null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql ="select * from Cliente";
			pstm = cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {			
				obj = new ClientesDTO();
				obj.setIdCliente(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setPrimerApellido(rs.getString(3));
				obj.setSegundoApellido(rs.getString(4));
				obj.setDNI(rs.getString(5));
				obj.setFechaRegistro(rs.getDate(6));
				obj.setSexo(rs.getString(7));
				data.add(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public ClientesDTO buscarCliente(int cod) {
		ClientesDTO obj = null;
		Connection cn=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from Cliente where IdCliente=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new ClientesDTO();
				obj.setIdCliente(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setPrimerApellido(rs.getString(3));
				obj.setSegundoApellido(rs.getString(4));
				obj.setDNI(rs.getString(5));
				obj.setFechaRegistro(rs.getDate(6));
				obj.setSexo(rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return obj;
	}

	@Override
	public int insertarCliente(ClientesDTO objC) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into Cliente values(null,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, objC.getNombre());
			pstm.setString(2, objC.getPrimerApellido());
			pstm.setString(3, objC.getSegundoApellido());
			pstm.setString(4, objC.getDNI());
			java.util.Date utilDate = objC.getFechaRegistro();
			java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
			pstm.setDate(5, fechaConvertida);
			pstm.setString(6, objC.getSexo());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int actualizarCliente(ClientesDTO objC) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update Cliente set Nombre=?,PrimerApellido=?,SegundoApellido=?,"
					+"DNI=?,FechaRegistro=?,Sexo=? where IdCliente=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, objC.getNombre());
			pstm.setString(2, objC.getPrimerApellido());
			pstm.setString(3, objC.getSegundoApellido());
			pstm.setString(4, objC.getDNI());
			java.util.Date utilDate = objC.getFechaRegistro();
			java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
			pstm.setDate(5, fechaConvertida);
			pstm.setString(6, objC.getSexo());
			pstm.setInt(7, objC.getIdCliente());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public int eliminarCliente(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "delete from Cliente where IdCliente=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}

	@Override
	public List<ClientesDTO> buscarPorNombre(String nombre) {
		List<ClientesDTO> data = new ArrayList<ClientesDTO>();
		ClientesDTO obj =null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql ="select * from Cliente where Nombre like '"+nombre+"%' or primerApellido like '"+nombre+"%'";						
			pstm = cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {			
				obj = new ClientesDTO();
				obj.setIdCliente(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setPrimerApellido(rs.getString(3));
				obj.setSegundoApellido(rs.getString(4));
				obj.setDNI(rs.getString(5));
				obj.setFechaRegistro(rs.getDate(6));
				obj.setSexo(rs.getString(7));
				data.add(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public ClientesDTO buscarPorDNI(String dni) {
		ClientesDTO obj = null;
		Connection cn=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from Cliente where DNI=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, dni);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new ClientesDTO();
				obj.setIdCliente(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setPrimerApellido(rs.getString(3));
				obj.setSegundoApellido(rs.getString(4));
				obj.setDNI(rs.getString(5));
				obj.setFechaRegistro(rs.getDate(6));
				obj.setSexo(rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return obj;
	}

}
