package beans;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;

public class EmpleadoDTO {
	
	private int idEmpleado;
	private String nombre;
	private String primerAp;
	private String segundoAp;
	private LocalDate fechaNac;
	private LocalDate fechaIngreso;
	private String usuario;
	private String clave;
	private CargoDTO cargo;
	private String telefono;
	
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerAp() {
		return primerAp;
	}
	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}
	public String getSegundoAp() {
		return segundoAp;
	}
	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public CargoDTO getCargo() {
		return cargo;
	}
	public void setCargo(CargoDTO cargo) {
		this.cargo = cargo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public int getEdad(){
		LocalDate fechaActual = LocalDate.now();
		Period edad = Period.between(this.fechaNac, fechaActual);
		return edad.getYears();
	}

}
