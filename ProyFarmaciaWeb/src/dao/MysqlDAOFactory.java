package dao;

import interfaces.CargoDAO;

public class MysqlDAOFactory extends DAOFactory {

	@Override
	public CargoDAO getCargo() {
		return new MysqlCargoDAO();
	}

}
