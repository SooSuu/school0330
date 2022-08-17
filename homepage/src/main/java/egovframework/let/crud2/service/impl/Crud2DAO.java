package egovframework.let.crud2.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.let.crud2.service.Crud2VO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("crud2DAO")
public class Crud2DAO extends EgovAbstractDAO {
	
	public Crud2VO selectCrud(Crud2VO crud2VO) throws Exception {
		return (Crud2VO)select("Crud2DAO.selectCrud",crud2VO);
	}
	
}
