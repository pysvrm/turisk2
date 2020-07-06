package mx.com.vrm.viai.configuration.restDTO;

// TODO: Auto-generated Javadoc
/**
 * ResponseObj.
 */
public class ResponseObj {

	/** The item. */
	private Item item;

	/** The response. */
	private Object response;

	/**
	 * ResponseObj.
	 */
	public ResponseObj() {
		super();
	}

	/**
	 * ResponseObj.
	 *
	 * @param item
	 *            the item
	 */
	public ResponseObj(Item item) {
		super();
		this.item = item;
	}

	/**
	 * ResponseObj.
	 *
	 * @param item
	 *            the item
	 * @param response
	 *            the response
	 */
	public ResponseObj(Item item, Object response) {
		super();
		this.item = item;
		this.response = response;
	}

	/**
	 * ResponseObj.
	 *
	 * @param eCodResp
	 *            the e cod resp
	 * @param eMsgResp
	 *            the e msg resp
	 * @param eTypeError
	 *            the e type error
	 */
	public ResponseObj(eCodResp eCodResp, eMsgResp eMsgResp, eTypeError eTypeError) {
		super();
		this.item = new Item(eCodResp.getValue(), eMsgResp.getValCod(), eMsgResp.getValMsg(), eTypeError.getValue());
	}

	/**
	 * ResponseObj.
	 *
	 * @param eCodResp
	 *            the e cod resp
	 * @param eMsgResp
	 *            the e msg resp
	 * @param eTypeError
	 *            the e type error
	 * @param response
	 *            the response
	 */
	public ResponseObj(eCodResp eCodResp, eMsgResp eMsgResp, eTypeError eTypeError, Object response) {
		super();
		this.item = new Item(eCodResp.getValue(), eMsgResp.getValCod(), eMsgResp.getValMsg(), eTypeError.getValue());
		this.response = response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseObj [item=" + item + ", response=" + response + "]";
	}

	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Sets the item.
	 *
	 * @param item
	 *            the new item
	 */
	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response
	 *            the new response
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

}
