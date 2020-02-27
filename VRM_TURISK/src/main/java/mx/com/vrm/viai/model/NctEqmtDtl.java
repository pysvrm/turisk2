package mx.com.vrm.viai.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the NCT_EQMT_DTL database table.
 * 
 */
@Entity
@Table(name="NCT_EQMT_DTL")
@NamedQuery(name="NctEqmtDtl.findAll", query="SELECT n FROM NctEqmtDtl n")
public class NctEqmtDtl implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NctEqmtDtlPK id;

	@Column(name="AAR_TYPE_CD")
	private String aarTypeCd;

	@Temporal(TemporalType.DATE)
	@Column(name="ADJ_MVMT_STAT_DATE")
	private Date adjMvmtStatDate;

	@Column(name="ATCS_DIR_CODE")
	private String atcsDirCode;

	@Column(name="ATCS_SEQ_NBR")
	private String atcsSeqNbr;

	@Column(name="ATCS_TRK")
	private String atcsTrk;

	@Column(name="ATCS_YARD")
	private String atcsYard;

	@Column(name="CAR_KIND")
	private String carKind;

	private String city;

	@Column(name="CMDY_ABRV")
	private String cmdyAbrv;

	@Column(name="CNSE_NAME")
	private String cnseName;

	@Temporal(TemporalType.DATE)
	@Column(name="CRTN_DT")
	private Date crtnDt;

	@Column(name="CRTN_USER_ID")
	private String crtnUserId;

	@Column(name="CUR_CAR_STAT_CODE")
	private String curCarStatCode;

	@Temporal(TemporalType.DATE)
	@Column(name="CUR_DISP_DATE")
	private Date curDispDate;

	@Column(name="DEST_ROAD")
	private String destRoad;

	@Column(name="DEST_SPOT")
	private String destSpot;

	@Column(name="DEST_SYS_STN_ID")
	private BigDecimal destSysStnId;

	@Column(name="DEST_TRK")
	private String destTrk;

	@Column(name="DEST_ZONE")
	private String destZone;

	@Column(name="EVNT_SYS_STN_ID")
	private String evntSysStnId;

	@Column(name="FRN_ACTG_CODE")
	private String frnActgCode;

	@Column(name="GR_WGT")
	private BigDecimal grWgt;

	@Column(name="HOLD_CODE_1")
	private String holdCode1;

	@Column(name="HOLD_CODE_2")
	private String holdCode2;

	@Column(name="HOLD_CODE_3")
	private String holdCode3;

	@Temporal(TemporalType.DATE)
	@Column(name="HOLD_STAT_DATE")
	private Date holdStatDate;

	@Column(name="HZRD_END_CODE")
	private String hzrdEndCode;

	@Column(name="HZRD_MATL_IND")
	private String hzrdMatlInd;

	@Temporal(TemporalType.DATE)
	@Column(name="INBD_ARVL_DATE")
	private Date inbdArvlDate;

	@Column(name="INBD_TIME")
	private String inbdTime;

	@Column(name="INBD_TMZN")
	private String inbdTmzn;

	@Column(name="INDY_PLAC_TIME")
	private String indyPlacTime;

	@Column(name="INDY_SPOT")
	private String indySpot;

	@Column(name="INDY_TRK")
	private String indyTrk;

	@Column(name="INDY_ZONE")
	private String indyZone;

	@Column(name="KMF_IND")
	private String kmfInd;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPTD_DT")
	private Date lastUptdDt;

	@Column(name="LAST_UPTD_USER_ID")
	private String lastUptdUserId;

	@Column(name="LE_CODE")
	private String leCode;

	@Temporal(TemporalType.DATE)
	@Column(name="MVMT_STAT_DATE")
	private Date mvmtStatDate;

	@Column(name="NTER_NTRA_IND")
	private String nterNtraInd;

	@Temporal(TemporalType.DATE)
	@Column(name="OTBD_TRN_DT")
	private Date otbdTrnDt;

	@Column(name="OTBD_TRN_SCTN_ID")
	private String otbdTrnSctnId;

	@Column(name="OTBD_TRN_SYMB")
	private String otbdTrnSymb;

	@Column(name="OUT_CAR_LGTH")
	private BigDecimal outCarLgth;

	@Column(name="REST_1")
	private String rest1;

	@Column(name="REST_1_CODE")
	private String rest1Code;

	@Column(name="REST_2")
	private String rest2;

	@Column(name="REST_2_CODE")
	private String rest2Code;

	@Column(name="ROLR_BRNG_IND")
	private String rolrBrngInd;

	@Column(name="SHPR_NAME")
	private String shprName;

	@Column(name="SPCL_COND_CODE_1")
	private String spclCondCode1;

	@Column(name="SPCL_COND_CODE_2")
	private String spclCondCode2;

	@Column(name="SPCL_COND_CODE_3")
	private String spclCondCode3;

	@Column(name="SPCL_COND_CODE_4")
	private String spclCondCode4;

	@Column(name="SPCL_COND_CODE_5")
	private String spclCondCode5;

	@Column(name="SPCL_COND_CODE_6")
	private String spclCondCode6;

	@Column(name="SPCL_COND_CODE_7")
	private String spclCondCode7;

	private String st;

	@Column(name="STCC_CODE")
	private String stccCode;

	@Column(name="SYS_BLOC_FINL_YARD_BLOC")
	private String sysBlocFinlYardBloc;

	@Column(name="SYS_BLOC_KEY_PNT")
	private String sysBlocKeyPnt;

	@Column(name="TARE_WGT")
	private BigDecimal tareWgt;

	@Column(name="TOTL_AXLE_CNT")
	private BigDecimal totlAxleCnt;

	@Column(name="TRN_BLOC")
	private String trnBloc;

	@Column(name="UP_LOCA_CODE")
	private String upLocaCode;

	@Column(name="YARD_BLOC_ID")
	private String yardBlocId;

	public NctEqmtDtl() {
	}

	public NctEqmtDtlPK getId() {
		return this.id;
	}

	public void setId(NctEqmtDtlPK id) {
		this.id = id;
	}

	public String getAarTypeCd() {
		return this.aarTypeCd;
	}

	public void setAarTypeCd(String aarTypeCd) {
		this.aarTypeCd = aarTypeCd;
	}

	public Date getAdjMvmtStatDate() {
		return this.adjMvmtStatDate;
	}

	public void setAdjMvmtStatDate(Date adjMvmtStatDate) {
		this.adjMvmtStatDate = adjMvmtStatDate;
	}

	public String getAtcsDirCode() {
		return this.atcsDirCode;
	}

	public void setAtcsDirCode(String atcsDirCode) {
		this.atcsDirCode = atcsDirCode;
	}

	public String getAtcsSeqNbr() {
		return this.atcsSeqNbr;
	}

	public void setAtcsSeqNbr(String atcsSeqNbr) {
		this.atcsSeqNbr = atcsSeqNbr;
	}

	public String getAtcsTrk() {
		return this.atcsTrk;
	}

	public void setAtcsTrk(String atcsTrk) {
		this.atcsTrk = atcsTrk;
	}

	public String getAtcsYard() {
		return this.atcsYard;
	}

	public void setAtcsYard(String atcsYard) {
		this.atcsYard = atcsYard;
	}

	public String getCarKind() {
		return this.carKind;
	}

	public void setCarKind(String carKind) {
		this.carKind = carKind;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCmdyAbrv() {
		return this.cmdyAbrv;
	}

	public void setCmdyAbrv(String cmdyAbrv) {
		this.cmdyAbrv = cmdyAbrv;
	}

	public String getCnseName() {
		return this.cnseName;
	}

	public void setCnseName(String cnseName) {
		this.cnseName = cnseName;
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

	public String getCurCarStatCode() {
		return this.curCarStatCode;
	}

	public void setCurCarStatCode(String curCarStatCode) {
		this.curCarStatCode = curCarStatCode;
	}

	public Date getCurDispDate() {
		return this.curDispDate;
	}

	public void setCurDispDate(Date curDispDate) {
		this.curDispDate = curDispDate;
	}

	public String getDestRoad() {
		return this.destRoad;
	}

	public void setDestRoad(String destRoad) {
		this.destRoad = destRoad;
	}

	public String getDestSpot() {
		return this.destSpot;
	}

	public void setDestSpot(String destSpot) {
		this.destSpot = destSpot;
	}

	public BigDecimal getDestSysStnId() {
		return this.destSysStnId;
	}

	public void setDestSysStnId(BigDecimal destSysStnId) {
		this.destSysStnId = destSysStnId;
	}

	public String getDestTrk() {
		return this.destTrk;
	}

	public void setDestTrk(String destTrk) {
		this.destTrk = destTrk;
	}

	public String getDestZone() {
		return this.destZone;
	}

	public void setDestZone(String destZone) {
		this.destZone = destZone;
	}

	public String getEvntSysStnId() {
		return this.evntSysStnId;
	}

	public void setEvntSysStnId(String evntSysStnId) {
		this.evntSysStnId = evntSysStnId;
	}

	public String getFrnActgCode() {
		return this.frnActgCode;
	}

	public void setFrnActgCode(String frnActgCode) {
		this.frnActgCode = frnActgCode;
	}

	public BigDecimal getGrWgt() {
		return this.grWgt;
	}

	public void setGrWgt(BigDecimal grWgt) {
		this.grWgt = grWgt;
	}

	public String getHoldCode1() {
		return this.holdCode1;
	}

	public void setHoldCode1(String holdCode1) {
		this.holdCode1 = holdCode1;
	}

	public String getHoldCode2() {
		return this.holdCode2;
	}

	public void setHoldCode2(String holdCode2) {
		this.holdCode2 = holdCode2;
	}

	public String getHoldCode3() {
		return this.holdCode3;
	}

	public void setHoldCode3(String holdCode3) {
		this.holdCode3 = holdCode3;
	}

	public Date getHoldStatDate() {
		return this.holdStatDate;
	}

	public void setHoldStatDate(Date holdStatDate) {
		this.holdStatDate = holdStatDate;
	}

	public String getHzrdEndCode() {
		return this.hzrdEndCode;
	}

	public void setHzrdEndCode(String hzrdEndCode) {
		this.hzrdEndCode = hzrdEndCode;
	}

	public String getHzrdMatlInd() {
		return this.hzrdMatlInd;
	}

	public void setHzrdMatlInd(String hzrdMatlInd) {
		this.hzrdMatlInd = hzrdMatlInd;
	}

	public Date getInbdArvlDate() {
		return this.inbdArvlDate;
	}

	public void setInbdArvlDate(Date inbdArvlDate) {
		this.inbdArvlDate = inbdArvlDate;
	}

	public String getInbdTime() {
		return this.inbdTime;
	}

	public void setInbdTime(String inbdTime) {
		this.inbdTime = inbdTime;
	}

	public String getInbdTmzn() {
		return this.inbdTmzn;
	}

	public void setInbdTmzn(String inbdTmzn) {
		this.inbdTmzn = inbdTmzn;
	}

	public String getIndyPlacTime() {
		return this.indyPlacTime;
	}

	public void setIndyPlacTime(String indyPlacTime) {
		this.indyPlacTime = indyPlacTime;
	}

	public String getIndySpot() {
		return this.indySpot;
	}

	public void setIndySpot(String indySpot) {
		this.indySpot = indySpot;
	}

	public String getIndyTrk() {
		return this.indyTrk;
	}

	public void setIndyTrk(String indyTrk) {
		this.indyTrk = indyTrk;
	}

	public String getIndyZone() {
		return this.indyZone;
	}

	public void setIndyZone(String indyZone) {
		this.indyZone = indyZone;
	}

	public String getKmfInd() {
		return this.kmfInd;
	}

	public void setKmfInd(String kmfInd) {
		this.kmfInd = kmfInd;
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

	public String getLeCode() {
		return this.leCode;
	}

	public void setLeCode(String leCode) {
		this.leCode = leCode;
	}

	public Date getMvmtStatDate() {
		return this.mvmtStatDate;
	}

	public void setMvmtStatDate(Date mvmtStatDate) {
		this.mvmtStatDate = mvmtStatDate;
	}

	public String getNterNtraInd() {
		return this.nterNtraInd;
	}

	public void setNterNtraInd(String nterNtraInd) {
		this.nterNtraInd = nterNtraInd;
	}

	public Date getOtbdTrnDt() {
		return this.otbdTrnDt;
	}

	public void setOtbdTrnDt(Date otbdTrnDt) {
		this.otbdTrnDt = otbdTrnDt;
	}

	public String getOtbdTrnSctnId() {
		return this.otbdTrnSctnId;
	}

	public void setOtbdTrnSctnId(String otbdTrnSctnId) {
		this.otbdTrnSctnId = otbdTrnSctnId;
	}

	public String getOtbdTrnSymb() {
		return this.otbdTrnSymb;
	}

	public void setOtbdTrnSymb(String otbdTrnSymb) {
		this.otbdTrnSymb = otbdTrnSymb;
	}

	public BigDecimal getOutCarLgth() {
		return this.outCarLgth;
	}

	public void setOutCarLgth(BigDecimal outCarLgth) {
		this.outCarLgth = outCarLgth;
	}

	public String getRest1() {
		return this.rest1;
	}

	public void setRest1(String rest1) {
		this.rest1 = rest1;
	}

	public String getRest1Code() {
		return this.rest1Code;
	}

	public void setRest1Code(String rest1Code) {
		this.rest1Code = rest1Code;
	}

	public String getRest2() {
		return this.rest2;
	}

	public void setRest2(String rest2) {
		this.rest2 = rest2;
	}

	public String getRest2Code() {
		return this.rest2Code;
	}

	public void setRest2Code(String rest2Code) {
		this.rest2Code = rest2Code;
	}

	public String getRolrBrngInd() {
		return this.rolrBrngInd;
	}

	public void setRolrBrngInd(String rolrBrngInd) {
		this.rolrBrngInd = rolrBrngInd;
	}

	public String getShprName() {
		return this.shprName;
	}

	public void setShprName(String shprName) {
		this.shprName = shprName;
	}

	public String getSpclCondCode1() {
		return this.spclCondCode1;
	}

	public void setSpclCondCode1(String spclCondCode1) {
		this.spclCondCode1 = spclCondCode1;
	}

	public String getSpclCondCode2() {
		return this.spclCondCode2;
	}

	public void setSpclCondCode2(String spclCondCode2) {
		this.spclCondCode2 = spclCondCode2;
	}

	public String getSpclCondCode3() {
		return this.spclCondCode3;
	}

	public void setSpclCondCode3(String spclCondCode3) {
		this.spclCondCode3 = spclCondCode3;
	}

	public String getSpclCondCode4() {
		return this.spclCondCode4;
	}

	public void setSpclCondCode4(String spclCondCode4) {
		this.spclCondCode4 = spclCondCode4;
	}

	public String getSpclCondCode5() {
		return this.spclCondCode5;
	}

	public void setSpclCondCode5(String spclCondCode5) {
		this.spclCondCode5 = spclCondCode5;
	}

	public String getSpclCondCode6() {
		return this.spclCondCode6;
	}

	public void setSpclCondCode6(String spclCondCode6) {
		this.spclCondCode6 = spclCondCode6;
	}

	public String getSpclCondCode7() {
		return this.spclCondCode7;
	}

	public void setSpclCondCode7(String spclCondCode7) {
		this.spclCondCode7 = spclCondCode7;
	}

	public String getSt() {
		return this.st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getStccCode() {
		return this.stccCode;
	}

	public void setStccCode(String stccCode) {
		this.stccCode = stccCode;
	}

	public String getSysBlocFinlYardBloc() {
		return this.sysBlocFinlYardBloc;
	}

	public void setSysBlocFinlYardBloc(String sysBlocFinlYardBloc) {
		this.sysBlocFinlYardBloc = sysBlocFinlYardBloc;
	}

	public String getSysBlocKeyPnt() {
		return this.sysBlocKeyPnt;
	}

	public void setSysBlocKeyPnt(String sysBlocKeyPnt) {
		this.sysBlocKeyPnt = sysBlocKeyPnt;
	}

	public BigDecimal getTareWgt() {
		return this.tareWgt;
	}

	public void setTareWgt(BigDecimal tareWgt) {
		this.tareWgt = tareWgt;
	}

	public BigDecimal getTotlAxleCnt() {
		return this.totlAxleCnt;
	}

	public void setTotlAxleCnt(BigDecimal totlAxleCnt) {
		this.totlAxleCnt = totlAxleCnt;
	}

	public String getTrnBloc() {
		return this.trnBloc;
	}

	public void setTrnBloc(String trnBloc) {
		this.trnBloc = trnBloc;
	}

	public String getUpLocaCode() {
		return this.upLocaCode;
	}

	public void setUpLocaCode(String upLocaCode) {
		this.upLocaCode = upLocaCode;
	}

	public String getYardBlocId() {
		return this.yardBlocId;
	}

	public void setYardBlocId(String yardBlocId) {
		this.yardBlocId = yardBlocId;
	}

}