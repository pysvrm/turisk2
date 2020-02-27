package mx.com.vrm.viai.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the NCT_EQMT database table.
 * 
 */
@Entity
@Table(name="NCT_EQMT")
@NamedQuery(name="NctEqmt.findAll", query="SELECT n FROM NctEqmt n")
public class NctEqmt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EQMT_ID")
	private long eqmtId;

	@Temporal(TemporalType.DATE)
	@Column(name="CRTN_DT")
	private Date crtnDt;

	@Column(name="CRTN_USER_ID")
	private String crtnUserId;

	@Column(name="EQMT_INIT")
	private String eqmtInit;

	@Column(name="EQMT_NBR")
	private BigDecimal eqmtNbr;

	@Column(name="EQMT_TYPE")
	private String eqmtType;

	@Column(name="HUMP_CNT")
	private BigDecimal humpCnt;

	@Column(name="HUMP_LEAD_MOVE_CNT")
	private BigDecimal humpLeadMoveCnt;

	@Temporal(TemporalType.DATE)
	@Column(name="IC_DLVY_DATE")
	private Date icDlvyDate;

	@Column(name="IC_DLVY_SCAC")
	private String icDlvyScac;

	@Column(name="IC_DLVY_SYS_STN_ID")
	private BigDecimal icDlvySysStnId;

	@Temporal(TemporalType.DATE)
	@Column(name="INBD_RESR_DT")
	private Date inbdResrDt;

	@Column(name="INBD_RESR_ID")
	private BigDecimal inbdResrId;

	@Column(name="INBD_RESR_SYMB")
	private String inbdResrSymb;

	@Column(name="INBD_RESR_TYPE")
	private String inbdResrType;

	@Column(name="INBD_SEQ_NBR")
	private BigDecimal inbdSeqNbr;

	@Column(name="LAST_KNWN_STN_ID")
	private BigDecimal lastKnwnStnId;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPTD_DT")
	private Date lastUptdDt;

	@Column(name="LAST_UPTD_USER_ID")
	private String lastUptdUserId;

	@Temporal(TemporalType.DATE)
	@Column(name="MAKE_TRN_DT")
	private Date makeTrnDt;

	@Column(name="MAKE_TRN_SCTN_ID")
	private String makeTrnSctnId;

	@Column(name="MAKE_TRN_SYMB")
	private String makeTrnSymb;

	@Column(name="MRTE_CODE")
	private String mrteCode;

	@Column(name="MSNG_CAR_SEQ_NBR")
	private BigDecimal msngCarSeqNbr;

	@Temporal(TemporalType.DATE)
	@Column(name="MSNG_STAT_DATE")
	private Date msngStatDate;

	@Column(name="NON_WKLS_EQMT_MOVE_CNT")
	private BigDecimal nonWklsEqmtMoveCnt;

	@Column(name="PREV_TRK_ID")
	private BigDecimal prevTrkId;

	@Temporal(TemporalType.DATE)
	@Column(name="SET_TRN_DT")
	private Date setTrnDt;

	@Column(name="SET_TRN_SCTN_ID")
	private String setTrnSctnId;

	@Column(name="SET_TRN_SYMB")
	private String setTrnSymb;

	@Temporal(TemporalType.DATE)
	@Column(name="STN_ARVL_DT")
	private Date stnArvlDt;

	@Column(name="SYS_STN_ID")
	private BigDecimal sysStnId;

	@Column(name="TEM_EQMT_TYPE")
	private String temEqmtType;

	@Temporal(TemporalType.DATE)
	@Column(name="TML_ARVL_DT")
	private Date tmlArvlDt;

	@Temporal(TemporalType.DATE)
	@Column(name="TRK_ARVL_DT")
	private Date trkArvlDt;

	@Column(name="TRK_ID")
	private BigDecimal trkId;

	@Column(name="TRK_SEQ_NBR")
	private BigDecimal trkSeqNbr;

	@Column(name="VRSN_NBR")
	private BigDecimal vrsnNbr;

	@Column(name="WKLS_EQMT_MOVE_CNT")
	private BigDecimal wklsEqmtMoveCnt;

	@Temporal(TemporalType.DATE)
	@Column(name="YARD_ARVL_DATE")
	private Date yardArvlDate;

	public NctEqmt() {
	}

	public long getEqmtId() {
		return this.eqmtId;
	}

	public void setEqmtId(long eqmtId) {
		this.eqmtId = eqmtId;
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

	public String getEqmtInit() {
		return this.eqmtInit;
	}

	public void setEqmtInit(String eqmtInit) {
		this.eqmtInit = eqmtInit;
	}

	public BigDecimal getEqmtNbr() {
		return this.eqmtNbr;
	}

	public void setEqmtNbr(BigDecimal eqmtNbr) {
		this.eqmtNbr = eqmtNbr;
	}

	public String getEqmtType() {
		return this.eqmtType;
	}

	public void setEqmtType(String eqmtType) {
		this.eqmtType = eqmtType;
	}

	public BigDecimal getHumpCnt() {
		return this.humpCnt;
	}

	public void setHumpCnt(BigDecimal humpCnt) {
		this.humpCnt = humpCnt;
	}

	public BigDecimal getHumpLeadMoveCnt() {
		return this.humpLeadMoveCnt;
	}

	public void setHumpLeadMoveCnt(BigDecimal humpLeadMoveCnt) {
		this.humpLeadMoveCnt = humpLeadMoveCnt;
	}

	public Date getIcDlvyDate() {
		return this.icDlvyDate;
	}

	public void setIcDlvyDate(Date icDlvyDate) {
		this.icDlvyDate = icDlvyDate;
	}

	public String getIcDlvyScac() {
		return this.icDlvyScac;
	}

	public void setIcDlvyScac(String icDlvyScac) {
		this.icDlvyScac = icDlvyScac;
	}

	public BigDecimal getIcDlvySysStnId() {
		return this.icDlvySysStnId;
	}

	public void setIcDlvySysStnId(BigDecimal icDlvySysStnId) {
		this.icDlvySysStnId = icDlvySysStnId;
	}

	public Date getInbdResrDt() {
		return this.inbdResrDt;
	}

	public void setInbdResrDt(Date inbdResrDt) {
		this.inbdResrDt = inbdResrDt;
	}

	public BigDecimal getInbdResrId() {
		return this.inbdResrId;
	}

	public void setInbdResrId(BigDecimal inbdResrId) {
		this.inbdResrId = inbdResrId;
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

	public BigDecimal getInbdSeqNbr() {
		return this.inbdSeqNbr;
	}

	public void setInbdSeqNbr(BigDecimal inbdSeqNbr) {
		this.inbdSeqNbr = inbdSeqNbr;
	}

	public BigDecimal getLastKnwnStnId() {
		return this.lastKnwnStnId;
	}

	public void setLastKnwnStnId(BigDecimal lastKnwnStnId) {
		this.lastKnwnStnId = lastKnwnStnId;
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

	public Date getMakeTrnDt() {
		return this.makeTrnDt;
	}

	public void setMakeTrnDt(Date makeTrnDt) {
		this.makeTrnDt = makeTrnDt;
	}

	public String getMakeTrnSctnId() {
		return this.makeTrnSctnId;
	}

	public void setMakeTrnSctnId(String makeTrnSctnId) {
		this.makeTrnSctnId = makeTrnSctnId;
	}

	public String getMakeTrnSymb() {
		return this.makeTrnSymb;
	}

	public void setMakeTrnSymb(String makeTrnSymb) {
		this.makeTrnSymb = makeTrnSymb;
	}

	public String getMrteCode() {
		return this.mrteCode;
	}

	public void setMrteCode(String mrteCode) {
		this.mrteCode = mrteCode;
	}

	public BigDecimal getMsngCarSeqNbr() {
		return this.msngCarSeqNbr;
	}

	public void setMsngCarSeqNbr(BigDecimal msngCarSeqNbr) {
		this.msngCarSeqNbr = msngCarSeqNbr;
	}

	public Date getMsngStatDate() {
		return this.msngStatDate;
	}

	public void setMsngStatDate(Date msngStatDate) {
		this.msngStatDate = msngStatDate;
	}

	public BigDecimal getNonWklsEqmtMoveCnt() {
		return this.nonWklsEqmtMoveCnt;
	}

	public void setNonWklsEqmtMoveCnt(BigDecimal nonWklsEqmtMoveCnt) {
		this.nonWklsEqmtMoveCnt = nonWklsEqmtMoveCnt;
	}

	public BigDecimal getPrevTrkId() {
		return this.prevTrkId;
	}

	public void setPrevTrkId(BigDecimal prevTrkId) {
		this.prevTrkId = prevTrkId;
	}

	public Date getSetTrnDt() {
		return this.setTrnDt;
	}

	public void setSetTrnDt(Date setTrnDt) {
		this.setTrnDt = setTrnDt;
	}

	public String getSetTrnSctnId() {
		return this.setTrnSctnId;
	}

	public void setSetTrnSctnId(String setTrnSctnId) {
		this.setTrnSctnId = setTrnSctnId;
	}

	public String getSetTrnSymb() {
		return this.setTrnSymb;
	}

	public void setSetTrnSymb(String setTrnSymb) {
		this.setTrnSymb = setTrnSymb;
	}

	public Date getStnArvlDt() {
		return this.stnArvlDt;
	}

	public void setStnArvlDt(Date stnArvlDt) {
		this.stnArvlDt = stnArvlDt;
	}

	public BigDecimal getSysStnId() {
		return this.sysStnId;
	}

	public void setSysStnId(BigDecimal sysStnId) {
		this.sysStnId = sysStnId;
	}

	public String getTemEqmtType() {
		return this.temEqmtType;
	}

	public void setTemEqmtType(String temEqmtType) {
		this.temEqmtType = temEqmtType;
	}

	public Date getTmlArvlDt() {
		return this.tmlArvlDt;
	}

	public void setTmlArvlDt(Date tmlArvlDt) {
		this.tmlArvlDt = tmlArvlDt;
	}

	public Date getTrkArvlDt() {
		return this.trkArvlDt;
	}

	public void setTrkArvlDt(Date trkArvlDt) {
		this.trkArvlDt = trkArvlDt;
	}

	public BigDecimal getTrkId() {
		return this.trkId;
	}

	public void setTrkId(BigDecimal trkId) {
		this.trkId = trkId;
	}

	public BigDecimal getTrkSeqNbr() {
		return this.trkSeqNbr;
	}

	public void setTrkSeqNbr(BigDecimal trkSeqNbr) {
		this.trkSeqNbr = trkSeqNbr;
	}

	public BigDecimal getVrsnNbr() {
		return this.vrsnNbr;
	}

	public void setVrsnNbr(BigDecimal vrsnNbr) {
		this.vrsnNbr = vrsnNbr;
	}

	public BigDecimal getWklsEqmtMoveCnt() {
		return this.wklsEqmtMoveCnt;
	}

	public void setWklsEqmtMoveCnt(BigDecimal wklsEqmtMoveCnt) {
		this.wklsEqmtMoveCnt = wklsEqmtMoveCnt;
	}

	public Date getYardArvlDate() {
		return this.yardArvlDate;
	}

	public void setYardArvlDate(Date yardArvlDate) {
		this.yardArvlDate = yardArvlDate;
	}

}