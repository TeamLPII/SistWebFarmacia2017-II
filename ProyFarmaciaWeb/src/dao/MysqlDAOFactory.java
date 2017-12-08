package dao;

import interfaces.CargoDAO;
import interfaces.CategoriaDAO;
import interfaces.ClientesDAO;
import interfaces.EmpleadoDAO;
import interfaces.LaboratorioDAO;
import interfaces.ProductoDAO;

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

	@Override
	public CategoriaDAO getCategoria() {
		return new MysqlCategoriaDAO();
	}

	@Override
	public LaboratorioDAO getLaboratorio() {
		return new MysqlLaboratorioDAO();
	}

	@Override
	public ProductoDAO getProducto() {
		return new MysqlProductoDAO();
	}

}
