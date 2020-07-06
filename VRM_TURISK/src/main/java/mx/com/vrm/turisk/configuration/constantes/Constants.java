package mx.com.vrm.viai.configuration.constantes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


// TODO: Auto-generated Javadoc
/**
 * The Class Constants.
 */
public class Constants {

	//FIXME:CAMBIAR TODOS LOS ELEMENTOS DE CONTRASENIAS, USUARIOS Y SERVIDORES A UN PROPERTIES
	/** The Constant LOGIN_URL. */
	
	public Properties p = new Properties();
	
	
	
	public Constants(Properties p) throws FileNotFoundException, IOException {
		super();
		p.load(new FileReader("files/properties/config.properties"));
		this.p = p;
	}

	public static final String LOGIN_URL = "/login";

	/** The Constant HEADER_AUTHORIZACION_KEY. */
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";

	/** The Constant TOKEN_BEARER_PREFIX. */
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	/** The Constant ISSUER_INFO. */
	public static final String ISSUER_INFO = "https://www.autentia.com/";

	/** The Constant SUPER_SECRET_KEY. */
	public static final String SUPER_SECRET_KEY = "p0l1t3cn1c0&";

	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final long TOKEN_EXPIRATION_TIME = 60000; // 1 minuto
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String USERNAME_SERVERS_JHE = "jheuser";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String USERNAME_SERVERS_TADS = "dctl999";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	
	public static final String USERNAME_SERVERS_71_CEO = "jheuser";
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String USERNAME_SERVERS_73_CEO = "jheuser";
	
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String PASSWORD_SERVERS_JHE = "e#4J18?+";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String PASSWORD_SERVERS_71_CEO= "SFv#h38-";
	
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String PASSWORD_SERVERS_73_CEO = "SFv#h38-";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String PASSWORD_SERVERS_TADS_481 = "z?Hx8gO5";
	
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String PASSWORD_SERVERS_TADS_480 = "jzntmftuz";
	
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final int PORT_SERVERS_JHE = 22;
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String HOST_75 = "10.1.4.75";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String HOST_76 = "10.1.4.76";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String HOST_78 = "10.1.4.78";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String HOST_79 = "10.1.4.79";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String HOST_480 = "10.1.4.80";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String HOST_481 = "10.1.4.81";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String HOST_CEO_71 = "10.1.4.71";
	
	/** The Constant TOKEN_EXPIRATION_TIME. */
	public static final String HOST_CEO_73 = "10.1.4.73";
	

}
