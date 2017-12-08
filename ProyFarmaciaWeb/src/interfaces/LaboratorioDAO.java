package interfaces;


import java.util.List;

import beans.LaboratorioDTO;

public interface LaboratorioDAO {

	public LaboratorioDTO buscarLaboratorio(int cod);

	public List<LaboratorioDTO> listarLaboratorio();

	public int registrarLaboratorio(LaboratorioDTO obj);

	public int actualizarLaboratorio(LaboratorioDTO obj);

	public int eliminarLaboratorio(int cod);
}
