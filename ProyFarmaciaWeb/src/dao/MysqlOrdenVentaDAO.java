package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import beans.DetalleVentaDTO;
import beans.OrdenVentaDTO;
import beans.ProductoDTO;
import interfaces.OrdenVentaDAO;
import utils.MysqlDBConexion;

public class MysqlOrdenVentaDAO implements OrdenVentaDAO {
	
	private final String INSERTARORDENVENTA = "INSERT INTO ordenventa (FechaOrden, IdCliente, IdEmpleado)"
							+"VALUES(?, ?, ?)";
	private final String INSERTARDETALLE = "INSERT INTO detalleventa (IdOrdenVenta, IdProducto, Cantidad, Monto)"
							+ "VALUES(?, ?, ?, ?)";
	private final String BUSCARORDENVENTA = "SELECT * FROM ordenventa where IdOrdenVenta = ?";
	
	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	@Override
	public int insertarOrdenVenta(String fecha, int idCliente, int idEmpleado) {
		// TODO Auto-generated method stub
		int estado = -1;
		OrdenVentaDTO encabezado = null;
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(INSERTARORDENVENTA);
			//pstm.setString(1, obj.getFechaOrden().toString());
			//pstm.setString(2, obj.getFechaPago().toString());
			//estado
//			pstm.setInt(2, obj.getCliente().getIdCliente());
//			pstm.setInt(3, obj.getEmpleado().getIdEmpleado());
			pstm.setString(1, fecha);
			pstm.setInt(2, idCliente);
			pstm.setInt(3, idEmpleado);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al insertar Venta \n"+e);
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		
		return estado;
	}

	@Override
	public void insertarDetalle(List<ProductoDTO> productos, OrdenVentaDTO ordenventa, int cantidad, double monto) {
		DetalleVentaDTO detalle = null;
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(INSERTARDETALLE);
			
			for (ProductoDTO productoDTO : productos) {
				detalle = new DetalleVentaDTO();
				detalle.setIdOrdenVenta(ordenventa.getIdOrdenVenta());
				//detalle.setProducto(productoDTO);
				
				pstm.setInt(1, detalle.getIdOrdenVenta());
				//pstm.setInt(2, detalle.getProducto().getCod_prod());
				pstm.setInt(3, cantidad);
				pstm.setDouble(4, monto);
				pstm.executeUpdate();
				
				ordenventa.addDetalle(detalle);
			}
		} catch (Exception e) {
			System.out.println("Error al insertar detalle. \n"+e);
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}		
	}

	@Override
	public OrdenVentaDTO buscarOrdenVenta(int cod) {
		MysqlClienteDAO cliente = new MysqlClienteDAO();
		MysqlEmpleadoDAO empleado = new MysqlEmpleadoDAO();
		
		OrdenVentaDTO ordenventa = null;
		
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(BUSCARORDENVENTA);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			if(rs.next()){
				ordenventa = new OrdenVentaDTO();
				ordenventa.setFechaOrden(rs.getDate(1).toLocalDate());
				ordenventa.setFechaPago(rs.getDate(2).toLocalDate());
				ordenventa.setEstado(rs.getInt(3));
				ordenventa.setCliente(cliente.buscarCliente(rs.getInt(4)));
				ordenventa.setEmpleado(empleado.buscarEmpleado(rs.getInt(5)));
			}
		} catch (Exception e) {
			System.out.println("Error al buscar Orden de Venta. \n"+e);
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return ordenventa;
	}

	/*@Override
	public void insertarDetalle(DetalleVentaDTO obj) {
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(INSERTARDETALLE);
			pstm.setInt(1, obj.getOrdenVenta().getIdOrdenVenta());
			pstm.setInt(2, obj.getProducto().getCod_prod());
			pstm.setInt(3, obj.getCantidad());
			pstm.setDouble(4, obj.getMonto());
			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al insertar el detalle\n"+e);
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}

	}*/

}
