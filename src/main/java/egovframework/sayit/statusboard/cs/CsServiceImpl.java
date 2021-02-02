package egovframework.sayit.statusboard.cs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("csService")
public class CsServiceImpl implements CsService{

	@Resource(name = "csDAO")
    private CsDAO csDAO;

    public List getCsList() throws Exception{
        return csDAO.selectList();
    }
}
