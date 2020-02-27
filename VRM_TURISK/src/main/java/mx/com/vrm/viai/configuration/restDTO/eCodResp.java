package mx.com.vrm.viai.configuration.restDTO;

// TODO: Auto-generated Javadoc
/**
 * eCodResp.
 */
public enum eCodResp {

	/** The ok. */
	OK(0),

	/** The ko gen ser. */
	KO_GEN_SER(-1),

	/** The ko gen bsn. */
	KO_GEN_BSN(1),

	/** The ko bad rqt. */
	KO_BAD_RQT(2),

	/** The ko bad rsp. */
	KO_BAD_RSP(3);

	/** The value. */
	private Integer value;

	/**
	 * Instantiates a new e cod resp.
	 *
	 * @param value
	 *            the value
	 */
	private eCodResp(Integer value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

}
