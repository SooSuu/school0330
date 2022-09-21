package egovframework.let.rsv.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.rsv.service.ReservationService;
import egovframework.let.rsv.service.ReservationVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class ReservationController {

	@Resource(name = "reservationService")
	private ReservationService reservationService;
	
	//예약목록 가져오기
	@RequestMapping(value = "/rsv/rsvSelectList.do")
	public String rsvSelectList(@ModelAttribute("searchVO") ReservationVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		//리스트를 가져온다
		List<EgovMap> resultList = reservationService.selectReservationList(searchVO);
		model.addAttribute("resultList", resultList);
		
		//count(목록수) 가져온다
		int totCnt = reservationService.selectReservationListCnt(searchVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		
		return "rsv/RsvSelectList";
	}
	/*
	//예약정보 등록,수정
	@RequestMapping(value = "/rsv/rsvRegist.do")
	public String rsvRegist(@ModelAttribute("searchVO") ReservationVO ReservationVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/rsv/rsvSelectList.do";
		}else {
			model.addAttribute("USER_INFO", user);
		}
		
		ReservationVO result = new ReservationVO();
		if(!EgovStringUtil.isEmpty(ReservationVO.getResveId())) {
			//수정할 수 있게 해당정보를 불러옴
			result = reservationService.selectReservation(ReservationVO);
		}
		model.addAttribute("result", result);
		
		request.getSession().removeAttribute("sessionReservation");
		
		return "rsv/RsvRegist";
	}
	//예약정보 등록하기
	@RequestMapping(value = "/rsv/rsvInsert.do")
	public String insert(@ModelAttribute("searchVO") ReservationVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		  //이중 서브밋 방지 체크
		  if(request.getSession().getAttribute("sessionReservation") != null) {
			  return "forward:/rsv/rsvSelectList.do";
		  }
		  
		  LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		  if(user == null) {
		     model.addAttribute("message", "로그인 후 사용가능합니다.");
		     return "forward:/rsv/rsvSelectList.do";
		  }
		  searchVO.setUserId(user.getId());
		  
		  reservationService.insertReservation(searchVO);
		  
		  //이중 서브밋 방지
		  request.getSession().setAttribute("sessionReservation", searchVO);
		  return "forward:/rsv/rsvSelectList.do";  
	}
	//예약정보 수정하기
	@RequestMapping(value = "/rsv/rsvUpdate.do")
	public String rsvUpdate(@ModelAttribute("searchVO") ReservationVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		  //이중 서브밋 방지
		  if(request.getSession().getAttribute("sessionReservation") != null) {
			  return "forward:/rsv/rsvSelectList.do";
		  }
		  
		  LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		  if(user == null) {
		     model.addAttribute("message", "로그인 후 사용가능합니다.");
		     return "forward:/rsv/rsvSelectList.do";
		  }
		  
		  searchVO.setUserId(user.getId());
		  
		  reservationService.updateReservation(searchVO);
		  
		  //이중 서브밋 방지
		  request.getSession().setAttribute("sessionReservation", searchVO);
		  return "forward:/rsv/rsvSelectList.do"; 
	}
	//예약정보 삭제하기
	@RequestMapping(value = "/rsv/rsvDelete.do")
	public String rsvDelete(@ModelAttribute("searchVO") ReservationVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null) {
	     	model.addAttribute("message", "로그인 후 사용가능합니다.");
	     	return "forward:/rsv/rsvSelectList.do";
		}
		
		searchVO.setUserId(user.getId());
		
		reservationService.deleteReservation(searchVO);
		
		return "forward:/rsv/rsvSelectList.do"; 
	}
	*/
}
