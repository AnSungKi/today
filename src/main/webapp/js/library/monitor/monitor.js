$(document).ready(function() {
	$("#contents2").css('display','none');
	$("#contents_wt").css('display','none');
	$("#contents_emp").css('display','none');
	$("#contents_unemp").css('display','none');
	$("#contents_population").css('display','none');
	
});


/** 마우스드레그로 이동 */
$( function() {
	$( "#sortable" ).sortable({
		revert: true
	});
	$( "#draggable" ).draggable({
		connectToSortable: "#sortable",
		helper: "clone",
		revert: "invalid"
	});
});
  
/** 클릭시 특정URL을 iframe에 적용*/
$( function() {
	console.log('[log] ----> monitor.js  .[1] function() ');
	// 자동새로고침 on/off
    $('.auto_replay .go_btn').click(function(){
        var isOff = $(this).hasClass('off');
        toggleInterval(isOff);
    });

    console.log('[log] ----> monitor.js  .[43] function() ');
	/*
	 *  홈선택시
	 */
	$("#home").click(function() {
		var $frms = $('<form></form>');
		$frms.attr("action", "http://www.sejong.go.kr/monitoring?user_id=" + hi_userId.value );
	    $frms.attr('method','post');
	    $(document.body).append($frms);
	    $frms.submit(); 
	});	
	console.log('[log] ----> monitor.js  .[44] function() ');
	
	/*
	 *  온라인시장실 클릭 이벤트
	 *  세종시 시민소통- 과제별 시민소통 페이지로 이동
	 */
	$("#sejongmayor").click(function() {
//		$("#popup iframe").attr("src", "http://www.sejong.go.kr/cop/bbs/BBSMSTR_000000000143/selectBoardList.do");
		$("#popup iframe").attr("src", "http://www.sejong.go.kr/mayor.do");
		popup();			  
	});
	console.log('[log] ----> monitor.js  .[4] function() ');
	/*
	 *  세종통계 클릭 이벤트
	 *  세종시 세종통계 페이지로 이동
	 */
	$("#sejongstat").click(function() {
		$("#popup iframe").attr("src", "http://www.sejong.go.kr/stat.do");
		popup();			  
	});
	console.log('[log] ----> monitor.js  .[5] function() ');
	/*
	 *  세종시 조직도 클릭 이벤트
	 *  세종시 조직도로 이동
	 */
	$("#sejongorganization").click(function() {
		$("#popup iframe").attr("src", "html/orgchart/organization.html");
		popup();			  
	});
	console.log('[log] ----> monitor.js  .[6] function() ');
	/*
	 *  청와대 일자리 현황판 클릭 이벤트
	 *  청와대 일자리 상황판으로 이동
	 */
	$("#bluehouse").click(function() {
		$("#popup iframe").attr("src", "https://www1.president.go.kr/c/job-status");
		popup();			  
	});
	console.log('[log] ----> monitor.js  .[7] function() ');
	/*
	 *  국가100대지표 클릭 이벤트
	 *  국가100대지표 페이지로 이동
	 */
	$("#kosis100").click(function() {
		$("#popup iframe").attr("src", "http://kosis.kr/conts/nsportalStats/nsportalStats_0101Body.jsp?menuId=all");
		popup();			  
	});	
	console.log('[log] ----> monitor.js  .[8] function() ');
	/*
	 *  시민투표 목록 페이지로 이동
	 */
	$("#citizenvote").click(function() {
		$("#contents").css('display','none');
		$("#contents2").css('display','block');
		$("#contents_wt").css('display','none');
		$("#contents_population").css('display','none');
		$("#wrap").removeClass("heightVariable");
		$("#wrap").removeClass("heightautoimportant");
		$("#wrap").addClass("height100important");
	});	
	console.log('[log] ----> monitor.js  .[9] function() ');
	/*
	 *  날씨나오기 목록 페이지로 이동
	 */
	$("#weatherdisplay").click(function() {
		$("#contents").css('display','none');
		$("#contents2").css('display','none');
		$("#contents_wt").css('display','block');
		$("#contents_population").css('display','none');
	});	
	console.log('[log] ----> monitor.js  .[10] function() ');
	/*
	 *  민원분석 페이지로 이동
	 */
	$("#minwonAnalysis").click(function() {
		$("#popup iframe").attr("src",  "minwonhtml/index.html");
		popup();			  
	});	
	console.log('[log] ----> monitor.js  .[11] function() ');
	/*
	 *  Search 버튼 클릭 이벤트
	 *  다음 소셜 검색으로 이동
	 */
	$("#daumsocial").click(function() {
//		popup();
		searchPopup();
		fn_popIframe();
	});
	console.log('[log] ----> monitor.js  .[12] function() ');
	/*
	 *  검색어 입력 후 Enter 키 입력 이벤트
	 *  다음 소셜 검색으로 이동
	 */
	$("#search_input").keydown(function(key) {
		if(key.keyCode == 13) {
//			popup();
			searchPopup();
			fn_popIframe();
		}
	});
	console.log('[log] ----> monitor.js  .[13] function() ');
	/*
	 *  시민의 소리 클릭 이벤트
	 *  시민의소리통합창구 페이지로 이동
	 */
	$("#sotongDetail").click(function() {
		$("#popup iframe").attr("src", "http://www.sejong.go.kr/opinion/index.do");
		popup();			  
	});	
	console.log('[log] ----> monitor.js  .[14] function() ');
	/*
	 *  시민의 소리 새로고침 클릭 이벤트
	 */
	$("#sotongRefresh").click(function() {
		fn_sotongMakeFile();
		
		$.ajaxSetup({ async:false });
		$.getJSON( "data/sotong.json", function( data ) {
			sotongList = data.item;
		});
		_sotongCursor = -1;
		sotongStart();
	});	
	console.log('[log] ----> monitor.js  .[15] function() ');
	/*
	 *  인구 현황판 클릭 이벤트
	 *  세종시청 인구 페이지로 이동
	 */
	$("#populationLink").click(function() {
		$("#contents2").css('display','none');
		$("#contents_wt").css('display','none');
		$("#contents").css('display','none');
		$("#contents_emp").css('display','none');
		$("#contents_unemp").css('display','none');
		$("#contents_population").css('display','block');
		
		try {
			$.ajax({
				url : G_CONTEXT_PATH + "/ntisp/totalCount.do"
				,method : "POST"
				,async : false
				,dataType : 'json'
				,success : function(res){
					console.log('[log] ----> monitor.js  .[16] function() ');
					var data = res.ntispTotalCount;
//					var totalSum = Number(data)+Number(4129);
					var totalSum = Number(data);
					$("#totalSum").animateNumbers(totalSum,true);
					$("#korTotal").html(setComma(data)+"명");
					$(".totalSumLayer").html(setComma(totalSum)+"명");
					$(".totalSumLayerG").html(setComma(totalSum));
					var per = Math.round((totalSum-284353)/284353*1000)/10;
					$(".totalSumLayerP").html(per+"%");
				}
			});
		} catch (e) {
			// TODO: handle exception
			console.log('[log] ----> monitor.js  .[17] function() ');
		}
		
		try {
			$.ajax({
				url : G_CONTEXT_PATH + "/ntisp/list.do"
				,method : "POST"
				,async : false
				,dataType : "json"
				,success : function(data){
					console.log('[log] ----> monitor.js  .[18] function() ');
					$.each(data.ntispList,function(index, obj){
						
						$("span[data-orgcode="+obj.admorgcode+"]").html(setComma(obj.totalcount));
					})
				}, error : function(error) {
			        alert("Error!" + error);
			        console.log('[log] ----> monitor.js  .[19] function() ');
			    },
			    complete : function() {
			    	
			    }

			})
		} catch (e) {
			// TODO: handle exception
			console.log('[log] ----> monitor.js  .[20] function() ');
		}
		
		function setComma(num){
			var str = "";
			
			if(typeof num == "number"){
				str = num+"";
			}else{
				str = num;
			}
			
			str = str.replace(/,/g,"");
			
			var reg = /(\d+)(\d{3})/;
			
			
			
			while(reg.test(str)){
				str = str.replace(reg,'$1'+','+'$2');
			}
			return str;
			
		}
	});
	
	/*
	 *  일자리현황판 고용률 클릭
	 *  세종시청 인구 페이지로 이동
	 */
	$("#employLink").click(function() {
		fn_topEmploy();
		fn_comboBoxEmploy();
		fn_getjobEmployTableList();
		
		$("#contents").css('display','none');
		$("#contents2").css('display','none');
		$("#contents_wt").css('display','none');
		$("#contents_emp").css('display','block');
		$("#contents_unemp").css('display','none');
		$("#contents_population").css('display','none');
		
		$("#wrap").removeClass("height100important");
		$("#wrap").addClass('heightautoimportant');
	});
	console.log('[log] ----> monitor.js  .[21] function() ');
	
	
	/*
	 *  일자리현황판 고용률 클릭
	 *  세종시청 인구 페이지로 이동
	 */
	$("#unemployLink").click(function() {
		fn_topUnemploy();
		fn_comboBoxUnemploy();
		fn_getUnEmpDatatableList();

		$("#contents").css('display','none');
		$("#contents2").css('display','none');
		$("#contents_wt").css('display','none');
		$("#contents_emp").css('display','none');
		$("#contents_unemp").css('display','block');
		$("#contents_population").css('display','none');
		
		$("#wrap").removeClass("height100important");
		$("#wrap").addClass('heightautoimportant');
	});
	console.log('[log] ----> monitor.js  .[22] function() ');
	

	/*
	 *  재정 현황판 클릭 이벤트
	 *  세종시청 재정정보공개 페이지로 이동
	 */
	$("#financeLink").click(function() {
		$("#popup iframe").attr("src", "http://www.sejong.go.kr/finance/");
		popup();			  
	});
	console.log('[log] ----> monitor.js  .[23] function() ');

	/*
	 *  오늘의 행사 클릭 이벤트
	 *  주간행사계획 페이지로 이동
	 */
	$("#eventDetail").click(function() {
		$("#popup iframe").attr("src", "http://www.sejong.go.kr/cop/bbs/BBSMSTR_000000000231/selectBoardList.do");
		popup();			  
	});
	console.log('[log] ----> monitor.js  .[24] function() ');


	/*
	 *  날씨 현황판 클릭 이벤트
	 *  기상청 페이지로 이동
	 */
	$("#weatherLink").click(function() {
		$("#contents").css('display','none');
		$("#contents2").css('display','none');
		$("#contents_population").css('display','none');
		$("#contents_wt").css('display','block');
		$("#wrap").removeClass("height100important");
		$("#wrap").addClass('heightVariable');
	});	 
	console.log('[log] ----> monitor.js  .[25] function() ');
	
	$(".pop-close").click(function(){
		$("#contents").css('display','block');
		$("#contents2").css('display','none');
		$("#contents_wt").css('display','none');
		$("#contents_emp").css('display','none');
		$("#contents_population").css('display','none');
		$("#wrap").css('height', '100%');
	})
	console.log('[log] ----> monitor.js  .[26] function() ');
	$(".wt-close").click(function(){
		$("#contents").css('display','block');
		$("#contents2").css('display','none');
		$("#contents_wt").css('display','none');
		$("#contents_population").css('display','none');
	})
	console.log('[log] ----> monitor.js  .[27] function() ');
	
	$("#callcenterOnOff").click(function() {
		$("#liCallcenterOnOff").attr("class", "on");
		$("#liSiminchangOnOff").attr("class", "");
		$("#sotong").css('display','none');
		$("#callcenter").css('display','');
		
		fn_csMakeFile();
		
		$.ajaxSetup({ async:false });
		$.getJSON( "data/cs.json", function( data ) {
			csList = data.item;
		});
		_csCursor = -1;
		csStart();
	});
	console.log('[log] ----> monitor.js  .[28] function() ');
	
	$("#siminchangOnOff").click(function() {
		$("#liCallcenterOnOff").attr("class", "");
		$("#liSiminchangOnOff").attr("class", "on");
		$("#sotong").css('display','');
		$("#callcenter").css('display','none');
		
		fn_sotongMakeFile();
		
		$.ajaxSetup({ async:false });
		$.getJSON( "data/sotong.json", function( data ) {
			sotongList = data.item;
		});
		_sotongCursor = -1;
		sotongStart();
	});
	console.log('[log] ----> monitor.js  .[29] function() ');
});

