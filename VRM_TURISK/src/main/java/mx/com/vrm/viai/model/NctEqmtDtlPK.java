package mx.com.vrm.viai.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the NCT_EQMT_DTL database table.
 * 
 */
@Embeddable
public class NctEqmtDtlPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="EQMT_INIT")
	private String eqmtInit;

	@Column(name="EQMT_NBR")
	private long eqmtNbr;

	public NctEqmtDtlPK() {
	}
	public String getEqmtInit() {
		return this.eqmtInit;
	}
	public void setEqmtInit(String eqmtInit) {
		this.eqmtInit = eqmtInit;
	}
	public long getEqmtNbr() {
		return this.eqmtNbr;
	}
	public void setEqmtNbr(long eqmtNbr) {
		this.eqmtNbr = eqmtNbr;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NctEqmtDtlPK)) {
			return false;
		}
		NctEqmtDtlPK castOther = (NctEqmtDtlPK)other;
		return 
			this.eqmtInit.equals(castOther.eqmtInit)
			&& (this.eqmtNbr == castOther.eqmtNbr);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.eqmtInit.hashCode();
		hash = hash * prime + ((int) (this.eqmtNbr ^ (this.eqmtNbr >>> 32)));
		
		return hash;
	}
}