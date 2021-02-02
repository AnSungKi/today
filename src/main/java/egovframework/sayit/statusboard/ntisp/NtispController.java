package egovframework.sayit.statusboard.ntisp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.sayit.statusboard.ntisp.NtispService;
import egovframework.sayit.statusboard.ntisp.NtispVO;

@Controller
public class NtispController {
	
	@Resource(name="ntispService")
	NtispService ntispService;
	
	@RequestMapping(value = "/ntisp/totalCount.do")
	public @ResponseBody Object totalCount(
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception{
		
		Map<String, Object> mp = new HashMap<String, Object>();
		mp.put("ntispTotalCount", ntispService.totalCount());
		
		return getJsonStringFromMap(mp, response);
		
	}
	 
	@RequestMapping(value = "/ntisp/list.do")
	public @ResponseBody Object list(
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception{
		
		Map<String, Object> mp = new HashMap<String, Object>();
		NtispVO ntispVO = new NtispVO();
		
		mp.put("ntispList", ntispService.list(ntispVO));
		
		return getJsonStringFromMap(mp, response);
		
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
