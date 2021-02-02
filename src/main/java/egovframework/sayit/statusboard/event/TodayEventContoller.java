package egovframework.sayit.statusboard.event;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.com.argo.hwp.HwpTextExtractor;
import net.sf.json.JSONArray;

@Controller
public class TodayEventContoller {
	@Resource(name="todayEventService")
    private TodayEventService todayEventService;
	
	String mkdirPath = "/webapps/today/data";
	static String url2 = "/webapps/today/data/event.json";
	String saveHWPPath =  "/webapps/today/data/TodayEvent.hwp";
	
//    String mkdirPath = "D:\\backup\\data";
//    static String url2 = "D:\\backup\\data\\event.json";
//    String saveHWPPath =  "D:\\backup\\data\\TodayEvent.hwp";
    static String pathSet;
    
    @RequestMapping(value="/getMakeEventJsonFile.do")
    public @ResponseBody Object selectMakeSotongJsonFile(
    		@ModelAttribute("todayeventVO") TodayEventVO  todayeventVO,
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{
    	
    	JSONObject json = new JSONObject();
    	JSONArray json2 = new JSONArray();
    	
    	//오늘의 세종 행사 변수 초기화 셋팅  *(각 변수들의 기본값 설텅)
    	String msg ="오늘 행사일정은  없습니다.";			//행사 일정 내용
    	String time="";			//행사 시간
    	String circle ="○";		//행사 구분자
    	String place ="　";		//행사 장소   :  이때 place 값에는 공백이 아닌 , '　' ('ㄱ' 한자 1번) 을 넣음
    	String person ="";		//행사 인원
    	String dept ="";		//행사 담당부서
    	String etc ="";			//비고
    	
    	File file = new File(mkdirPath);
    	boolean fileexist = true;		//file 존재 여부 확인 Flag 
    	
    	if(!file.exists()){
//    		System.out.println("폴더 없음, 폴더생성");
    		file.mkdirs();
    	} else {
//    		System.out.println("폴더 있음");
    	}
    	
    	// 오늘 일정이 있는 파일을 다운받았는지 확인
    	List eventList = todayEventService.selectFileExist(todayeventVO);
    	
    	if(eventList.size() == 0){ // 파일이 없다면 파일 다운로드 로직
    		int fileDocNum;	
    		TodayEventVO voFileDocNum = todayEventService.selectFileDocNum(todayeventVO);
    		Document doc = Jsoup.connect("http://www.sejong.go.kr/cop/bbs/BBSMSTR_000000000231/selectBoardList.do").get();
        	String temp = doc.html();
        	fileDocNum = voFileDocNum.getFileDocnum();
        	fileDocNum = fileDocNum + 1;
        	
        	if(temp.indexOf(fileDocNum + ".</span>") >= 0){ // 최신글이 올라왔나 확인 후 있다면 다운로드 / 없다면 Flag = false;
        		String docNum = "";
            	int stNum;
            	int enNum;
            	stNum = temp.indexOf("atchFileId=FILE_");
            	enNum = temp.indexOf("&amp;fileSn=");
            	docNum = temp.substring(stNum, enNum);
            	
            	//파일 다운로드하기
            	URL url = new URL("http://www.sejong.go.kr/cmm/fms/FileDown.do?atchFileId=" + docNum + "&fileSn=0");
//            	System.out.println("한글파일 파일 다운로드");
            	try {
            		InputStream in = new URL("http://www.sejong.go.kr/cmm/fms/FileDown.do?" + docNum + "&fileSn=0").openStream();
            		OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(saveHWPPath)));
            		int readInt = 0;
            		while((readInt = in.read()) != -1){
            			out.write(readInt);
            		}
            		in.close();
        			out.close();
//        			System.out.println("한글파일 다운로드 완료");
        		}catch(Exception e){
            		e.printStackTrace();
            	}
            	
            	// 다운로드 한 파일 정보 Insert
            	TodayEventVO voDate = todayEventService.selectFiledate(voFileDocNum);
            	voDate.setFileStartdate(voDate.getFileStartdate().substring(0, 10));
            	voDate.setFileEnddate(voDate.getFileEnddate().substring(0, 10));
            	voDate.setFileName("TodayEvent.hwp");
            	voDate.setFileDocnum(fileDocNum);
            	todayEventService.insertNewFileInfo(voDate);
        	}else{
//          		System.out.println("일정 없을때");
        		json.put("date", " ");
        		json.put("msg", "주간 행사 계획 파일이 없습니다. 관리자에게 문의하세요.");
        		json.put("time", " ");
        		json.put("circle", " ");
        		json.put("place", " ");
        		json.put("person", " ");
        		json.put("dept", " ");
        		json.put("etc", " ");
    		
            	json2.add(json);
            	json.put("item", json2);
            	
        		fileexist = false;
        	}		
    	}
    	if(fileexist){
        	File hwp = new File(saveHWPPath); // 텍스트를 추출할 HWP 파일
        	
        	Writer writer = new StringWriter(); // 추출된 텍스트를 출력할 버퍼
        	HwpTextExtractor.extract(hwp, writer); // 파일로부터 텍스트 추출
        	String text = writer.toString(); // 추출된 텍스트
        	List list = new ArrayList();
        	List listJson = new ArrayList();
        	for(String str : text.split(" \n")){
				if (!str.equals("".toString())) {
					list.add(str);
				}
        	}
        	
        	Calendar cal = Calendar.getInstance();
        	 
        	//현재 년도, 월, 일
        	int year = cal.get ( cal.YEAR );
        	int month = cal.get ( cal.MONTH ) + 1 ;
        	int date = cal.get ( cal.DATE ) ;
        	 
        	int today_num = 0;
        	int tommorow_num = 0;
        	
            
        	String today = month + "." + date + ".";
        	date = date + 1;
        	String yoil = "";
        	List yoilList = new ArrayList();
        	yoilList.add(0, "월");
        	yoilList.add(1, "화");
        	yoilList.add(2, "수");
        	yoilList.add(3, "목");
        	yoilList.add(4, "금");
        	yoilList.add(5, "토");
        	yoilList.add(6, "일");
        	Map<String, Object> mp = new HashMap<String, Object>();
        	
        	for(int i = 0; i < list.size(); i++) {
        		if(list.get(i).toString().replace(" ",  "").equals(today)){
        			today_num = i;
        			yoil = list.get(i+1).toString().replace(" ",  "");
        			yoil = yoil.replace("(", "");
        			yoil = yoil.replace(")", "");
        			for(int j = 0; j < 7; j++){
        				if(yoilList.get(j).toString().equals(yoil)){
        					if(j!=6){
        						yoil = yoilList.get(j+1).toString();
        						break;
        					} else {
        						yoil = yoilList.get(0).toString();
        						break;
        					}
        				}
        			}
        		}
        		if(list.get(i).toString().replace(" ",  "").equals("(" + yoil + ")")){
        			tommorow_num = i - 1;
        			break;
        		}
        	} 	
        	date = date - 1;	
			if (month < 10) { today = "0" + month + "-";} 
			else { today = month + "-"; }
        	
        	if(date < 10){ today = today + "0" + date; } 
        	else { today = today + date; }
//        	System.out.println("Json 생성 시작");
        	if((today_num + 2) != tommorow_num) {
            	for(int j = (today_num + 2); j < tommorow_num; j++){
            		if(list.get(j).toString().matches("^[0-9]{2}:[0-9]{2}$")){
                        if(j != (today_num + 2)){
                        	addEventjson(json,msg,time,circle,place,person,dept,etc);	//json에 해당 field 넣고 초기값으로 변경
                        	json2.add(json);
                        	json.clear();
                        }
                        if(json.get("date") == null){
                        	json.put("date", today + list.get(today_num + 1).toString());
                        	json.put("time", list.get(j).toString());
                        	time = list.get(j).toString();
                        }
                     } else {
                    	if(json.get("circle") == null){
                    		if(list.get(j).toString().trim().equals("○")){
                    			json.put("circle", list.get(j).toString().trim());
                    			circle = list.get(j).toString().trim();
                    		} else {
                    			json.put("time", list.get(j).toString());
                    			time = list.get(j).toString();
                    		}
                    	} else if(json.get("msg") == null){
                           json.put("msg", list.get(j).toString());
                           msg = list.get(j).toString();
                        } else if(json.get("place") == null){
                        	if(list.get(j+1).toString().matches("^[0-9]+$") || list.get(j+1).toString().equals("-")){
                        		json.put("place", list.get(j).toString());
                        		place = list.get(j).toString();
                        	} else {
                        		json.put("msg", json.get("msg").toString() + list.get(j).toString());
                        		msg = msg+list.get(j).toString();
                        	}
                        } else if(json.get("person") == null){
                           json.put("person", list.get(j).toString());
                           person = list.get(j).toString();
                        } else if(json.get("dept") == null){
                        	json.put("dept", list.get(j).toString());
                        	dept = list.get(j).toString();
                        } else if(json.get("etc") == null){
                        	if(list.get(j+1).toString().matches("^[0-9]{2}:[0-9]{2}$") || list.get(j+2).toString().equals("(" + yoil + ")")){
                        		json.put("etc", list.get(j).toString());
                        		etc = list.get(j).toString();
                        	} else {
                        		json.put("dept", json.get("dept").toString() + list.get(j).toString());
                        		dept = dept + list.get(j).toString();                        	}
                        }
                     }
            	}
        	}
        	
//        	System.out.println("Json 생성 시작");

        	addEventjson(json,msg,time,circle,place,person,dept,etc);	//json에 해당 field 넣고 초기값으로 변경
        	json2.add(json);
            json.clear();
        	json.put("item", json2);
    	}

    	
    	return getJsonStringFromMap(json, response);
    }
    
    @RequestMapping(value="/getEventFileData.do")
    public @ResponseBody Object getEventFileData(
    		HttpServletRequest request,
    		HttpServletResponse response) throws Exception{
    	
    	JSONParser parser = new JSONParser();
    	Map<String, Object> mp = new HashMap<String, Object>();
    	
    	Object obj = parser.parse(new FileReader(url2));
        
		JSONObject jsonObject = (JSONObject) obj;
		
		if(jsonObject.size() > 1){
			// loop array
			JSONArray item = (JSONArray) jsonObject.get("item");
			
			mp.put("item", item);
		} else if(jsonObject.size() == 1){
			mp.put("item", jsonObject.get("item"));
		}
		
		return getJsonFromMap(mp, response);
    }

	public static JSONObject getJsonStringFromMap(JSONObject json, HttpServletResponse response ) throws IOException {

//		response.setContentType("text/xml; charset=utf-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
   		PrintWriter out = response.getWriter();

   		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(url2), StandardCharsets.UTF_8);
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
	
	public void addEventjson(JSONObject json,String msg,String time,String circle,String place,String person,String dept,String etc){
		json.put("msg", msg);
		json.put("time", time);
		json.put("circle", circle);
		json.put("place", place);			//이때 place 값에는 공백이 아닌 , '　' ('ㄱ' 한자 1번) 을 넣음
		json.put("person", person);
		json.put("dept", dept);
		json.put("etc", etc);
		
    	//오늘의 세종 행사 변수 초기화 셋팅  *(각 변수들의 기본값 설텅)
    	msg ="오늘 행사일정은  없습니다.";			//행사 일정 내용
    	time="";			//행사 시간
    	circle ="○";		//행사 구분자
    	place ="　";		//행사 장소   :  이때 place 값에는 공백이 아닌 , '　' ('ㄱ' 한자 1번) 을 넣음
    	person ="";		//행사 인원
    	dept ="";		//행사 담당부서
    	etc ="";			//비고
	}
}
