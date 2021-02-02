package egovframework.sayit.statusboard.cs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("csDAO")
public class CsDAO extends CsComAbstractDAO {

	    public List selectList(){
	        return list("csDAO.selectList", null);
	    }
}
