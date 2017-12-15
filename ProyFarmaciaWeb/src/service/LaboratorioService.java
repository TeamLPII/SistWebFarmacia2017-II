package service;

import java.util.List;

import beans.LaboratorioDTO;
import dao.DAOFactory;
import interfaces.LaboratorioDAO;
import utils.Constantes;

public class LaboratorioService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	LaboratorioDAO objL = fabrica.getLaboratorio();
	
	public List<LaboratorioDTO> listarLaboratorio(){
		return objL.listarLaboratorio();
	}
	public LaboratorioDTO buscaLaboratorio(int cod){
		return objL.buscarLaboratorio(cod);
	}
	public int registrarLaboratorio(LaboratorioDTO obj){
		return objL.registrarLaboratorio(obj);
	}
	public int actualizarLaboratorio(LaboratorioDTO obj){
		return objL.actualizarLaboratorio(obj);
	}
	public int eliminarLaboratorio(int cod){
		return objL.eliminarLaboratorio(cod);
	}

}
