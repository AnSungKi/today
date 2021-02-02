package egovframework.sayit.statusboard.weather;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

import net.sf.json.JSONArray;

@Controller
public class WeatherContoller {
	
	@Resource(name="weatherService")
    private WeatherService weatherService;

	String mkdirPath = "/webapps/today/data";
	String savePath = "/webapps/today/data/weather.json";
	String saveJidoPath = "/webapps/today/data/weatherjido.json";
//	String mkdirPath = "D:\\backup\\data";
//	String savePath = "D:\\backup\\data\\weather.json";
//	String saveJidoPath = "D:\\backup\\data\\weatherjido.json";
	StringBuilder sb = new StringBuilder();
	String xml = "";
	String jsonStr = "";
	
	private static final String URL = "http://apis.data.go.kr/1360000/VilageFcstInfoService/getUltraSrtFcst?";
	private static final String KEY = "serviceKey=tpvA%2B7fkLl6Shce03R1%2B1nH45T%2Fk0lZdjZSDvAHoMm%2BqyDnh9Qgrzw1%2B4O4INM2%2FDhhN2dzxwsnsc9lQoGXHcA%3D%3D&";
	private static final String[] COORDINATES = new String[]{
			"nx=63&ny=108&", //소정면 
			"nx=64&ny=108&", //전의면 
			"nx=65&ny=107&", //전동면 
			"nx=66&ny=106&", //조치원읍
			"nx=65&ny=106&", //연서면 
			"nx=66&ny=105&", //연동면 
			"nx=65&ny=105&", //연기면 
			"nx=67&ny=104&", //부강면 
			"nx=66&ny=103&", //보람동 
			"nx=65&ny=103&", //금남면 
			"nx=64&ny=104&", //장군면 
			"nx=65&ny=104&", //고운동 
			"nx=65&ny=104&", //아름동 
			"nx=65&ny=104&", //증촌동 
			"nx=65&ny=103&", //새롬동 
			"nx=65&ny=103&", //한솔동 
			"nx=65&ny=104&" //도담동 
	};
	
	private static final String[] PLACE_CODE = new String[]{
			"sjm", //소정면 
			"jwm", //전의면 
			"jdm", //전동면 
			"jcw", //조치원읍
			"ysm", //연서면 
			"ydm", //연동면 
			"ygm", //연기면 
			"bgm", //부강면 
			"brm", //보람동 
			"gnm", //금남면 
			"jgm", //장군면 
			"gwd", //고운동 
			"ard", //아름동 
			"jcd", //증촌동 
			"srd", //새롬동 
			"hsd", //한솔동 
			"ddd" //도담동 
	};
	private void addPlaceCode(List<String> arrName) {
		for (int i = 0; i < PLACE_CODE.length; i++) {
			arrName.add(PLACE_CODE[i]);
		}
	}
	private void addWeather(List<String> arrAddr, String baseDate, String baseTime, String numOfRows) {
		 for (int i = 0; i < COORDINATES.length; i++) {
			 arrAddr.add(URL + KEY + baseDate + baseTime + COORDINATES[i] + numOfRows); //소정면
		}
	}
	
     /*
     * 기상청 세종시 날씨정보 Data xml 형태로 jsp 로 넘기기
     */
    @RequestMapping(value="/getXMLFile.do")
    public @ResponseBody void getXMLFile(
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{
    	
    	JSONObject json = new JSONObject();
    	JSONArray json2 = new JSONArray();
    	
    	File file = new File(mkdirPath);
    	
    	if(!file.exists()){
    		System.out.println("폴더 없음, 폴더생성");
    		file.mkdirs();
    	} else {
    		System.out.println("폴더 있음");
    	}
    	
        try {
        	String addr = "http://www.kma.go.kr/wid/queryDFS.jsp?gridx=66&gridy=106";
 
        	DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
			Document doc = dBuilder.parse(addr);
			
			// root tag 
			doc.getDocumentElement().normalize();

			// 파싱할 tag
			NodeList nList = doc.getElementsByTagName("data");
			List list = new ArrayList();
			Map<String, Object> mp = new HashMap<String, Object>();
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					json.put("temp", getTagValue("temp", eElement));
					json.put("wfEn", getTagValue("wfEn", eElement));
					json.put("wfKor", getTagValue("wfKor", eElement));
					json.put("pop", getTagValue("pop", eElement));
					json.put("hour", getTagValue("hour", eElement));
					json.put("day", getTagValue("day", eElement));
					
					json2.add(json);
					json.clear();
					
//					list.add(mp2);
				}
			}
			
			json.put("item", json2);
			
//			mp.put("item", list);
			
			
			response.setContentType("text/xml; charset=utf-8");
	   		PrintWriter out = response.getWriter();
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(savePath), StandardCharsets.UTF_8);
			writer.write(json.toJSONString());
			writer.flush();
			writer.close();
			
