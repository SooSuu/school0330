package egovframework.let.board2.service.impl;
import java.util.Iterator;
import java.util.List;

import egovframework.let.board2.service.Board2VO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import org.springframework.stereotype.Repository;

@Mapper("board2Mapper")
public interface Board2Mapper {
	
	//게시물 목록 가져오기
	List<EgovMap> selectBoard2List(Board2VO vo) throws Exception;

	//게시물 목록 수
	int selectBoard2ListCnt(Board2VO vo) throws Exception;
	
	//게시물 등록하기
	void insertBoard2(Board2VO vo) throws Exception;
	
	//게시물 상세정보
	Board2VO selectBoard2(Board2VO vo) throws Exception;
	
	//조회수 업데이트
	void updateViewCnt(Board2VO vo) throws Exception;
	
	//게시물 수정하기
	void updateBoard2(Board2VO vo) throws Exception;
	
	//게시물 삭제하기
	void deleteBoard2(Board2VO vo) throws Exception;
}
