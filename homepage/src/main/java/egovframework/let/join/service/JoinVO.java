package egovframework.let.join.service;

import java.io.Serializable;

import egovframework.com.cmm.ComDefaultVO;

public class JoinVO extends ComDefaultVO implements Serializable{

	//ID
	private String emplyrId;
	//이름
	private String userNm;
	//비밀번호
	private String password;
	//비밀번호 힌트
	private String passwordHint;
	//비밀번호 힌트정답
	private String passwordCnsr;
	//사용자 상태코드
	private String emplyrSttusCord;
	//회원고유ID
	private String esntlId;
	//로그인타입
	private String loginType;
	//가입일자
	private java.util.Date sbscrbDe;
	
	
	public String getEmplyrId() {
		return emplyrId;
	}
	public void setEmplyrId(String emplyrId) {
		this.emplyrId = emplyrId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	public String getPasswordCnsr() {
		return passwordCnsr;
	}
	public void setPasswordCnsr(String passwordCnsr) {
		this.passwordCnsr = passwordCnsr;
	}
	public String getEmplyrSttusCord() {
		return emplyrSttusCord;
	}
	public void setEmplyrSttusCord(String emplyrSttusCord) {
		this.emplyrSttusCord = emplyrSttusCord;
	}
	public String getEsntlId() {
		return esntlId;
	}
	public void setEsntlId(String esntlId) {
		this.esntlId = esntlId;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public java.util.Date getSbscrbDe() {
		return sbscrbDe;
	}
	public void setSbscrbDe(java.util.Date sbscrbDe) {
		this.sbscrbDe = sbscrbDe;
	}
}
