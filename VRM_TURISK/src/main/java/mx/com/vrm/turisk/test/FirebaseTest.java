package mx.com.vrm.turisk.test;

import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;

public class FirebaseTest {

	private static FirebaseAuth mAuth;
	
	public static void main(String[] args) throws FirebaseAuthException {
		System.out.println("Prueba de conexión bd firebase desde Java");
		FirebaseOptions options = null;
		try {
			options = new FirebaseOptions.Builder()
				    .setCredentials(GoogleCredentials.getApplicationDefault())
				    .setDatabaseUrl("https://turisk-4882d.firebaseio.com/")
				    .build();
			
			System.out.println("Prueba de conexión bd firebase desde Java-Options");	
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Prueba de conexión bd firebase desde Java-initializeApp");
		FirebaseApp.initializeApp(options);
		crearUsuario();
		//recuperarUsuario("91SqM8vaJ1fpZB4xY2GIqC340hl1");
	}
	
	public static void crearUsuario() throws FirebaseAuthException {
		CreateRequest request = new CreateRequest()
			    .setEmail("vladimir.rodriguez.mtz@gmail.com")
			    .setEmailVerified(false)
			    .setPassword("12345678")
			    .setPhoneNumber("+11234567890")
			    .setDisplayName("John Doe")
			    .setPhotoUrl("http://www.example.com/12345678/photo.png")
			    .setDisabled(false);

			UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
			System.out.println("Successfully created new user: " + userRecord.getUid());
	}
	
	public static void recuperarUsuario(String uid) throws FirebaseAuthException {
		UserRecord userRecord = FirebaseAuth.getInstance().getUser(uid);
		// See the UserRecord reference doc for the contents of userRecord.
		System.out.println("Successfully fetched user data: " + userRecord.getUid());
		System.out.println("Successfully fetched user data: " + userRecord.getEmail());
		System.out.println("Successfully fetched user data: "+userRecord.getDisplayName());
	}
	
	
	public static void recuperarUsuarioPassword(String email,String password) throws FirebaseAuthException {
		mAuth = FirebaseAuth.getInstance();
		FirebaseAuth auth = FirebaseAuth.getInstance();
	}
}
