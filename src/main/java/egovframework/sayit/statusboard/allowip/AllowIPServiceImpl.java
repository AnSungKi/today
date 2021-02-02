package egovframework.sayit.statusboard.allowip;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("allowIPService")
public class AllowIPServiceImpl implements AllowIPService {

	@Resource(name="allowIPDAO")
	private AllowIPDAO allowIPDAO;

	@Override
	public List selectAllowIP(AllowIPVO vo) throws Exception {
		// TODO Auto-generated method stub
		return allowIPDAO.selectAllowIP(vo);
	}
}
