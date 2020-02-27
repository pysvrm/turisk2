package mx.com.vrm.viai.dao.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import mx.com.vrm.viai.configuration.crudmngImpl.CrudDataManagerImpl;
import mx.com.vrm.viai.configuration.util.FechaUtil;
import mx.com.vrm.viai.dao.BajarPatioDAO;
import mx.com.vrm.viai.dto.TrenInboundResourceDTO;
import mx.com.vrm.viai.model.NctInbdResr;
import mx.com.vrm.viai.model.NctSysStn;

@Repository
public class BajarPatioDAOImpl extends CrudDataManagerImpl<NctInbdResr, Serializable> implements BajarPatioDAO {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(BajarPatioDAOImpl.class);

	public NctInbdResr nctInbdResr = new NctInbdResr();
	public List<NctInbdResr> listaNctInbdResr = new ArrayList<NctInbdResr>();

	@Override
	public TrenInboundResourceDTO consultarTrenBajarPatio(String tren, String fecha, String inbdResrDt) {
		TrenInboundResourceDTO trenInboundResourceDTO = new TrenInboundResourceDTO();
		try {
			logger.info("tren DAO::" + tren);
			logger.info("fectren DAO:::" + fecha);
			NctSysStn claveEstacion = new NctSysStn();
			
			
			claveEstacion.setSysStnId(Long.valueOf(inbdResrDt));
			listaNctInbdResr = manager.createQuery(
					"SELECT rr FROM NctInbdResr rr WHERE rr.inbdResrSymb = :tren AND inbdResrDt = :fectren AND rr.nctSysStn=:inbound ORDER BY rr.inbdResrSymb DESC ",NctInbdResr.class)
					.setParameter("tren", tren)
					.setParameter("fectren", new SimpleDateFormat("dd-MM-yyyy").parse(fecha))
					.setParameter("inbound", claveEstacion).getResultList();
			logger.info("NUMERO DE TRENES OBTENIDOS::" + listaNctInbdResr.size());
			
			if(listaNctInbdResr.size()>1) {
				trenInboundResourceDTO.setDuplicado(true);
				trenInboundResourceDTO.setIdTrenDelete((String.valueOf(listaNctInbdResr.get(1).getInbdResrId())));
			}
			trenInboundResourceDTO.setIdTren(String.valueOf(listaNctInbdResr.get(0).getInbdResrId()));
			trenInboundResourceDTO.setTren(String.valueOf(listaNctInbdResr.get(0).getInbdResrSymb()));
			trenInboundResourceDTO.setFecha(
					FechaUtil.obtenerFechaFromStringDDMMYYYY(String.valueOf(listaNctInbdResr.get(0).getInbdResrDt())));
		} catch (Exception e) {
			logger.error("Error al consultar la estación" + e);
		}
		return trenInboundResourceDTO;
	}

	@Override
	public List<NctInbdResr> consultarTrenesRepetidosBajarPatio(String tren, Date fecha) {

		try {
			listaNctInbdResr = manager.createQuery(
					"SELECT rr FROM NctInbdResr rr WHERE rr.inbdResrSymb = ?1 AND inbdResrDt = ?2 ORDER BY rr.inbdResrSymb DESC ",
					NctInbdResr.class).setParameter(1, tren).setParameter(2, fecha).getResultList();
			logger.info("NUMERO DE TRENES OBTENIDOS::" + listaNctInbdResr.size());

		} catch (Exception e) {
			logger.error("Error al consultar la estación" + e);
		}
		return listaNctInbdResr;
	}

	public void eliminarTrenBajarPatio(String idTren, String tren, Date fecha) {
		NctInbdResr nctInbdResr = new NctInbdResr();
		nctInbdResr.setInbdResrId(Long.valueOf(idTren));
		nctInbdResr.setInbdResrSymb(tren);
		nctInbdResr.setLastUptdDt(fecha);
		this.delete(nctInbdResr);
	}

}
