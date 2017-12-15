package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import beans.ReportesDTO;
import interfaces.ReportesDAO;
import utils.MysqlDBConexion;

public class MySqlReportesDAO implements ReportesDAO {

	@Override
	public List<ReportesDTO> listarVendedores() {
		List<ReportesDTO> data = new ArrayList<ReportesDTO>();
		ReportesDTO obj =null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql ="select IdEmpleado,concat(Nombre,' ',PrimerApellido,' ',SegundoApellido)  from empleado where IdCargo=2";
			pstm = cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {			
				obj = new ReportesDTO();
				obj.setIdEmpleado(rs.getInt(1));
				obj.setNombreEmpleado(rs.getString(2));
				data.add(obj);
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
		return data;
	}

	@Override
	public List<ReportesDTO> ventaGeneral(String fInicio, String fFin) {
		List<ReportesDTO> data = new ArrayList<ReportesDTO>();
		ReportesDTO obj =null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql ="select o.IdOrdenVenta,o.FechaOrden,concat(c.Nombre,' ',c.PrimerApellido),concat(e.Nombre,' ',e.PrimerApellido), d.IdProducto,p.Nombre,d.Cantidad,d.Monto from ordenventa o inner join detalleventa d " 
						+"on o.IdOrdenVenta=d.IdOrdenVenta inner join producto p on d.IdProducto=p.IdProducto inner join cliente c on o.IdCliente=c.IdCliente inner join empleado e on o.IdEmpleado=e.IdEmpleado "
						+"where o.FechaOrden between '"+fInicio+"' and '"+fFin+"' order by o.IdOrdenVenta asc";
			pstm = cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while (rs.next()) {			
				obj = new ReportesDTO();
				obj.setIdOrdenVenta(rs.getInt(1));
				obj.setFechaOrden(rs.getString(2));
				obj.setNombreCliente(rs.getString(3));
				obj.setNombreEmpleado(rs.getString(4));
				obj.setIdProducto(rs.getInt(5));
				obj.setNombreProducto(rs.getString(6));
				obj.setCantidad(rs.getInt(7));
				obj.setMonto(rs.getDouble(8));
				data.add(obj);
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
		return data;
	}

	@Override
	public List<ReportesDTO> ventasPorVendedor(int codVend,String fInicio, String fFin) {
		List<ReportesDTO> data = new ArrayList<ReportesDTO>();
		ReportesDTO obj =null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql ="select o.IdOrdenVenta,o.FechaOrden,d.IdProducto,p.Nombre as nombreProducto,d.Cantidad,d.Monto from ordenventa o inner join empleado e "
						+"on o.IdEmpleado=e.IdEmpleado inner join detalleventa d on o.IdOrdenVenta=d.IdOrdenVenta inner join producto p " 
						+"on d.IdProducto=p.IdProducto where e.IdEmpleado=? and o.FechaOrden between '"+fInicio+"' and '"+fFin+"'";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, codVend);
			rs=pstm.executeQuery();
			while (rs.next()) {			
				obj = new ReportesDTO();
				obj.setIdOrdenVenta(rs.getInt(1));
				obj.setFechaOrden(rs.getString(2));
				obj.setIdProducto(rs.getInt(3));
				obj.setNombreProducto(rs.getString(4));
				obj.setCantidad(rs.getInt(5));
				obj.setMonto(rs.getDouble(6));
				data.add(obj);
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
		return data;
	}

}
