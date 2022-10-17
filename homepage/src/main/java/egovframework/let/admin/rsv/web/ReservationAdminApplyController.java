package egovframework.let.admin.rsv.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.util.FileUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.Response;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovFileMngUtil;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.service.JsonResponse;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.rsv.service.ReservationApplyService;
import egovframework.let.rsv.service.ReservationApplyVO;
import egovframework.let.rsv.service.ReservationService;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class ReservationAdminApplyController {

	@Resource(name = "reservationApplyService")
	private ReservationApplyService reservationApplyService;
	
	@Resource(name = "reservationService")
	private ReservationService reservationService;
	
	@Resource(name = "EgovFileMngUtil")
	private EgovFileMngUtil fileUtil;
	
	//예약자정보 목록 가져오기
	@RequestMapping(value = "/admin/rsv/selectApplyList.do")
	public String selectApplyList(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "redirect:/index.do";
		}
		
		//관리자
		searchVO.setMngAt("Y");
		
		List<EgovMap> resultList = reservationApplyService.selectReservationApplyList(searchVO);
		model.addAttribute("resultList", resultList);
		
		//엑셀 다운로드
		if("Y".equals(searchVO.getExcelAt())) {
			return "admin/rsv/RsvApplySelectListExcel";			
		}
		
		return "admin/rsv/RsvApplySelectList";
	}
	
	//예약자정보 상세
	@RequestMapping(value = "/admin/rsv/rsvApplySelect.do")
	public String rsvApplySelect(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "redirect:/index.do";
		}else {
			model.addAttribute("USER_INFO", user);
		}
		
		ReservationApplyVO result = reservationApplyService.selectReservationApply(searchVO);
		
		model.addAttribute("result", result);
		
		//세션삭제(사용자 승인 또는 반려 후 수정사항 적용)
		request.getSession().removeAttribute("sessionReservationApply");
		
		return "admin/rsv/RsvApplySelect";
	}
	
	//예약정보 승인
	@RequestMapping(value = "/admin/rsv/rsvApplyConfirm.do")
	public String updateReservationConfirm(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		//이중서브밋방지
		if(request.getSession().getAttribute("sessionReservationApply") != null) {
			return "forward:/admin/rsv/selectApplyList.do";
		}
		
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "redirect:/index.do";
		}
		
		searchVO.setUserId(user.getId());
		
		reservationApplyService.updateReservationConfirm(searchVO);
		
		//이중서브밋방지
		request.getSession().setAttribute("sessionReservationApply", searchVO);
		return "forward:/admin/rsv/selectApplyList.do";
	}
	
	//예약정보 삭제하기
	@RequestMapping(value = "/admin/rsv/rsvApplyDelete.do")
	public String rsvApplyDelete(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
	
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "redirect:/index.do";
		}
		
		searchVO.setUserId(user.getId());
		
		reservationApplyService.deleteReservationApply(searchVO);
		
		return "forward:/admin/rsv/selectApplyList.do";
	}
	
	//예약자정보 엑셀 다운로드
	@RequestMapping(value = "/admin/rsv/excel.do")
	public ModelAndView excel(@ModelAttribute("searchVO") ReservationApplyVO searchVO, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
	
		//공통모듈
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> columMap = new ArrayList<String>();
		List<Object> valueMap = new ArrayList<Object>();
		String fileName = "";
		
		columMap.add("번호");
		columMap.add("신청자명");
		columMap.add("연락처");
		columMap.add("이메일");
		columMap.add("신청일");
		
		//파일이름
		map.put("title", "예약신청현황");
		fileName = EgovStringUtil.getConvertFileName(request, "예약신청현황");	//ConvertFileName 으로 한글인코딩 변환
		
		//관리자
		searchVO.setMngAt("Y");
		//목록	-	쿼리로 불러와 리스트에 담음
		List<EgovMap> resultList = reservationApplyService.selectReservationApplyList(searchVO);
		
		if(resultList != null) {
			EgovMap tmpVO = null;
			Map<String, Object> tmpMap = null;
			for(int i = 0; i < resultList.size(); i++) {
				tmpVO = resultList.get(i);
				
				//위와 순서를 맞춰줘야한다!!
				tmpMap = new HashMap<String, Object>();
				tmpMap.put("번호", i+1);
				tmpMap.put("신청자명", tmpVO.get("chargerNm").toString() + "(" + tmpVO.get("frstRegisterId").toString() + ")");
				tmpMap.put("연락처", tmpVO.get("telno").toString());
				tmpMap.put("이메일", tmpVO.get("email").toString());
				tmpMap.put("신청일", tmpVO.get("frstRegistPnttmYmd").toString());
				
				valueMap.add(tmpMap);
			}
		}
		
		map.put("columMap", columMap);	//헤더 리스트
		map.put("valueMap", valueMap);	//값 리스트
		
		//페이지를 이동하는게 아닌 다운로드라고 알려준다
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xls");
		//파리미터를 보냄
		return new ModelAndView("excelDownroadView", "dataMap", map);
	}
	
	//엑셀업로드
	@RequestMapping(value = "/admin/rsv/excelUplode.json", method=RequestMethod.POST)
	public @ResponseBody JsonResponse excelUplode(@ModelAttribute ReservationApplyVO searchVO, MultipartHttpServletRequest multiRequest, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
	
		JsonResponse res = new JsonResponse();
		res.setSuccess(true);
		
		try {
			List<FileVO> result = null;
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			if(!files.isEmpty()) {
				result = fileUtil.parseFileInf(files, "TEMP_", 0, null, "resFileStorePath");
				Map<String, Object> resultMap = new HashMap<>();
				
				for(FileVO file : result) {
					if("xls".equals(file.getFileExtsn()) || "xlsx".equals(file.getFileExtsn())) {
						searchVO.setCreatIp(request.getRemoteAddr());
						resultMap = reservationApplyService.excelUpload(file, searchVO);
						if(!(Boolean)resultMap.get("success")) {
							res.setMessage(String.valueOf(resultMap.get("msg")));
							ArrayList resultList = (ArrayList) resultMap.get("resultList");
							res.setData(resultList);
							res.setSuccess(false);
						}
					}
				}
			}
		}catch (DataAccessException e) {
			res.setMessage(e.getLocalizedMessage());
		}
		return res;
	}
}
