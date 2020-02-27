package mx.com.vrm.viai.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import mx.com.vrm.viai.configuration.crudmngImpl.CrudDataManagerImpl;
import mx.com.vrm.viai.dao.EstacionDAO;
import mx.com.vrm.viai.dto.EstacionDTO;
import mx.com.vrm.viai.model.NctSysStn;

@Repository
public class EstacionDAOImpl extends CrudDataManagerImpl<NctSysStn, Serializable> implements EstacionDAO {

	private static final Logger logger = LoggerFactory.getLogger(EstacionDAOImpl.class);
	public NctSysStn estacion = new NctSysStn();

	@Override
	public EstacionDTO consultaEstacionPorC7(String stacionc7) {
		EstacionDTO estacionDTO = new EstacionDTO();
		try {
			logger.info("Estacion DAO :::"+stacionc7);
			estacion = (NctSysStn) manager
					.createQuery("SELECT n FROM NctSysStn n WHERE n.stnCrc7Code =:stacionc7 ", NctSysStn.class).setParameter("stacionc7", stacionc7).getSingleResult();
			estacionDTO.setCir7(stacionc7);
			estacionDTO.setStationId(String.valueOf(estacion.getSysStnId()));
		} catch (Exception e) {
			logger.error("Error al consultar la estacion::::" + e);
		}

		return estacionDTO;
	}

}
