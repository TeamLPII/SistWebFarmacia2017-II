package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ClientesDTO;
import beans.ProductoDTO;
import beans.RealizarPagoDTO;
import interfaces.RealizarPagoDAO;
import utils.MysqlDBConexion;

public class MySqlRealizarPago implements RealizarPagoDAO {

	@Override
	public List<RealizarPagoDTO> listarOrdenVenta(int codVenta) {
		List<RealizarPagoDTO> lista = new ArrayList<RealizarPagoDTO>();
		RealizarPagoDTO obj=null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select c.Nombre,c.PrimerApellido,d.IdProducto,p.Nombre,d.Cantidad,p.Precio,d.Monto from ordenventa o inner join detalleventa d "+
							"on o.IdOrdenVenta=d.IdOrdenVenta inner join cliente c on o.IdCliente=c.IdCliente inner join producto p "+ 
							"on d.IdProducto=p.IdProducto where o.IdOrdenVenta=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codVenta);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new RealizarPagoDTO();
				obj.setNomCliente(rs.getString(1));
				obj.setApeCliente(rs.getString(2));
				obj.setIdProducto(rs.getInt(3));
				obj.setNomProducto(rs.getString(4));
				obj.setCantidad(rs.getInt(5));
				obj.setPrecioUnitario(rs.getDouble(6));
				obj.setMonto(rs.getDouble(7));
				lista.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al listar OrdenVenta y Detalle.");
		}

		finally {
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

		return lista;
	}

	@Override
	public RealizarPagoDTO buscarCliente(int codVenta) {
		RealizarPagoDTO obj =null;
		Connection cn=null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select c.Nombre,concat(c.PrimerApellido,' ',c.SegundoApellido) as apellidos from ordenventa o inner join cliente c "
						+"on o.IdCliente=c.IdCliente where o.IdOrdenVenta=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codVenta);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj=new RealizarPagoDTO();
				obj.setNomCliente(rs.getString(1));
				obj.setApeCliente(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al buscar Cliente por IdOrdenVenta");
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
	public int actualizarEstado(RealizarPagoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "update ordenventa set Estado=?, FechaPago=? where IdOrdenVenta=?;";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, obj.getEstado());
			pstm.setString(2, obj.getFechaPago());
			pstm.setInt(3, obj.getIdOrdenVenta());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al actualizar Estado");
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



}
