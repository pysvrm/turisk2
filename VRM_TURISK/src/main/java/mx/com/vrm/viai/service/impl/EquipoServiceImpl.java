package mx.com.vrm.viai.service.impl;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.vrm.viai.dao.EquipoDAO;
import mx.com.vrm.viai.dto.EquipoCompletoDTO;
import mx.com.vrm.viai.model.NctEqmt;
import mx.com.vrm.viai.service.EquipoService;

@Service
@Transactional
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	EquipoDAO equipoDAO;

	public void eliminaEquipo(NctEqmt nctEqmt) throws SQLException {
		equipoDAO.eliminaEquipo(nctEqmt);
	}

	@Override
	public String obtenerListaRepetidos(String tren, String fechaTren) throws SQLException {
		return equipoDAO.obtenerListaRepetidos(tren, fechaTren);
	}


	@Override
	public void crearEquipo(NctEqmt nctEqmt) {
		equipoDAO.crearEquipo(nctEqmt);
	}

	@Override
	public NctEqmt obtenerEquipo(NctEqmt nctEqmt) throws SQLException {
				return equipoDAO.obtenerEquipo(nctEqmt);
	}

	@Override
	public void actualizaInbrsTren(NctEqmt nctEqmt) {
		equipoDAO.actualizaInbrsTren(nctEqmt);
		
	}

}
