package egovframework.sayit.statusboard.job;

import java.util.List;


public interface JobService {

	/*
	 * 고용률 ComboBox Select
	 */
	public List selectTopEmploy(JobVO vo) throws Exception;
	
	/*
     * 고용률 전국 ComboChart 그리기
     */
	public List selectJsonEmployGrapeList(JobVO vo) throws Exception;
	
	/*
	 * 고용률 ComboBox Select
	 */
	public List selectEmployComboBox(JobVO vo) throws Exception;
	
	/*
	 * 고용률 반기별 DataTable 조회
	 */
	public List selectjobEmployDataTableList(JobVO vo) throws Exception;
	
	/*
	 * 실업률 최근 데이터 Select
	 */
	public List selectTopUnemploy(JobVO vo) throws Exception;	
	
 	/*
     * 실업률 ComboBox Select
     */
	public List selectUnemployComboBox(JobVO vo) throws Exception;
	
	/*
     * 실업율 DataTable 조회
     */
	public List selectUnEmpDatatableList(JobVO vo) throws Exception;
	
    /************************************************************************************/
    /************************************************************************************/
    /*                         위에꺼는 쓰는거 아래꺼는 안쓰는거                        */
    /************************************************************************************/
    /************************************************************************************/
	
	/*
	 * 메인화면 일자리 현황판 기본정보 조회 (아래 3개)
	 */
	public List selectJsonSearchJobMonitorData(JobVO vo) throws Exception;
	public List selectJsonMonitorPopulationData(JobVO vo) throws Exception;
	// 아래 2개는 안쓰는거 정리해야함
	public List selectEmployPercent(JobVO vo) throws Exception;
	public List selectUnEmployPercent(JobVO vo) throws Exception;
	public List selectJobIntroducePercent(JobVO vo) throws Exception;

	/*
	 * 고용률 반기별 DataTable Data Insert
	 */
	public void insertJobEmployDataTable(JobVO vo) throws Exception;
	
	/*
     * 고용률 반기 성별 Data Insert
     */
	public void InsertSEmpMWYData(JobVO vo) throws Exception;
	
	/*
     * 고용률 세종 ComboChart 그리기
     */
//	public List selectJsonEmployGrapeListSejong(JobVO vo) throws Exception;
	
	/*
     * 고용률 BarChart 그리기
     */
	public List selectJsonJobEmployBarGrapeList(JobVO vo) throws Exception;

	/*
	 * 성별 고용률 ComboBox Select
	 */
	public List selectSemployComboBox(JobVO vo) throws Exception;
	
	/*
     * 실업율 DataTable Data Insert
     */
     public void insertUnEmployRateInsertData(JobVO vo) throws Exception; 
     
     /*
      * 전국 실업률 ComboChart 그리기
      */
 	public List selectJsonUnEmployGrapeList(JobVO vo) throws Exception;     

 	/*
     *  세종 실업률 ComboChart 그리기
     */
// 	public List selectJsonUnEmployGrapeListSejong(JobVO vo) throws Exception;     
    
     /*
      * 취업알선 DataTable 조회
      */
     public List selectJobIntroDatatableList(JobVO vo) throws Exception;
     
     /*
      * 취업알선 DataTable Data Insert
      */
     public void updateJobIntroInsertCellData(JobVO vo) throws Exception;
     
     /*
      * 취업알선 LineChart 그리기
      */
  	public List selectJsonJobIntroduceGrapeList(JobVO vo) throws Exception; 
  	
  	/*
     * 취업알선 BarChart 그리기
     */
  	public List selectJsonJobIntroBarGrapeList(JobVO vo) throws Exception;
  	
  	 /*
     * 취업알선 ComboBox Select
     */
     public List selectJobIntroduceComboBox(JobVO vo) throws Exception;
  	
}
