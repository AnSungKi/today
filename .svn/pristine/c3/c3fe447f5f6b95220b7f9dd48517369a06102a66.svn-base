package egovframework.sayit.statusboard.weather;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("weatherDAO")
public class WeatherDAO extends EgovComAbstractDAO {

	/*
	 * 미세먼지 Data Select
	 */
	public List getAirInfo(WeatherVO vo) throws Exception {
		return list("weather.getAirInfo", vo);
	}
}
