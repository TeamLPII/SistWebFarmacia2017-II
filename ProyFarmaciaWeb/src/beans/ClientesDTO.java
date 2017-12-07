package beans;

import java.util.Date;

public class ClientesDTO {
	private int idCliente;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String DNI;
	private Date fechaRegistro;
	private String sexo;
	
	public ClientesDTO(){}

	public ClientesDTO(int idCliente, String nombre, String primerApellido, String segundoApellido, String dNI,
			Date fechaRegistro, String sexo) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.DNI = dNI;
		this.fechaRegistro = fechaRegistro;
		this.sexo = sexo;
	}
	
	public ClientesDTO(String nombre, String primerApellido, String segundoApellido, String dNI, Date fechaRegistro,
			String sexo) {
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.DNI = dNI;
		this.fechaRegistro = fechaRegistro;
		this.sexo = sexo;
	}

	public int getIdCliente() {
		return idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public String getDNI() {
		return DNI;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public String getSexo() {
		return sexo;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
