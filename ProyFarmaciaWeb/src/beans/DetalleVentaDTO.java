package beans;

public class DetalleVentaDTO {
	private int idOrdenVenta; 
	private int idProducto;
	private int cantidad;
	private double monto;
	
	public int getIdOrdenVenta() {
		return idOrdenVenta;
	}
	public void setIdOrdenVenta(int idOrdenVenta) {
		this.idOrdenVenta = idOrdenVenta;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