			response.setContentType("text/xml; charset=utf-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(json);
			printWriter.flush();
			printWriter.close();

        } catch (Exception e) {
            System.out.println("다운로드에러" + e.getMessage());
        }
    }

    /*
     * 미세먼지 Data Select
     */
    @RequestMapping(value="/getAirInfo.do")
    public @ResponseBody Object getAirInfo(
    		@ModelAttribute("weatherVO") WeatherVO weatherVO,
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{

    	Map<String, Object> mp = new HashMap<String, Object>();

    	mp.put("getAirInfo", weatherService.getAirInfo(weatherVO));
			
		return getJsonFromMap(mp, response);
				 
    }
    
    /*
    * 기상청 세종시 날씨정보 Data xml 형태로 weather.jsp 로 넘기기
    */
   @RequestMapping(value="/getXMLFileJido.do")
   public @ResponseBody void getXMLFileJido(
   		HttpServletRequest request,
   		HttpServletResponse response) throws Exception{
	   
	   	JSONObject json = new JSONObject();
	   	JSONArray json2 = new JSONArray();

       try {
    	   /* 소정면, 전의면, 전동면, 조치원읍, 연서면, 연동면, 연기면, 부강면, 보람동, 금남면, 고운동, 아름동, 증촌동, 새롬동, 한솔동, 도담동 */
    	   List<String> arrAddr = new ArrayList<>();  // xml 데이터 url
    	   List<String> arrName = new ArrayList<>();  // 각 면, 동 이름
    	   
    	   DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
    	   DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
    	   Document doc;
    	   
    	   String base_date = new java.text.SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
    	   String base_hour = new java.text.SimpleDateFormat("HH").format(new java.util.Date());
    	   String base_min  = new java.text.SimpleDateFormat("mm").format(new java.util.Date());
    	   
    	   Calendar cal =  Calendar.getInstance();
    	   cal.add(Calendar.DATE, -1);
    	   if(Integer.parseInt(base_min) < 31){
    		   if(Integer.parseInt(base_hour)==0){
    			   base_date = new java.text.SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    			   base_hour = "23";
    		   }else if(Integer.parseInt(base_hour)<11){
    			   base_hour = "0" + Integer.toString(Integer.parseInt(base_hour)-1);
    		   }else{
    			   base_hour = Integer.toString(Integer.parseInt(base_hour)-1);
    		   }
    	   }
    	   
    	   String viewDate="";
    	   
    	   String baseDate = "base_date=" + base_date + "&";
    	   String baseTime = "base_time=" + base_hour + "30&";
    	   String numOfRows = "numOfRows=50";
    	   
    	   addWeather(arrAddr, baseDate, baseTime, numOfRows);
    	   addPlaceCode(arrName);

			for(int i = 0; i < arrName.size(); i++) {
				doc = dBuilder.parse(arrAddr.get(i).toString());
				
				// root tag 
				doc.getDocumentElement().normalize();
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				if(i==0){
					Node tNode = nList.item(0);
					if (tNode.getNodeType() == Node.ELEMENT_NODE) {
						Calendar calyoil = Calendar.getInstance();
						Element tElement = (Element) tNode;
						viewDate = getTagValue("fcstDate", tElement);
						Date dateyoil = new SimpleDateFormat("yyyyMMdd").parse(viewDate);
						calyoil.setTime(dateyoil);
						String viewyoil = Integer.toString(calyoil.get(Calendar.DAY_OF_WEEK)-1);
						viewDate += getTagValue("fcstTime", tElement);
						viewDate += viewyoil;
						json.put("tm", viewDate);
						json2.add(json);
						json.clear();
					}
				}
				String categorytag;
				String t1h= "";
				String pty="";
				String sky="";
				for(int j=0;j<nList.getLength();j++){
					Node nNode = nList.item(j);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						Element eElement = (Element) nNode;
						categorytag = getTagValue("category",eElement);
						if(categorytag.equals("T1H")){
							if(t1h.equals(""))
							t1h = getTagValue("fcstValue", eElement);
						}else if(categorytag.equals("PTY")){
							if(pty.equals(""))
								pty = getTagValue("fcstValue", eElement);
						}else if(categorytag.equals("SKY")){
							if(sky.equals(""))
							sky = getTagValue("fcstValue", eElement);
						}
						if(!sky.equals("") && !pty.equals("") && !t1h.equals("")){
							json.put("placeName", arrName.get(i));
							if(t1h.contains("."))
								json.put("temp", t1h);
							else
								json.put("temp", t1h+".0");
							if(pty.equals("0")){
								if(sky.equals("1")){
									json.put("wfKor", "맑음");
									json.put("wfEn", "Clear");
									break;
								}else if(sky.equals("2")){
									json.put("wfKor", "구름 조금");
									json.put("wfEn", "Partly Cloudy");
									break;
								}else if(sky.equals("3")){
									json.put("wfKor", "구름 많음");
									json.put("wfEn", "Mostly Cloudy");
									break;
								}else if(sky.equals("4")){
									json.put("wfKor", "흐림");
									json.put("wfEn", "Cloudy");
									break;
								}
							}else if(pty.equals("1")){
								json.put("wfKor", "비");
								json.put("wfEn", "Rain");
								break;
							}else if(pty.equals("2")){
								json.put("wfKor", "눈/비");
								json.put("wfEn", "Snow/Rain");
								break;
							}else if(pty.equals("3")){
								json.put("wfKor", "눈");
								json.put("wfEn", "Snow");
								break;
							}
						}
					}
				}
				
				json2.add(json);
				json.clear();
			}
			
			
			json.put("item", json2);
			
	   		response.setContentType("text/xml; charset=utf-8");
	   		PrintWriter out = response.getWriter();
			
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(saveJidoPath), StandardCharsets.UTF_8);
			writer.write(json.toJSONString());
			writer.flush();
			writer.close();
			
			response.setContentType("text/xml; charset=utf-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(json);
			printWriter.flush();
			printWriter.close();

       } catch (Exception e) {
           System.out.println("다운로드에러" + e.getMessage());
       }
   }    

