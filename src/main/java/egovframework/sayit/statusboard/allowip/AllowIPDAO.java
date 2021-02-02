package egovframework.sayit.statusboard.allowip;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository("allowIPDAO")
public class AllowIPDAO extends EgovComAbstractDAO {

	public List selectAllowIP(AllowIPVO vo) throws Exception {
		return list("allowIP.selectAllowIP", vo);
	}
	
}
