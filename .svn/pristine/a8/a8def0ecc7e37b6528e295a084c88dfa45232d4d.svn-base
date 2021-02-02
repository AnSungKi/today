package egovframework.sayit.statusboard.sotong;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("sotongDAO")
public class SotongDAO extends EgovComAbstractDAO {

	/*
	 * 소통 오늘자 Count 가 10개가 넘는지 확인하기위해 오늘자 소통 갯수 Select
	 */
	public SotongVO selectTodaySotongCount() throws Exception {
		return (SotongVO) select("sotong.selectTodaySotongCount");
	}

	/*
	 * 소통 오늘자 Count 가 10개가 넘는지 확인하기위해 오늘자 소통 갯수 Select
	 */
	public List selectMakeSotongJsonFile(SotongVO vo) throws Exception {
		return list("sotong.selectMakeSotongJsonFile", vo);
	}

	/*
	 * 소통 Json Data 파일 만들 Data Select(오늘날짜 Data가 10개 이상일때)
	 */
	public List selectTodayMakeSotongJsonFile(SotongVO vo) throws Exception {
		return list("sotong.selectTodayMakeSotongJsonFile", vo);
	}
}
