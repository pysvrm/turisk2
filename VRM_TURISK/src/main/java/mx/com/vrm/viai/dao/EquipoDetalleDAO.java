package mx.com.vrm.viai.dao;

import java.sql.SQLException;

import mx.com.vrm.viai.dto.EquipoCompletoDTO;
import mx.com.vrm.viai.model.NctEqmt;
import mx.com.vrm.viai.model.NctEqmtDtl;

public interface EquipoDetalleDAO {
	
	public void consultaEquipoDetalle (NctEqmtDtl nctEqmt);
	
	public void eliminaEquipoDetalle (NctEqmtDtl nctEqmt);
	
	public void crearDetalleEquipo (NctEqmtDtl nctEqmtDtl);
	
	public NctEqmtDtl obtenerEquipo(NctEqmt nctEqmt) throws SQLException;
}
