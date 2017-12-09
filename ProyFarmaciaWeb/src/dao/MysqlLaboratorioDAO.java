package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.LaboratorioDTO;
import interfaces.LaboratorioDAO;
import utils.MysqlDBConexion;

public class MysqlLaboratorioDAO implements LaboratorioDAO {

	@Override
	public LaboratorioDTO buscarLaboratorio(int cod) {
		LaboratorioDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM Laboratorio WHERE IdLaboratorio=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if (rs.next()) {
				obj = new LaboratorioDTO();
				obj.setCod_lab(rs.getInt(1));
				obj.setNom_lab(rs.getString(2));
				
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
	public List<LaboratorioDTO> listarLaboratorio() {
		List<LaboratorioDTO> lista = new ArrayList<LaboratorioDTO>();
		LaboratorioDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "SELECT * FROM Laboratorio";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				obj = new LaboratorioDTO();
				obj.setCod_lab(rs.getInt(1));
				obj.setNom_lab(rs.getString(2));
				lista.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al listar laboratorio.");
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
	public int registrarLaboratorio(LaboratorioDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "INSERT INTO Laboratorio VALUES(null,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNom_lab());
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
	public int actualizarLaboratorio(LaboratorioDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "UPDATE Laboratorio SET Nombre=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, obj.getNom_lab());
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
	public int eliminarLaboratorio(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "DELETE FROM Laboratorio WHERE IdLaboratorio=?";
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

}
