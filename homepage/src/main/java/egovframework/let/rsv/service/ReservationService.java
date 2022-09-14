package egovframework.let.rsv.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface ReservationService {

	//예약목록 가져오기
	public List<EgovMap> selectReservationList(ReservationVO vo) throws Exception;
	//예약목록수
	public int selectReservationListCnt(ReservationVO vo) throws Exception;
	//예약상세정보
	public ReservationVO selectReservation(ReservationVO vo) throws Exception;
	//예약등록하기
	public String insertReservation(ReservationVO vo) throws Exception;
	//예약수정하기
	public void updateReservation(ReservationVO vo) throws Exception;
	//예약삭제하기
	public void deleteReservation(ReservationVO vo) throws Exception; 
}
