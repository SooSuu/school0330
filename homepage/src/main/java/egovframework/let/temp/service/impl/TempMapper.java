package egovframework.let.temp.service.impl;
import java.util.Iterator;
import java.util.List;

import egovframework.let.cop.bbs.service.Board;
import egovframework.let.cop.bbs.service.BoardVO;
import egovframework.let.temp.service.TempVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

import org.springframework.stereotype.Repository;

@Mapper("tempMapper")
public interface TempMapper {
	
	TempVO selectTemp(TempVO vo) throws Exception;
}
