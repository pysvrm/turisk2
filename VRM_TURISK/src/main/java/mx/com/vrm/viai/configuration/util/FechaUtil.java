package mx.com.vrm.viai.configuration.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * Componente util con funciones de fecha.
 * 
 */
public class FechaUtil {

	/** The meses. */
	private static Map<String, Integer> meses;

	static {
		meses = new HashMap<String, Integer>();
		meses.put("ENE", 1);
		meses.put("FEB", 2);
		meses.put("MAR", 3);
		meses.put("ABR", 4);
		meses.put("MAY", 5);
		meses.put("JUN", 6);
		meses.put("JUL", 7);
		meses.put("AGO", 8);
		meses.put("SEP", 9);
		meses.put("OCT", 10);
		meses.put("NOV", 11);
		meses.put("DIC", 12);
		meses.put("01", 1);
		meses.put("02", 2);
		meses.put("03", 3);
		meses.put("04", 4);
		meses.put("05", 5);
		meses.put("06", 6);
		meses.put("07", 7);
		meses.put("08", 8);
		meses.put("09", 9);
		meses.put("10", 10);
		meses.put("11", 11);
		meses.put("12", 12);
	}

	// /**
	// * Para evitar instanciaciones
	/**
	 * Instantiates a new fecha util.
	 */
	// */
	private FechaUtil() {
	}

	/**
	 * Se encarga de obtener la fecha completa usando el dia y el mes.
	 * 
	 * @param dia
	 *            Es el dia de la fecha.
	 * @param mes
	 *            Es el mes de la fecha.
	 * @return La fecha completa.
	 * @throws IllegalArgumentException
	 *             Es lanzada si existe un error.
	 */
	public static Date obtenFechaCompleta(String dia, String mes) throws IllegalArgumentException {
		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaEvento = Calendar.getInstance();
		Integer diaEvento;
		Integer mesFecha = meses.get(mes.trim());
		Integer anioFecha = null;

		if (mesFecha == null) {
			throw new IllegalArgumentException("El mes '" + mes + "' no existe");
		}
		try {
			diaEvento = Integer.parseInt(dia);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("El dia '" + dia + "' no viene en formato entero");
		}

		Integer mesActual = fechaActual.get(Calendar.MONTH) + 1;
		if (mesFecha > mesActual) {
			anioFecha = fechaActual.get(Calendar.YEAR) - 1;
		} else {
			anioFecha = fechaActual.get(Calendar.YEAR);
		}

		fechaEvento.set(Calendar.DAY_OF_MONTH, diaEvento);
		fechaEvento.set(Calendar.MONTH, mesFecha - 1);
		fechaEvento.set(Calendar.YEAR, anioFecha);
		fechaEvento.set(Calendar.HOUR, 0);
		fechaEvento.set(Calendar.MINUTE, 0);
		// fechaEvento.set(Calendar.SECOND, 0);
		// fechaEvento.set(Calendar.MILLISECOND, 0);

		return fechaEvento.getTime();
	}

	/**
	 * Obtiene fecha completa.
	 * 
	 * @param dia
	 *            Es el dia de la fecha.
	 * @param mes
	 *            Es el mes de la fecha.
	 * @param hora
	 *            Es la hora de la fecha.
	 * @param minutos
	 *            Es el minuto de la fecha.
	 * @return Regresa un valor de tipo {@link Calendar}.
	 */
	public static Date obtenFechaCompleta(String dia, String mes, String hora, String minutos) {
		Integer horaEvento = Integer.parseInt(hora);
		Integer minutosEvento = Integer.parseInt(minutos);
		Date fechaEvento = obtenFechaCompleta(dia, mes);
		Calendar calEvento = Calendar.getInstance();
		calEvento.setTime(fechaEvento);
		calEvento.set(Calendar.HOUR_OF_DAY, horaEvento);
		calEvento.set(Calendar.MINUTE, minutosEvento);
		return calEvento.getTime();
	}

	/**
	 * Format date DDMMYYYHHMMSS.
	 *
	 * @param fecha
	 *            the fecha
	 * @return the string
	 */
	public static String formatDateDDMMYYYHHMMSS(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(fecha);
	}

	/**
	 * Format date DDMMYYYHHMM.
	 *
	 * @param fecha
	 *            the fecha
	 * @return the string
	 */
	public static String formatDateDDMMYYYHHMM(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return sdf.format(fecha);
	}

	/**
	 * Format date DDMMYY.
	 *
	 * @param fecha
	 *            the fecha
	 * @return the string
	 */
	public static String formatDateDDMMYY(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		return sdf.format(fecha);
	}
	
	public static String obtenerDiaFechaCompleta(String fecha) throws ParseException {
		String diaString = "";
		Date fechaDate = new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
		Calendar fechaCalendar = Calendar.getInstance();
		fechaCalendar.setTime(fechaDate);
		diaString = String.valueOf(fechaCalendar.get(Calendar.DAY_OF_MONTH));
		return diaString;
	}
	
	public static Date obtenerDiaFechaCompletaGuion(String fecha) throws ParseException {
		String diaString = "";
		Date fechaDate = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
		Calendar fechaCalendar = Calendar.getInstance();
		fechaCalendar.setTime(fechaDate);
		diaString = String.valueOf(fechaCalendar.get(Calendar.DAY_OF_MONTH));
		return fechaDate;
	}

	public static Date obtenerFechaFromStringDDMMYYYY(String fecha) throws ParseException {
		String diaString = "";
		Date fechaDate = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
		return fechaDate;
	}
	
}
