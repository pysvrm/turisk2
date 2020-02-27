package mx.com.vrm.viai.dto;

import org.springframework.stereotype.Component;

@Component
public class EstacionDTO {

	String cir7 ="";
	String stationId ="";
	
	public String getCir7() {
		return cir7;
	}
	public void setCir7(String cir7) {
		this.cir7 = cir7;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	
	
}
