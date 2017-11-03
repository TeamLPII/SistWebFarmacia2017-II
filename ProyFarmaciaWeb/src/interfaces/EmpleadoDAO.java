package interfaces;

import java.util.List;

import beans.EmpleadoDTO;

public interface EmpleadoDAO {
	public List<EmpleadoDTO> listarEmpleados();
	public EmpleadoDTO buscarEmpleado(int id);
	public EmpleadoDTO iniciarSesion(String xuser, String xpass);
	public int registrarEmpleado(EmpleadoDTO obj);
	public int actualizarEmpleado(EmpleadoDTO obj);
	public int eliminarEmpleado(int id);
}
