package egovframework.let.crud2.wep;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.let.crud2.service.Crud2Service;
import egovframework.let.crud2.service.Crud2VO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class Crud2Controller {
	
	//crud2Service는 impl에서 가져온다
	@Resource(name = "crud2Service")
	private Crud2Service crud2Service;
	
	//CRUD 가져오기
	@RequestMapping(value = "/crud2/select.do")
	public String select(@ModelAttribute("searchVO") Crud2VO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
		//Crud2VO=새로운 객체 생성해서 result 에 담음      ===위의 Crud2VO와 아래는 다르다!!
		Crud2VO result = crud2Service.selectCrud2(searchVO);
		model.addAttribute("result",result);
		return "crud2/Crud2Select";
	}
	//CRUD 목록 가져오기   (value=브라우저에서 입력하는 주소)
	@RequestMapping(value = "/crud2/selectList.do")
	public String selectList(@ModelAttribute("searchVO") Crud2VO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		int totCnt = crud2Service.selectCrud2ListCnt(searchVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo",paginationInfo);
		
		List<EgovMap> resultList = crud2Service.selectCrud2List(searchVO);
		model.addAttribute("resultList", resultList);
		
		return "crud2/Crud2SelectList";
		//return "불러올 jsp 페이지"
	}
	//CRUD 등록,수정
	@RequestMapping(value = "/crud2/crudRegist.do")
	public String crudRegist(@ModelAttribute("searchVO") Crud2VO crud2VO,HttpServletRequest request, ModelMap model) throws Exception{
		
		Crud2VO result = new Crud2VO();
		if(!EgovStringUtil.isEmpty(crud2VO.getCrudId())) {
			result = crud2Service.selectCrud2(crud2VO);
		}
		model.addAttribute("result", result);
		
		return "crud2/Crud2Regist";
	}
	//CRUD 등록하기
	@RequestMapping(value = "/crud2/insert.do")
	public String insert(@ModelAttribute("searchVO") Crud2VO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
		
		crud2Service.insertCrud2(searchVO);
		return "forward:/crud2/selectList.do";
	}
	//CRUD 수정하기
	@RequestMapping(value = "/crud2/update.do")
	public String update(@ModelAttribute("searchVO") Crud2VO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
		
		crud2Service.updateCrud2(searchVO);
		return "forward:/crud2/selectList.do";
	}
	//CRUD 삭제하기
	@RequestMapping(value = "/crud2/delete.do")
	public String delete(@ModelAttribute("searchVO") Crud2VO searchVO,HttpServletRequest request, ModelMap model) throws Exception{
		
		crud2Service.deleteCrud2(searchVO);
		return "forward:/crud2/selectList.do";
	}
}
