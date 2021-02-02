package egovframework.sayit.statusboard.event;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("todayEventDAO")
public class TodayEventDAO extends EgovComAbstractDAO {

	public List selectFileExist(TodayEventVO vo) throws Exception {
		return list("todayEvent.selectFileExist", vo);
	}

	public TodayEventVO selectFileDocNum(TodayEventVO vo) throws Exception {
		return (TodayEventVO) select("todayEvent.selectFileDocNum", vo);
	}

	public TodayEventVO selectFiledate(TodayEventVO vo) throws Exception {
		return (TodayEventVO) select("todayEvent.selectFiledate", vo);
	}

	public void insertNewFileInfo(TodayEventVO vo) throws Exception {
		insert("todayEvent.insertNewFileInfo", vo);
	}
}
