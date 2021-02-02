package egovframework.sayit.statusboard.population;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("populationService")
public class PopulationServiceImpl implements PopulationService{

	@Resource(name="populationDAO")
	private PopulationDAO populationDAO;

	@Override
	public List selectPopulation() throws Exception {
		// TODO Auto-generated method stub
		return populationDAO.selectPopulation();
	}
}
