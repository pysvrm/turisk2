package mx.com.vrm.viai.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.vrm.viai.dao.BajarPatioDAO;
import mx.com.vrm.viai.dto.TrenInboundResourceDTO;
import mx.com.vrm.viai.model.NctInbdResr;
import mx.com.vrm.viai.service.BajarPatioService;

@Service
@Transactional
public class BajarPatioServiceImpl implements BajarPatioService {

	@Autowired
	BajarPatioDAO bajarPatioDAO;

	@Override
	public TrenInboundResourceDTO consultarTrenBajarPatio(String tren, String fecha, String inbdResrDt) {
		return bajarPatioDAO.consultarTrenBajarPatio(tren, fecha, inbdResrDt);
	}

	@Override
	public List<NctInbdResr> consultarTrenesRepetidosBajarPatio(String tren, Date fecha) {
		// TODO Auto-generated method stub
		return bajarPatioDAO.consultarTrenesRepetidosBajarPatio(tren, fecha);
	}

	@Override
	public void eliminarTrenBajarPatio(String idTren, String tren, Date fecha) {
		// TODO Auto-generated method stub
		bajarPatioDAO.eliminarTrenBajarPatio(idTren, tren, fecha);
	}

}
