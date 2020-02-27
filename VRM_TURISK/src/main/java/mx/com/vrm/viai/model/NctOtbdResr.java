package mx.com.vrm.viai.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the NCT_OTBD_RESR database table.
 * 
 */
@Entity
@Table(name="NCT_OTBD_RESR")
@NamedQuery(name="NctOtbdResr.findAll", query="SELECT n FROM NctOtbdResr n")
public class NctOtbdResr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="OTBD_RESR_ID")
	private long otbdResrId;

	@Column(name="ALLW_AUTO_TS_FLAG")
	private String allwAutoTsFlag;

	@Temporal(TemporalType.DATE)
	@Column(name="CRTN_DT")
	private Date crtnDt;

	@Column(name="CRTN_USER_ID")
	private String crtnUserId;

	@Column(name="DEP_DIR_CODE")
	private String depDirCode;

	@Column(name="DSPL_DIR_CODE")
	private String dsplDirCode;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPTD_DT")
	private Date lastUptdDt;

	@Column(name="LAST_UPTD_USER_ID")
	private String lastUptdUserId;

	@Temporal(TemporalType.DATE)
	@Column(name="OTBD_RESR_DT")
	private Date otbdResrDt;

	@Column(name="OTBD_RESR_SCTN_ID")
	private String otbdResrSctnId;

	@Column(name="OTBD_RESR_SEQ_NBR")
	private BigDecimal otbdResrSeqNbr;

	@Column(name="OTBD_RESR_SYMB")
	private String otbdResrSymb;

	@Column(name="SCND_DIR_CODE")
	private String scndDirCode;

	@Column(name="TRN_SET_FLAG")
	private String trnSetFlag;

	public NctOtbdResr() {
	}

	public long getOtbdResrId() {
		return this.otbdResrId;
	}

	public void setOtbdResrId(long otbdResrId) {
		this.otbdResrId = otbdResrId;
	}

	public String getAllwAutoTsFlag() {
		return this.allwAutoTsFlag;
	}

	public void setAllwAutoTsFlag(String allwAutoTsFlag) {
		this.allwAutoTsFlag = allwAutoTsFlag;
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

	public String getDepDirCode() {
		return this.depDirCode;
	}

	public void setDepDirCode(String depDirCode) {
		this.depDirCode = depDirCode;
	}

	public String getDsplDirCode() {
		return this.dsplDirCode;
	}

	public void setDsplDirCode(String dsplDirCode) {
		this.dsplDirCode = dsplDirCode;
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

	public Date getOtbdResrDt() {
		return this.otbdResrDt;
	}

	public void setOtbdResrDt(Date otbdResrDt) {
		this.otbdResrDt = otbdResrDt;
	}

	public String getOtbdResrSctnId() {
		return this.otbdResrSctnId;
	}

	public void setOtbdResrSctnId(String otbdResrSctnId) {
		this.otbdResrSctnId = otbdResrSctnId;
	}

	public BigDecimal getOtbdResrSeqNbr() {
		return this.otbdResrSeqNbr;
	}

	public void setOtbdResrSeqNbr(BigDecimal otbdResrSeqNbr) {
		this.otbdResrSeqNbr = otbdResrSeqNbr;
	}

	public String getOtbdResrSymb() {
		return this.otbdResrSymb;
	}

	public void setOtbdResrSymb(String otbdResrSymb) {
		this.otbdResrSymb = otbdResrSymb;
	}

	public String getScndDirCode() {
		return this.scndDirCode;
	}

	public void setScndDirCode(String scndDirCode) {
		this.scndDirCode = scndDirCode;
	}

	public String getTrnSetFlag() {
		return this.trnSetFlag;
	}

	public void setTrnSetFlag(String trnSetFlag) {
		this.trnSetFlag = trnSetFlag;
	}

}