package egovframework.sayit.statusboard.ntisp;

import java.util.List;

public interface NtispService {
	
	public int totalCount()  throws Exception;
	
	public List list(NtispVO bean) throws Exception;
}
