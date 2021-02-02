package egovframework.sayit.statusboard.sotong;

import java.util.List;


public interface SotongService {
	
	/*
	 * 소통 오늘자 Count 가 10개가 넘는지 확인하기위해 오늘자 소통 갯수 Select
	 */
	public SotongVO selectTodaySotongCount() throws Exception;

	/*
	 * 소통 Json Data 파일 만들 Data Select(오늘날짜 Data가 10개 이하일때)
	 */
	public List selectMakeSotongJsonFile(SotongVO vo) throws Exception;

	/*
	 * 소통 Json Data 파일 만들 Data Select(오늘날짜 Data가 10개 이상일때)
	 */
	public List selectTodayMakeSotongJsonFile(SotongVO vo) throws Exception;
  	
}
