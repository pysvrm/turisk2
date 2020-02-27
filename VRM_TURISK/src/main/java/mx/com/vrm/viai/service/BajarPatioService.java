package mx.com.vrm.viai.service;

import java.util.Date;
import java.util.List;

import mx.com.vrm.viai.dto.EstacionDTO;
import mx.com.vrm.viai.dto.TrenInboundResourceDTO;
import mx.com.vrm.viai.model.NctInbdResr;

public interface BajarPatioService {

	public TrenInboundResourceDTO consultarTrenBajarPatio(String tren, String fecha, String inbdResrDt);
	public List<NctInbdResr> consultarTrenesRepetidosBajarPatio(String tren, Date fecha);
	public void eliminarTrenBajarPatio(String idTren, String tren, Date fecha);
}
