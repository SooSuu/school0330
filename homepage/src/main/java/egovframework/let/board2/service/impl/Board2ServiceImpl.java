package egovframework.let.board2.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.let.board2.service.Board2Service;
import egovframework.let.board2.service.Board2VO;
import egovframework.let.utl.fcc.service.EgovDateUtil;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("board2Service")
public class Board2ServiceImpl extends EgovAbstractServiceImpl implements Board2Service{
		
	@Resource(name = "board2Mapper")
	private Board2Mapper board2Mapper;
	
	//idgen--> context-idgen
	@Resource(name = "egovBoardIdGnrService")
	private EgovIdGnrService idgenService;
	
	//게시물 목록 가져오기
	public List<EgovMap> selectBoard2List(Board2VO vo) throws Exception{
		return board2Mapper.selectBoard2List(vo);
	}
	//게시물 목록 수
	public int selectBoard2ListCnt(Board2VO vo) throws Exception{
		return board2Mapper.selectBoard2ListCnt(vo);
	}
	//게시물 등록하기
	public String insertBoard2(Board2VO vo) throws Exception{
		String id = idgenService.getNextStringId();
		vo.setBoardId(id);
		board2Mapper.insertBoard2(vo);
		
		return id;
	}
	//게시물 상세정보
	public Board2VO selectBoard2(Board2VO vo) throws Exception{
		//조회수 업(Controller에 들어가도 되지만 트랜잭션 처리를 위해 impl에 넣음)
		board2Mapper.updateViewCnt(vo);
		
		return board2Mapper.selectBoard2(vo);
	}
	//게시물 수정하기
	public void updateBoard2(Board2VO vo) throws Exception{
		board2Mapper.updateBoard2(vo);
	}
	//게시물 삭제하기
	public void deleteBoard2(Board2VO vo) throws Exception{
		board2Mapper.deleteBoard2(vo);
	}
}
