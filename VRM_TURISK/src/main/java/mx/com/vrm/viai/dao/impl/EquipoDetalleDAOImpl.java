package mx.com.vrm.viai.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import mx.com.vrm.viai.configuration.crudmngImpl.CrudDataManagerImpl;
import mx.com.vrm.viai.dao.EquipoDetalleDAO;
import mx.com.vrm.viai.model.NctEqmt;
import mx.com.vrm.viai.model.NctEqmtDtl;

@Repository
public class EquipoDetalleDAOImpl extends CrudDataManagerImpl<NctEqmtDtl, Serializable> implements EquipoDetalleDAO {

	@Override
	public void eliminaEquipoDetalle(NctEqmtDtl nctEqmt) {
		delete(nctEqmt);
	}

	@Override
	public void consultaEquipoDetalle(NctEqmtDtl nctEqmt) {
	}

	@Override
	public NctEqmtDtl obtenerEquipo(NctEqmt nctEqmt) throws SQLException {
		NctEqmtDtl nctEqmtDtl = new NctEqmtDtl();
		nctEqmtDtl = manager
		.createQuery("SELECT rr FROM NctEqmtDtl rr WHERE rr.id.eqmtInit = ?1 AND rr.id.eqmtNbr =?2", NctEqmtDtl.class)
		.setParameter(1, nctEqmt.getEqmtInit()).setParameter(2, nctEqmt.getEqmtNbr().longValue()).getResultList().get(0);
		return nctEqmtDtl;
	}

	@Override
	public void crearDetalleEquipo(NctEqmtDtl nctEqmtDtl) {
		this.create(nctEqmtDtl);
	}

	
}
