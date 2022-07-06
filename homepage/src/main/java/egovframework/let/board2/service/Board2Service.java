package egovframework.let.board2.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface Board2Service {
	
	//게시물 목록 가져오기
	public List<EgovMap> selectBoard2List(Board2VO vo) throws Exception;
	//게시물 목록 수
	public int selectBoard2ListCnt(Board2VO vo) throws Exception;
	//게시물 등록하기
	public String insertBoard2(Board2VO vo) throws Exception;
	//게시물 상세정보
	public Board2VO selectBoard2(Board2VO vo) throws Exception;
	//게시물 수정하기
	public void updateBoard2(Board2VO vo) throws Exception;
	//게시물 삭제하기
	public void deleteBoard2(Board2VO vo) throws Exception;
}