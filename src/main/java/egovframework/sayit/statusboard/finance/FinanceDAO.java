package egovframework.sayit.statusboard.finance;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.sayit.statusboard.event.TodayEventVO;

@Repository("financeDAO")
public class FinanceDAO extends EgovComAbstractDAO {

	public FinanceVO selectTotalBuget(FinanceVO vo) throws Exception {
		return (FinanceVO) select("finance.selectTotalBuget", vo);
	};
	
	public FinanceVO selectTotalIncome(FinanceVO vo) throws Exception {
		return (FinanceVO) select("finance.selectTotalIncome", vo);
	};
	
	public FinanceVO selectTotalExpenses(FinanceVO vo) throws Exception {
		return (FinanceVO) select("finance.selectTotalExpenses", vo);
	};
}
