package egovframework.sayit.statusboard.ntisp;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.sayit.statusboard.ntisp.NtispVO;

@Repository("ntispDAO")
public class NtispDAO  extends EgovComAbstractDAO  {
	public int totalCount()  throws Exception {
		// 목록
		return (Integer) select("NtispDAO.totalCount", null);
	}
	
	public List list(NtispVO bean) throws Exception {
		// 목록
		return  list("NtispDAO.list", bean);
	}
}
