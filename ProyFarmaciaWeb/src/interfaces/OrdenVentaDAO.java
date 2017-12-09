package interfaces;

import java.util.List;

import beans.ClientesDTO;
import beans.DetalleVentaDTO;
import beans.EmpleadoDTO;
import beans.OrdenVentaDTO;
import beans.ProductoDTO;

public interface OrdenVentaDAO {
	public int insertarOrdenVenta(String fecha, int idCliente, int idEmpleado);
	public OrdenVentaDTO buscarOrdenVenta(int cod);
	public void insertarDetalle(List<ProductoDTO> productos, OrdenVentaDTO ordenventa, int cantidad, double monto);
}
