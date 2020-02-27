package mx.com.vrm.viai.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the NCT_INBD_RESR database table.
 * 
 */
@Entity
@Table(name="NCT_INBD_RESR")
@NamedQuery(name="NctInbdResr.findAll", query="SELECT n FROM NctInbdResr n")
public class NctInbdResr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INBD_RESR_ID")
	private long inbdResrId;

	@Temporal(TemporalType.DATE)
	@Column(name="CRTN_DT")
	private Date crtnDt;

	@Column(name="CRTN_USER_ID")
	private String crtnUserId;

	@Temporal(TemporalType.DATE)
	@Column(name="INBD_RESR_DT")
	private Date inbdResrDt;

	@Column(name="INBD_RESR_SCTN_ID")
	private String inbdResrSctnId;

	@Column(name="INBD_RESR_SYMB")
	private String inbdResrSymb;

	@Column(name="INBD_RESR_TYPE")
	private String inbdResrType;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPTD_DT")
	private Date lastUptdDt;

	@Column(name="LAST_UPTD_USER_ID")
	private String lastUptdUserId;

	@Column(name="RVSE_ORD_FLAG")
	private String rvseOrdFlag;

	@Column(name="YARD_COMP_IND")
	private String yardCompInd;

	//bi-directional many-to-one association to NctSysStn
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SYS_STN_ID")
	private NctSysStn nctSysStn;

	public NctInbdResr() {
	}

	public long getInbdResrId() {
		return this.inbdResrId;
	}

	public void setInbdResrId(long inbdResrId) {
		this.inbdResrId = inbdResrId;
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

	public Date getInbdResrDt() {
		return this.inbdResrDt;
	}

	public void setInbdResrDt(Date inbdResrDt) {
		this.inbdResrDt = inbdResrDt;
	}

	public String getInbdResrSctnId() {
		return this.inbdResrSctnId;
	}

	public void setInbdResrSctnId(String inbdResrSctnId) {
		this.inbdResrSctnId = inbdResrSctnId;
	}

	public String getInbdResrSymb() {
		return this.inbdResrSymb;
	}

	public void setInbdResrSymb(String inbdResrSymb) {
		this.inbdResrSymb = inbdResrSymb;
	}

	public String getInbdResrType() {
		return this.inbdResrType;
	}

	public void setInbdResrType(String inbdResrType) {
		this.inbdResrType = inbdResrType;
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

	public String getRvseOrdFlag() {
		return this.rvseOrdFlag;
	}

	public void setRvseOrdFlag(String rvseOrdFlag) {
		this.rvseOrdFlag = rvseOrdFlag;
	}

	public String getYardCompInd() {
		return this.yardCompInd;
	}

	public void setYardCompInd(String yardCompInd) {
		this.yardCompInd = yardCompInd;
	}

	public NctSysStn getNctSysStn() {
		return this.nctSysStn;
	}

	public void setNctSysStn(NctSysStn nctSysStn) {
		this.nctSysStn = nctSysStn;
	}

}