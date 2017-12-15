package dao;

import interfaces.CargoDAO;
import interfaces.CategoriaDAO;
import interfaces.EmpleadoDAO;
import interfaces.LaboratorioDAO;
import interfaces.OrdenVentaDAO;
import interfaces.ProductoDAO;
import interfaces.RealizarPagoDAO;
import interfaces.ReportesDAO;
import interfaces.ClientesDAO;

public abstract class DAOFactory {
	// los posibles origenes de datos
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	public static final int DB2 = 3;
	public static final int SQLSERVER = 4;
	public static final int XML = 5;
	
	/*
	 * Existirá un metodo get por cada DAO que exista en el sistema.
	 * Ejemplo:
	 * public abstract ArticuloDAO getArticuloDAO();
	 * registramos nuestros daos
	 */
	public abstract EmpleadoDAO getEmpleado();
	public abstract CargoDAO getCargo();
	public abstract ClientesDAO getCliente();
	public abstract CategoriaDAO getCategoria();
	public abstract LaboratorioDAO getLaboratorio();
	public abstract ProductoDAO getProducto();
	public abstract OrdenVentaDAO getOrdenVenta();
	public abstract RealizarPagoDAO getRealizarPago();
	public abstract ReportesDAO getReportes();
	
	public static DAOFactory getDAOFactory(int whichFactory){
		switch(whichFactory){
		case MYSQL:
			return new MysqlDAOFactory();
		case XML:
			//return new XmlDAOFactory();
		case ORACLE:
			//return new OracleDAOFactory();
		}
		return null;
	}
}
