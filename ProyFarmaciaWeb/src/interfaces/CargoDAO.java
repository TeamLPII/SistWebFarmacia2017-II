package interfaces;

import java.util.List;

import beans.CargoDTO;

public interface CargoDAO {
	
	public List<CargoDTO> listarCargo();
	public CargoDTO buscarCargo(int cod);
	
}
