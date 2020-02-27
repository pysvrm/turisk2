package mx.com.vrm.viai.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import mx.com.vrm.viai.configuration.ConexionJavaOracleSicop;
import mx.com.vrm.viai.configuration.crudmngImpl.CrudDataManagerImpl;
import mx.com.vrm.viai.dao.EquipoDAO;
import mx.com.vrm.viai.dto.EquipoCompletoDTO;
import mx.com.vrm.viai.model.NctEqmt;
import mx.com.vrm.viai.model.NctSysStn;

@Repository
public class EquipoDAOImpl extends CrudDataManagerImpl<NctEqmt, Serializable> implements EquipoDAO {

	private static final Logger logger = LoggerFactory.getLogger(EquipoDAOImpl.class);
	
	public void eliminaEquipo(NctEqmt nctEqmt) throws SQLException {
		ejecutaDelete(nctEqmt);
		
	}

	public void ejecutaDelete(NctEqmt nctEqmt) throws SQLException {
		final ConexionJavaOracleSicop conexionJavaOracleSicop = new ConexionJavaOracleSicop();
		Connection connection = conexionJavaOracleSicop.conexionOracle();
		Statement deleteStatement = connection.createStatement();

		try {
			String deleteEqmt = "DELETE FROM nct_eqmt WHERE eqmt_init ='" + nctEqmt.getEqmtInit().toUpperCase()
					+ "'  AND   eqmt_nbr =" + nctEqmt.getEqmtNbr();
			String deleteEqmtDtl = " DELETE FROM nct_eqmt_dtl WHERE eqmt_init ='" + nctEqmt.getEqmtInit().toUpperCase()
			+ "' AND   eqmt_nbr =" + nctEqmt.getEqmtNbr();
			logger.info(":::::::Se elimina Equipo::::" + nctEqmt.getEqmtInit() + nctEqmt.getEqmtNbr());
			deleteStatement.executeUpdate(deleteEqmt);
			deleteStatement.executeUpdate(deleteEqmtDtl);
			logger.info(":: Termina borrado ::");
		} catch (SQLException e) {
			logger.error("Error al eliminar ::" + e);
		} finally {
			logger.info(":: Termina Session ::");
			deleteStatement.close();
			connection.close();
		}
	}

	@Override
	public String obtenerListaRepetidos(String tren, String fechaTren) throws SQLException {
		final ConexionJavaOracleSicop conexionJavaOracleSicop = new ConexionJavaOracleSicop();
		Connection connection = conexionJavaOracleSicop.conexionOracle();
		Statement queryStatement = connection.createStatement();
		ResultSet rs;
		String equipos = "";
		
		logger.info("Fechas Equipo DAO::::"+fechaTren);
		try {
			String obtieneEqmtRepetido = "SELECT qq.EQMT_INIT || qq.EQMT_NBR  as EQMT " + 
					" FROM NCT_EQMT qq " + 
					" WHERE qq.INBD_RESR_SYMB = "
					+ "'"+tren+"' " + 
					" AND INBD_RESR_DT = TO_DATE("
					+ "'"+fechaTren+"' , 'dd-mm-yyyy')" + 
					" GROUP BY qq.EQMT_INIT || qq.EQMT_NBR " + 
					" HAVING COUNT(qq.EQMT_INIT || qq.EQMT_NBR) > 1 ";
			
			rs = queryStatement.executeQuery(obtieneEqmtRepetido);
			 while ( rs.next() ) {
	                 equipos = equipos+ rs.getString("EQMT")+",";
	            }
			logger.info(":: Termina borrado ::");
		} catch (SQLException e) {
			logger.error("Error al eliminar ::" + e);
		} finally {
			logger.info(":: Termina Session ::");
			queryStatement.close();
			connection.close();
		}
		
		return equipos;
	}

	@Override
	public NctEqmt obtenerEquipo(NctEqmt nctEqmt) throws SQLException {
		NctEqmt nctEqmtCompleto = new NctEqmt(); 
		
		nctEqmtCompleto = manager
		.createQuery("SELECT rr FROM NctEqmt rr WHERE rr.eqmtInit = ?1 AND rr.eqmtNbr=?2 ORDER BY rr.eqmtId ASC", NctEqmt.class)
		.setParameter(1, nctEqmt.getEqmtInit()).setParameter(2, nctEqmt.getEqmtNbr()).getResultList().get(0);
		logger.info("IDEQUIPO:"+nctEqmtCompleto.getEqmtId());
		return nctEqmtCompleto;
	}

	@Override
	public void crearEquipo(NctEqmt equipoCompleto) {
		create(equipoCompleto);
		
	}

	@Override
	public void actualizaInbrsTren(NctEqmt nctEqmt) {
		 manager
			.createQuery("UPDATE NctEqmt rr SET rr.inbdResrId = ?1 WHERE  rr.inbdResrSymb=?2 AND rr.inbdResrDt=?3 ")
			.setParameter(1, nctEqmt.getInbdResrId()).setParameter(2, nctEqmt.getInbdResrSymb()).setParameter(3, nctEqmt.getInbdResrDt()).executeUpdate();
	}

}
