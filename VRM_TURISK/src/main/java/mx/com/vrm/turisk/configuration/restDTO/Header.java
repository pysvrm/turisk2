package mx.com.vrm.viai.configuration.restDTO;

// TODO: Auto-generated Javadoc
/**
 * Header.
 */
public class Header {

	/** The imei. */
	private String imei;

	/** The mac. */
	private String mac;

	/** The token. */
	private String token;

	/**
	 * Header.
	 */
	public Header() {
		super();
	}

	/**
	 * Header.
	 *
	 * @param imei
	 *            the imei
	 * @param mac
	 *            the mac
	 */
	public Header(String imei, String mac) {
		super();
		this.imei = imei;
		this.mac = mac;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Header [imei=" + imei + ", mac=" + mac + "]";
	}

	/**
	 * Checks if is valid.
	 *
	 * @return true, if is valid
	 */
	public boolean isValid() {
		if (this.imei == null || "".equals(this.imei)) {
			return false;
		}
		if (this.mac == null || "".equals(this.mac)) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the imei.
	 *
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * Sets the imei.
	 *
	 * @param imei
	 *            the new imei
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * Gets the mac.
	 *
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * Sets the mac.
	 *
	 * @param mac
	 *            the new mac
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token
	 *            the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
