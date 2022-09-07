package egovframework.let.join.web;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.let.api.naver.service.NaverLoginService;
import egovframework.let.join.service.JoinService;
import egovframework.let.join.service.JoinVO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import net.sf.json.JSONObject;

@Controller
public class JoinController {

	@Resource(name = "joinService")
	private JoinService joinService;
	
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	@Resource(name = "naverLoginService")
	private NaverLoginService naverLoginService;
	
	//회원구분
	@RequestMapping(value = "/join/memberType.do")
	public String memberType(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model, HttpSession session) throws Exception{
		
		//Naver
		String domain =  request.getServerName();
		String naverAuthUrl = naverLoginService.getAuthorizationUrl(session, domain);
		model.addAttribute("naverAuthUrl",naverAuthUrl);
		
		return "join/MemberType";
	}
	
	//회원등록 폼
	@RequestMapping(value = "/join/memberRegist.do")
	public String memberRegist(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model) throws Exception{
		return "join/MemberRegist";
	}
	
	//회원가입
	@RequestMapping(value = "/join/insertMember.do")
	public String insertMember(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, ModelMap model) throws Exception{
		if(!EgovStringUtil.isEmpty(vo.getLoginType())) {
			//일반가입을 제외하고는 ID값은 SNS명 + ID값 (ex. KAKAO-12345)
			//SNS 가입자는 비밀번호를 변경/조회할 필요가 없다.
			if(!("normal").equals(vo.getLoginType())) {
				vo.setEmplyrId(vo.getLoginType() + "-" + vo.getEmplyrId());
				vo.setPassword("");//null이 아님
				vo.setPasswordHint("SNS가입자");
				vo.setPasswordCnsr("SNS가입자");
			}
		}
		
		//동시접속자 중복등록방지
		if(joinService.duplicateCheck(vo) > 0) {
			model.addAttribute("message", egovMessageSource.getMessage("fail.duplicate.member"));
			//이미 사용중인 ID입니다.
			return "forward:/join/memberType.do";
		}else {
			joinService.insertJoin(vo);
			model.addAttribute("message", egovMessageSource.getMessage("join.request.msg"));
			//회원신청이 정상적으로 완료되었습니다. 로그인 후 이용해주세요.
		}
		
		return "forward:/index.do";
	}
	
	//아이디 중복체크
	@RequestMapping(value = "/join/duplicateCheck.do")
	public void duplicateCheck(@ModelAttribute("searchVO") JoinVO vo, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		String successYn = "Y";
		String message = "성공";
		
		JSONObject jo = new JSONObject();
		response.setContentType("application/json; charset=utf-8");
		//보안때문에 사용. 어떤 값인지 알려주는 코드
		
		
		int duplicateCnt = joinService.duplicateCheck(vo);
		if(duplicateCnt > 0) {	//하루한번 출석체크 로직
			successYn = "N";
			message = egovMessageSource.getMessage("fail.duplicate.member");	//이미 사용중인 ID입니다.
		}
		
		jo.put("successYn", successYn);
		jo.put("message", message);
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println(jo.toString());
		printWriter.flush();
		printWriter.close();
		//닫아주지 않으면 리소스가 계속 쌓임
	}
}
