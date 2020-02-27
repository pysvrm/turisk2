package mx.com.vrm.viai.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.vrm.viai.dao.EquipoDAO;
import mx.com.vrm.viai.dao.EstacionDAO;
import mx.com.vrm.viai.dto.EstacionDTO;
import mx.com.vrm.viai.service.EstacionService;

@Service
@Transactional
public class  EstacionServiceImpl implements EstacionService {

	@Autowired
	EstacionDAO estacionDAO;
	
	@Override
	public EstacionDTO consultaEstacionPorC7(String stacionc7) {
		
		return estacionDAO.consultaEstacionPorC7(stacionc7);
	}

}
