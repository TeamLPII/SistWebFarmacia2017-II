package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.CargoDTO;
import interfaces.CargoDAO;
import utils.MysqlDBConexion;

public class MysqlCargoDAO implements CargoDAO {
	
	private final String OBTENERLISTA = "SELECT * FROM Cargo";
	private final String OBTENERCARGO = "SELECT * FROM Cargo WHERE idCargo=?";
	
	Connection cn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;

	@Override
	public List<CargoDTO> listarCargo() {
		CargoDTO cargo = null;
		List<CargoDTO> data = new ArrayList<CargoDTO>();
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(OBTENERLISTA);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				cargo = new CargoDTO();
				cargo.setIdCargo(rs.getInt(1));
				cargo.setNombre(rs.getString(2));
				data.add(cargo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al listar cargo.");
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return data;
	}

	@Override
	public CargoDTO buscarCargo(int cod) {
		CargoDTO cargo = null;
		try {
			cn = MysqlDBConexion.getConexion();
			pstm = cn.prepareStatement(OBTENERCARGO);
			pstm.setInt(1, cod);
			rs = pstm.executeQuery();
			
			if(rs.next()){
				cargo = new CargoDTO();
				cargo.setIdCargo(rs.getInt(1));
				cargo.setNombre(rs.getString(2));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al buscar cargo.");
		}finally {
			MysqlDBConexion.cerrarConexion(cn, pstm, rs);
		}
		return cargo;
	}

}
