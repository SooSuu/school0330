package egovframework.let.join.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.let.join.service.JoinService;
import egovframework.let.join.service.JoinVO;
import egovframework.let.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Service("joinService")
public class JoinServiceImpl extends EgovAbstractServiceImpl implements JoinService{

	@Resource(name="joinMapper")
	private JoinMapper joinMapper;
	
	@Resource(name="joinIdGnrService")
	private EgovIdGnrService idGnrService;
	
	//회원등록
	@Override
	public String insertJoin(JoinVO vo) throws Exception{
		String esntlId = idGnrService.getNextStringId();
		vo.setEsntlId(esntlId);
		
		//입력한 비밀번호를 암호화
		String enpassword = EgovFileScrty.encryptPassword(vo.getPassword(), vo.getEmplyrId());
		vo.setPassword(enpassword);

		joinMapper.insertJoin(vo);
		return esntlId;
	}
	
	//ID 중복체크
	@Override
	public int duplicateCheck(JoinVO vo) throws Exception{
		return joinMapper.duplicateCheck(vo);
	}
}
