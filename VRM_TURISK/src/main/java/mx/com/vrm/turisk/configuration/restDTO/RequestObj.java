package mx.com.vrm.viai.configuration.restDTO;

// TODO: Auto-generated Javadoc
/**
 * Request Object.
 */
public class RequestObj {

	/** The header. */
	private Header header;

	/**
	 * RequestObj.
	 */
	public RequestObj() {
		super();
	}

	/**
	 * RequestObj.
	 *
	 * @param header
	 *            the header
	 */
	public RequestObj(Header header) {
		super();
		this.header = header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestObj [header=" + header + "]";
	}

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * Sets the header.
	 *
	 * @param header
	 *            the new header
	 */
	public void setHeader(Header header) {
		this.header = header;
	}

}
