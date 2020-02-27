package mx.com.vrm.viai.configuration.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.vrm.viai.model.NctEqmt;

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

	public static List<NctEqmt> listaEquipos(String listaEquiposString) {
		List<NctEqmt> listaEquipos = new ArrayList<NctEqmt>();
		String[] parts = listaEquiposString.split(",");
		try {
			for (int cnt = 0; cnt < parts.length; cnt++) {
				NctEqmt nuevoEquipo = new NctEqmt();
				Pattern pinicial = Pattern.compile("[a-zA-Z]{1,4}");
				Pattern pnumero = Pattern.compile("[^a-zA-Z]{1,6}");
				Matcher inicialm = pinicial.matcher(parts[cnt]);
				Matcher numerom = pnumero.matcher(parts[cnt]);

				inicialm.find();
				numerom.find();

				nuevoEquipo.setEqmtInit(inicialm.group(0).trim());
				nuevoEquipo.setEqmtNbr(new BigDecimal(numerom.group(0).trim()));

				listaEquipos.add(nuevoEquipo);

			}
		} catch (Exception e) {
			log.info("Error al obtener la lista de equipos");
		}

		return listaEquipos;
	}
}
