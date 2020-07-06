package mx.com.vrm.viai.configuration.restDTO;

// TODO: Auto-generated Javadoc
/**
 * The Enum eTypeError.
 */
public enum eTypeError {

	/** The error. */
	ERROR("E"),

	/** The mdlware. */
	MDLWARE("M"),

	/** The origin. */
	ORIGIN("O");

	/** The value. */
	private String value;

	/**
	 * Instantiates a new e type error.
	 *
	 * @param value
	 *            the value
	 */
	private eTypeError(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
