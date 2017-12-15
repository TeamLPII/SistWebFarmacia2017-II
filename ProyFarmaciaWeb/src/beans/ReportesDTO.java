package beans;

public class ReportesDTO {
	private int IdOrdenVenta;
	private int IdCliente;
	private int IdEmpleado;
	private int IdProducto;
	private int cantidad;
	private double monto;
	private String fechaOrden;
	private String nombreCliente;
	private String nombreEmpleado;
	private String nombreProducto;
	public int getIdOrdenVenta() {
		return IdOrdenVenta;
	}
	public int getIdCliente() {
		return IdCliente;
	}
	public int getIdEmpleado() {
		return IdEmpleado;
	}
	public int getIdProducto() {
		return IdProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public double getMonto() {
		return monto;
	}
	public String getFechaOrden() {
		return fechaOrden;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setIdOrdenVenta(int idOrdenVenta) {
		IdOrdenVenta = idOrdenVenta;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
	}
	public void setIdEmpleado(int idEmpleado) {
		IdEmpleado = idEmpleado;
	}
	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public void setFechaOrden(String fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


}
