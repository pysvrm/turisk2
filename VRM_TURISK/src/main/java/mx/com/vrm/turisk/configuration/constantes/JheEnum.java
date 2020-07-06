package mx.com.vrm.viai.configuration.constantes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import mx.com.vrm.viai.dto.EstatusJHEDTO;

public enum JheEnum {
	TERMINAL_AUDIT
	("-Dproject.artifactId=terminal-audit"), 
	TERMINAL_COMMONS(
	"-Dproject.artifactId=terminal-commons"), 
	TERMINAL_EQUIPMENT(
	"-Dproject.artifactId=terminal-equipment"), 
	TERMINAL_INVENTORY(
	"-Dproject.artifactId=terminal-inventory"), 
	TERMINAL_LOCATION(
	"-Dproject.artifactId=terminal-location"), 
	TERMINAL_MANAGMENT_CORE(
	"-Dproject.artifactId=terminal-management-core"), 
	TERMINAL_MANAGMENT_EVENT(
	"-Dproject.artifactId=terminal-management-event"), 
	TERMINAL_MANAGMENT_VIEW(
	"-Dproject.artifactId=terminal-management-view"), 
	TERMINAL_REPORT_BOWL_COMPLIANCE(
	"-Dproject.artifactId=terminal-report-bowl-compliance"), 
	TERMINAL_SICOTRA(
	"-Dproject.artifactId=terminal-sicotra"),
	TERMINAL_CONTROL
	("-Dproject.artifactId=terminal-control"),
	TERMINAL_CORE
	("-Dproject.artifactId=terminal-core"),
	EDIT_CAR_PLACEMENT
	("-Dproject.artifactId=terminal-edit-car-placement"),
	INBOUND_HUMP_ADAPTER
	("-Dproject.artifactId=terminal-process-inbound-hump-adapter"),
	TERMINAL_REPORT
	("-Dproject.artifactId=terminal-report"),
	TERMINAL_SCHEDULER
	("-Dproject.artifactId=terminal-scheduler"),
	TERMINAL_SICOTRA_ROUTER
	("-Dproject.artifactId=terminal-sicotra-router"),
	TERMINAL_TAD_FXE
	("-Dproject.artifactId=terminal-tad-fxe"),
	TERMINAL_TRAIN
	("-Dproject.artifactId=terminal-train")
	;

	private String descripcion = "";

	private JheEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public static List<EstatusJHEDTO> existeJHE(String resultadoServer) {
		List<EstatusJHEDTO> listaProcesos = new ArrayList<EstatusJHEDTO>();

		if (resultadoServer != null && !resultadoServer.isEmpty()) {
			for (JheEnum jheValue : JheEnum.values()) {
				EstatusJHEDTO procesoJhe = new EstatusJHEDTO();
				if (resultadoServer.contains(jheValue.getDescripcion())) {
					procesoJhe.setTmiProces(jheValue.getDescripcion());
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

	public static List<EstatusJHEDTO> getDetalleProceso(List<EstatusJHEDTO> procesosIdentificados,
			String resultadoServer, String server) {
		List<EstatusJHEDTO> listaProcesosDetallados = new ArrayList<EstatusJHEDTO>();
		Reader inputString = new StringReader(resultadoServer);
		BufferedReader inFromUser = new BufferedReader(inputString);
		String linea;
		try {
			while ((linea = inFromUser.readLine()) != null) {
				if (!linea.trim().equals("")) {
					for (EstatusJHEDTO estatusJhe : procesosIdentificados) {
						if (linea.contains(estatusJhe.getTmiProces())) {
							estatusJhe.setPid(linea.substring(10, 14).trim());
							estatusJhe.setCpu(linea.substring(16, 21).trim());
							estatusJhe.setMem(linea.substring(22, 27).trim());
							estatusJhe.setTime(linea.substring(28, 35).trim());
							estatusJhe.setTmiProces(estatusJhe.getTmiProces().replaceAll("-Dproject.artifactId=", ""));
							estatusJhe.setServer(server);
							listaProcesosDetallados.add(estatusJhe);
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
