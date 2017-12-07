package dao;

import interfaces.CargoDAO;
import interfaces.ClientesDAO;
import interfaces.EmpleadoDAO;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public CargoDAO getCargo() {
		return new MysqlCargoDAO();
	}

	@Override
	public EmpleadoDAO getEmpleado() {
		return new MysqlEmpleadoDAO();
	}

	@Override
	public ClientesDAO getCliente() {
		return new MysqlClienteDAO();
	}

}
