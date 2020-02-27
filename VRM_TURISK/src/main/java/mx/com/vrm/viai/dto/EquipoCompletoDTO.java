package mx.com.vrm.viai.dto;

import mx.com.vrm.viai.model.NctEqmt;
import mx.com.vrm.viai.model.NctEqmtDtl;

public class EquipoCompletoDTO {

	public NctEqmt equipo = new NctEqmt();
	public NctEqmtDtl equipoDetalle = new NctEqmtDtl();
	
	public NctEqmt getEquipo() {
		return equipo;
	}
	public void setEquipo(NctEqmt equipo) {
		this.equipo = equipo;
	}
	public NctEqmtDtl getEquipoDetalle() {
		return equipoDetalle;
	}
	public void setEquipoDetalle(NctEqmtDtl equipoDetalle) {
		this.equipoDetalle = equipoDetalle;
	}
	
	
}
