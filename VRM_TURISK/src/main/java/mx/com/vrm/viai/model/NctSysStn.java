package mx.com.vrm.viai.model;

import java.io.Serializable;
import javax.persistence.*;

import mx.com.vrm.viai.model.NctInbdResr;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the NCT_SYS_STN database table.
 * 
 */
@Entity
@Table(name="NCT_SYS_STN")
@NamedQuery(name="NctSysStn.findAll", query="SELECT n FROM NctSysStn n")
public class NctSysStn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SYS_STN_ID")
	private long sysStnId;

	@Temporal(TemporalType.DATE)
	@Column(name="CRTN_DT")
	private Date crtnDt;

	@Column(name="CRTN_USER_ID")
	private String crtnUserId;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPTD_DT")
	private Date lastUptdDt;

	@Column(name="LAST_UPTD_USER_ID")
	private String lastUptdUserId;

	@Column(name="STN_CRC7_CODE")
	private String stnCrc7Code;

	@Column(name="TML_AREA_SYS_ID")
	private BigDecimal tmlAreaSysId;

	@Column(name="VRSN_NBR")
	private BigDecimal vrsnNbr;

	//bi-directional many-to-one association to NctInbdResr
	@OneToMany(mappedBy="nctSysStn")
	private List<NctInbdResr> nctInbdResrs;

	public NctSysStn() {
	}

	public long getSysStnId() {
		return this.sysStnId;
	}

	public void setSysStnId(long sysStnId) {
		this.sysStnId = sysStnId;
	}

	public Date getCrtnDt() {
		return this.crtnDt;
	}

	public void setCrtnDt(Date crtnDt) {
		this.crtnDt = crtnDt;
	}

	public String getCrtnUserId() {
		return this.crtnUserId;
	}

	public void setCrtnUserId(String crtnUserId) {
		this.crtnUserId = crtnUserId;
	}

	public Date getLastUptdDt() {
		return this.lastUptdDt;
	}

	public void setLastUptdDt(Date lastUptdDt) {
		this.lastUptdDt = lastUptdDt;
	}

	public String getLastUptdUserId() {
		return this.lastUptdUserId;
	}

	public void setLastUptdUserId(String lastUptdUserId) {
		this.lastUptdUserId = lastUptdUserId;
	}

	public String getStnCrc7Code() {
		return this.stnCrc7Code;
	}

	public void setStnCrc7Code(String stnCrc7Code) {
		this.stnCrc7Code = stnCrc7Code;
	}

	public BigDecimal getTmlAreaSysId() {
		return this.tmlAreaSysId;
	}

	public void setTmlAreaSysId(BigDecimal tmlAreaSysId) {
		this.tmlAreaSysId = tmlAreaSysId;
	}

	public BigDecimal getVrsnNbr() {
		return this.vrsnNbr;
	}

	public void setVrsnNbr(BigDecimal vrsnNbr) {
		this.vrsnNbr = vrsnNbr;
	}

	public List<NctInbdResr> getNctInbdResrs() {
		return this.nctInbdResrs;
	}

	public void setNctInbdResrs(List<NctInbdResr> nctInbdResrs) {
		this.nctInbdResrs = nctInbdResrs;
	}

	public NctInbdResr addNctInbdResr(NctInbdResr nctInbdResr) {
		getNctInbdResrs().add(nctInbdResr);
		nctInbdResr.setNctSysStn(this);

		return nctInbdResr;
	}

	public NctInbdResr removeNctInbdResr(NctInbdResr nctInbdResr) {
		getNctInbdResrs().remove(nctInbdResr);
		nctInbdResr.setNctSysStn(null);

		return nctInbdResr;
	}

}