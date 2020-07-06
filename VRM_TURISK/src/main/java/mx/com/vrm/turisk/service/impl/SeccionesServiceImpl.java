package mx.com.vrm.viai.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import mx.com.vrm.viai.dao.SeccionesDAO;
import mx.com.vrm.viai.service.SeccionesService;

// TODO: Auto-generated Javadoc
/**
 * The Class SeccionesServiceImpl.
 */
@Service
@Transactional
public class SeccionesServiceImpl implements SeccionesService {

	/** The secciones DAO. */
	// @Autowired
	SeccionesDAO seccionesDAO;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(SeccionesServiceImpl.class);

}
