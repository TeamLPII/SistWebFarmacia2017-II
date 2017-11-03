package dao;

import interfaces.CargoDAO;
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

}
