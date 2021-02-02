//$(window).load(function() {
function weatherJidoMain() {	
	var weatherList = [];

	weatherJidoMake();
	
	$.ajaxSetup({ async:false });
	try {
		$.ajax({
	        url: G_CONTEXT_PATH + '/getWeatherJidoFileData.do',
	        type: "POST",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {
	        	console.log('[log] ----> weatherjido.js  . [성공] -> getWeatherJidoFileData.do ');
	        	weathertList = res.item;
	        	weatherJidoStart(weathertList);
		    },
		    error: function(xhr, status, error) {
		    	alert('서버와의 통신 문제로 날씨 지도 정보를 가져오지 못했습니다. 잠시 후 다시 시도해 주세요.');
		    	console.log('[log] ----> weatherjido.js  . [에러] -> getWeatherJidoFileData.do ');
		    }
		});
	} catch (e) {
		// TODO: handle exception
		console.log('[log] ----> weatherjido.js  . [예외] -> getWeatherJidoFileData.do ');
	}
}
	
//});

function weatherJidoMake() {
	try {
		$.ajax({
	        url: G_CONTEXT_PATH + '/getXMLFileJido.do',
	        type: "POST",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {
	        	console.log('[log] ----> weatherjido.js  . [성공] -> getXMLFileJido.do ');

	        	var weatherList = res.item;
	        	
	        	var date = new Date();
	        	var placeName = [];
	        	var temp = [];
	        	var wfEn = [];
	        	var wfKor = [];
	        	var pop = [];
	        	var hour = [];
	        	var day = [];
	        	var dayOfKorean = ["(일)", "(월)", "(화)", "(수)", "(목)", "(금)", "(토)"];
	        	var tm ;		// tm = 수집시간 정보 
	        	tm = weatherList[0].tm;	// tm 수집시간 정보 ( YYYYMMDDHHMMy 형태로 저장됨 . ex '2018050417003' , 마지막 y는 요일 )
	        	var collecYear = tm.substr(0,4);
	        	var collecMontn = tm.substr(4,2);
	        	var collecDay = tm.substr(6,2);
	        	var collecHour = tm.substr(8,2);
	        	var collecMin = tm.substr(10,2);
	        	var dayofNum = tm.substr(12,1);
	        	var collecyoil;
	        	
	        	
	        	 for(var i = 0; i < 7; i++) {
	        	    	if(i == dayofNum) {
	        	    		collecyoil =dayOfKorean[i];
	        	    		break;
	        	    	}
	        	    }
	        	
//	        	$("#collecYear").html(collecYear);
	        	$("#collecMontn").html(collecMontn);
	        	$("#collecDay").html(collecDay);
	        	$("#collecHour").html(collecHour);
	        	$("#collecMin").html(collecMin);
	        	$("#collecyoil").html(collecyoil);
	        	
	        	for(var j = 1; j < weatherList.length; j++) {
	        		placeName[j-1] = weatherList[j].placeName;
	        		temp[j-1] = weatherList[j].temp;
	        		wfEn[j-1] = weatherList[j].wfEn;
	        		wfKor[j-1] = weatherList[j].wfKor;
	        	}
	        	
	        	/* <p> 태그 온도 표시 */
	        	/* 소정면, 전의면, 전동면, 조치원읍, 연서면, 연동면, 연기면, 부강면, 보람동, 금남면, 고운동, 아름동, 증종촌동, 새롬동, 한솔동, 도담동 */
	        	$("#p_sjm").text(temp[0] + "℃");
	        	$("#p_jwm").text(temp[1] + "℃");
	        	$("#p_jdm").text(temp[2] + "℃");
	        	$("#p_jcw").text(temp[3] + "℃");
	        	$("#p_ysm").text(temp[4] + "℃");
	        	$("#p_ydm").text(temp[5] + "℃");
	        	$("#p_ygm").text(temp[6] + "℃");
	        	$("#p_bgm").text(temp[7] + "℃");
	        	$("#p_brm").text(temp[8] + "℃");
	        	$("#p_gnm").text(temp[9] + "℃");
	        	$("#p_jgm").text(temp[10] + "℃");
	        	$("#p_gwd").text(temp[11] + "℃");
	        	$("#p_ard").text(temp[12] + "℃");
	        	$("#p_jcd").text(temp[13] + "℃");
	        	$("#p_srd").text(temp[14] + "℃");
	        	$("#p_hsd").text(temp[15] + "℃");
	        	$("#p_ddd").text(temp[16] + "℃");
	        	
	        	/* 대평동 */
	        	$("#p_dpd").text(temp[8] + "℃");
	        	/* 소담동 */
	        	$("#p_sdd").text(temp[8] + "℃");
	        	

	        	/* <img> 태그 날씨 이미지 넣기 */
	        	/* 소정면, 전의면, 전동면, 조치원읍, 연서면, 연동면, 연기면, 부강면, 보람동, 금남면, 고운동, 아름동, 종촌동, 새롬동, 한솔동, 도담동 */
	        	$("#img_sjm").attr("src", "images/contents/" + wfEn[0] + ".png");
	        	$("#img_jwm").attr("src", "images/contents/" + wfEn[1] + ".png");
	        	$("#img_jdm").attr("src", "images/contents/" + wfEn[2] + ".png");
	        	$("#img_jcw").attr("src", "images/contents/" + wfEn[3] + ".png");
	        	$("#img_ysm").attr("src", "images/contents/" + wfEn[4] + ".png");
	        	$("#img_ydm").attr("src", "images/contents/" + wfEn[5] + ".png");
	        	$("#img_ygm").attr("src", "images/contents/" + wfEn[6] + ".png");
	        	$("#img_bgm").attr("src", "images/contents/" + wfEn[7] + ".png");
	        	$("#img_brm").attr("src", "images/contents/" + wfEn[8] + ".png");
	        	$("#img_gnm").attr("src", "images/contents/" + wfEn[9] + ".png");
	        	$("#img_jgm").attr("src", "images/contents/" + wfEn[10] + ".png");
	        	$("#img_gwd").attr("src", "images/contents/" + wfEn[11] + ".png");
	        	$("#img_ard").attr("src", "images/contents/" + wfEn[12] + ".png");
	        	$("#img_jcd").attr("src", "images/contents/" + wfEn[13] + ".png");
	        	$("#img_srd").attr("src", "images/contents/" + wfEn[14] + ".png");
	        	$("#img_hsd").attr("src", "images/contents/" + wfEn[15] + ".png");
	        	$("#img_ddd").attr("src", "images/contents/" + wfEn[16] + ".png");
	        	
	        	/* 대평동 */
	        	$("#img_dpd").attr("src", "images/contents/" + wfEn[8] + ".png");
	        	/* 소담동*/
	        	$("#img_sdd").attr("src", "images/contents/" + wfEn[8] + ".png");

	        	/* <img> 태그 Title 넣기 */
	        	/* 소정면, 전의면, 전동면, 조치원읍, 연서면, 연동면, 연기면, 부강면, 보람동, 금남면, 고운동, 아름동, 종촌동, 새롬동, 한솔동, 도담동 */
	        	$("#img_sjm").attr("title", "소정면 날씨 : " + wfKor[0]);
	        	$("#img_jwm").attr("title", "전의면 날씨 : " + wfKor[1]);
	        	$("#img_jdm").attr("title", "전동면 날씨 : " + wfKor[2]);
	        	$("#img_jcw").attr("title", "조치원 날씨 : " + wfKor[3]);
	        	$("#img_ysm").attr("title", "연서면 날씨 : " + wfKor[4]);
	        	$("#img_ydm").attr("title", "연동면 날씨 : " + wfKor[5]);
	        	$("#img_ygm").attr("title", "연기면 날씨 : " + wfKor[6]);
	        	$("#img_bgm").attr("title", "부강면 날씨 : " + wfKor[7]);
	        	$("#img_brm").attr("title", "보람동 날씨 : " + wfKor[8]);
	        	$("#img_gnm").attr("title", "금남면 날씨 : " + wfKor[9]);
	        	$("#img_jgm").attr("title", "장군면 날씨 : " + wfKor[10]);
	        	$("#img_gwd").attr("title", "고운동 날씨 : " + wfKor[11]);
	        	$("#img_ard").attr("title", "아름동 날씨 : " + wfKor[12]);
	        	$("#img_jcd").attr("title", "종촌동 날씨 : " + wfKor[13]);
	        	$("#img_srd").attr("title", "새롬동 날씨 : " + wfKor[14]);
	        	$("#img_hsd").attr("title", "한솔동 날씨 : " + wfKor[15]);
	        	$("#img_ddd").attr("title", "도담동 날씨 : " + wfKor[16]);
	        	
	        	/* 대평동 */
	        	$("#img_dpd").attr("title", "대평동 날씨 : " + wfKor[8]);
	        	/* 소담동 */
	        	$("#img_sdd").attr("title", "소담동 날씨 : " + wfKor[8]);
	        	
		    },error: function(xhr, status, error) {
		    	alert('서버와의 통신 문제로 날씨 지도 정보를 가져오지 못했습니다. 잠시 후 다시 시도해 주세요.');
		    	alert("/getAirInfo.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    	console.log('[log] ----> weatherjido.js  . [에러] -> getXMLFileJido.do ');
		    }
		});
	} catch (e) {
		// TODO: handle exception
		console.log('[log] ----> weatherjido.js  . [예외] -> getXMLFileJido.do ');
	}
}

function weatherJidoStart(weathertList) {
	var _temp;
	var _item;
	
	var list = [];
	list = weathertList;
	
	var date = new Date();
	var placeName = [];
	var temp = [];
	var wfEn = [];
	var wfKor = [];
	var pop = [];
	var hour = [];
	var day = [];
	var dayofNum;
	var tm ;		// tm = 수집시간 정보 
	tm = list[0].tm;	// tm 수집시간 정보 ( YYYYMMDDHHMM 형태로 저장됨 . ex '201805041700' )
	var collecYear = tm.substr(0,4);
	var collecMontn = tm.substr(4,2);
	var collecDay = tm.substr(6,2);
	var collecHour = tm.substr(8,2);
	var collecMin = tm.substr(10,2);
	dayofNum = date.getDay();
	
	
	
	for(var j = 1; j < list.length; j++) {
		
		_item = list[j];
		
		placeName[j-1] = _item.placeName;
		temp[j-1] = _item.temp;
		if(_item.wfEn.indexOf("/") < 0){
			wfEn[j-1] = _item.wfEn;
		} else {
			wfEn[j-1] = _item.wfEn.replace("/", "");
		}
		wfKor[j-1] = _item.wfKor;
	}
	
	/* <p> 태그 온도 표시 */
	/* 소정면, 전의면, 전동면, 조치원읍, 연서면, 연동면, 연기면, 부강면, 보람동, 금남면, 고운동, 아름동, 종촌동, 새롬동, 한솔동, 도담동 */
	$("#p_sjm").text(temp[0] + " ℃");
	$("#p_jwm").text(temp[1] + " ℃");
	$("#p_jdm").text(temp[2] + " ℃");
	$("#p_jcw").text(temp[3] + " ℃");
	$("#p_ysm").text(temp[4] + " ℃");
	$("#p_ydm").text(temp[5] + " ℃");
	$("#p_ygm").text(temp[6] + " ℃");
	$("#p_bgm").text(temp[7] + " ℃");
	$("#p_brd").text(temp[8] + " ℃");
	$("#p_gnm").text(temp[9] + " ℃");
	$("#p_jgm").text(temp[10] + " ℃");
	$("#p_gwd").text(temp[11] + " ℃");
	$("#p_ard").text(temp[12] + " ℃");
	$("#p_jcd").text(temp[13] + " ℃");
	$("#p_srd").text(temp[14] + " ℃");
	$("#p_hsd").text(temp[15] + " ℃");
	$("#p_ddd").text(temp[16] + " ℃");
	/* 대평동 */	
	$("#p_dpd").text(temp[8] + " ℃");
	/* 소담동 */	
	$("#p_sdd").text(temp[8] + " ℃");

	/* <img> 태그 날씨 이미지 넣기 */
	/* 소정면, 전의면, 전동면, 조치원읍, 연서면, 연동면, 연기면, 부강면, 보람동, 금남면, 고운동, 아름동, 종촌동, 새롬동, 한솔동, 도담동 */
	$("#img_sjm").attr("src", "images/contents/" + wfEn[0] + ".png" );
	$("#img_jwm").attr("src", "images/contents/" + wfEn[1] + ".png" );
	$("#img_jdm").attr("src", "images/contents/" + wfEn[2] + ".png" );
	$("#img_jcw").attr("src", "images/contents/" + wfEn[3] + ".png" );
	$("#img_ysm").attr("src", "images/contents/" + wfEn[4] + ".png" );
	$("#img_ydm").attr("src", "images/contents/" + wfEn[5] + ".png" );
	$("#img_ygm").attr("src", "images/contents/" + wfEn[6] + ".png" );
	$("#img_bgm").attr("src", "images/contents/" + wfEn[7] + ".png" );
	$("#img_brd").attr("src", "images/contents/" + wfEn[8] + ".png" );
	$("#img_gnm").attr("src", "images/contents/" + wfEn[9] + ".png" );
	$("#img_jgm").attr("src", "images/contents/" + wfEn[10] + ".png");
	$("#img_gwd").attr("src", "images/contents/" + wfEn[11] + ".png");
	$("#img_ard").attr("src", "images/contents/" + wfEn[12] + ".png");
	$("#img_jcd").attr("src", "images/contents/" + wfEn[13] + ".png");
	$("#img_srd").attr("src", "images/contents/" + wfEn[14] + ".png");
	$("#img_hsd").attr("src", "images/contents/" + wfEn[15] + ".png");
	$("#img_ddd").attr("src", "images/contents/" + wfEn[16] + ".png");
	/* 대평동 */
	$("#img_dpd").attr("src", "images/contents/" + wfEn[8] + ".png" );
	/* 소담동 */
	$("#img_sdd").attr("src", "images/contents/" + wfEn[8] + ".png" );

	/* <img> 태그 Title 넣기 */
	/* 소정면, 전의면, 전동면, 조치원읍, 연서면, 연동면, 연기면, 부강면, 보람동, 금남면, 고운동, 아름동, 종촌동, 새롬동, 한솔동, 도담동 */
	$("#img_sjm").attr("title", "소정면 날씨 : " + wfKor[0] );
	$("#img_jwm").attr("title", "전의면 날씨 : " + wfKor[1] );
	$("#img_jdm").attr("title", "전동면 날씨 : " + wfKor[2] );
	$("#img_jcw").attr("title", "조치원 날씨 : " + wfKor[3] );
	$("#img_ysm").attr("title", "연서면 날씨 : " + wfKor[4] );
	$("#img_ydm").attr("title", "연동면 날씨 : " + wfKor[5] );
	$("#img_ygm").attr("title", "연기면 날씨 : " + wfKor[6] );
	$("#img_bgd").attr("title", "부강면 날씨 : " + wfKor[7] );
	$("#img_brd").attr("title", "보람동 날씨 : " + wfKor[8] );
	$("#img_gnm").attr("title", "금남면 날씨 : " + wfKor[9] );
	$("#img_jgm").attr("title", "장군면 날씨 : " + wfKor[10]);
	$("#img_gwd").attr("title", "고운동 날씨 : " + wfKor[11]);
	$("#img_ard").attr("title", "아름동 날씨 : " + wfKor[12]);
	$("#img_jcd").attr("title", "종촌동 날씨 : " + wfKor[13]);
	$("#img_srd").attr("title", "새롬동 날씨 : " + wfKor[14]);
	$("#img_hsd").attr("title", "한솔동 날씨 : " + wfKor[15]);
	$("#img_ddd").attr("title", "도담동 날씨 : " + wfKor[16]);
	/* 대평동 */
	$("#img_dpd").attr("title", "대평동 날씨 : " + wfKor[8] );
	/* 소담동 */
	$("#img_sdd").attr("title", "소담동 날씨 : " + wfKor[8] );
	
//	$tblTbody = '<tr><td>고운동</td><td>'+$("#p_gwd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[11] + ".png"+'" title="'+"고운동 날씨 : " + wfKor[11]+'"/></td></tr>';
//	$tblTbody += '<tr><td>아름동</td><td>'+$("#p_ard").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[12] + ".png"+'" title="'+"아름동 날씨 : " + wfKor[12]+'"/></td></tr>';
//	$tblTbody += '<tr><td>종촌동</td><td>'+$("#p_jcd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[13] + ".png"+'" title="'+"종촌동 날씨 : " + wfKor[13]+'"/></td></tr>';
//	$tblTbody += '<tr><td>새롬동</td><td>'+$("#p_srd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[14] + ".png"+'" title="'+"새롬동 날씨 : " + wfKor[14]+'"/></td></tr>';
//	$tblTbody += '<tr><td>한솔동</td><td>'+$("#p_hsd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[15] + ".png"+'" title="'+"한솔동 날씨 : " + wfKor[15]+'"/></td></tr>';
//	$tblTbody += '<tr><td>도담동</td><td>'+$("#p_ddd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[16] + ".png"+'" title="'+"도담동 날씨 : " + wfKor[16]+'"/></td></tr>';
//	$tblTbody += '<tr><td>보람동</td><td>'+$("#p_brd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[8] + ".png" +'" title="'+"보람동 날씨 : " + wfKor[8] +'"/></td></tr>';	
//	$tblTbody += '<tr><td>조치원읍</td><td>'+$("#p_jcw").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[3] + ".png" +'" title="'+"조치원 날씨 : " + wfKor[3] +'"/></td></tr>';	
//	$tblTbody += '<tr><td>소정면</td><td>'+$("#p_sjm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[0] + ".png" +'" title="'+"소정면 날씨 : " + wfKor[0] +'"/></td></tr>';
//	$tblTbody += '<tr><td>전의면</td><td>'+$("#p_jwm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[1] + ".png" +'" title="'+"전의면 날씨 : " + wfKor[1] +'"/></td></tr>';
//	$tblTbody += '<tr><td>전동면</td><td>'+$("#p_jdm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[2] + ".png" +'" title="'+"전동면 날씨 : " + wfKor[2] +'"/></td></tr>';
//	$tblTbody += '<tr><td>연서면</td><td>'+$("#p_ysm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[4] + ".png" +'" title="'+"연서면 날씨 : " + wfKor[4] +'"/></td></tr>';
//	$tblTbody += '<tr><td>연동면</td><td>'+$("#p_ydm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[5] + ".png" +'" title="'+"연동면 날씨 : " + wfKor[5] +'"/></td></tr>';
//	$tblTbody += '<tr><td>연기면</td><td>'+$("#p_ygm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[6] + ".png" +'" title="'+"연기면 날씨 : " + wfKor[6] +'"/></td></tr>';
//	$tblTbody += '<tr><td>부강면</td><td>'+$("#p_bgm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[7] + ".png" +'" title="'+"부강면 날씨 : " + wfKor[7] +'"/></td></tr>';
//	$tblTbody += '<tr><td>금남면</td><td>'+$("#p_gnm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[9] + ".png" +'" title="'+"금남면 날씨 : " + wfKor[9] +'"/></td></tr>';
//	$tblTbody += '<tr><td>장군면</td><td>'+$("#p_jgm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[10] + ".png"+'" title="'+"장군면 날씨 : " + wfKor[10]+'"/></td></tr>';
	
	
	$tblTbody = '<tr><td>조치원읍</td><td>'+$("#p_jcw").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[3] + ".png" +'" title="'+"조치원 날씨 : " + wfKor[3] +'"/></td></tr>';
	$tblTbody += '<tr><td>연기면</td><td>'+$("#p_ygm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[6] + ".png" +'" title="'+"연기면 날씨 : " + wfKor[6] +'"/></td></tr>';
	$tblTbody += '<tr><td>연동면</td><td>'+$("#p_ydm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[5] + ".png" +'" title="'+"연동면 날씨 : " + wfKor[5] +'"/></td></tr>';
	$tblTbody += '<tr><td>부강면</td><td>'+$("#p_bgm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[7] + ".png" +'" title="'+"부강면 날씨 : " + wfKor[7] +'"/></td></tr>';
	$tblTbody += '<tr><td>금남면</td><td>'+$("#p_gnm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[9] + ".png" +'" title="'+"금남면 날씨 : " + wfKor[9] +'"/></td></tr>';
	$tblTbody += '<tr><td>장군면</td><td>'+$("#p_jgm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[10] + ".png"+'" title="'+"장군면 날씨 : " + wfKor[10]+'"/></td></tr>';
	$tblTbody += '<tr><td>연서면</td><td>'+$("#p_ysm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[4] + ".png" +'" title="'+"연서면 날씨 : " + wfKor[4] +'"/></td></tr>';
	$tblTbody += '<tr><td>전의면</td><td>'+$("#p_jwm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[1] + ".png" +'" title="'+"전의면 날씨 : " + wfKor[1] +'"/></td></tr>';
	$tblTbody += '<tr><td>전동면</td><td>'+$("#p_jdm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[2] + ".png" +'" title="'+"전동면 날씨 : " + wfKor[2] +'"/></td></tr>';
	$tblTbody += '<tr><td>소정면</td><td>'+$("#p_sjm").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[0] + ".png" +'" title="'+"소정면 날씨 : " + wfKor[0] +'"/></td></tr>';
	$tblTbody += '<tr><td>한솔동</td><td>'+$("#p_hsd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[15] + ".png"+'" title="'+"한솔동 날씨 : " + wfKor[15]+'"/></td></tr>';
	$tblTbody += '<tr><td>도담동</td><td>'+$("#p_ddd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[16] + ".png"+'" title="'+"도담동 날씨 : " + wfKor[16]+'"/></td></tr>';
	$tblTbody += '<tr><td>아름동</td><td>'+$("#p_ard").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[12] + ".png"+'" title="'+"아름동 날씨 : " + wfKor[12]+'"/></td></tr>';
	$tblTbody += '<tr><td>종촌동</td><td>'+$("#p_jcd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[13] + ".png"+'" title="'+"종촌동 날씨 : " + wfKor[13]+'"/></td></tr>';
	$tblTbody += '<tr><td>고운동</td><td>'+$("#p_gwd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[11] + ".png"+'" title="'+"고운동 날씨 : " + wfKor[11]+'"/></td></tr>';
	$tblTbody += '<tr><td>보람동</td><td>'+$("#p_brd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[8] + ".png" +'" title="'+"보람동 날씨 : " + wfKor[8] +'"/></td></tr>';
	$tblTbody += '<tr><td>새롬동</td><td>'+$("#p_srd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[14] + ".png"+'" title="'+"새롬동 날씨 : " + wfKor[14]+'"/></td></tr>';
	/* 대평동 */
	$tblTbody += '<tr><td>대평동</td><td>'+$("#p_dpd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[8] + ".png"+'" title="'+"대평동 날씨 : " + wfKor[8]+'"/></td></tr>';
	/* 소담동 */
	$tblTbody += '<tr><td>소담동</td><td>'+$("#p_sdd").text()+'</td><td><img class="img_sjm01" src="'+"images/contents/" + wfEn[8] + ".png"+'" title="'+"소담동 날씨 : " + wfKor[8]+'"/></td></tr>';
	
//	alert($tblTbody);
	
	$("#tblTbody").append($tblTbody);
	
	
	
}