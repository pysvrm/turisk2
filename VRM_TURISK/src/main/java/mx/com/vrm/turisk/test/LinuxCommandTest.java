package mx.com.vrm.turisk.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import mx.com.vrm.turisk.configuration.constantes.Constants;
import mx.com.vrm.turisk.configuration.constantes.JheEnum;
import mx.com.vrm.turisk.configuration.util.SFTPConnector;
import mx.com.vrm.turisk.dto.EstatusJHEDTO;

public class LinuxCommandTest {

	public static void main(String[] args) throws SftpException {

		try {
			SFTPConnector sshConnector = new SFTPConnector();
			sshConnector.connect(Constants.USERNAME_SERVERS_73_CEO, Constants.PASSWORD_SERVERS_73_CEO,
					Constants.HOST_CEO_73, Constants.PORT_SERVERS_JHE);
			sshConnector.executeCommand("cd /upapps/jvm/com-ceo_filter/bin; ./ceo-filter-script stop");
			sshConnector.executeCommand("cd /upapps/jvm/com-ceo_filter/bin; ./ceo-filter-script start");
			//System.out.println(resultado);
			sshConnector.disconnect();
			

		} catch (JSchException ex) {
			ex.printStackTrace();

			System.out.println(ex.getMessage());
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();

			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();

			System.out.println(ex.getMessage());
		}
	}
}
