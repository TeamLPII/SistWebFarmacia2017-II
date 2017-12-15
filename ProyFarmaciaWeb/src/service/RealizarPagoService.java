package service;

import java.util.List;

import beans.RealizarPagoDTO;
import dao.DAOFactory;
import interfaces.RealizarPagoDAO;
import utils.Constantes;

public class RealizarPagoService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	RealizarPagoDAO objR = fabrica.getRealizarPago();
	
	public List<RealizarPagoDTO> listarOrdenVenta(int codVenta){
		return objR.listarOrdenVenta(codVenta);
	}
	public RealizarPagoDTO buscarCliente(int codVenta){
		return objR.buscarCliente(codVenta);
	}
	public int actualizarEstado(RealizarPagoDTO obj){
		return objR.actualizarEstado(obj);
	}
}
