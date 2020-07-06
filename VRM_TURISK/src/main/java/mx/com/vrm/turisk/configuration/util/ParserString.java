package mx.com.vrm.viai.configuration.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mx.com.vrm.viai.dto.EstatusJHEDTO;

public class ParserString {

	
	public static EstatusJHEDTO estatusJHE = new EstatusJHEDTO();
	public static List<EstatusJHEDTO> listaJhe = new ArrayList<EstatusJHEDTO>();
    Pattern pattern = Pattern.compile("^.|^@");
    

	
	public static EstatusJHEDTO obtenerListaJHE75(String resultadoServer){
		
		return estatusJHE;
	}
	
	public static EstatusJHEDTO obtenerListaJHE76(String resultadoServer){
		
		return estatusJHE;
	}
	
	
	public static boolean verificarStatusContains(String jhe, String resultadoServer){
		boolean existe = false;
		
		return existe;
	}
	
	public static List<EstatusJHEDTO> verificarListaStatusContains(String resultadoServer){
		
		return listaJhe;
	}
	
}
