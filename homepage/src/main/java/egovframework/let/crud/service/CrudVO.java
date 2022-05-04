package egovframework.let.crud.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import egovframework.com.cmm.ComDefaultVO;

public class CrudVO extends ComDefaultVO implements Serializable {
	//임시데이터 ID
	private String crudId;
	//임시데이터 제목
	private String crudSj;
	//데이터 내용
	private String crudCn;
	//데이터 작성자
	private String crudNm;
	//데이터 작성일
	private String frstRegistPnttm;
	
	public String getCrudId() {
		return crudId;
	}
	public void setCrudId(String crudId) {
		this.crudId = crudId;
	}
	public String getCrudSj() {
		return crudSj;
	}
	public void setCrudSj(String crudSj) {
		this.crudSj = crudSj;
	}
	public String getCrudCn() {
		return crudCn;
	}
	public void setCrudCn(String crudCn) {
		this.crudCn = crudCn;
	}
	public String getCrudNm() {
		return crudNm;
	}
	public void setCrudNm(String crudNm) {
		this.crudNm = crudNm;
	}
	public String getFrstRegistPnttm() {
		return frstRegistPnttm;
	}
	public void setFrstRegistPnttm(String frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}
	
}
