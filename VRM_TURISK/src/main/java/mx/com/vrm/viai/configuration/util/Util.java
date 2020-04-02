package mx.com.vrm.viai.configuration.util;

import java.util.Formatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Util.
 */
public class Util {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(Util.class);

	/**
	 * Ajusta longitud con ceros a la izquierda.
	 * 
	 * @param aComplementar Recibe un entero.
	 * @param longitud      Recibe un entero.
	 * @return Regresa un valor de tipo {@link Formatter}.
	 */
	@SuppressWarnings("resource")
	// FIXME:Meter a cache
	public static String ajustaLongitudConZerosIzquierda(Integer aComplementar, int longitud) {
		Formatter fmt = new Formatter();
		fmt.format("%1$0" + longitud + "d", aComplementar);
		return fmt.toString();
	}

	/**
	 * Ajusta caracter derecha.
	 * 
	 * @param aComplementar Recibe una cadena.
	 * @param caracter      Recibe una cadena.
	 * @param longitud      Recibe un entero.
	 * @return Regresa un acadena.
	 */
	// FIXME:Meter a cache
	public static String ajustaLongitudConCaracterDerecha(String aComplementar, Character caracter, int longitud) {
		while (aComplementar.length() < longitud) {
			aComplementar += caracter;
		}
		return aComplementar;
	}

	/**
	 * Ajusta caracter izquierda.
	 * 
	 * @param aComplementar Recibe una cadena.
	 * @param caracter      Recibe una cadena.
	 * @param longitud      Recibe un entero.
	 * @return Regresa un acadena.
	 */
	// FIXME:Meter a cache
	public static String ajustaLongitudConCaracterIzquierda(String aComplementar, Character caracter, int longitud) {

		while (aComplementar.length() < longitud)

			aComplementar = caracter + aComplementar;

		return aComplementar;
	}

}
