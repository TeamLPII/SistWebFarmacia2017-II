package interfaces;


import java.util.List;

import beans.CategoriaDTO;

public interface CategoriaDAO {

	public CategoriaDTO buscarCategoria(int cod);

	public List<CategoriaDTO> listarCategoria();

	public int registrarCategoria(CategoriaDTO obj);

	public int actualizarCategoria(CategoriaDTO obj);

	public int eliminarCategoria(int cod);
}
