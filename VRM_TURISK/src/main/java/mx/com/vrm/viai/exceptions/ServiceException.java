package mx.com.vrm.viai.exceptions;

import mx.com.vrm.viai.configuration.restDTO.Item;
import mx.com.vrm.viai.configuration.restDTO.eCodResp;
import mx.com.vrm.viai.configuration.restDTO.eMsgResp;
import mx.com.vrm.viai.configuration.restDTO.eTypeError;

/**
 * ServiceException
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 3261624784975022938L;

	private final Item item;
	private final Object object;

	/**
	 * ServiceException
	 * 
	 * @param item
	 * @param object
	 */
	public ServiceException(Item item, Object object) {
		super();
		this.item = item;
		this.object = object;
	}

	/**
	 * ServiceException
	 * 
	 * @param eCodResp
	 * @param eMsgResp
	 * @param object
	 */
	public ServiceException(eCodResp eCodResp, eMsgResp eMsgResp, Object object) {
		super();
		this.item = new Item(eCodResp.getValue(), eMsgResp.getValCod(), eMsgResp.getValMsg(),
				eTypeError.ERROR.getValue());
		this.object = object;
	}

	@Override
	public String toString() {
		return "ServiceException [item=" + item + ", object=" + object + "]";
	}

	public Item getItem() {
		return item;
	}

	public Object getObject() {
		return object;
	}

}
