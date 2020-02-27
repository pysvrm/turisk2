package mx.com.vrm.viai.service.impl;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import mx.com.vrm.viai.dao.PoliticasDAO;
import mx.com.vrm.viai.service.PoliticasService;

// TODO: Auto-generated Javadoc
/**
 * The Class PoliticasServiceImpl.
 */
@Service
@Transactional
public class PoliticasServiceImpl implements PoliticasService {

	/** The politicas DAO. */
	// @Autowired
	PoliticasDAO politicasDAO;

}