/* 텍스트애니메이션 플러그인 */
(function($){
    $.fn.animateNumbers = function(stop, commas, duration, ease) { 
        return this.each(function() {
            var $this = $(this);
            var start = Number($this.text().replace(/,/g,""));
			commas = (commas == undefined) ? true : commas;
            $({value: start}).animate({value: stop}, {
            	duration: duration == undefined ? 1000 : duration, 
            	easing: ease == undefined ? "swing" : ease,
            	step: function(){
					if(commas == true){
						$this.text(Math.floor(this.value).toLocaleString().split(".")[0]);
					}else{
						$this.text(Math.floor(this.value));
					}
            	},
            	complete: function(){
					if(Number($this.text()) != Number(stop)){
						if(commas == true){
							$this.text(Math.floor(Number(stop)).toLocaleString().split(".")[0]);
						}else{
							$this.text(Math.floor(Number(stop)));
						}
					}
            	}
            });
        });
    };
})(jQuery);

/** 내부팝업보이기 */
function popup() {
	$('#iframeLoading').show();
	$('#popup').bPopup({
		easing: 'easeOutBack',
		speed: 650,
		transition: 'slideDown',
      	transitionClose: 'slideDown'
	});
}
/** 검색팝업보이기*/
function searchPopup() {
	$('#iframeLoading').show();
	$('#searchPopup').bPopup({
		easing: 'easeOutBack',
		speed: 650,
		transition: 'slideDown',
      	transitionClose: 'slideBack'
	});
}

