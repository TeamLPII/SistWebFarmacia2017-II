package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MysqlDBConexion;

public class MysqlProductoDAO implements ProductoDAO {

	@Override
	public ProductoDTO buscarProducto(int cod) {
		ProductoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select p.IdProducto, p.Nombre, p.Precio, p.Stock, c.Nombre, l.Nombre from producto p "+
						"inner join categoria c on p.IdCategoria=c.IdCategoria inner join laboratorio l "+
						"on p.IdLaboratorio=l.IdLaboratorio where p.IdProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new ProductoDTO();
				obj.setCod_prod(rs.getInt(1));
				obj.setNom_prod(rs.getString(2));
				obj.setPre_prod(rs.getDouble(3));
				obj.setStk_prod(rs.getInt(4));
				obj.setNom_cat(rs.getString(5));;
				obj.setNom_lab(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	public List<ProductoDTO> listarProducto() {
		List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
		ProductoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select p.IdProducto, p.Nombre, p.Precio, p.Stock, c.Nombre, l.Nombre from producto p "+
					"inner join categoria c on p.IdCategoria=c.IdCategoria inner join laboratorio l "+
					"on p.IdLaboratorio=l.IdLaboratorio order by p.IdProducto";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new ProductoDTO();
				obj.setCod_prod(rs.getInt(1));
				obj.setNom_prod(rs.getString(2));
				obj.setPre_prod(rs.getDouble(3));
				obj.setStk_prod(rs.getInt(4));
				obj.setNom_cat(rs.getString(5));;
				obj.setNom_lab(rs.getString(6));
				lista.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al listar producto.");
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
	public int registrarProducto(ProductoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO Producto VALUES(null,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNom_prod());
			pstm.setDouble(2, obj.getPre_prod());
			pstm.setInt(3, obj.getStk_prod());
			pstm.setInt(4, obj.getCod_cat());
			pstm.setInt(5, obj.getCod_lab());
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
	public int actualizarProducto(ProductoDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "UPDATE Producto SET Nombre=?, Precio=?, Stock=?, IdCategoria=?, IdLaboratorio=? WHERE IdProducto=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNom_prod());
			pstm.setDouble(2, obj.getPre_prod());
			pstm.setInt(3, obj.getStk_prod());
			pstm.setInt(4, obj.getCod_cat());
			pstm.setInt(5, obj.getCod_lab());
			pstm.setInt(6, obj.getCod_prod());
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
	public int eliminarProducto(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "DELETE FROM Producto WHERE IdProducto=?";
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
	public List<ProductoDTO> buscarProductoNombre(String nombre) {
		List<ProductoDTO> lista = new ArrayList<ProductoDTO>();
		ProductoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select p.IdProducto, p.Nombre, p.Precio, p.Stock, c.Nombre, l.Nombre from producto p "+
					"inner join categoria c on p.IdCategoria=c.IdCategoria inner join laboratorio l "+
					"on p.IdLaboratorio=l.IdLaboratorio  where p.Nombre like '"+nombre+"%' order by p.IdProducto";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new ProductoDTO();
				obj.setCod_prod(rs.getInt(1));
				obj.setNom_prod(rs.getString(2));
				obj.setPre_prod(rs.getDouble(3));
				obj.setStk_prod(rs.getInt(4));
				obj.setNom_cat(rs.getString(5));;
				obj.setNom_lab(rs.getString(6));
				lista.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al listar producto por Nombre.");
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

}
