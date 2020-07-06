package mx.com.vrm.viai.configuration.restDTO;

// TODO: Auto-generated Javadoc
/**
 * eMsgResp.
 */
public enum eMsgResp {

	/** The ok. */
	/* Generic Codes */
	OK(0, "Exito"),

	/** The gen ser. */
	GEN_SER(-1, "Error de Servicio"),

	/** The gen bsn. */
	GEN_BSN(1, "Error de Negocio"),

	/** The bad rqt. */
	BAD_RQT(2, "Parametros no validos"),

	/** The bad rsp. */
	BAD_RSP(3, "Error en origen"),

	/** The bad rsp sq. */
	BAD_RSP_BD(4, "Error en respuesta en la DB"),

	/** The bad rsp io. */
	BAD_RSP_IO(5, "Error, operacion interrupida"),

	/** The bad que no. */
	BAD_QUE_NO(6, "Error, al consumir queue de notificaciones"),

	/** The bad login. */
	BAD_LOGIN(7, "usr/pass, incorrecto"),

	/** The bad privilege. */
	BAD_PRIVILEGE(8, "Sin permisos para acceder a la APP"),

	/** The date parser. */
	/* Date */
	DATE_PARSER(10, "Fecha con formato incorrecto"),

	/** The header fail. */
	/* Header */
	HEADER_FAIL(100, "Dispositivo no permitido"),

	/** The profile fail. */
	PROFILE_FAIL(101, "Sin respuesta al obtener el perfil"),

	/** The user not fount. */
	USER_NOT_FOUNT(102, "Usuario no encontrado"),

	/** The roles not fount. */
	ROLES_NOT_FOUNT(103, "Lista de Roles no encontrada"),

	/** The role unknow. */
	ROLE_UNKNOW(104, "Rol desconocido"),

	/** The local not found. */
	LOCAL_NOT_FOUND(105, "Localidad No encontrada"),

	/** The div not found. */
	DIV_NOT_FOUND(106, "Division No encontrada"),

	/** The cat unknow. */
	/* Catalog MSG Errors */
	CAT_UNKNOW(200, "Catalogo Desconocido"),

	/** The cat vias. */
	CAT_VIAS(201, "Sin respuesta al obtener el catalogo de vias"),

	/** The cat division. */
	CAT_DIVISION(202, "Sin respuesta al obtener el catalogo de divisiones"),

	/** The cat station. */
	CAT_STATION(203, "Sin respuesta al obtener el catalogo de estaciones"),

	/** The cat yards. */
	CAT_YARDS(204, "Sin respuesta al obtener el catalogo de patios"),

	/** The cat orders. */
	CAT_ORDERS(205, "Sin respuesta al obtener el catalogo de orders"),

	/** The cat exeptions. */
	CAT_EXEPTIONS(206, "Sin respuesta al obtener el catalogo de excepciones"),

	/** The cat status l. */
	CAT_STATUS_L(207, "Sin respuesta al obtener el catalogo de status de lista de maniobras"),

	/** The cat status r. */
	CAT_STATUS_R(208, "Sin respuesta al obtener el catalogo de status de rodajes"),

	/** The error rules doc. */
	/* Documents MSG Errors */
	ERROR_RULES_DOC(300, "Sin respuesta al obtener reglas de los documentos"),

	/** The path doc error. */
	PATH_DOC_ERROR(301, "Error en la ruta de documentos"),

	/** The not ff. */
	NOT_FF(302, "Archivo no encontrado"),

	/** The error file. */
	ERROR_FILE(303, "Error en el Archivo"),

	/** The get maneuver. */
	/* Maneuver */
	GET_MANEUVER(400, "Sin respuesta al obtener lista de maniobras"),

	/** The no program maneuver. */
	NO_PROGRAM_MANEUVER(401, "Sin respuesta al obtener trabajo no programado"),

	/** The moving maneuver. */
	MOVING_MANEUVER(402, "Sin respuesta al realizar movimiento de maniobra"),

	/** The status maneuver. */
	STATUS_MANEUVER(403, "Sin respuesta al cambiar el estatus de maniobras"),

	/** The get running. */
	/* Running */
	GET_RUNNING(500, "Sin respuesta al obtener lista de rodajes"),

	/** The movieng running. */
	MOVIENG_RUNNING(501, "Sin respuesta al realizar movimiento de rodajes"),

	/** The status running. */
	STATUS_RUNNING(502, "Sin respuesta al cambiar estatus de rodajes"),

	/** The extra running. */
	EXTRA_RUNNING(503, "Sin respuesta al obtener trabajo extraordinario"),

	/** The deallocate running. */
	DEALLOCATE_RUNNING(504, "Sin respuesta al desasignar rodaje"),

	/** The get msg. */
	/* Messages */
	GET_MSG(600, "Sin respuesta al obtener Mensajes"),

	/** The commit msg. */
	COMMIT_MSG(601, "Sin respuesta al confirmar mensajes"),

	/** The get notify. */
	GET_NOTIFY(602, "Sin respuesta al obtener notificaciones"),

	/** The commit notify. */
	COMMIT_NOTIFY(603, "Sin respuesta al confirmar notificaciones"),

	/** The bad rsp duplicate. */
	/* Bussines */
	BAD_RSP_DUPLICATE(700, "Registro ya existente"),

	/** The bad ins. */
	BAD_INS(701, "Error al insertar registro en la BD"),

	/** The bad upd. */
	BAD_UPD(702, "Error al actualizar registro en la BD"),

	/** The bad dlt. */
	BAD_DLT(703, "Error al eliminar registro en la BD"),

	/** The bad dlta. */
	BAD_DLTA(704, "Error al eliminar todos los registro en la BD"),;

	/** The val cod. */
	private Integer valCod;

	/** The val msg. */
	private String valMsg;

	/**
	 * Instantiates a new e msg resp.
	 *
	 * @param valCod
	 *            the val cod
	 * @param valMsg
	 *            the val msg
	 */
	private eMsgResp(Integer valCod, String valMsg) {
		this.valCod = valCod;
		this.valMsg = valMsg;
	}

	/**
	 * Gets the val cod.
	 *
	 * @return the val cod
	 */
	public Integer getValCod() {
		return valCod;
	}

	/**
	 * Gets the val msg.
	 *
	 * @return the val msg
	 */
	public String getValMsg() {
		return valMsg;
	}

}
