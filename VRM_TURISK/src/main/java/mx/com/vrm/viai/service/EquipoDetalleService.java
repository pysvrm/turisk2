package mx.com.vrm.viai.service;

import java.sql.SQLException;

import mx.com.vrm.viai.model.NctEqmt;
import mx.com.vrm.viai.model.NctEqmtDtl;

public interface EquipoDetalleService {

	public NctEqmtDtl consultaDetalleEquipo (NctEqmt nctEqmtDtl) throws SQLException;
	public void crearDetalleEquipo (NctEqmtDtl nctEqmtDtl);
	public void eliminaDetalleEquipo (NctEqmtDtl nctEqmtDtl);
	
}
