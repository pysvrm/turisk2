package mx.com.vrm.turisk.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TrenInboundResourceDTO {

	String idTren;
	String idTrenDelete;
	String tren;
	Date fecha;
	boolean duplicado =false;
	
	public String getTren() {
		return tren;
	}
	public void setTren(String tren) {
		this.tren = tren;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getIdTren() {
		return idTren;
	}
	public void setIdTren(String idTren) {
		this.idTren = idTren;
	}
	public String getIdTrenDelete() {
		return idTrenDelete;
	}
	public void setIdTrenDelete(String idTrenDelete) {
		this.idTrenDelete = idTrenDelete;
	}
	public boolean isDuplicado() {
		return duplicado;
	}
	public void setDuplicado(boolean duplicado) {
		this.duplicado = duplicado;
	}
	
	
	
}
