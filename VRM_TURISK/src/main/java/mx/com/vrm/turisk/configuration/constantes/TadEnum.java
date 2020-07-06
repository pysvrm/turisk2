package mx.com.vrm.viai.configuration.constantes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import mx.com.vrm.viai.dto.EstatusJHEDTO;
import mx.com.vrm.viai.dto.EstatusTADDTO;

public enum TadEnum {
	BCJMSREQ("bcjmsreq.sic.sh"),
	BUJMSREQ("bujmsreq.sic.sh")	,
	CSJMSREQ("csjmsreq.sic.sh")	,
	CTJMSREQ("ctjmsreq.sic.sh")	,
	DBJMSREQ("dbjmsreq.sic.sh")	,
	EJJMSREQ("ejjmsreq.sic.sh")	,
	EYJMSREQ("eyjmsreq.sic.sh")	,
	FSJMSREQ("fsjmsreq.sic.sh")	,
	GENTCSJMS_GW_SH("genTCSJMS.gw.sh"),
	GENTCSJMS("genTCSJMS.sic.sh"),
	GHJMSREQ("ghjmsreq.sic.sh"),
	GIJMSREQ("gijmsreq.sic.sh"),
	IDJMSREQ("idjmsreq.sic.sh"),
	IRJMSREQ("irjmsreq.sic.sh"),
	JTJMSREQ("jtjmsreq.sic.sh"),
	MIJMSREQ("mijmsreq.sic.sh"),
	MPJMSREQ("mpjmsreq.sic.sh"),
	MRJMSREQ("mrjmsreq.sic.sh"),
	O418JMSREQ("o418jmsreq.sic.sh"),
	PCJMSREQ("pcjmsreq.sic.sh"),
	RAJMSREQ("rajmsreq.sic.sh"),
	RHJMSREQ("rhjmsreq.sic.sh"),
	RKJMSREQ("rkjmsreq.sic.sh"),
	RYJMSREQ("ryjmsreq.sic.sh"),
	SCJMSREQ("scjmsreq.sic.sh"),
	X3JMSREQ("x3jmsreq.sic.sh"),
	X99JMSREQ("x99jmsreq.sic.sh"),
	XBTJMSREQ("xbtjmsreq.sic.sh"),
	XCIJMSREQ("xcijmsreq.sic.sh"),
	XPIJMSREQ("xpijmsreq.sic.sh"),
	XPSJMSREQ("xpsjmsreq.sic.sh"),
	XSTJMSREQ("xstjmsreq.sic.sh"),
	XSWJMSREQ("xswjmsreq.sic.sh"),
	XTIJMSREQ("xtijmsreq.sic.sh"),
	XTLJMSREQ("xtljmsreq.sic.sh"),
	XYPJMSREQ("xypjmsreq.sic.sh"),
	YCJMSREQ("ycjmsreq.sic.sh"),
	YDJMSREQ("ydjmsreq.sic.sh"),
	YDWJMSREQ("ydwjmsreq.sic.sh"),
	YE6JMSREQ("ye6jmsreq.sic.sh"),
	YIJMSREQ("yijmsreq.sic.sh"),
	YPIJMSREQ("ypijmsreq.sic.sh"),
	YR8JMSREQ("yr8jmsreq.sic.sh"),
	YS8JMSREQ("ys8jmsreq.sic.sh"),
	YTZJMSREQ("ytzjmsreq.sic.sh"),
	;

	private String descripcion = "";

	private TadEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public static List<EstatusTADDTO> existeTAD(String resultadoServer) {
		List<EstatusTADDTO> listaProcesos = new ArrayList<EstatusTADDTO>();

		if (resultadoServer != null && !resultadoServer.isEmpty()) {
			for (TadEnum tadValue : TadEnum.values()) {
				EstatusTADDTO procesoJhe = new EstatusTADDTO();
				if (resultadoServer.contains(tadValue .getDescripcion())) {
					procesoJhe.setTadProces(tadValue .getDescripcion());
					procesoJhe.setStatus(true);
					listaProcesos.add(procesoJhe);
				}
			}
		}
		return listaProcesos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static List<EstatusTADDTO> getDetalleProceso(List<EstatusTADDTO> procesosIdentificados,
			String resultadoServer, String server) {
		List<EstatusTADDTO> listaProcesosDetallados = new ArrayList<EstatusTADDTO>();
		Reader inputString = new StringReader(resultadoServer);
		BufferedReader inFromUser = new BufferedReader(inputString);
		String linea;
		try {
			while ((linea = inFromUser.readLine()) != null) {
				if (!linea.trim().equals("")) {
					for (EstatusTADDTO estatusTad : procesosIdentificados) {
						if (linea.contains(estatusTad.getTadProces())) {
							estatusTad.setPid(linea.substring(0, 19).trim());
							estatusTad.setMem(linea.substring(20, 27).trim());
							estatusTad.setTime(linea.substring(28, 36).trim());
							estatusTad.setTadProces(estatusTad.getTadProces().replaceAll(".sic.sh", ""));
							estatusTad.setServer(server);
							listaProcesosDetallados.add(estatusTad);
						}
					}
				}
			}
		} catch (IOException e) {
			System.out.println("error" + e);
			e.printStackTrace();
		}
		return listaProcesosDetallados;
	}

}
