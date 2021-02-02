package egovframework.sayit.statusboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import egovframework.sayit.duplex.Duplex;
import egovframework.sayit.statusboard.allowip.AllowIPService;
import egovframework.sayit.statusboard.allowip.AllowIPVO;
import egovframework.sayit.statusboard.job.JobService;
import egovframework.sayit.statusboard.job.JobVO;

@Controller
public class StsBoardController {

	@Resource(name="allowIPService")
    private AllowIPService allowIPService;
	
	@Resource(name="jobService")
    private JobService jobService;
	
	@RequestMapping(value="/statusBoardMain.do")
	public String openStatusBoardMain(
			HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO,
    		ModelMap modelMap,
    		Model model) throws Exception {
		
		String returnStr = "";
		
		try {
			
			String ipAddress = (String) request.getRemoteAddr();
			System.out.println(ipAddress);
			String[] quarterIp = ipAddress.split("\\.");
			ipAddress = quarterIp[0] +"." + quarterIp[1] +"." + quarterIp[2] +".";
			
			AllowIPVO vo = new AllowIPVO();
			
			vo.setIpallowIp(ipAddress);
			List list = allowIPService.selectAllowIP(vo);
			
			if(list.size() != 0) {
				returnStr = "/statusboard/statusboardmain";
			} else {
				returnStr = "redirect:http://www.sejong.go.kr/common/error.do";
			}
			if(request.getParameter("user_id").length() < 20){
				String en_UserId =  Duplex.encrypt(request.getParameter("user_id"), "naraeIctVoteMove");
				String en_DeptCd =  Duplex.encrypt(request.getParameter("dept_cd"), "naraeIctVoteMove");
			    String de_UserId = Duplex.decrypt(en_UserId, "naraeIctVoteMove");
			    String de_DeptCd = Duplex.decrypt(en_DeptCd, "naraeIctVoteMove");
			    
//				String user_id = request.getParameter("user_id");
//				String dept_cd = request.getParameter("dept_cd");
				String user_id = Duplex.encrypt(request.getParameter("user_id"), "naraeIctVoteMove");
				String dept_cd = Duplex.encrypt(request.getParameter("dept_cd"), "naraeIctVoteMove");
				
//				request.getSession().setAttribute("user_id", user_id);
				
				model.addAttribute("user_id", user_id);
				model.addAttribute("dept_cd", dept_cd);
			} else {
				model.addAttribute("user_id", request.getParameter("user_id"));
			}
			
			model.addAttribute("curemppercent", jobService.selectEmployPercent(jobVO));
			model.addAttribute("curunemppercent", jobService.selectUnEmployPercent(jobVO));
//			model.addAttribute("curjobintroduce", jobService.selectJobIntroducePercent(jobVO));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return returnStr;
	}
	
	@RequestMapping(value="/jobEmployPage.do")
	public String openJobEmployPage() throws Exception{
		return "/statusboard/job/jobEmploy";
	}

	@RequestMapping(value="/minwonAnalysis.do")
	public String openMinwonAnalysisPage() throws Exception{
		return "/statusboard/minwonanalysis";
	}
	
	@RequestMapping(value="/jobUnEmployPage.do")
	public String openJobUnEmployPage() throws Exception{
		return "/statusboard/job/jobUnEmploy";
	}
	
	@RequestMapping(value="/jobIntroPage.do")
	public String openJobIntroducePage() throws Exception{
		return "/statusboard/job/jobIntroduce";
	}
	
	@RequestMapping(value="/getSearchJobMonitorData.do")
    public @ResponseBody Object selectJsonSearchJobMonitorData(
    		HttpServletRequest request,
    		HttpServletResponse response,
    		@ModelAttribute("jobVO") JobVO jobVO
    		) throws Exception {
		
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		
		String year = format.format(d).replace("-", "").substring(0, 4);
		String month = format.format(d).replace("-", "").substring(4);
		
		jobVO.setEmployYear(year);
		jobVO.setUnemployYear(year);
		jobVO.setJobYear(year);
		
		jobVO.setJobJanuary(month);
		
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("monitorData", jobService.selectJsonSearchJobMonitorData(jobVO));
    	
    	return getJsonStringFromMap(mp, response);
    }   
	
	@RequestMapping(value="/getMonitorPopulationData.do")
	public @ResponseBody Object selectJsonMonitorPopulationData(
			HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("jobVO") JobVO jobVO
			) throws Exception {
		
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("monitorPopulationData", jobService.selectJsonMonitorPopulationData(jobVO));
		
		return getJsonStringFromMap(mp, response);
	}   
	
	@RequestMapping(value="/weatherJido.do")
	public String openWeatherJidoPage() throws Exception{
		return "/statusboard/weather/weather";
	}
	
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
