package mx.com.vrm.viai.dao;

import java.util.Date;
import java.util.List;

import mx.com.vrm.viai.dto.TrenInboundResourceDTO;
import mx.com.vrm.viai.model.NctInbdResr;

public interface BajarPatioDAO {

	public TrenInboundResourceDTO consultarTrenBajarPatio(String tren, String fecha, String inbdResrDt);
	public List<NctInbdResr> consultarTrenesRepetidosBajarPatio(String tren, Date fecha);
	public void eliminarTrenBajarPatio(String idTren, String tren, Date fecha);
}
