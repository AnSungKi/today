package egovframework.sayit.statusboard.job;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("jobService")
public class JobServiceImpl implements JobService{

	@Resource(name="jobDAO")
	private JobDAO jobDAO;
	
	/*
     * 고용률 최근 데이터 Select
     */
	@Override
	public List selectTopEmploy(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectTopEmploy(vo);
	}
	
	/*
     * 고용률 전국/세종 그래프 그리기
     */
	@Override
	public List selectJsonEmployGrapeList(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectJsonEmployGrapeList(vo);
	}
	
	/*
     * 고용률 ComboBox Select
     */
	@Override
	public List selectEmployComboBox(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectEmployComboBox(vo);
	}
	
	/*
	 * 고용률 반기별 DataTable 조회
	 */
	@Override
	public List selectjobEmployDataTableList(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectjobEmployDataTableList(vo);
	}
	
	/*
     * 실업률 최근 데이터 Select
     */
	@Override
	public List selectTopUnemploy(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectTopUnemploy(vo);
	}
	
	/*
     * 실업률 ComboBox Select
     */
	@Override
	public List selectUnemployComboBox(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectUnemployComboBox(vo);
	}	
	
	/*
     * 실업율 DataTable 조회
     */
	@Override
	public List selectUnEmpDatatableList(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectUnEmpDatatableList(vo);
	}
    /************************************************************************************/
    /************************************************************************************/
    /*                         위에꺼는 쓰는거 아래꺼는 안쓰는거                        */
    /************************************************************************************/
    /************************************************************************************/
	
	/*
	 * 메인화면 일자리 현황판 기본정보 조회 (아래 3개)
	 */
	@Override
	public List selectJsonSearchJobMonitorData(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectJsonSearchJobMonitorData(vo);
	}
	
	@Override
	public List selectJsonMonitorPopulationData(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectJsonMonitorPopulationData(vo);
	}
	// 아래 3개 안쓰는거 정리해야함
	@Override
	public List selectEmployPercent(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectEmployPercent(vo);
	}
	
	@Override
	public List selectUnEmployPercent(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectUnEmployPercent(vo);
	}
	
	@Override
	public List selectJobIntroducePercent(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectJobIntroducePercent(vo);
	}
	
	/*
	 * 고용률 반기별 DataTable Data Insert
	 */
	@Override
	public void insertJobEmployDataTable(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		jobDAO.insertJobEmployDataTable(vo);
	}

	/*
     * 고용률 반기 성별 Data Insert
     */
	@Override
	public void InsertSEmpMWYData(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		jobDAO.InsertSEmpMWYData(vo);
	}

	/*
     * 고용률 세종 ComboChart 그리기
     */
//	@Override
//	public List selectJsonEmployGrapeListSejong(JobVO vo) throws Exception {
//		// TODO Auto-generated method stub
//		return jobDAO.selectJsonEmployGrapeListSejong(vo);
//	}
	
	/*
     * 고용률 BarChart One 그리기
     */
	@Override
	public List selectJsonJobEmployBarGrapeList(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectJsonJobEmployBarGrapeList(vo);
	}
	
	/*
	 * 성별 고용률 ComboBox Select
	 */
	@Override
	public List selectSemployComboBox(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectSemployComboBox(vo);
	}
	
	/*
     * 실업율 DataTable Data Insert
     */
	@Override
	public void insertUnEmployRateInsertData(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		jobDAO.insertUnEmployRateInsertData(vo);
	}
	
	/*
     * 전국 실업률 ComboChart 그리기
     */
	@Override
	public List selectJsonUnEmployGrapeList(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectJsonUnEmployGrapeList(vo);
	}

	/*
     *  세종 실업률 ComboChart 그리기
     */
//	@Override
//	public List selectJsonUnEmployGrapeListSejong(JobVO vo) throws Exception {
//		// TODO Auto-generated method stub
//		return jobDAO.selectJsonUnEmployGrapeListSejong(vo);
//	}
	
	/*
     * 취업알선 DataTable 조회
     */
	@Override
	public List selectJobIntroDatatableList(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectJobIntroDatatableList(vo);
	}

	/*
     * 취업알선 DataTable Data Insert
     */
	@Override
	public void updateJobIntroInsertCellData(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		jobDAO.updateJobIntroInsertCellData(vo);
	}

	/*
     * 취업알선 LineChart 그리기
     */
	@Override
	public List selectJsonJobIntroduceGrapeList(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectJsonJobIntroduceGrapeList(vo);
	}

	/*
     * 취업알선 BarChart 그리기
     */
	@Override
	public List selectJsonJobIntroBarGrapeList(JobVO vo) throws Exception {
		// TODO Auto-generated method stub
		return jobDAO.selectJsonJobIntroBarGrapeList(vo);
	}

	/*
     * 취업알선 ComboBox Select
     */
     @Override
 	public List selectJobIntroduceComboBox(JobVO vo) throws Exception {
 		// TODO Auto-generated method stub
 		return jobDAO.selectJobIntroduceComboBox(vo);
 	}
}
