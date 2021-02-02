package egovframework.sayit.statusboard.weather;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("weatherService")
public class WeatherServiceImpl implements WeatherService{

	@Resource(name="weatherDAO")
	private WeatherDAO weatherDAO;

	/*
	 * 미세먼지 Data Select
	 */
	@Override
	public List getAirInfo(WeatherVO vo) throws Exception {
		// TODO Auto-generated method stub
		return weatherDAO.getAirInfo(vo);
	}
}
