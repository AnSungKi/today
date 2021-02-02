package egovframework.sayit.statusboard.job;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JobContoller {
    @Resource(name="jobService")
    private JobService jobService;
    
    /*
     * 고용률 최근 데이터 Select
     */
    @RequestMapping(value="/getTopEmploy.do")
    public @ResponseBody Object selectTopEmploy(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
    	Map<String, Object> mp = new HashMap<String, Object>();
    	mp.put("TopEmploy", jobService.selectTopEmploy(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }
    
    /*
     * 고용률 전국 ComboChart 그리기
     */
    @RequestMapping(value="/getEmployGrapeList.do")
    public @ResponseBody Object selectJsonEmployGrapeList(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("employLineData", jobService.selectJsonEmployGrapeList(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }

    /*
     * 고용률 ComboBox Select
     */
    @RequestMapping(value="/getEmployComboBox.do")
    public @ResponseBody Object selectEmployComboBox(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
    	Map<String, Object> mp = new HashMap<String, Object>();
    	mp.put("employComboBox", jobService.selectEmployComboBox(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }
    
    /*
     * 고용율 Table 조회
     */
    @RequestMapping(value="/getjobEmployDataTableList.do")
    public @ResponseBody Object selectjobEmployDataTableList(
    		@ModelAttribute("jobVO") JobVO jobVO,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		ModelMap modelMap,
    		Model model) throws Exception{
    	
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("data", jobService.selectjobEmployDataTableList(jobVO));
		
		return getJsonStringFromMap(mp, response);
    }
    
    /************************************************************************************/
    /*                                      실업률                                      */
    /************************************************************************************/
    
    /*
     * 실업률 최근 데이터 Select
     */
    @RequestMapping(value="/getTopUnemploy.do")
    public @ResponseBody Object selectTopUnemploy(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
    	Map<String, Object> mp = new HashMap<String, Object>();
    	mp.put("TopUnemploy", jobService.selectTopUnemploy(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }    
    
    /*
     * 실업률 ComboBox Select
     */
    @RequestMapping(value="/getUnemployComboBox.do")
    public @ResponseBody Object selectUnemployComboBox(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
    	Map<String, Object> mp = new HashMap<String, Object>();
    	mp.put("unemployComboBox", jobService.selectUnemployComboBox(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }
    
    /*
     * 실업율 DataTable 조회
     */
    @RequestMapping(value="/getUnEmpDatatableList.do")
    public @ResponseBody Object selectUnEmpDatatableList(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO,
    		ModelMap modelMap,
    		Model model) throws Exception {
    	Map<String, Object> mp = new HashMap<String, Object>();
    	mp.put("data", jobService.selectUnEmpDatatableList(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }
    
    /************************************************************************************/
    /************************************************************************************/
    /*                         위에꺼는 쓰는거 아래꺼는 안쓰는거                        */
    /************************************************************************************/
    /************************************************************************************/
    
    /*
     * 고용율 DataTable Data Insert
     */
    @RequestMapping(value="/setInsertJobEmployDataTable.do")
    public void insertJobEmployDataTable(
    		@ModelAttribute("jobVO") JobVO jobVO,
    		HttpServletRequest request,
    		HttpServletResponse response,
    		ModelMap modelMap,
    		Model model) throws Exception{
    	response.setContentType("text/plain; charset=utf-8");
    	try {
			String[] employTitle = request.getParameterValues("employTitle");
			String[] employTotal = request.getParameterValues("employTotal");
			String[] employSejong = request.getParameterValues("employSejong");
			
			for(int i = 0; i < employTitle.length; i++){
				String year = "20" + employTitle[i].toString().substring(0, 2);
				
				jobVO.setEmployTitle(employTitle[i]);
				jobVO.setEmployTotal(employTotal[i]);
				jobVO.setEmploySejong(employSejong[i]);
				jobVO.setEmployYear(year);
				
				jobService.insertJobEmployDataTable(jobVO);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    	response.setContentType("text/xml;charset=utf-8");
    	PrintWriter printWriter = response.getWriter();
		printWriter.flush();
		printWriter.close();
    }
    
    /*
     * 고용률 반기 성별 Data Insert
     */
    @RequestMapping(value="/setInsertSEmpMWYData.do")
    public void InsertSEmpMWYData(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO,
    		ModelMap modelMap,
    		Model model) throws Exception {
    	response.setContentType("text/plain; charset=utf-8");
    	try {
    		String[] semployTitle = request.getParameterValues("semployTitle");
        	String[] semployMan = request.getParameterValues("semployMan");
        	String[] semployWomen = request.getParameterValues("semployWomen");
        	String[] semployYouth = request.getParameterValues("semployYouth");

        	for(int i = 0; i < semployTitle.length; i++){
        		
        		String year = "20" + semployTitle[i].toString().substring(0, 2);
        		
        		jobVO.setSemployTitle(semployTitle[i]);
        		jobVO.setSemployMan(semployMan[i]);
        		jobVO.setSemployWomen(semployWomen[i]);
        		jobVO.setSemployYouth(semployYouth[i]);
        		jobVO.setSemployYear(year);
        		
        		jobService.InsertSEmpMWYData(jobVO);
        	}
				
		} catch(Exception e) {
			e.printStackTrace();
		}
    	response.setContentType("text/xml;charset=utf-8");
    	PrintWriter printWriter = response.getWriter();
		printWriter.flush();
		printWriter.close();
    }
    
    /*
     * 고용률 세종 ComboChart 그리기
     */
//    @RequestMapping(value="/getEmployGrapeListSejong.do")
//    public @ResponseBody Object selectJsonEmployGrapeListSejong(
//    		HttpServletRequest request,
//    		HttpServletResponse response,
//    		@ModelAttribute("jobVO") JobVO jobVO
//    		) throws Exception {
//    	
//    	Map<String, Object> mp = new HashMap<String, Object>();
//    	mp.put("employLineData", jobService.selectJsonEmployGrapeListSejong(jobVO));
//    	
//    	return getJsonStringFromMap(mp, response);
//    }
    
    /*
     * 고용률 BarChart One 그리기
     */
    @RequestMapping(value="/getJobEmployBarGrapeList.do")
    public @ResponseBody Object selectJsonJobEmployBarGrapeList(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("jobEmployBarData", jobService.selectJsonJobEmployBarGrapeList(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }

    /*
     * 성별 고용률 ComboBox Select
     */
    @RequestMapping(value="/getSemployComboBox.do")
    public @ResponseBody Object selectSemployComboBox(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
    	Map<String, Object> mp = new HashMap<String, Object>();
    	mp.put("semployComboBox", jobService.selectSemployComboBox(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }
    
    /*
     * 실업율 DataTable Data Insert
     */
    @RequestMapping(value="/setUnEmployRateInsertData.do")
    public void insertUnEmployRateInsertData(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO,
    		ModelMap modelMap,
    		Model model) throws Exception {
    	
    	response.setContentType("text/plain; charset=utf-8");
    	try {
    		String[] unemployTitle = request.getParameterValues("unemployTitle");
        	String[] unemployTotal = request.getParameterValues("unemployTotal");
        	String[] unemploySejong = request.getParameterValues("unemploySejong");

        	for(int i = 0; i < unemployTitle.length; i++){
        		
        		String year = "20" + unemployTitle[i].toString().substring(0, 2);
        		
        		jobVO.setUnemployTitle(unemployTitle[i]);
        		jobVO.setUnemployTotal(unemployTotal[i]);
        		jobVO.setUnemploySejong(unemploySejong[i]);
        		jobVO.setUnemployYear(year);
        		
        		jobService.insertUnEmployRateInsertData(jobVO);
        	}
				
		} catch(Exception e) {
			e.printStackTrace();
		}
    	response.setContentType("text/xml;charset=utf-8");
    	PrintWriter printWriter = response.getWriter();
		printWriter.flush();
		printWriter.close();
    }
    
    /*
     * 전국 실업률 ComboChart 그리기
     */
    @RequestMapping(value="/getUnEmployGrapeList.do")
    public @ResponseBody Object selectJsonUnEmployGrapeList(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("unemployLineData", jobService.selectJsonUnEmployGrapeList(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }

    /*
     *  세종 실업률 ComboChart 그리기
     */
//    @RequestMapping(value="/getUnEmployGrapeListSejong.do")
//    public @ResponseBody Object selectJsonUnEmployGrapeListSejong(
//    		HttpServletRequest request,
//    		HttpServletResponse response,
//    		@ModelAttribute("jobVO") JobVO jobVO
//    		) throws Exception {
//    	
//    	Map<String, Object> mp = new HashMap<String, Object>();
//    	mp.put("unemployLineData", jobService.selectJsonUnEmployGrapeListSejong(jobVO));
//    	
//    	return getJsonStringFromMap(mp, response);
//    }
    
    /*
     * 취업알선 DataTable 조회
     */
    @RequestMapping(value="/getJobIntroDatatableList.do")
    public @ResponseBody Object selectJobIntroDatatableList(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	Map<String, Object> mp = new HashMap<String, Object>();
    	mp.put("data", jobService.selectJobIntroDatatableList(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }
    
    /*
     * 취업알선 DataTable Data Insert
     */
    @RequestMapping(value="/setJobIntroInsertCellData.do")
    public void insertJobIntroInsertCellData(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO,
    		ModelMap modelMap,
    		Model model
    		) throws Exception {
    	
    	response.setContentType("text/plain; charset=utf-8");
    	
    	try {
    		String[] introEmp = request.getParameterValues("introEmp");

    		JobVO jobIntroVO_One = new JobVO();
    		JobVO jobIntroVO_Two = new JobVO();
    		
    		jobIntroVO_One.setJobTitle(introEmp[0]);
    		jobIntroVO_One.setJobJanuary(introEmp[1]);
    		jobIntroVO_One.setJobFebruary(introEmp[2]);
    		jobIntroVO_One.setJobMarch(introEmp[3]);
    		jobIntroVO_One.setJobApril(introEmp[4]);
    		jobIntroVO_One.setJobMay(introEmp[5]);
    		jobIntroVO_One.setJobJune(introEmp[6]);
    		jobIntroVO_One.setJobJuly(introEmp[7]);
    		jobIntroVO_One.setJobAugust(introEmp[8]);
    		jobIntroVO_One.setJobSebtember(introEmp[9]);
    		jobIntroVO_One.setJobOctober(introEmp[10]);
    		jobIntroVO_One.setJobNovember(introEmp[11]);
    		jobIntroVO_One.setJobDecember(introEmp[12]);
    		jobIntroVO_One.setJobSeq("1");
    		jobIntroVO_One.setJobYear("2017");

    		jobIntroVO_Two.setJobTitle(introEmp[13]);
    		jobIntroVO_Two.setJobJanuary(introEmp[14]);
    		jobIntroVO_Two.setJobFebruary(introEmp[15]);
    		jobIntroVO_Two.setJobMarch(introEmp[16]);
    		jobIntroVO_Two.setJobApril(introEmp[17]);
    		jobIntroVO_Two.setJobMay(introEmp[18]);
    		jobIntroVO_Two.setJobJune(introEmp[19]);
    		jobIntroVO_Two.setJobJuly(introEmp[20]);
    		jobIntroVO_Two.setJobAugust(introEmp[21]);
    		jobIntroVO_Two.setJobSebtember(introEmp[22]);
    		jobIntroVO_Two.setJobOctober(introEmp[23]);
    		jobIntroVO_Two.setJobNovember(introEmp[24]);
    		jobIntroVO_Two.setJobDecember(introEmp[25]);
    		jobIntroVO_Two.setJobSeq("2");
    		jobIntroVO_Two.setJobYear("2017");
    		
    		jobService.updateJobIntroInsertCellData(jobIntroVO_One);
    		jobService.updateJobIntroInsertCellData(jobIntroVO_Two);

				
		} catch(Exception e) {
			e.printStackTrace();
		}
    	response.setContentType("text/xml;charset=utf-8");
    	PrintWriter printWriter = response.getWriter();
		printWriter.flush();
		printWriter.close();
    }
    
    /*
     * 취업알선 LineChart 그리기
     */
    @RequestMapping(value="/getJobIntroduceGrapeList.do")
    public @ResponseBody Object selectJsonJobIntroduceGrapeList(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("jobIntroduceLineData", jobService.selectJsonJobIntroduceGrapeList(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }    
    
    /*
     * 취업알선 BarChart 그리기
     */
    @RequestMapping(value="/getJobIntroBarGrapeList.do")
    public @ResponseBody Object selectJsonJobIntroBarGrapeList(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("jobIntroBarData", jobService.selectJsonJobIntroBarGrapeList(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }    
    
    /*
     * 취업알선 ComboBox Select
     */
    @RequestMapping(value="/getJobIntroduceComboBox.do")
    public @ResponseBody Object selectJobIntroduceComboBox(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
    	
    	Map<String, Object> mp = new HashMap<String, Object>();
    	mp.put("jobIntroduceComboBox", jobService.selectJobIntroduceComboBox(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }
    
    // DataTable에 사용할 JSON 데이터 만드는 함수
	public static JSONObject getJsonStringFromMap( Map<String, Object> map, HttpServletResponse response ) throws IOException {

		response.setContentType("text/plain; charset=utf-8");
   		PrintWriter out = response.getWriter();
		
		JSONObject json = new JSONObject();
		JSONObject json2 = new JSONObject();
		for( Map.Entry<String, Object> entry : map.entrySet() ) {
			String key = entry.getKey();
			Object value = entry.getValue();
			json.put(key, value);
		}
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.print(json);
		printWriter.flush();
		printWriter.close();
		
		return null;
	}
}
