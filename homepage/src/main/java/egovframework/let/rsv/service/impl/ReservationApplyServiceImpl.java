package egovframework.let.rsv.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.rsv.service.ReservationApplyService;
import egovframework.let.rsv.service.ReservationApplyVO;
import egovframework.let.rsv.service.ReservationService;
import egovframework.let.rsv.service.ReservationVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("reservationApplyService")
public class ReservationApplyServiceImpl extends EgovAbstractServiceImpl implements ReservationApplyService{

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;
	
	@Resource(name = "reservationApplyMapper")
	protected ReservationApplyMapper reservationApplyMapper;
	
	@Resource(name = "egovReqIdGnrService")
	protected EgovIdGnrService idGnrService;
	
	@Resource(name = "reservationService")
	protected ReservationService reservationService;
	
	@Resource(name = "egovReqTempIdGnrService")
	protected EgovIdGnrService idgerTempService;
	
	//예약가능여부확인
	@Override
	public ReservationApplyVO rsvCheck(ReservationApplyVO vo) throws Exception{
		//신청 인원 체크
		ReservationVO reservationVO = new ReservationVO();
		reservationVO.setResveId(vo.getResveId());
		
		ReservationVO result = reservationService.selectReservation(reservationVO);
		//최대참가인원 <= 승인된 신청자
		if(result.getMaxAplyCnt() <= result.getApplyFCnt()) {
			vo.setErrorCode("ERROR-R1");
			vo.setMessage("마감되었습니다.");
		}else if(reservationApplyMapper.duplicateApplyCheck(vo) > 0) {//중복신청자인지 확인
			vo.setErrorCode("ERROR-R2");
			vo.setMessage("해당 프로그램 예약이 이미 되어져 있습니다.");
		}
		
		
		return vo;
	}

	//예약자 상세정보
	@Override
	public ReservationApplyVO selectReservationApply(ReservationApplyVO vo) throws Exception{
		return reservationApplyMapper.selectReservationApply(vo);
	}
	//예약자 등록하기
	@Override
	public ReservationApplyVO insertReservationApply(ReservationApplyVO vo) throws Exception {
		//신청인원 체크
		ReservationVO reservationVO = new ReservationVO();
		reservationVO.setResveId(vo.getResveId());
		ReservationVO result = reservationService.selectReservation(reservationVO);
		if(result.getMaxAplyCnt() <= result.getApplyFCnt()) {
			vo.setErrorCode("ERROR-R1");
			vo.setMessage("마감되었습니다.");
		}else {
			//기존 신청여부
			if(reservationApplyMapper.duplicateApplyCheck(vo) > 0) {
				vo.setErrorCode("ERROR-R2");
				vo.setMessage("해당 프로그램이 이미 예약되었습니다.");
			}else {
				String id = idGnrService.getNextStringId();
				vo.setReqstId(id);
				reservationApplyMapper.insertReservationApply(vo);
			}
		}
		
		return vo;
	}
	//예약자정보 목록 가져오기
	@Override
	public List<EgovMap> selectReservationApplyList(ReservationApplyVO vo) throws Exception {
		return reservationApplyMapper.selectReservationApplyList(vo);
	}
	//예약자정보 목록 수
	@Override
	public int selectReservationApplyListCnt(ReservationApplyVO vo) throws Exception {
		return reservationApplyMapper.selectReservationApplyListCnt(vo);
	}
	
	
	//예약자 수정
	@Override
	public void updateReservationApply(ReservationApplyVO vo) throws Exception {
		reservationApplyMapper.updateReservationApply(vo);
	}
	//예약자 삭제
	@Override
	public void deleteReservationApply(ReservationApplyVO vo) throws Exception {
		reservationApplyMapper.deleteReservationApply(vo);
	}
	//예약자 승인처리
	@Override
	public void updateReservationConfirm(ReservationApplyVO vo) throws Exception {
		reservationApplyMapper.updateReservationConfirm(vo);
	}
}
