package mx.com.vrm.viai.service.impl;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.vrm.viai.dao.EquipoDetalleDAO;
import mx.com.vrm.viai.model.NctEqmt;
import mx.com.vrm.viai.model.NctEqmtDtl;
import mx.com.vrm.viai.service.EquipoDetalleService;

@Service
@Transactional
public class EquipoDetalleServiceImpl implements EquipoDetalleService {

	
	@Autowired
	EquipoDetalleDAO equipoDetalleDAO;

	@Override
	public NctEqmtDtl consultaDetalleEquipo(NctEqmt nctEqmtDtl) throws SQLException {
		return equipoDetalleDAO.obtenerEquipo(nctEqmtDtl);
	}


	@Override
	public void eliminaDetalleEquipo(NctEqmtDtl nctEqmtDtl) {
		equipoDetalleDAO.eliminaEquipoDetalle(nctEqmtDtl);
		
	}


	@Override
	public void crearDetalleEquipo(NctEqmtDtl nctEqmtDtl) {
		equipoDetalleDAO.crearDetalleEquipo(nctEqmtDtl);
		
	}

}
