package egovframework.sayit.statusboard.population;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PopulationContoller {
    @Resource(name="populationService")
    private PopulationService populationService;
    
    @RequestMapping(value="/getPopulation.do")
    public @ResponseBody Object selectPopulation(
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{

    	Map<String, Object> mp = new HashMap<String, Object>();
    	mp.put("totalPopulation", populationService.selectPopulation());
    	
    	return getJsonStringFromMap(mp, response);
    }

    // JSON 데이터 만드는 함수
	public static JSONObject getJsonStringFromMap( Map<String, Object> map, HttpServletResponse response ) throws IOException {

		response.setContentType("text/plain; charset=utf-8");
		
		JSONObject json = new JSONObject();
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
