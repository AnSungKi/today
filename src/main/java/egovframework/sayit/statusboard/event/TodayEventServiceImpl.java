package egovframework.sayit.statusboard.event;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("todayEventService")
public class TodayEventServiceImpl implements TodayEventService {

	@Resource(name="todayEventDAO")
	private TodayEventDAO todayEventDAO;

	@Override
	public List selectFileExist(TodayEventVO vo) throws Exception {
		// TODO Auto-generated method stub
		return todayEventDAO.selectFileExist(vo);
	}
	
	@Override
	public TodayEventVO selectFileDocNum(TodayEventVO vo) throws Exception {
		// TODO Auto-generated method stub
		return todayEventDAO.selectFileDocNum(vo);
	}

	@Override
	public TodayEventVO selectFiledate(TodayEventVO vo) throws Exception {
		// TODO Auto-generated method stub
		return todayEventDAO.selectFiledate(vo);
	}
	
	@Override
	public void insertNewFileInfo(TodayEventVO vo) throws Exception {
		// TODO Auto-generated method stub
		todayEventDAO.insertNewFileInfo(vo);
	}
}
