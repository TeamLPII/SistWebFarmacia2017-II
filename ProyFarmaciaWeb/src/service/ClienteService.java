package service;

import java.util.List;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import beans.ClientesDTO;
import dao.DAOFactory;
import interfaces.ClientesDAO;
import utils.Constantes;

public class ClienteService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ClientesDAO objCli = fabrica.getCliente();
	
	public List<ClientesDTO>listaCliente(){
		return objCli.listarClientes();
	}
	public ClientesDTO buscaCliente(int cod){
		return objCli.buscarCliente(cod);
	}
	public int insertaCliente(ClientesDTO objC){
		return objCli.insertarCliente(objC);
	}
	public int actualizaCliente(ClientesDTO objC){
		return objCli.actualizarCliente(objC);
	}
	public int eliminaCliente(int cod){
		return objCli.eliminarCliente(cod);
	}
	public List<ClientesDTO> buscarPorNombre(String nombre){
		return objCli.buscarPorNombre(nombre);	
	}
	
	public ClientesDTO buscarPorDNI(String dni){
		return objCli.buscarPorDNI(dni);
	}

}
