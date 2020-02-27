package mx.com.vrm.viai.exceptions;

import mx.com.vrm.viai.configuration.restDTO.Item;
import mx.com.vrm.viai.configuration.restDTO.eCodResp;
import mx.com.vrm.viai.configuration.restDTO.eMsgResp;
import mx.com.vrm.viai.configuration.restDTO.eTypeError;

/**
 * Bussines's Exception
 */
public class BussinesException extends RuntimeException{

	
	private static final long serialVersionUID = -6890808317320003009L;

	private final Item item;	
	private final Object object;
	

	/**
	 * BussinesException
	 * @param item
	 * @param object
	 */
	public BussinesException(Item item, Object object) {
		super();
		this.item = item;
		this.object = object;
	}

	/**
	 * 
	 * @param eCodResp
	 * @param eMsgResp
	 * @param eTypeError
	 * @param object
	 */
	public BussinesException(eCodResp eCodResp, eMsgResp eMsgResp, eTypeError eTypeError, Object object) {
		super();
		this.item = new Item(eCodResp.getValue(), eMsgResp.getValCod(), eMsgResp.getValMsg(), eTypeError.getValue());
		this.object = object;
	}	
	
	@Override
	public String toString() {
		return "BussinesException [item=" + item + ", object=" + object + "]";
	}



	public Item getItem() {
		return item;
	}



	public Object getObject() {
		return object;
	}



	
}
