package service;

import java.util.List;

import beans.CargoDTO;
import dao.DAOFactory;
import interfaces.CargoDAO;
import utils.Constantes;

public class CargoService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	CargoDAO objCargo = fabrica.getCargo();
	
	public List<CargoDTO> listarCargos(){
		return objCargo.listarCargo();
	}
	
	public CargoDTO buscarCargo(int cod){
		return objCargo.buscarCargo(cod);
	}
}
