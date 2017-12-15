package service;

import java.util.List;

import beans.OrdenVentaDTO;
import beans.ProductoDTO;
import dao.DAOFactory;
import interfaces.OrdenVentaDAO;
import utils.Constantes;

public class OrdenVentaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	OrdenVentaDAO objVenta = fabrica.getOrdenVenta();
	
	public int insertarOrdenVenta(String fecha, int idCliente, int idEmpleado){
		return objVenta.insertarOrdenVenta(fecha, idCliente, idEmpleado);
	}
	
	public void insertarDetalle(int ordenVenta, int idproducto, int cantidad, double monto){
		objVenta.insertarDetalle(ordenVenta, idproducto, cantidad, monto);
	}
	
	public OrdenVentaDTO buscarOrdenVenta(int cod){
		return objVenta.buscarOrdenVenta(cod);
	}
	public int getNextIDOrdenVenta(){
		return  objVenta.getNextIDOrdenVenta();
	}
}
