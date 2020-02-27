package mx.com.vrm.viai.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.jcraft.jsch.JSchException;

import ch.qos.logback.classic.pattern.Util;
import mx.com.vrm.viai.configuration.constantes.Constants;
import mx.com.vrm.viai.configuration.constantes.JheEnum;
import mx.com.vrm.viai.configuration.constantes.TadEnum;
import mx.com.vrm.viai.configuration.util.FechaUtil;
import mx.com.vrm.viai.configuration.util.ProcesosSicopUtil;
import mx.com.vrm.viai.configuration.util.SFTPConnector;
import mx.com.vrm.viai.dao.BajarPatioDAO;
import mx.com.vrm.viai.dto.EquipoCompletoDTO;
import mx.com.vrm.viai.dto.EstatusJHEDTO;
import mx.com.vrm.viai.dto.EstatusTADDTO;
import mx.com.vrm.viai.dto.TrenInboundResourceDTO;
import mx.com.vrm.viai.model.NctEqmt;
import mx.com.vrm.viai.service.BajarPatioService;
import mx.com.vrm.viai.service.EquipoDetalleService;
import mx.com.vrm.viai.service.EquipoService;
import mx.com.vrm.viai.service.EstacionService;

// TODO: Auto-generated Javadoc
/**
 * The Class AppController.
 */
