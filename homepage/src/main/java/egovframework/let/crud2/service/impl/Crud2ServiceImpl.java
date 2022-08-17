package egovframework.let.crud2.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.crud2.service.Crud2Service;
import egovframework.let.crud2.service.Crud2VO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("crud2Service")
public class Crud2ServiceImpl extends EgovAbstractServiceImpl implements Crud2Service{
	//Crud2ServiceImpl 에서 에러 표시가 뜨는 것은 기능이 다 추가되지 않은 것. F2로 무언가 추가해서 에러표시만 해제하면 나중에 힘들다...ㅠㅠ 
	//implements Crud2Service = Crud2Service를 가져온다	
	
	@Resource(name = "crud2Mapper")
	private Crud2Mapper crud2Mapper;
	
	//idgen--> context-idgen
	@Resource(name = "egovCrudIdGnrService")
	private EgovIdGnrService idgenService;
	
	
	//CRUD 목록 가져오기
	public List<EgovMap> selectCrud2List(Crud2VO vo) throws Exception{
		return crud2Mapper.selectCrud2List(vo);
	}
	//CRUD 등록하기
	public String insertCrud2(Crud2VO vo) throws Exception{
		String id = idgenService.getNextStringId();
		vo.setCrudId(id);
		crud2Mapper.insertCrud2(vo);
		return null;
	}
	//CRUD 가져오기
	public Crud2VO selectCrud2(Crud2VO vo) throws Exception{
		return crud2Mapper.selectCrud2(vo);
	}
	//CRUD 수정하기
	public void updateCrud2(Crud2VO vo) throws Exception{
		crud2Mapper.updateCrud2(vo);
	}
	//CRUD 삭제하기
	public void deleteCrud2(Crud2VO vo) throws Exception{
		crud2Mapper.deleteCrud2(vo);
	}
	//CRUD 목록 수
	public int selectCrud2ListCnt(Crud2VO vo) throws Exception{
		return crud2Mapper.selectCrud2ListCnt(vo);
	}
}
