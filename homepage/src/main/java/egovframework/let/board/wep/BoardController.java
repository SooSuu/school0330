package egovframework.let.board.wep;
import java.util.List;
import java.util.Map;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.board.service.BoardService;
import egovframework.let.board.service.BoardVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;

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
import org.springmodules.validation.commons.DefaultBeanValidator;

@Controller
public class BoardController {
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	//BOARD 목록 가져오기
	@RequestMapping(value = "/board/selectList.do")
	public String selectList(@ModelAttribute("searchVO") BoardVO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
		
		//공지 게시글
		searchVO.setNoticeAt("Y");
		List<EgovMap> noticeResultList = boardService.selectBoardList(searchVO);
		model.addAttribute("noticeResultList", noticeResultList);
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		
		searchVO.setNoticeAt("N");
		List<EgovMap> resultList = boardService.selectBoardList(searchVO);
		model.addAttribute("resultList", resultList);	
		
		
		int totCnt = boardService.selectBoardListCnt(searchVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo",paginationInfo);
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		
		return "board/BoardSelectList";
	}
	
	//게시물 등록, 수정
	@RequestMapping(value = "/board/boardRegist.do")
	public String boardRegist(@ModelAttribute("searchVO") BoardVO BoardVO,HttpServletRequest request, ModelMap model) throws Exception{
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/board/selectList.do";
		}else {
			model.addAttribute("USER_INFO", user);
		}
		
		BoardVO result = new BoardVO();
		if(!EgovStringUtil.isEmpty(BoardVO.getBoardId())) {
			/*
			result = boardService.selectBoard(BoardVO);
			//본인 및 관리자만 허용 (비밀글)
			if(!user.getId().equals(result.getFrstRegistId()) && !"admin".equals(user.getId())) {
				model.addAttribute("message", "작성자 본인만 확인 가능합니다.");
				return "forward:/board/selectList.do";
			}
			*/
		}
		model.addAttribute("result", result);
		
		request.getSession().removeAttribute("sessionBoard");
		
		return "board/BoardRegist";
	}
	//게시글 등록
	@RequestMapping(value = "/board/insert.do")
	public String insert(@ModelAttribute("searchVO") BoardVO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
	
		//이중 서브밋 방지 체크
		if(request.getSession().getAttribute("sessionBoard") != null) {
			return "forward:/board/selectList.do";
		}
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		if(user == null || user.getId() == null) {
			model.addAttribute("message", "로그인 후 사용가능합니다.");
			return "forward:/board/selectList.do";
		}
		
		searchVO.setCreatIp(request.getRemoteAddr());
		searchVO.setUserId(user.getId());
		
		boardService.insertBoard(searchVO);
		
		//이중 서브밋 방지
		request.getSession().setAttribute("sessionBoard", searchVO);
		return "forward:/board/selectList.do";
	}
}