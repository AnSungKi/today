package egovframework.sayit.statusboard.finance;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("financeService")
public class FinanceServiceImpl implements FinanceService{

	@Resource(name="financeDAO")
	private FinanceDAO financeDAO;

	public FinanceVO selectTotalBuget(FinanceVO vo) throws Exception {
		return financeDAO.selectTotalBuget(vo);
	};
	
	public FinanceVO selectTotalIncome(FinanceVO vo) throws Exception {
		return financeDAO.selectTotalIncome(vo);
	};
	
	public FinanceVO selectTotalExpenses(FinanceVO vo) throws Exception {
		return financeDAO.selectTotalExpenses(vo);
	};
}
