package mx.com.vrm.viai.configuration.util;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.JSchException;

import mx.com.vrm.viai.configuration.constantes.Constants;

public final class ProcesosSicopUtil {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ProcesosSicopUtil.class);
	private static final SFTPConnector sshConnector = new SFTPConnector();

	public static String server75(boolean restart) throws JSchException, IllegalAccessException, IOException {
		String resultado = "";
		sshConnector.connect(Constants.USERNAME_SERVERS_JHE, Constants.PASSWORD_SERVERS_JHE, Constants.HOST_75,
				Constants.PORT_SERVERS_JHE);
		if (restart) {
			resultado = sshConnector.executeCommand("cd /upapps/jhe/tmi/;./restart_jhe.sh") + "/n";
		}
		resultado = sshConnector.executeCommand("./showproc.sh") + "/n";
		logger.info("-- :: Resultado ::--" + resultado);
		logger.info("--Instruccion completada de servicios JHE 78 completado--");
		sshConnector.disconnect();
		return resultado;
	}

	public static String server76(boolean restart) throws JSchException, IllegalAccessException, IOException {
		String resultado = "";
		sshConnector.connect(Constants.USERNAME_SERVERS_JHE,  Constants.PASSWORD_SERVERS_JHE, Constants.HOST_76,
				Constants.PORT_SERVERS_JHE);
		if (restart) {
			resultado = sshConnector.executeCommand("cd /upapps/jhe/tmi/;./restart_jhe.sh") + "/n";
		}
		resultado = sshConnector.executeCommand("./showproc.sh") + "/n";
		logger.info("-- :: Resultado ::--" + resultado);
		logger.info("--Instruccion completada de servicios JHE 78 completado--");
		sshConnector.disconnect();
		return resultado;
	}

	public static String server78(boolean restart) throws JSchException, IllegalAccessException, IOException {
		String resultado = "";
		sshConnector.connect(Constants.USERNAME_SERVERS_JHE, Constants.PASSWORD_SERVERS_JHE, Constants.HOST_78,
				Constants.PORT_SERVERS_JHE);
		if (restart) {
			resultado = sshConnector.executeCommand("cd /upapps/jhe/tmi/;./restart_jhe.sh") + "/n";
		}
		resultado = sshConnector.executeCommand("./showproc.sh") + "/n";
		logger.info("-- :: Resultado ::--" + resultado);
		logger.info("--Instruccion completada de servicios JHE 78 completado--");
		sshConnector.disconnect();
		return resultado;
	}

	public static String server79(boolean restart) throws JSchException, IllegalAccessException, IOException {
		String resultado = "";
		sshConnector.connect(Constants.USERNAME_SERVERS_JHE,Constants.PASSWORD_SERVERS_JHE, Constants.HOST_79,
				Constants.PORT_SERVERS_JHE);
		if (restart) {
			resultado = sshConnector.executeCommand("cd /upapps/jhe/tmi/;./restart_jhe.sh") + "/n";
		}
		resultado = sshConnector.executeCommand("./showproc.sh") + "/n";
		logger.info("-- :: Resultado ::--" + resultado);
		logger.info("--Instruccion completada de servicios JHE 79 completado--");
		sshConnector.disconnect();
		return resultado;
	}
	
	public static String server480(boolean restart) throws JSchException, IllegalAccessException, IOException {
		String resultado = "";
		sshConnector.connect(Constants.USERNAME_SERVERS_TADS, Constants.PASSWORD_SERVERS_TADS_480,
				Constants.HOST_480, Constants.PORT_SERVERS_JHE);
		resultado = sshConnector.executeCommand("cd ; ./stopAll.sh");
		resultado = sshConnector
				.executeCommand("cd /logs/ctl/tmp;rm *;cd /logs/ctl;rm *.*;cd /home/dctl999;./startAll.sh");
		resultado = sshConnector.executeCommand("cd ; ./showproc.sh");
		logger.info("-- :: Resultado ::--" + resultado);
		logger.info("--Instruccion completada de servicios TADS 1280 completado--");
		sshConnector.disconnect();
		return resultado;
	}
	
	public static String server481(boolean restart) throws JSchException, IllegalAccessException, IOException {
		String resultado = "";
		sshConnector.connect(Constants.USERNAME_SERVERS_TADS, Constants.PASSWORD_SERVERS_TADS_481,
				Constants.HOST_481, Constants.PORT_SERVERS_JHE);
		resultado = sshConnector.executeCommand("cd ; ./stopAll.sh");
		resultado = sshConnector
				.executeCommand("cd /logs/ctl/tmp;rm *;cd /logs/ctl;rm *.*;cd /home/dctl999;./startAll.sh");
		resultado = sshConnector.executeCommand("cd ; ./showproc.sh");
		logger.info("-- :: Resultado ::--" + resultado);
		logger.info("--Instruccion completada de servicios TADS 680 completado--");
		sshConnector.disconnect();
		return resultado;
	}
	
	public static String server480s(boolean restart) throws JSchException, IllegalAccessException, IOException {
		String resultado = "";
		sshConnector.connect(Constants.USERNAME_SERVERS_TADS, Constants.PASSWORD_SERVERS_TADS_480,
				Constants.HOST_480, Constants.PORT_SERVERS_JHE);
		resultado = sshConnector.executeCommand("cd ; ./showproc.sh");
		logger.info("-- :: Resultado ::--" + resultado);
		logger.info("--Instruccion completada de servicios TADS 1280 completado--");
		sshConnector.disconnect();
		return resultado;
	}
	
	public static String server680s(boolean restart) throws JSchException, IllegalAccessException, IOException {
		String resultado = "";
		sshConnector.connect(Constants.USERNAME_SERVERS_TADS, Constants.PASSWORD_SERVERS_TADS_481,
				Constants.HOST_481, Constants.PORT_SERVERS_JHE);
		resultado = sshConnector.executeCommand("cd ; ./showproc.sh");
		logger.info("-- :: Resultado ::--" + resultado);
		logger.info("--Instruccion completada de servicios TADS 680 completado--");
		sshConnector.disconnect();
		return resultado;
	}
	
}
