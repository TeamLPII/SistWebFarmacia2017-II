package dao;

import interfaces.CargoDAO;
import interfaces.CategoriaDAO;
import interfaces.ClientesDAO;
import interfaces.EmpleadoDAO;
import interfaces.LaboratorioDAO;
import interfaces.OrdenVentaDAO;
import interfaces.ProductoDAO;
import interfaces.RealizarPagoDAO;
import interfaces.ReportesDAO;

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

	@Override
	public OrdenVentaDAO getOrdenVenta() {
		return new MysqlOrdenVentaDAO();
	}
	@Override
	public RealizarPagoDAO getRealizarPago() {
		// TODO Auto-generated method stub
		return new MySqlRealizarPago();
	}

	@Override
	public ReportesDAO getReportes() {
		// TODO Auto-generated method stub
		return new MySqlReportesDAO();
	}

}
