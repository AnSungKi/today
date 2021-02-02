package egovframework.sayit.statusboard.sotong;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("sotongService")
public class SotongServiceImpl implements SotongService{

	@Resource(name="sotongDAO")
	private SotongDAO sotongDAO;

	/*
	 * 소통 오늘자 Count 가 10개가 넘는지 확인하기위해 오늘자 소통 갯수 Select
	 */
	@Override
	public SotongVO selectTodaySotongCount() throws Exception {
		// TODO Auto-generated method stub
		return sotongDAO.selectTodaySotongCount();
	}

	/*
	 * 소통 Json Data 파일 만들 Data Select
	 */
	@Override
	public List selectMakeSotongJsonFile(SotongVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sotongDAO.selectMakeSotongJsonFile(vo);
	}

	/*
	 * 소통 Json Data 파일 만들 Data Select(오늘날짜 Data가 10개 이상일때)
	 */
	@Override
	public List selectTodayMakeSotongJsonFile(SotongVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sotongDAO.selectTodayMakeSotongJsonFile(vo);
	}
}
