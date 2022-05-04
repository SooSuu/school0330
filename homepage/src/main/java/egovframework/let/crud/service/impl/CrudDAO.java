package egovframework.let.crud.service.impl;
import java.util.Iterator;
import java.util.List;

import egovframework.let.cop.bbs.service.Board;
import egovframework.let.cop.bbs.service.BoardVO;
import egovframework.let.crud.service.CrudVO;
import egovframework.let.temp.service.TempVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

import org.springframework.stereotype.Repository;

@Repository("crudDAO")
public class CrudDAO extends EgovAbstractDAO {
	
	public CrudVO selectCrud(CrudVO crudVO) throws Exception {
		return (CrudVO)select("CrudDAO.selectCrud",crudVO);
	}
	
}
