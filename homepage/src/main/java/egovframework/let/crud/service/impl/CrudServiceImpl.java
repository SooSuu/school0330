package egovframework.let.crud.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.let.cop.bbs.service.Board;
import egovframework.let.cop.bbs.service.BoardVO;
import egovframework.let.cop.bbs.service.EgovBBSManageService;
import egovframework.let.crud.service.CrudService;
import egovframework.let.crud.service.CrudVO;
import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
import egovframework.let.temp2.service.Temp2VO;
import egovframework.let.utl.fcc.service.EgovDateUtil;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("crudService")
public class CrudServiceImpl extends EgovAbstractServiceImpl
	implements CrudService{
		
	@Resource(name = "crudMapper")
	private CrudMapper crudMapper;
	
	@Resource(name = "egovCrudIdGnrService")
	private EgovIdGnrService idgenService;
	
	@Override
	public CrudVO selectCrud(CrudVO vo) throws Exception{
		return crudMapper.selectCrud(vo);
		
	}
	//임시데이터 목록 가져오기
	public List<EgovMap> selectCrudList(CrudVO vo) throws Exception{
		return crudMapper.selectCrudList(vo);
	}
	//임시데이터 등록하기
	public String insertCrud(CrudVO vo) throws Exception{
		String id = idgenService.getNextStringId();
		vo.setCrudId(id);
		crudMapper.insertCrud(vo);
		return null;
	}
	//임시데이터 목록 가져오기
	public void updateCrud(CrudVO vo) throws Exception{
		crudMapper.updateCrud(vo);
	}
	//임시데이터 삭제하기
	public void deleteCrud(CrudVO vo) throws Exception{
		crudMapper.deleteCrud(vo);
	}
	//임시데이터 목록 수
	public int selectCrudListCnt(CrudVO vo) throws Exception{
		return crudMapper.selectCrudListCnt(vo);
	}
}
