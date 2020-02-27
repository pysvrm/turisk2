package mx.com.vrm.viai.dao;

import java.sql.SQLException;

import mx.com.vrm.viai.dto.EquipoCompletoDTO;
import mx.com.vrm.viai.model.NctEqmt;

public interface EquipoDAO {
	
	public void eliminaEquipo(NctEqmt nctEqmt) throws SQLException;
	public void crearEquipo(NctEqmt nctEqmt);
	public void actualizaInbrsTren(NctEqmt nctEqmt);
	public NctEqmt obtenerEquipo(NctEqmt nctEqmt) throws SQLException;
	public String obtenerListaRepetidos(String tren, String fechaTren) throws SQLException;

}
