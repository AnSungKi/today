package egovframework.sayit.statusboard.cs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class CsContoller {
//    @Resource(name="csService")
	@Autowired
    private CsService csService;
    
//    String mkdirPath = "/webapps/today/data";
//    static String url = "/webapps/today/data/cs.json";
    String mkdirPath = "D:\\backup\\data";
    static String url = "D:\\backup\\data\\cs.json";
    static String pathSet;
    
    JSONObject json = new JSONObject();
	JSONArray json2 = new JSONArray();
	
    @RequestMapping(value="/getMakeCsJsonFile.do")
    public @ResponseBody Object getMakeCsJsonFile(
    		@ModelAttribute("csVO") CsVO csVO,
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{
    	
    	File file = new File(mkdirPath);
    	
    	if(!file.exists()){
    		System.out.println("CS 폴더 없음, 폴더생성");
    		file.mkdirs();
    	} else {
    		System.out.println("CS 폴더 있음");
    	}

    	Map<String, Object> mp = new HashMap<String, Object>();
//		mp.put("item", csService.getCsList());
		
		return getJsonStringFromMap(mp, response);
    }
    
    @RequestMapping(value="/getCsFileData.do")
    public @ResponseBody Object getCsFileData(
    		@ModelAttribute("csVO") CsVO csVO,
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{

    	JSONParser parser = new JSONParser();
    	Map<String, Object> mp = new HashMap<String, Object>();
    	
//    	Object obj = parser.parse(new FileReader(url));
//        
//		JSONObject jsonObject = (JSONObject) obj;
// 
//		// loop array
//		JSONArray item = (JSONArray) jsonObject.get("item");
		
//		mp.put("item", item);
		
		return getJsonFromMap(mp, response);
    }

	public static JSONObject getJsonStringFromMap( Map<String, Object> map, HttpServletResponse response ) throws IOException {

//		response.setContentType("text/xml; charset=utf-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
   		PrintWriter out = response.getWriter();
		
		JSONObject json = new JSONObject();
		JSONObject json2 = new JSONObject();
		for( Map.Entry<String, Object> entry : map.entrySet() ) {
			String key = entry.getKey();
			Object value = entry.getValue();
			json.put(key, value);
		}
		
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(url), StandardCharsets.UTF_8);
		writer.write(json.toJSONString());
		writer.flush();
		writer.close();
		
//		response.setContentType("text/xml; charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.print(json);
		printWriter.flush();
		printWriter.close();
		
		return null;
	}
	
		public static JSONObject getJsonFromMap( Map<String, Object> map, HttpServletResponse response ) throws IOException {

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
