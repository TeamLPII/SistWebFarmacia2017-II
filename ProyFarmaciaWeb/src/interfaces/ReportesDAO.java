package interfaces;

import java.util.List;

import beans.ReportesDTO;

public interface ReportesDAO {
	public List<ReportesDTO> listarVendedores();
	public List<ReportesDTO> ventaGeneral(String fInicio,String fFin);
	public List<ReportesDTO> ventasPorVendedor(int codVend,String fInicio,String fFin);
}
