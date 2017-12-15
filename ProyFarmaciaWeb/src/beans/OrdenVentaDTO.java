package beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdenVentaDTO {
	private int idOrdenVenta;
	private LocalDate fechaOrden;
	private LocalDate fechaPago;
	private int estado;
	private int cliente;
	private int empleado;
	private List<DetalleVentaDTO> detalle = new ArrayList<>();
	
	public List<DetalleVentaDTO> getDetalle() {
		return detalle;
	}
	public void addDetalle(DetalleVentaDTO item) {
		detalle.add(item);
	}
	public int getIdOrdenVenta() {
		return idOrdenVenta;
	}
	public void setIdOrdenVenta(int idOrdenVenta) {
		this.idOrdenVenta = idOrdenVenta;
	}
	public LocalDate getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(LocalDate fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
	}
	public int getEmpleado() {
		return empleado;
	}
	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}
	
}
