package mx.com.vrm.viai.test;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import mx.com.vrm.viai.controller.AppController;

// TODO: Auto-generated Javadoc
/**
 * The Class PassGeneratorTest.
 */
public class PassGeneratorTest {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			System.out.println(passwordEncoder.encode(":cc9O71U"));


			
			//boolean isPasswordMatches = false;
			//System.out.println(passwordEncoder.matches("12345678", "$2a$10$Zfp9ujuOO1f3x8Wm6LvBZevPKxWXP5Ki24Xr/Zc2IH5pTK/zsRJrG"));
		}
	

}