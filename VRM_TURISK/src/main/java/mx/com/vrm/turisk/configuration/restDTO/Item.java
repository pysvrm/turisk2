package mx.com.vrm.viai.configuration.restDTO;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * Item.
 */
public class Item implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5627363484322927073L;

	/** The code. */
	private Integer code;

	/** The cod msg. */
	private Integer codMsg;

	/** The msg. */
	private String msg;

	/** The type. */
	private String type;

	/**
	 * Item.
	 */
	public Item() {
		super();
	}

	/**
	 * Item.
	 *
	 * @param code
	 *            the code
	 * @param codMsg
	 *            the cod msg
	 * @param msg
	 *            the msg
	 * @param type
	 *            the type
	 */
	public Item(Integer code, Integer codMsg, String msg, String type) {
		super();
		this.code = code;
		this.codMsg = codMsg;
		this.msg = msg;
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Item [code=" + code + ", codMsg=" + codMsg + ", msg=" + msg + ", type=" + type + "]";
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * Gets the cod msg.
	 *
	 * @return the cod msg
	 */
	public Integer getCodMsg() {
		return codMsg;
	}

	/**
	 * Sets the cod msg.
	 *
	 * @param codMsg
	 *            the new cod msg
	 */
	public void setCodMsg(Integer codMsg) {
		this.codMsg = codMsg;
	}

	/**
	 * Gets the msg.
	 *
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * Sets the msg.
	 *
	 * @param msg
	 *            the new msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

}