@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	BajarPatioService bajarPatioService;

	@Autowired
	EquipoService equipoService;

	@Autowired
	EstacionService estacionService;

	@Autowired
	EquipoDetalleService equipoDetalleService;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(AppController.class);
	private static final SFTPConnector sshConnector = new SFTPConnector();
	List<EstatusJHEDTO> listaProcesoDetallado75 = new ArrayList<EstatusJHEDTO>();
	List<EstatusJHEDTO> listaProcesoDetallado76 = new ArrayList<EstatusJHEDTO>();
	List<EstatusJHEDTO> listaProcesoDetallado78 = new ArrayList<EstatusJHEDTO>();
	List<EstatusJHEDTO> listaProcesoDetallado79 = new ArrayList<EstatusJHEDTO>();
	List<EstatusTADDTO> listaProcesoDetallado680 = new ArrayList<EstatusTADDTO>();
	List<EstatusTADDTO> listaProcesoDetallado1280 = new ArrayList<EstatusTADDTO>();
	String total75 = "";
	String total76 = "";
	String total78 = "";
	String total79 = "";
	String total680 = "";
	String total1280 = "";
	ModelAndView model = new ModelAndView("principal");

	/**
	 * Login page.
	 *
	 * @param request  the request
	 * @param response the response
	 * @return the string
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String loginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		{
			logger.info("--inicia Login--");
			return "home";
		}
	}

	@RequestMapping(value = { "/reiniciaJHE" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void reiniciaJHE(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws ServletException, IOException {
		{
			logger.info("--Proceso:::Reinicio de servicios JHE:::Usuario->" + principal.getName());
			try {
				ProcesosSicopUtil.server75(true);
				ProcesosSicopUtil.server76(true);
				ProcesosSicopUtil.server78(true);
				ProcesosSicopUtil.server79(true);

			} catch (IllegalAccessException e) {
				logger.error("--Error Reinicio de servicios JHE--IllegalAccessException" + e);
			} catch (JSchException e) {
				logger.error("--Error Reinicio de servicios JHE--JSchException" + e);
			}
		}
	}

	@RequestMapping(value = { "/reiniciaTADS" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void reiniciaTADS(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws ServletException, IOException {
		{
			logger.info("--Proceso:::Reinicio de servicios TAD:::Usuario->" + principal.getName());

			try {
				ProcesosSicopUtil.server480(true);
				ProcesosSicopUtil.server481(true);
			} catch (IllegalAccessException e) {
				logger.error("--Error Reinicio de servicios JHE--IllegalAccessException" + e);
			} catch (JSchException e) {
				logger.error("--Error Reinicio de servicios JHE--JSchException" + e);
			}
		}
	}

	@RequestMapping(value = { "/armadoTren" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void consultaTren(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws ServletException, IOException {
		String resultado = "";
		{
			logger.info("--Proceso:::Reinicio de servicios Armando de tren:::Usuario->" + principal.getName());

			try {

				ProcesosSicopUtil.server480(true);
				ProcesosSicopUtil.server481(true);

				sshConnector.connect(Constants.USERNAME_SERVERS_JHE, Constants.PASSWORD_SERVERS_JHE, Constants.HOST_76,
						Constants.PORT_SERVERS_JHE);
				resultado = sshConnector
						.executeCommand("cd /upapps/jhe/tmi/;./terminal-train/bin/terminal-train restart") + "/n";
				resultado = sshConnector.executeCommand("./showproc.sh") + "/n";
				logger.info("-- :: Resultado ::--" + resultado);
				logger.info("--Instruccion completada de servicios armadoTren reinicio terminal-train 76 completado--");
				sshConnector.disconnect();

				sshConnector.connect(Constants.USERNAME_SERVERS_JHE, Constants.PASSWORD_SERVERS_JHE, Constants.HOST_79,
						Constants.PORT_SERVERS_JHE);
				resultado = sshConnector
						.executeCommand("cd /upapps/jhe/tmi/;./terminal-train/bin/terminal-train restart") + "/n";
				resultado = sshConnector.executeCommand("./showproc.sh") + "/n";
				logger.info("-- :: Resultado ::--" + resultado);
				logger.info("--Instruccion completada de servicios armadoTren reinicio terminal-train 79 completado--");
				sshConnector.disconnect();

			} catch (IllegalAccessException e) {
				logger.error("--Error Reinicio de servicios JHE--IllegalAccessException" + e);
			} catch (JSchException e) {
				logger.error("--Error Reinicio de servicios JHE--JSchException" + e);
			}
		}
	}

	@RequestMapping(value = { "/verificaErrores" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void verificaErrores(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws ServletException, IOException {
		String resultado = "";
		{
			logger.info("--Proceso:::Reinicio de servicios Verifica Errores:::Usuario->" + principal.getName());

			try {
				ProcesosSicopUtil.server480(true);
				ProcesosSicopUtil.server481(true);

				sshConnector.connect(Constants.USERNAME_SERVERS_JHE, Constants.PASSWORD_SERVERS_JHE, Constants.HOST_76,
						Constants.PORT_SERVERS_JHE);
				resultado = sshConnector.executeCommand(
						"cd /upapps/jhe/tmi/;./terminal-edit-car-placement_PL_1.4/bin/terminal-edit-car-placement restart")
						+ "/n";
				resultado = sshConnector.executeCommand("./showproc.sh") + "/n";
				logger.info("-- :: Resultado ::--" + resultado);
				logger.info(
						"--Instruccion completada de servicios verificaErrores reinicio placement_PL_1.4 76 completado--");
				sshConnector.disconnect();

				sshConnector.connect(Constants.USERNAME_SERVERS_JHE, Constants.PASSWORD_SERVERS_JHE, Constants.HOST_79,
						Constants.PORT_SERVERS_JHE);
				resultado = sshConnector.executeCommand(
						"cd /upapps/jhe/tmi/;./terminal-edit-car-placement_PL_1.4/bin/terminal-edit-car-placement restart")
						+ "/n";
				resultado = sshConnector.executeCommand("./showproc.sh") + "/n";
				logger.info("-- :: Resultado ::--" + resultado);
				logger.info(
						"--Instruccion completada de servicios verificaErrores reinicio placement_PL_1.4 79 completado--");
				sshConnector.disconnect();

			} catch (IllegalAccessException e) {
				logger.error("--Error Reinicio de servicios verificaErrores--IllegalAccessException" + e);
			} catch (JSchException e) {
				logger.error("--Error Reinicio de servicios verificaErrores--JSchException" + e);
			}
		}
	}

	@RequestMapping(value = { "/cartel0" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void cartel0(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws ServletException, IOException {
		String resultado = "";
		{
			logger.info("--Proceso:::Proceso cartel 00 :::Usuario->" + principal.getName());

			try {

				sshConnector.connect(Constants.USERNAME_SERVERS_JHE, Constants.PASSWORD_SERVERS_JHE, Constants.HOST_75,
						Constants.PORT_SERVERS_JHE);
				resultado = sshConnector.executeCommand("cd Reporte/;./ejecutaCartel0.sh") + "/n";
				logger.info("-- :: Resultado ::--" + resultado);
				logger.info("--Instruccion completada Corrección de cartel en la bd--");
				sshConnector.disconnect();

			} catch (IllegalAccessException e) {
				logger.error("--Error En la correcon de cartel 0--IllegalAccessException" + e);
			} catch (JSchException e) {
				logger.error("--Error En la correcon de cartel 0--JSchException" + e);
			}
		}
	}

	@RequestMapping(value = { "/eliminaEquipo" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void eliminaEquipo(HttpServletRequest request, HttpServletResponse response, Model model,
			@ModelAttribute("inicial") String inicial, @ModelAttribute("numero") String numero, Principal principal)
			throws ServletException, IOException {
		{
			try {
				logger.info("--Proceso:::Proceso ELIMINA EQUIPO:::Usuario->" + principal.getName());
				NctEqmt nctEqmt = new NctEqmt();

				logger.info("::::::inicial->" + inicial + "------numero->" + numero + ":::::::::");
				nctEqmt.setEqmtInit(inicial);
				nctEqmt.setEqmtNbr(new BigDecimal(numero));
				equipoService.eliminaEquipo(nctEqmt);
			} catch (SQLException e) {
				logger.error("--Error Reinicio de servicios JHE--IllegalAccessException" + e);
			}
		}
	}

	@RequestMapping(value = { "/eliminaEquipos" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void eliminaEquipos(HttpServletRequest request, HttpServletResponse response, Model model,
			@ModelAttribute("listaEquipos") String listaEquipos, Principal principal)
			throws ServletException, IOException {
		{
			try {
				logger.info("--Proceso:::Proceso ELIMINA EQUIPOs:::Usuario->" + principal.getName());
				NctEqmt nctEqmt = new NctEqmt();
				String[] parts = listaEquipos.split(",");

				for (int cnt = 0; cnt < parts.length; cnt++) {
					Pattern pinicial = Pattern.compile("[a-zA-Z]{1,4}");
					Pattern pnumero = Pattern.compile("[^a-zA-Z]{1,6}");
					Matcher inicialm = pinicial.matcher(parts[cnt]);
					Matcher numerom = pnumero.matcher(parts[cnt]);
					inicialm.find();
					numerom.find();
					logger.info("Inicial:::" + inicialm.group(0).trim());
					logger.info("Numero:::" + numerom.group(0).trim());
					nctEqmt.setEqmtInit(inicialm.group(0).trim());
					nctEqmt.setEqmtNbr(new BigDecimal(numerom.group(0).trim()));
					equipoService.eliminaEquipo(nctEqmt);
				}

			} catch (Exception e) {
				logger.error("--Error Reinicio de servicios JHE--IllegalAccessException" + e);
			}
		}
	}

	@RequestMapping(value = { "/eliminaTrenDuplicado" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void eliminaTrenesDuplicados(HttpServletRequest request, HttpServletResponse response, Model model,
			@ModelAttribute("estacion") String estacion, @ModelAttribute("tren") String tren,
			@ModelAttribute("fecTren") String fechaTren, Principal principal) throws ServletException, IOException {
		{
			try {
				TrenInboundResourceDTO trenInboundResourceDTO = new TrenInboundResourceDTO();
				List<NctEqmt> listaEquipos = new ArrayList<NctEqmt>();
				NctEqmt updateInbRse = new NctEqmt();
				EquipoCompletoDTO equipoCompletoDTO = new EquipoCompletoDTO();
				logger.info("--Proceso:::Proceso ELIMINA TREN DUPLICADO:::Usuario->" + principal.getName());
				logger.info("--Proceso:::ESTACION--" + estacion);
				logger.info("--Proceso:::TREN DUPLICADO--" + tren + " "
						+ FechaUtil.obtenerDiaFechaCompletaGuion(fechaTren));
				logger.info("--Proceso:::ESTACION--" + estacion + "/"
						+ estacionService.consultaEstacionPorC7(estacion).getStationId());

				trenInboundResourceDTO = bajarPatioService.consultarTrenBajarPatio(tren, fechaTren,
						estacionService.consultaEstacionPorC7(estacion).getStationId());
				updateInbRse.setInbdResrId(new BigDecimal(trenInboundResourceDTO.getIdTren()));
				updateInbRse.setInbdResrSymb(tren);
				updateInbRse.setInbdResrDt(FechaUtil.obtenerFechaFromStringDDMMYYYY(fechaTren));

				if (trenInboundResourceDTO.isDuplicado()) {
					bajarPatioService.eliminarTrenBajarPatio(trenInboundResourceDTO.getIdTrenDelete(), tren,
							FechaUtil.obtenerFechaFromStringDDMMYYYY(fechaTren));
					logger.info("Inicia obtencion de repetidos");
					listaEquipos = mx.com.vrm.viai.configuration.util.Util
							.listaEquipos(equipoService.obtenerListaRepetidos(tren, fechaTren));
					logger.info("Inicia obtencion de repetidos::::" + listaEquipos.size());
					if (listaEquipos.size() > 0) {
						for (NctEqmt equipoConsulta : listaEquipos) {
							logger.info("Inicia recorrer equipos");
							//equipoConsulta.setInbdResrId(new BigDecimal(trenInboundResourceDTO.getIdTrenDelete()));
							equipoCompletoDTO.setEquipo(equipoService.obtenerEquipo(equipoConsulta));
							logger.info("Inicia recorrer equipos:::>Equipo consultado" + equipoCompletoDTO.getEquipo());
							// equipoCompletoDTO.setEquipoDetalle(equipoDetalleService.consultaDetalleEquipo(equipoConsulta));
							equipoService.eliminaEquipo(equipoCompletoDTO.getEquipo());
							// equipoCompletoDTO.getEquipo().setInbdResrId(new
							// BigDecimal(trenInboundResourceDTO.getIdTren()));
							// equipoService.crearEquipo(equipoCompletoDTO.getEquipo());
							// equipoDetalleService.crearDetalleEquipo(equipoCompletoDTO.equipoDetalle);

						}
						
					}
				} else {
					logger.info("No hay trenes repetidos");
					listaEquipos = mx.com.vrm.viai.configuration.util.Util
							.listaEquipos(equipoService.obtenerListaRepetidos(tren, fechaTren));
					logger.info("Inicia obtencion de repetidos cuando no hay trenes::::" + listaEquipos.size());
					if (listaEquipos.size() > 0) {
						for (NctEqmt equipoConsulta : listaEquipos) {
							//equipoConsulta.setInbdResrId(new BigDecimal(trenInboundResourceDTO.getIdTrenDelete()));
							equipoConsulta.setInbdResrSymb(tren);
							equipoCompletoDTO.setEquipo(equipoService.obtenerEquipo(equipoConsulta));
							// equipoCompletoDTO.setEquipoDetalle(equipoDetalleService.consultaDetalleEquipo(equipoConsulta));
							equipoService.eliminaEquipo(equipoCompletoDTO.getEquipo());
							// equipoCompletoDTO.getEquipo().setInbdResrId(new
							// BigDecimal(trenInboundResourceDTO.getIdTren()));
							// equipoService.crearEquipo(equipoCompletoDTO.getEquipo());
							// equipoDetalleService.crearDetalleEquipo(equipoCompletoDTO.equipoDetalle);

						}
						
					}
				}
				equipoService.actualizaInbrsTren(updateInbRse);	
			} catch (Exception e) {
				logger.error("--Error al eliminar el tren duplicado" + e);
			}
		}
	}

	@RequestMapping(value = { "/reiniciaCeo" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void reiniciaCeo(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws ServletException, IOException {
		{
			logger.info("--Proceso:::Reinicio de procesos CEO:::Usuario->" + principal.getName());

			try {

				sshConnector.connect(Constants.USERNAME_SERVERS_73_CEO, Constants.PASSWORD_SERVERS_73_CEO,
						Constants.HOST_CEO_73, Constants.PORT_SERVERS_JHE);
				sshConnector.executeCommand("cd /upapps/jvm/com-ceo_filter/bin; ./ceo-filter-script stop");
				sshConnector.executeCommand("cd /upapps/jvm/com-ceo_filter/bin; ./ceo-filter-script start");
				logger.info("--Instruccion completada reinicio de CEO--");
				sshConnector.disconnect();

				sshConnector.connect(Constants.USERNAME_SERVERS_71_CEO, Constants.PASSWORD_SERVERS_71_CEO,
						Constants.HOST_CEO_71, Constants.PORT_SERVERS_JHE);
				sshConnector.executeCommand("cd /upapps/jvm/com-ceo_filter/bin; ./ceo-filter-script stop");
				sshConnector.executeCommand("cd /upapps/jvm/com-ceo_filter/bin; ./ceo-filter-script start");
				logger.info("--Instruccion completada reinicio de CEO--");
				sshConnector.disconnect();

			} catch (IllegalAccessException e) {
				logger.error("--Error al reiniciar ceo--IllegalAccessException" + e);
			} catch (JSchException e) {
				logger.error("--Error al reiniciar ceo--JSchException" + e);
			}
		}
	}

	@RequestMapping(value = { "/reiniciaTodo" }, method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void reiniciaTodo(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws ServletException, IOException, IllegalAccessException, JSchException {
		{
			logger.info("--Proceso:::REINICIANDO TODO:::Usuario->" + principal.getName());
			reiniciaTADS(request, response, principal);
			reiniciaJHE(request, response, principal);
		}
	}

	@RequestMapping(value = { "/obtenerStatusJhe" }, method = RequestMethod.GET)
	public ModelAndView obtenerStatus(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws ServletException, IOException, IllegalAccessException, JSchException {
		String resultado = "";

		try {

			logger.info("--Proceso:::Obtener status JHE:::Usuario->" + principal.getName());

			resultado = ProcesosSicopUtil.server75(false);
			logger.info("::SERVER 75 STATUS::" + getListaProcesoDetallado75().size());
			setListaProcesoDetallado75(JheEnum.getDetalleProceso(JheEnum.existeJHE(resultado), resultado, "75"));
			resultado = "";

			resultado = ProcesosSicopUtil.server76(false);
			logger.info("::SERVER 76 STATUS::" + getListaProcesoDetallado76().size());
			setListaProcesoDetallado76(JheEnum.getDetalleProceso(JheEnum.existeJHE(resultado), resultado, "76"));
			resultado = "";

			resultado = ProcesosSicopUtil.server78(false);
			logger.info("::SERVER 78 STATUS::" + getListaProcesoDetallado78().size());
			setListaProcesoDetallado78(JheEnum.getDetalleProceso(JheEnum.existeJHE(resultado), resultado, "78"));
			resultado = "";

			logger.info("::SERVER 79 STATUS::" + getListaProcesoDetallado79().size());
			resultado = ProcesosSicopUtil.server79(false);
			setListaProcesoDetallado79(JheEnum.getDetalleProceso(JheEnum.existeJHE(resultado), resultado, "79"));
			resultado = "";

			model.addObject("listaProcesoDetallado75", getListaProcesoDetallado75());
			model.addObject("listaProcesoDetallado76", getListaProcesoDetallado76());
			model.addObject("listaProcesoDetallado78", getListaProcesoDetallado78());
			model.addObject("listaProcesoDetallado79", getListaProcesoDetallado79());

			setTotal75(String.valueOf(getListaProcesoDetallado75().size()));
			setTotal76(String.valueOf(getListaProcesoDetallado76().size()));
			setTotal78(String.valueOf(getListaProcesoDetallado78().size()));
			setTotal79(String.valueOf(getListaProcesoDetallado79().size()));

			model.addObject("total75", getTotal75());
			model.addObject("total76", getTotal76());
			model.addObject("total78", getTotal78());
			model.addObject("total79", getTotal79());

			return model;

		} catch (JSchException ex) {
			ex.printStackTrace();

			logger.info(ex.getMessage());
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();

			logger.info(ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();

			logger.info(ex.getMessage());
		}
		return model;
	}

	@RequestMapping(value = { "/obtenerStatusTad" }, method = RequestMethod.GET)
	public ModelAndView obtenerStatusTad(HttpServletRequest request, HttpServletResponse response, Principal principal)
			throws ServletException, IOException, IllegalAccessException, JSchException {
		String resultado = "";

		try {
			logger.info("--Proceso:::Obtener Status TAD:::Usuario->" + principal.getName());

			resultado = ProcesosSicopUtil.server680s(false);
			logger.info("::SERVER 680 STATUS::" + getListaProcesoDetallado680().size());
			setListaProcesoDetallado680(TadEnum.getDetalleProceso(TadEnum.existeTAD(resultado), resultado, "680"));
			resultado = "";

			resultado = ProcesosSicopUtil.server480s(false);
			logger.info("::SERVER 1280 STATUS::" + getListaProcesoDetallado1280().size());
			setListaProcesoDetallado1280(TadEnum.getDetalleProceso(TadEnum.existeTAD(resultado), resultado, "1280"));
			resultado = "";

			setTotal680(String.valueOf(getListaProcesoDetallado680().size()));
			setTotal1280(String.valueOf(getListaProcesoDetallado1280().size()));

			model.addObject("listaProcesoDetallado680", getListaProcesoDetallado680());
			model.addObject("listaProcesoDetallado1280", getListaProcesoDetallado1280());
			model.addObject("total680", getTotal680());
			model.addObject("total1280", getTotal1280());
			return model;

		} catch (JSchException ex) {
			ex.printStackTrace();

			logger.info(ex.getMessage());
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();

			logger.info(ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();

			logger.info(ex.getMessage());
		}
		return model;
	}

	/**
	 * Home page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = { "/principal" }, method = RequestMethod.GET)
	public ModelAndView homePage(ModelAndView internalModel) {

		model = new ModelAndView("principal");
		model.addObject("listaProcesoDetallado75", listaProcesoDetallado75);
		model.addObject("listaProcesoDetallado76", listaProcesoDetallado76);
		model.addObject("listaProcesoDetallado78", listaProcesoDetallado78);
		model.addObject("listaProcesoDetallado79", listaProcesoDetallado79);
		model.addObject("total75", getTotal75());
		model.addObject("total76", getTotal76());
		model.addObject("total78", getTotal78());
		model.addObject("total79", getTotal79());
		model.addObject("listaProcesoDetallado680", getListaProcesoDetallado680());
		model.addObject("listaProcesoDetallado1280", getListaProcesoDetallado1280());
		model.addObject("total680", getTotal680());
		model.addObject("total1280", getTotal1280());
		return model;
	}

	/**
	 * Gets the principal.
	 *
	 * @return the principal
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	/**
	 * Access denied page.
	 *
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "Access_Denied";
	}

	/**
	 * Login page.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String loginPage() {
		return "home";
	}

	/**
	 * Logout page.
	 *
	 * @param request  the request
	 * @param response the response
	 * @return the string
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home?logout";
	}

	public List<EstatusJHEDTO> getListaProcesoDetallado75() {
		return listaProcesoDetallado75;
	}

	public void setListaProcesoDetallado75(List<EstatusJHEDTO> listaProcesoDetallado75) {
		this.listaProcesoDetallado75 = listaProcesoDetallado75;
	}

	public List<EstatusJHEDTO> getListaProcesoDetallado76() {
		return listaProcesoDetallado76;
	}

	public void setListaProcesoDetallado76(List<EstatusJHEDTO> listaProcesoDetallado76) {
		this.listaProcesoDetallado76 = listaProcesoDetallado76;
	}

	public List<EstatusJHEDTO> getListaProcesoDetallado78() {
		return listaProcesoDetallado78;
	}

	public void setListaProcesoDetallado78(List<EstatusJHEDTO> listaProcesoDetallado78) {
		this.listaProcesoDetallado78 = listaProcesoDetallado78;
	}

	public List<EstatusJHEDTO> getListaProcesoDetallado79() {
		return listaProcesoDetallado79;
	}

	public void setListaProcesoDetallado79(List<EstatusJHEDTO> listaProcesoDetallado79) {
		this.listaProcesoDetallado79 = listaProcesoDetallado79;
	}

	public List<EstatusTADDTO> getListaProcesoDetallado680() {
		return listaProcesoDetallado680;
	}

	public void setListaProcesoDetallado680(List<EstatusTADDTO> listaProcesoDetallado680) {
		this.listaProcesoDetallado680 = listaProcesoDetallado680;
	}

	public List<EstatusTADDTO> getListaProcesoDetallado1280() {
		return listaProcesoDetallado1280;
	}

	public void setListaProcesoDetallado1280(List<EstatusTADDTO> listaProcesoDetallado1280) {
		this.listaProcesoDetallado1280 = listaProcesoDetallado1280;
	}

	public String getTotal75() {
		return total75;
	}

	public void setTotal75(String total75) {
		this.total75 = total75;
	}

	public String getTotal76() {
		return total76;
	}

	public void setTotal76(String total76) {
		this.total76 = total76;
	}

	public String getTotal78() {
		return total78;
	}

	public void setTotal78(String total78) {
		this.total78 = total78;
	}

	public String getTotal79() {
		return total79;
	}

	public void setTotal79(String total79) {
		this.total79 = total79;
	}

	public String getTotal680() {
		return total680;
	}

	public void setTotal680(String total680) {
		this.total680 = total680;
	}

	public String getTotal1280() {
		return total1280;
	}

	public void setTotal1280(String total1280) {
		this.total1280 = total1280;
	}

}
