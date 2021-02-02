package egovframework.sayit.statusboard.cs;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

public abstract class CsComAbstractDAO extends EgovAbstractDAO {

	 @Resource(name="callcenter.sqlMapClient")
	    public void setSuperSqlMapClient(SqlMapClient sqlMapClient) {
	        super.setSuperSqlMapClient(sqlMapClient);
	    }
}
