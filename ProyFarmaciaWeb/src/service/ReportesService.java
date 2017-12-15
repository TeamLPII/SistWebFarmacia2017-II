package service;

import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import beans.ReportesDTO;
import dao.DAOFactory;
import interfaces.ReportesDAO;
import utils.Constantes;

public class ReportesService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ReportesDAO objR = fabrica.getReportes();
	
	public List<ReportesDTO> listarVendedor(){
		return objR.listarVendedores();
	}
	public List<ReportesDTO> ventaGeneral(String fInicio,String fFin){
		return objR.ventaGeneral(fInicio, fFin);
	}
	public List<ReportesDTO> ventasPorVendedor(int codVend,String fInicio,String fFin){
		return objR.ventasPorVendedor(codVend, fInicio, fFin);
	}

}
