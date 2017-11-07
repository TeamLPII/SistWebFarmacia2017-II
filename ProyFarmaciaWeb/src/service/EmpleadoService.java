package service;

import java.util.List;

import beans.EmpleadoDTO;
import dao.DAOFactory;
import interfaces.EmpleadoDAO;
import utils.Constantes;

public class EmpleadoService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	EmpleadoDAO objEmp = fabrica.getEmpleado();
	
	public EmpleadoDTO iniciarSesion(String xuser, String xpass){
		return objEmp.iniciarSesion(xuser, xpass);
	}
	
	public List<EmpleadoDTO> listarEmpleados(){
		return objEmp.listarEmpleados();
	}
	
	public EmpleadoDTO buscarEmpleado(int cod){
		return objEmp.buscarEmpleado(cod);
	}
	
	public int actualizarEmpleado(EmpleadoDTO obj){
		return objEmp.actualizarEmpleado(obj);
	}
	
	public int registrarEmpleado(EmpleadoDTO obj){
		return objEmp.registrarEmpleado(obj);
	}
}
