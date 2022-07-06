package egovframework.let.board2.wep;
import java.util.List;
import java.util.Map;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.board2.service.Board2Service;
import egovframework.let.board2.service.Board2VO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.let.utl.fcc.service.FileMngUtil;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springmodules.validation.commons.DefaultBeanValidator;

@Controller
public class Board2Controller {
	
	@Resource(name = "board2Service")
	private Board2Service board2Service;
	
	@Resource(name = "EgovFileMngService")
	private EgovFileMngService fileMngService;
	
	@Resource(name = "fileMngUtil")
	private FileMngUtil fileUtil;
	
	//BOARD 목록 가져오기
	@RequestMapping(value = "/board2/selectList.do")
	public String selectList(@ModelAttribute("searchVO") Board2VO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
		
		//공지 게시글
		searchVO.setNoticeAt("Y");//공지글 가져오기
		List<EgovMap> noticeResultList = board2Service.selectBoard2List(searchVO);
		model.addAttribute("noticeResultList", noticeResultList);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
				
		searchVO.setNoticeAt("N");//일반글 가져오기
		List<EgovMap> resultList = board2Service.selectBoard2List(searchVO);
		model.addAttribute("resultList", resultList);	
		
		
		int totCnt = board2Service.selectBoard2ListCnt(searchVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo",paginationInfo);
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		
		return "board2/Board2SelectList";
	}
	
	//게시물 등록, 수정
	@RequestMapping(value = "/board2/board2Regist.do")
	public String board2Regist(@ModelAttribute("searchVO") Board2VO Board2VO,HttpServletRequest request, ModelMap model) throws Exception{
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/board2/selectList.do";
		}else {
			model.addAttribute("USER_INFO", user);
		}
		
		Board2VO result = new Board2VO();
		if(!EgovStringUtil.isEmpty(Board2VO.getBoardId())) {
			
			result = board2Service.selectBoard2(Board2VO);
			//본인 및 관리자만 허용 (비밀글)
			if(!user.getId().equals(result.getFrstRegisterId()) && !"admin".equals(user.getId())) {
				model.addAttribute("message", "작성자 본인만 확인 가능합니다.");
				return "forward:/board2/selectList.do";
			}
		}
		model.addAttribute("result", result);
		
		request.getSession().removeAttribute("sessionBoard");
		
		return "board2/Board2Regist";
	}
	//게시글 등록
	@RequestMapping(value="/board2/insert.do")
	   public String insert(final MultipartHttpServletRequest multiReqeust, @ModelAttribute("searchVO") Board2VO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
	      
	      //이중 서브밋 방지 체크
	      if(request.getSession().getAttribute("sessionBoard") != null) {
	         return "forward:/board2/selectList.do";
	      }
	      
	      LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
	      if(user == null || user.getId() == null) {
	         model.addAttribute("message", "로그인 후 사용가능합니다.");
	         return "forward:/board2/selectList.do";
	      }
	      
	      List<FileVO> result = null;
	      String atchFileId = "";
	      
	      final Map<String, MultipartFile> files = multiReqeust.getFileMap();
	      if(!files.isEmpty()) {
	         result = fileUtil.parseFileInf(files, "BOARD2_", 0, "", "board.fileStorePath");
	         atchFileId = fileMngService.insertFileInfs(result);
	      }
	      searchVO.setAtchFileId(atchFileId);
	      
	      searchVO.setCreatIp(request.getRemoteAddr());
	      searchVO.setUserId(user.getId());
	      
	      board2Service.insertBoard2(searchVO);
	      
	      //이중 서브밋 방지
	      request.getSession().setAttribute("sessionBoard", searchVO);
	      return "forward:/board2/selectList.do";
	      
	   }   
	//게시물가져오기
	@RequestMapping(value = "/board2/select.do")
	public String select(@ModelAttribute("searchVO") Board2VO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		
			//상세정보 가져오기
		Board2VO result = board2Service.selectBoard2(searchVO);
		//비밀글여부체크
		if("Y".equals(result.getOthbcAt())) {
			//본인 및 관리자만 허용 (틀리면 if문 실행, 맞으면 if 아래 실행)
			if(user == null || user.getId() == null || (!user.getId().equals(result.getFrstRegisterId()) && !"admin".equals(user.getId()))) {
				model.addAttribute("message","작성자 본인만 확인 가능합니다.");
				return "forward:/board2/selectList.do";
			}
		}
		model.addAttribute("result",result);
		return "board2/BoardSelect";
	}
	//게시물 수정하기
	@RequestMapping(value = "/board2/update.do")
	public String update(final MultipartHttpServletRequest multiRequest, @ModelAttribute("searchVO") Board2VO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
		//이중 서브밋 방지
		if(request.getSession().getAttribute("sessionBoard2") != null) {
			return "forward:/board2/selectList.do";
		}
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message","로그인 후 사용 가능합니다.");
			return "forward:/board2/selectList.do";
		} else if("admin".equals(user.getId())){
			searchVO.setMngAt("Y");
		}
		
		String atchFileId = searchVO.getAtchFileId();
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		if(!files.isEmpty()) {
			if(EgovStringUtil.isEmpty(atchFileId)) {
				List<FileVO> result = fileUtil.parseFileInf(files, "BOARD2_", 0, "", "board.fileStorePath");
				atchFileId = fileMngService.insertFileInfs(result);
				searchVO.setAtchFileId(atchFileId);
			}else {
				FileVO fvo = new FileVO();
				fvo.setAtchFileId(atchFileId);
				int cnt = fileMngService.getMaxFileSN(fvo);
				List<FileVO> _result = fileUtil.parseFileInf(files, "BOARD2_", cnt, atchFileId, "board.fileStorePath");
				fileMngService.updateFileInfs(_result);
			}
		}
		
		searchVO.setUserId(user.getId());
		
		board2Service.updateBoard2(searchVO);
		
		//이중 서브밋 방지
		request.getSession().setAttribute("sessionBoard", searchVO);
		return "forward:/board2/selectList.do";
	}
	//게시물 삭제하기
	@RequestMapping(value = "/board2/delete.do")
	public String delete(@ModelAttribute("searchVO") Board2VO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message","로그인 후 사용 가능합니다.");
			return "forward:/board2/selectList.do";
		} else if("admin".equals(user.getId())) {
			searchVO.setMngAt("Y");
		}
		searchVO.setUserId(user.getId());
		
		board2Service.deleteBoard2(searchVO);
		
		return "forward:/board2/selectList.do";
	}
}