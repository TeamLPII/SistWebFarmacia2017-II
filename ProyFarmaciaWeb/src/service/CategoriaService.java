package service;

import java.util.List;

import beans.CategoriaDTO;
import dao.DAOFactory;
import interfaces.CategoriaDAO;
import utils.Constantes;

public class CategoriaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	CategoriaDAO objC = fabrica.getCategoria();
	
	public List<CategoriaDTO> listarCategoria(){
		return objC.listarCategoria();
	}
	public CategoriaDTO buscaCategoria(int cod){
		return objC.buscarCategoria(cod);
	}

}
