package mx.com.vrm.viai.dto;

import org.springframework.stereotype.Component;

@Component
public class EstatusJHEDTO {

	String user ="";
	String pid ="";
	String cpu ="";
	String mem ="";
	String time ="";
	String tmiProces ="";
	String stringStatus = "";
	String server ="";
	String activeProces="";
	
	boolean status = false;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getMem() {
		return mem;
	}
	public void setMem(String mem) {
		this.mem = mem;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTmiProces() {
		return tmiProces;
	}
	public void setTmiProces(String tmiProces) {
		this.tmiProces = tmiProces;
	}
	public String getStringStatus() {
		return stringStatus;
	}
	public void setStringStatus(String stringStatus) {
		this.stringStatus = stringStatus;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getActiveProces() {
		return activeProces;
	}
	public void setActiveProces(String activeProces) {
		this.activeProces = activeProces;
	}
	
	
	
}
