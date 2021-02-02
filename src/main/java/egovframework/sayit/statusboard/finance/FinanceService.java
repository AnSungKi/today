package egovframework.sayit.statusboard.finance;

import java.util.List;


public interface FinanceService {
	
	public FinanceVO selectTotalBuget(FinanceVO vo) throws Exception;
	
	public FinanceVO selectTotalIncome(FinanceVO vo) throws Exception;
	
	public FinanceVO selectTotalExpenses(FinanceVO vo) throws Exception;
  	
}