// 인구현황판 클릭시 세종시청 홈페이지에서 function을 실행 시켜야해서 따로 빼줌
function popup_population() {
	$('#iframeLoading').show();
	$('#vote-container').bPopup({
		easing: 'easeOutBack',
		speed: 650,
		transition: 'slideDown',
		transitionClose: 'slideBack'
	});
}

function fn_popIframe() {
	var $frms = $('<form></form>');
	$frms.attr("action", "http://www.sejong.go.kr/opinion/voc/sns.do");
    $frms.attr('method','post');
    $frms.attr('target','snsPopIframe');    
    $frms.append('<input type="hidden" name="searchWrd" value="'+$('#search_input').val()+'"/>');
    $(document.body).append($frms);
    $frms.submit(); 
    
    $frms.attr("action", "http://www.sejong.go.kr/opinion/voc/cs.do");
    $frms.attr('target','csPopIframe');
    $frms.submit(); 
    
} 

function loaded() {
	$('#iframeLoading').hide();
}

function searchLoaded(){
	$('#searchIframeLoading').hide();
}

/** 목록 스클롤 */

var intervalTime = 6000;
var intervalTimeSotongJsong = 1000 * 60 * 5; // (1000 * 1분 * 5분)
var intervalTimeWeather = 1000 * 60 * 30; // (1000 * 1분 * 30분)
var intervalTimePop = 1000 * 60 * 60; // (1000 * 1분 * 30분)
var intervalTimeAll = 1000 * 60 * 10; // (1000 * 1분 * 10분)
var graphNum = 0;
var sotongList;
var sotongIndex = -1;
var eventList;
var eventIndex = -1;
var csList;
var csIndex = -1;
var sulmunList;
var sulmunIndex = -1;
var weathertList;
var weatherKSCList;
//var interval = null;
$(window).load(function() {
	
	setInterval("AllRefresh()", intervalTimeAll);
	
	/*
	 * 시민소통 JSON data 파일 생성 함수 호출
	 */
	fn_sotongMakeFile();
	console.log('[log] ----> monitor.js  .[30] function() ');
	setInterval("fn_sotongMakeFile()", intervalTimeSotongJsong);
	
	fn_eventMakeFile();
	console.log('[log] ----> monitor.js  .[31] function() ');
	setInterval("fn_eventMakeFile()", intervalTimeSotongJsong);

//	fn_csMakeFile();
//	setInterval("fn_csMakeFile()", intervalTimeSotongJsong);
	
	$.ajaxSetup({ async:false });
	try {
		$.ajax({
	        url: G_CONTEXT_PATH + '/getSotongFileData.do',
	        type: "POST",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {
	        	console.log('[log] ----> monitor.js  .[32] function() ');
	        	sotongList = res.item;
	        	sotongStart();
	        	setInterval("sotongStart()", intervalTime);
		    },
		    error: function(xhr, status, error) {
		    	console.log('[log] ----> monitor.js  .[33] function() ');
		    	alert('서버와의 통신 문제로 시민의 소리 정보를 가져오지 못했습니다. 잠시 후 다시 시도해 주세요.');
		    }
		});
	} catch (e) {
		// TODO: handle exception
		console.log('[log] ----> monitor.js  .[34] function() ');
	}

	try {
		$.ajax({
	        url: G_CONTEXT_PATH + '/getEventFileData.do',
	        type: "POST",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {
	        	console.log('[log] ----> monitor.js  .[35] function() ');
	        	eventList = res.item;
	        	eventStart();
	        	setInterval("eventStart()", intervalTime);
		    },
		    error: function(xhr, status, error) {
		    	console.log('[log] ----> monitor.js  .[36] function() ');
		    	alert('서버와의 통신 문제로 행사 정보를 가져오지 못했습니다. 잠시 후 다시 시도해 주세요.');
		    }
		});
	} catch (e) {
		// TODO: handle exception
		console.log('[log] ----> monitor.js  .[37] function() ');
	}	

//	try {
//		$.ajax({
//			url: G_CONTEXT_PATH + '/getCsFileData.do',
//			type: "POST",
//			dataType: "JSON",
//			async: false,
//			success: function(res) {
//				console.log("getCsFileData Success");
//				csList = res.item;
//				//ajax 성공적으로 타고 왔을시 csStart 시작 
//				csStart();
//				setInterval("csStart()", intervalTime);
//			},
//			error: function(xhr, status, error) {
//				alert('서버와의 통신 문제로 콜센터 정보를 가져오지 못했습니다. 잠시 후 다시 시도해 주세요.');
//			}
//		});
//	} catch (e) {
//		// TODO: handle exception
//	}
	
//	인구현황판 인구 Select
	populationLoad();
	setInterval("populationLoad()", intervalTimePop);
//	인구현황판 날짜 구하기
	fn_getPopToday();
//	미세먼조 구하는 함수
	airInfoLoad();
//	재정 현황판 함수
//	financeLoad();
//	메인화면 상단 오늘날짜 함수
	fn_getToday();
	
	weatherJidoMain();
	
	try {
		$.ajax({
	        type: "POST",
	        url:  G_CONTEXT_PATH + "/getSearchJobMonitorData.do",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {
	        	console.log('[log] ----> monitor.js  .[38] function() ');
	            $.each(res.monitorData, function(inx, obj) {
	            	$("#stEmpSejong").text(obj.employSejong);
	            	$("#stEmpTotal").text(obj.employTotal);

	            	if(obj.employSejong > obj.employTotal){
	            		$("#pEmp").attr("class", "up");
	            		$("#pEmp").html("<span>" + Number(obj.employSejong - obj.employTotal).toFixed(1) + "<em>%</em></span>");
	            	} else if(obj.employSejong < obj.employTotal) {
	            		$("#pEmp").attr("class", "down");
	            		$("#pEmp").html("<span>" + Number(obj.employTotal - obj.employSejong).toFixed(1) + "<em>%</em></span>");
	            	} else {
	            		$("#pEmp").text("-");
	            	}

	            	$("#stUnempSejong").text(obj.unemploySejong);
	            	$("#stUnempTotal").text(obj.unemployTotal);
	            	
	            	if(obj.unemploySejong > obj.unemployTotal){
	            		$("#pUnemp").attr("class", "up");
	            		$("#pUnemp").html("<span>" + Number(obj.unemploySejong - obj.unemployTotal).toFixed(1) + "<em>%</em></span>");
	            	} else if(obj.unemploySejong < obj.unemployTotal) {
	            		$("#pUnemp").attr("class", "down");
	            		$("#pUnemp").html("<span>" + Number(obj.unemployTotal - obj.unemploySejong).toFixed(1) + "<em>%</em></span>");
	            	} else {
	            		$("#pUnemp").text("-");
	            	}
	            });
	        },error:function(request,status,error){
	            alert("/getSearchJobMonitorData.do   code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            console.log('[log] ----> monitor.js  .[39] function() ');
	           }
	    });
	} catch (e) {
		// TODO: handle exception
	}
	
//	오늘 날씨 구하는 함수
	weatherLoad();
	setInterval("weatherLoad()", intervalTimeWeather);
	
	try {
		$.ajax({
	        url: G_CONTEXT_PATH + '/getWeatherFileData.do',
	        type: "POST",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {
	        	console.log('[log] ----> monitor.js  .[40] function() ');
	        	console.log("getWeatherFileData Success");
	        	weathertList = res.item;
	        	weatherKSCList = res.itemKSC;
		    },
		    error: function(xhr, status, error) {
		    	alert('서버와의 통신 문제로 날씨 정보를 가져오지 못했습니다. 잠시 후 다시 시도해 주세요.');
		    	console.log('[log] ----> monitor.js  .[41] function() ');
		    }
		});
	} catch (e) {
		// TODO: handle exception
		console.log('[log] ----> monitor.js  .[42] function() ');
	}
	
	weatherStart();
	setInterval("weatherStart()", intervalTimeWeather);
	
	var nowDate = new Date();
	var yesterday = nowDate.getTime() - (24*60*60*1000);
	nowDate.setTime(yesterday);
	var year = nowDate.getFullYear();
	var month =  nowDate.getMonth()+1;
	var day = nowDate.getDate();
	var dt = year +"년 " +month+"월 "+day+"일";

	$(".yesterday").append(dt);
	$("#totalSum2").animateNumbers("35",false);
	$("#totalSum3").animateNumbers("0",false);
	
//	auto_replay_AC();
});


var _sotongCursor = -1;
function sotongStart() {
	if(sotongList != null) {
		var list = $("#sotong ul li");
		var _temp;	
		var _item;
		var _sns;
	
		_sotongCursor = _sotongCursor + 1;
		if(_sotongCursor == sotongList.length) _sotongCursor = 0;
		
		sotongIndex = _sotongCursor;
	
		$.each(list, function(index, item) {
			if(index < sotongList.length) {
				_item = sotongList[sotongIndex];
				if(_item != null) {
					if(_item.sns == "kakao"){
						_sns = "ico3";
					} else if(_item.sns == "band") {
						_sns = "ico5";
					} else if(_item.sns == "twitter") {
						_sns = "ico4";
					} else if(_item.sns == "facebook") {
						_sns = "ico1";
					} else if(_item.sns == "instagram") {
						_sns = "ico2";
					} else if(_item.sns == "blog") {
						_sns = "ico6";
					} else if(_item.sns == "sub06_02") {
						_sns = "ico7";
					}
					_temp = "<p class='txt'>" + _item.msg +"</p>"
						  + "<p class='date'>" + _item.date + "</p>";
					$(list[index]).attr("class", _sns);
	
					_sns="";
				} else {
					_temp = "";
				}
				$(list[index]).html(_temp);
				if(sotongIndex+1 == sotongList.length) {
					sotongIndex = 0;
				} else {
					sotongIndex = sotongIndex + 1;
				}
	 		}
		});
	}
}

var _eventCursor = -1;
function eventStart() {
	var list = $("#event ul li");
	var _temp;
	var _item;

	_eventCursor = _eventCursor + 1;
	if(_eventCursor == eventList.length) _eventCursor = 0;
	eventIndex = _eventCursor;
	
	$.each(list, function(index, item) {
		if(index < eventList.length) {
			_item = eventList[eventIndex];
			if(_item != null) {
				_temp = "<p class='cal'><span class='month'>" + _item.date + "</span><span class='time'>" + _item.time + "</span></p>"
				_temp = "<p class='cal'></span><span class='time'>" + _item.time + "</span></p>"
					  + "<p class='posi'>" + _item.place + "</p>"
					  + "<p class='txt'>" + _item.msg + "</p>"
					  + "<p class='depart'>" + _item.dept + "</p>";
			} else {
				_temp = "";
			}
			$(list[index]).html(_temp);
			if(eventIndex+1 == eventList.length) {
				eventIndex = 0;
			} else {
				eventIndex = eventIndex + 1;
			}
 		}
	});
}

var _csCursor = -1;
function csStart() {
	var list = $("#callcenter ul li");
	var _temp;
	var _item;
	var _sns;

	_csCursor = _csCursor + 1;
	if(_csCursor == csList.length) _csCursor = 0;
	csIndex = _csCursor;

	$.each(list, function(index, item) {
		if(index < csList.length) {
			_item = csList[csIndex];
			if(_item != null) {
//				여기서부터
//				src/main/webapp/css/contents.css 47 ~ 65라인에서 class 명에 따라 이미지 바꿔주는 역할입니다.
//				행정업무/ 일반정보 등 제목 바꿔주는곳
				if(_item.questionTypeSeq == "1"){  //행정업무(Default)
					_typeSeq = "btns color_01";
				} else if(_item.questionTypeSeq == "2") {  // 일반정보(1차상담)
					_typeSeq = "btns color_02";
				} else if(_item.questionTypeSeq == "3") {  // 관광,행사(1차상담-1)
					_typeSeq = "btns color_03";
				} else if(_item.questionTypeSeq == "4") {  // 대중교통(1차상담-2)
					_typeSeq = "btns color_04";
				} else if(_item.questionTypeSeq == "5") {  // 불편신고(접수)
					_typeSeq = "btns color_05";
				} else if(_item.questionTypeSeq == "6") {  // 단순연결(voc)
					_typeSeq = "btns color_06";
				} else if(_item.questionTypeSeq == "7") {  // 기타(etc)
					_typeSeq = "btns color_07";
				} else if(_item.questionTypeSeq == "8") {  // out(OUT)
					_typeSeq = "btns color_08";
				}
				_temp = "<p class='txt'>" + _item.questionContent +"</p>"
					  + "<p class='date'>" + _item.questionRegDate + "</p>";
				$(list[index]).attr("class", _typeSeq);

				_sns="";
			} else {
				_temp = "";
			}
			$(list[index]).html(_temp);
			if(csIndex+1 == csList.length) {
				csIndex = 0;
			} else {
				csIndex = csIndex + 1;
			}
 		}
	});
}

/*
 *  숫자 3자리마다 (,) 찍는 함수
 */
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function fn_sotongMakeFile() {
	try {
		$.ajax({
	        type: "POST",
	        url: G_CONTEXT_PATH + "/getMakeSotongJsonFile.do",
	        async: false,
	        success: function(res) {
	        	console.log("success");
	        }
	    });
	} catch (e) {
		// TODO: handle exception
	}
}

function fn_eventMakeFile() {
	try {
		$.ajax({
			type: "POST",
			url: G_CONTEXT_PATH + "/getMakeEventJsonFile.do",
			async: false,
			success: function(res) {
				console.log("success");
			}
		});
	} catch (e) {
		// TODO: handle exception
	}
}

function fn_csMakeFile() {
	try {
		$.ajax({
			type: "POST",
			url: G_CONTEXT_PATH + "/getMakeCsJsonFile.do",
			async: false,
			success: function(res) {
				console.log("CS success");
			}
		});
	} catch (e) {
		// TODO: handle exception
	}
}

/* 타이틀 년/월/일/요일 구하는 함수 */
function fn_getToday() {
	var date;
	var year;
	var month;
	var day;
	var yoil;
	var dayOfNumber;
	var dateResult;
	var dateResult2;
	var dayOfKorean = ["일", "월", "화", "수", "목", "금", "토"];
	
	date = new Date()
	date.setDate(date.getDate());
		
	year = date.getFullYear();
	month = date.getMonth()+1;
	day = date.getDate();
	dayOfNumber = date.getDay();
		
    /* example
     * 9시 -> 09시 변경 필요
     */
	    
    if(month[i] < 10) {
        month[i] = '0' + month[i];
    }    
    if(day[i] < 10) {
        day[i] = '0' + day[i];
    } 
    
    for(var i = 0; i < 7; i++) {
    	if(i == dayOfNumber) {
    		yoil = dayOfKorean[i];
    	}
    }
 
    dateResult = year + "년 " + month + "월 " + day + "일 (" + yoil + ")";
    dateResult2 = "(" + year + ". " + month + ". " + day + ")";
    
    $("#span_dateInput").text(dateResult);
    $("#eventTitle").text("오늘의 행사 " + dateResult2);
}

/* 인구현황판 년/월/일 구하는 함수 */
function fn_getPopToday() {
	var date;
	var year;
	var month;
	var day;
	var yoil;
	var dayOfNumber;
	var dateResult;
	var dayOfKorean = ["일", "월", "화", "수", "목", "금", "토"];
	
	date = new Date()
	date.setDate(date.getDate()-1);
		
	year = date.getFullYear();
	month = date.getMonth()+1;
	day = date.getDate();
	dayOfNumber = date.getDay();
		
    /* example
     * 9시 -> 09시 변경 필요
     */
	    
    if(month[i] < 10) {
        month[i] = '0' + month[i];
    }    
    if(day[i] < 10) {
        day[i] = '0' + day[i];
    } 
    
    for(var i = 0; i < 7; i++) {
    	if(i == dayOfNumber) {
    		yoil = dayOfKorean[i];
    	}
    }
 
    dateResult = year + "년 " + month + "월 " + day + "일";
    
    $("#sapn_popDate").text(dateResult + " 기준");
}

function weatherStart() {
	var list = $("#event ul li");
	var _temp;
	var _item;
	
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

	_item = weathertList[17];		//도담동의 정보를 가져와야함. weathertList[17]의 정보가 도담동(ddd) 정보.
	_itemKSC = weatherKSCList[0];	//메인에 강수확률 정보를 표시하기 위해 기상청의 날씨정보를 받아옴. 동네예보(초단기예보) 에는 강수확률 정보가 없음.
	
	var tmpWfEn;
	if(_item.wfEn.indexOf("/") > 0){
		tmpWfEn = _item.wfEn.replace("/", "");
	} else {
		tmpWfEn = _item.wfEn;
	}
	
	if(_item != null) {
		$("#span_weatherTodayDate").text(dateResult);
    	
    	$("#span_weatherTodayTemp").html(_item.temp + "<em>℃</em>");
    	$("#img_weatherTodayImg").attr("src", "images/contents/" + tmpWfEn + ".png");
    	$("#liPop").text("강수확률 " + _itemKSC.pop + " %");
    	$("#spanWfKor").text(_item.wfKor);
	} else {
		_temp = "";
	}
}
function AllRefresh() {
	window.location.reload();
}