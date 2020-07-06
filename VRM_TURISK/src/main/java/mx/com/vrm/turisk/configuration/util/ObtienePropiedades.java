package mx.com.vrm.viai.configuration.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class ObtienePropiedades.
 */
public class ObtienePropiedades {

	/** The input. */
	private InputStream input = null;

	/** The properties. */
	private Properties properties = new Properties();

	/**
	 * Obtiene propiedades.
	 *
	 * @param urlFile
	 *            the url file
	 * @return the properties
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Properties obtienePropiedades(String urlFile) throws IOException {
		input = new FileInputStream(urlFile);
		properties.load(input);
		return properties;

	}
}