// tag값의 정보를 가져오는 메소드
 	private static String getTagValue(String tag, Element eElement) {
 	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
 	    Node nValue = (Node) nlList.item(0);
 	    if(nValue == null) 
 	        return null;
 	    return nValue.getNodeValue();
 	}
 	
 	/*
     * 고용율 DataTable Data Insert
     */
    @RequestMapping(value="/getWeatherFileData.do")
    public @ResponseBody Object getWeatherFileData(
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{

//    	File inFile = new File("D:\\backup\\data", "sotong.json");
    	
    	JSONParser parser = new JSONParser();
    	Map<String, Object> mp = new HashMap<String, Object>();
    	
    	Object obj = parser.parse(new FileReader(saveJidoPath));		// 동네예보 날씨 데이터 가져옴. (도담동의 온도와 날씨 정보 가져와서 메인에 뿌려줌)
    	Object objKSC = parser.parse(new FileReader(savePath)); 		// 기상청 날씨 데이터 가져옴. (강수확률 정보 때문에 )

    	  
    	JSONObject jsonObject = (JSONObject) obj;
    	JSONObject jsonObjectKSC = (JSONObject) objKSC;
		
 
		// loop array
		org.json.simple.JSONArray item = (org.json.simple.JSONArray) jsonObject.get("item");
		org.json.simple.JSONArray itemKSC = (org.json.simple.JSONArray) jsonObjectKSC.get("item");
		
		mp.put("item", item);
		mp.put("itemKSC", itemKSC);
		
		return getJsonFromMap(mp, response);
    }

    /*
     * 고용율 DataTable Data Insert
     */
    @RequestMapping(value="/getWeatherJidoFileData.do")
    public @ResponseBody Object getWeatherJidoFileData(
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{
//    	File inFile = new File("D:\\backup\\data", "sotong.json");
    	
    	JSONParser parser = new JSONParser();
    	Map<String, Object> mp = new HashMap<String, Object>();
    	
    	Object obj = parser.parse(new FileReader(saveJidoPath));
    	
    	JSONObject jsonObject = (JSONObject) obj;
    	
    	// loop array
    	org.json.simple.JSONArray item = (org.json.simple.JSONArray) jsonObject.get("item");
    	
    	mp.put("item", item);
    	
    	return getJsonFromMap(mp, response);
    }
	
	// DataTable에 사용할 JSON 데이터 만드는 함수
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
