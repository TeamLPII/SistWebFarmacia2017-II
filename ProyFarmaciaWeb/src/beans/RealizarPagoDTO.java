package beans;

public class RealizarPagoDTO {
	private int IdOrdenVenta;
	private String nomCliente;
	private String apeCliente;
	private int IdProducto;
	private String nomProducto;
	private int Cantidad;
	private double precioUnitario;
	private double monto;
	private int estado;
	private String fechaPago;
	public int getIdOrdenVenta() {
		return IdOrdenVenta;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public String getApeCliente() {
		return apeCliente;
	}
	public int getIdProducto() {
		return IdProducto;
	}
	public String getNomProducto() {
		return nomProducto;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public double getMonto() {
		return monto;
	}
	public int getEstado() {
		return estado;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setIdOrdenVenta(int idOrdenVenta) {
		IdOrdenVenta = idOrdenVenta;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public void setApeCliente(String apeCliente) {
		this.apeCliente = apeCliente;
	}
	public void setIdProducto(int idProducto) {
		IdProducto = idProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	
}

