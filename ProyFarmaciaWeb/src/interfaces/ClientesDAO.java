package interfaces;

import java.util.List;

import beans.ClientesDTO;

public interface ClientesDAO {
	public List<ClientesDTO> listarClientes();
	public ClientesDTO buscarCliente(int cod);
	public int insertarCliente(ClientesDTO objC);
	public int actualizarCliente(ClientesDTO objC);
	public int eliminarCliente(int cod);
	public List<ClientesDTO> buscarPorNombre(String nombre);
}
