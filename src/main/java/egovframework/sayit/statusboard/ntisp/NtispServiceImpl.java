package egovframework.sayit.statusboard.ntisp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.sayit.statusboard.ntisp.NtispService;
import egovframework.sayit.statusboard.ntisp.NtispVO;

@Service("ntispService")
public class NtispServiceImpl implements NtispService{

	@Resource(name="ntispDAO")
	NtispDAO ntispDAO;
	
	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub
		return ntispDAO.totalCount();
	}

	@Override
	public List list(NtispVO bean) throws Exception {
		// TODO Auto-generated method stub
		return ntispDAO.list(bean);
	}

}
