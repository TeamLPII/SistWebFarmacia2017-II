package interfaces;

import java.util.List;

import beans.RealizarPagoDTO;

public interface RealizarPagoDAO {
	public List<RealizarPagoDTO> listarOrdenVenta(int codVenta);
	public RealizarPagoDTO buscarCliente(int codVenta);
	public int actualizarEstado(RealizarPagoDTO obj);

}
