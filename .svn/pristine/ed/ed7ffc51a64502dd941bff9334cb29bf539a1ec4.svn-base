function weatherLoad(){
	var date = [];
	var year = [];
	var month = [];
	var day = [];
	var dateResult = [];
	
	for(var i=0; i<3; i++) {
		date[i] = new Date()
		date[i].setDate(date[i].getDate() + i);
		
		year[i] = date[i].getFullYear();
		month[i] = date[i].getMonth()+1;
		day[i] = date[i].getDate();
		
	    /* example
	     * 9시 -> 09시 변경 필요
	     */
	    
	    if(month[i] < 10) {
	        month[i] = '0' + month[i];
	    }    
	    if(day[i] < 10) {
	        day[i] = '0' + day[i];
	    } 
	 
	    dateResult[i] = year[i] + ". " + month[i] + ". " + day[i];
	}
	
	try {
		$.ajax({
	        url: G_CONTEXT_PATH + '/getXMLFile.do',
	        type: "POST",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {
	        	console.log('[log] ----> weather.js  . [성공] -> getXMLFile.do ');
		    },
		    error: function(xhr, status, error) {
		    	alert('서버와의 통신 문제로 날씨 정보를 가져오지 못했습니다. 잠시 후 다시 시도해 주세요.');
		    	console.log('[log] ----> weather.js  . [에러] -> getXMLFile.do ');
		    }
		});
	} catch (e) {
		// TODO: handle exception
		console.log('[log] ----> weather.js  . [예외] -> getXMLFile.do ');
	}
}

// 미세먼지 불러오기
function airInfoLoad(){
	try {
		$.ajax({
			type: "POST",
	        url: G_CONTEXT_PATH + "/getAirInfo.do",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {  
	        	console.log('[log] ----> weather.js  . [성공] -> getAirInfo.do ');
	        	var datatime = res.getAirInfo[0].datatime;
	        	var stationname = res.getAirInfo[0].stationname;
	        	var khaigrade = res.getAirInfo[0].khaigrade;
	        	
	        	if(khaigrade == 1){
	        		$("#liAirinfo").text("미세먼지 좋음")
	        	} else if(khaigrade == 2){
	        		$("#liAirinfo").text("미세먼지 보통")
	        	} else if(khaigrade == 3){
	        		$("#liAirinfo").text("미세먼지 나쁨")
	        	} else if(khaigrade == 4){
	        		$("#liAirinfo").text("미세먼지 매우나쁨")
	        	}
	        	
	        },error: function(res) {
		    	alert("/getAirInfo.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    	console.log('[log] ----> weather.js  . [에러] -> getAirInfo.do ');
		    }
		});
	} catch (e) {
		// TODO: handle exception
		console.log('[log] ----> weather.js  . [예외] -> getAirInfo.do ');
	}
}