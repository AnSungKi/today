<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%>
<%--<%
//로그인 정보
String user_id = session.getAttribute("user_id");
if(user_id != null) {
	request.setAttribute("user_id",user_id);
	String sessUserId = "";
	try {
		sessUserId =user_id;
		request.setAttribute("sessUserId",sessUserId);
		System.out.pringln("세션적용 완료");
		System.out.pringln(session.getAttribute("user_id").toString());
	}
	catch(Exception e) {
		System.out.println("예외 상황 발생");
		sessUserId ="";
	}
}
%>--%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=1920,maximum-scale=2.0,user-scalable=yes" />
<meta name="format-detection" content="telephone=no,email=no,address=no" />
<meta name="title" content="오늘의 세종" />
<meta name="keywords" content="오늘의 세종" />
<meta name="description" content="사이트 설명" />
<meta name="copyright"
	content="Copyright ⓒ 2017 세종특별자치시. All Rights Reserved." />
<title>오늘의 세종</title>
<link rel="shortcut icon" type="image/x-icon"
	href="images/common/favicon.ico" />
<link rel="apple-touch-icon" href="images/common/favicon.png" />
<link rel="stylesheet"
	href="js/plug/custom-scrollbar-plugin/jquery.mCustomScrollbar.css"
	media="all" />
<link rel="stylesheet" href="css/quick/quick_main.css" media="all" />
<!-- <link rel="stylesheet" href="css/quick/quick.css" media="all" /> -->
<!-- <link rel="stylesheet" href="css/quick/map.css" media="all" /> -->
<link rel="stylesheet" href="css/common.css" media="all" />
<link rel="stylesheet" href="css/layout.css" media="all" />
<link rel="stylesheet" href="css/contents.css" media="all" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script
	src="js/plug/custom-scrollbar-plugin/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="js/common.js"></script>
<!-- Jquery ui, bpopup-->
<script src="./js/library/jquery-ui/jquery-ui.min.js"></script>
<script src="./js/library/bpopup/jquery-bpopup.min.js"></script>
<!-- 데이터셋팅 -->
<script src="./js/library/monitor/monitor.js"></script>
<!-- 날씨정보 js -->
<script src="./js/library/weather/weather.js"></script>
<!-- 매뉴얼 정보 -->
<script src="./js/library/manual/manual.js"></script>
<!-- 인구정보 js -->
<script src="./js/library/population/population.js"></script>
<!-- 재정정보 js -->
<script src="./js/library/finance/finance.js"></script>
<script type="text/javascript">
	var G_CONTEXT_PATH = "${pageContext.request.contextPath}";
</script>
<!-- 차트부분 js -->
<script src="js/library/chart/dist/Chart.js"></script>
<script src="js/library/chart/samples/utils.js"></script>
<script src="js/library/job/jobUnEmploy.js"></script>
<script src="js/library/job/jobEmploy.js"></script>
<!-- 날씨부분 js -->
<!-- <link rel="stylesheet" type="text/css" href="http://www.sejong.go.kr/css/common/common.css" media="all" /> -->
<link rel="stylesheet" type="text/css" href="css/weather.css"
	media="all" />
<script src="js/library/weather/weatherjido.js"></script>
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
	<script src="js/respond.min.js"></script> 
<![endif]-->
</head>
<c:set var="userId" value="${user_id}"/>
<c:set var="userName" value="${user_name}"/>
<c:set var="deptName" value="${dept_name}"/>
<c:set var="deptCd" value="${dept_cd}"/>

<body>
	<input type="hidden" id="hi_userId" name="hi_userId" value="${user_id}">
	<!-- iframe Popup -->
	<div id="popup">
		<span class="b-close">닫기<i class="fa fa-times"
			aria-hidden="true"></i></span>
		<iframe id="popIframe" name="popIframe" onload="loaded();"
			allowfullscreen></iframe>
<!-- 			<img class="main-loader" id="iframeLoading" alt="로딩중입니다...." -->
<!-- 			src="images/loader.gif"> -->
	</div>
	<!-- //iframe Popup -->
	<!-- iframe Popup2 : 검색 팝업 -->
	<div id="searchPopup">
		<span class="b-close" style="margin-top: 34.4px;">닫기<i
			class="fa fa-times" aria-hidden="true"></i></span>
		<div>
			<iframe id="snsPopIframe" name="snsPopIframe"
				onload="searchLoaded();" allowfullscreen></iframe>
		</div>
		<div style="margin-left: 50%;">
			<iframe id="csPopIframe" name="csPopIframe" onload="searchLoaded();"
				allowfullscreen></iframe>
		</div>
		<img class="main-loader" id="searchIframeLoading" alt="로딩중입니다...."
			src="images/loader.gif">
	</div>
	<!-- skip :S -->
	<div id="skip">
		<strong class="hidden">반복영역 건너뛰기</strong>
		<ul>
			<li><a href="#contents">본문 바로가기</a></li>
			<li><a href="#lnb">주메뉴 바로가기</a></li>
		</ul>
	</div>
	<!-- skip :E -->
	<div id="wrap" class="height100important">
		<!-- Header :S -->
		<div id="header">
			<h1 class="logo">
				<img src="images/common/logo.png" alt="오늘의 세종" />
			</h1>
			<dl class="today">
				<dt>TODAY</dt>
				<dd id="span_dateInput">
<!-- 				2018년 1월 4일(목) -->
				</dd>
			</dl>
			<div class="search">
				<fieldset>
					<legend>통합검색</legend>
					<label for="search_input" class="hidden">검색어 입력</label> <input
						type="text" name="search_input" id="search_input"
						placeholder="검색어를 입력하세요." /> <input type="submit" id="daumsocial"
						value="검색" />
				</fieldset>
			</div>
		</div>
		<!-- Header :E -->
		<!-- Container :S -->
		<div id="container">
			<!-- Lnb :S -->
			<div id="lnb">
				<h2 class="hidden">메뉴</h2>
				<ul>
					<li class="menu_00"><a href="#" id="home" class="active"><span>HOME</span></a></li>
					<li class="menu_01"><a href="#" id="sejongmayor"><span>온라인시장실</span></a></li>
					<li class="menu_02"><a href="#" id="sejongstat"><span>세종통계</span></a></li>
					<!-- <li class="menu_03"><a href="#" id="bluehouse"><span>청와대일자리현황판</span></a></li> -->
					<li class="menu_04"><a href="#" id="kosis100"><span>국가100대지표</span></a></li>
					<li class="menu_05"><a href="#" id="citizenvote"><span>시민투표</span></a></li>
					<!-- 			<li class="menu_06"><a href="#" id="minwonAnalysis"><span>민원분석</span></a></li> -->
				</ul>
				<a href="#" class="lnb_btn"><span>메뉴열기</span></a>
				<!-- Footer :S -->
				<div id="footer">
					<p>
						Copyright ⓒ 2017 세종특별자치시. <br /> All Rights Reserved.
					</p>
				</div>
				<!-- Footer :E -->
			</div>
			<!-- Lnb :E -->
			<!-- Contents1 :S -->
			<div id="contents">
				<div class="slogon">
					<p>
						<span>시민과 소통하는 </span><strong><span>오늘의 세종</span>입니다.</strong>
					</p>
				</div>
				<div class="box">
					<div class="sns">
						<div class="mar">
							<h3>시민의 소리</h3>
							<!-- 탭메뉴 스크립트로 온오프 처리해야함  -->
							<div class="tab">
								<ul id="range_selector">
									<!-- 									<li class="on" name="callcenterOnOff"><a href="#">콜센터</a></li> -->
									<!-- 									<li class="" name="siminchangOnOff"><a href="#">시민의 창</a></li> -->
									<li class="on" id="liCallcenterOnOff"><a href="#"
										id="callcenterOnOff">콜센터</a></li>
									<li class="" id="liSiminchangOnOff"><a href="#"
										id="siminchangOnOff">시민의 창</a></li>
								</ul>
							</div>
							<div class="list scroll" id="sotong" style="display: none;">
								<ul>
									<li id="one"></li>
									<li id="two"></li>
									<li id="three"></li>
									<li id="four"></li>
									<li id="five"></li>
								</ul>
							</div>
							<div class="list scroll02" id="callcenter">
								<ul>
									<li id="one"></li>
									<li id="two"></li>
									<li id="three"></li>
									<li id="four"></li>
									<li id="five"></li>
								</ul>
							</div>
							<script>
								// 클릭 이벤트
								// 						    function rangeClick(seq, type, amount){
								// 						        $("#range_selector li").removeClass("on");
								// 						        $("#range_selector li:nth-child("+seq+")").addClass("on");
								// 						    }
							</script>
							<a href="#" class="link_btn" id="sotongDetail">바로가기</a>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="weather">
						<div class="mar">
							<h3>날씨</h3>
							<a href="#" class="go_btn" id="weatherLink"><span>바로가기</span></a>
							<div class="cont">
								<div class="elem">
									<div class="detail">
										<span class="icon"><img
											src="images/contents/weather_ico.png" alt="loading"
											id="img_weatherTodayImg" /></span>
										<p class="temp" id="span_weatherTodayTemp">
<!-- 											20<em>℃</em> -->
										</p>
										<!-- 									<p class="add"><strong>세종시</strong><span id="spanWfKor">비옴</span></p> -->
										<p class="add">
											<span id="spanWfKor">
<!-- 											비옴 -->
											</span>
										</p>
									</div>
									<ul class="etc_infor">
										<li class="ico1" id="liPop">
<!-- 										강수확률 10 % -->
										</li>
										<li class="ico2" id="liAirinfo">
<!-- 										미세먼지 나쁨 -->
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="schedule">
						<div class="mar">
							<h3>행사</h3>
							<a href="#" class="go_btn" id="eventDetail"><span>바로가기</span></a>
							<div class="list scroll" id="event">
								<ul>
									<li></li>
									<li></li>
									<li></li>
									<li></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="box">
					<div class="population">
						<div class="mar">
							<h3>인구</h3>
							<a href="#" class="go_btn" id="populationLink"><span>바로가기</span></a>
							<div class="cont">
								<div class="elem">
									<div class="state">
										<p class="member">
											<span style="visibility: hidden;">세종시 총 인구</span><strong
												id="sapn_popNumber">
<!-- 												284,353<em>명</em> -->
												</strong>
										</p>
										<p class="date" id="sapn_popDate" style="visibility: hidden;">2018년
											1월 1일 기준</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="finance">
						<div class="mar">
							<h3>재정</h3>
							<a href="#" class="go_btn" id="financeLink"><span>바로가기</span></a>
							<div class="cont">
								<div class="elem">
									<ul>
										<li>
											<p class="money">
												<span>수입</span><strong id="span_inputSil">
<!-- 												00,000<em>억원</em> -->
												</strong>
											</p>
											<p class="percent" id="span_inputPer">
<!-- 											(000.00%) -->
											</p>
										</li>
										<li>
											<p class="money">
												<span>지출</span><strong id="span_outputSil">
<!-- 												00,000<em>억원</em> -->
												</strong>
											</p>
											<p class="percent" id="span_outputPer">
<!-- 											(00.00%) -->
											</p>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="job">
						<div class="mar">
							<h3>일자리</h3>
							<div class="cont">
								<div class="elem">
									<ul>
										<li><a href="#" id="employLink">고용률(15~64세)</a>
											<ul>
												<li>세종 <strong id="stEmpSejong">
<!-- 												80.3 -->
												</strong>%
												</li>
												<li>전국 <em id="stEmpTotal">
<!-- 												70.2 -->
												</em>%
												</li>
											</ul>
											<p class="up" id="pEmp">
												<span>
<!-- 												10<em>%</em> -->
												</span>
											</p></li>
										<li><a href="#" id="unemployLink">실업률</a>
											<ul>
												<li>세종 <strong id="stUnempSejong">
<!-- 												2.0 -->
												</strong>%
												</li>
												<li>전국 <em id="stUnempTotal">
<!-- 												1.5 -->
												</em>%
												</li>
											</ul>
											<p class="down" id="pUnemp">
												<span>
<!-- 												5<em>%</em> -->
												</span>
											</p></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Contents1 :E -->
			<!-- Contents2 :S -->
			<div id="contents2">
				<div class="slogon">
					<p>
						<span>시민과 소통하는 </span><strong><span>세종의 뜻</span>입니다.</strong>
					</p>
				</div>
				<div class="box">
					<div class="vote">
						<div class="mar">
							<h3>모바일 투표</h3>
							<a href="#" class="link_btn" onclick="go_manual('mobile');">매뉴얼</a>
<!-- 							<a href="#" class="link_btn">매뉴얼</a> -->
							<div class="cont01">
								<div class="vote al_center">
									<img src="images/vote/vote_phone.png" alt="모바일투표">
									
									<ul>
										<li class="box02"><a
											href="https://www.sejong.go.kr/vote/portal/index.do"
											target="_blank" class="link_btn03"><span>투표참여</span></a></li>
										<li class="box02"><a
											href="http://www.sejong.go.kr/vote/sys/login.do?user_id=${user_id}&amp;returnUrl=/sys/vote/prog/index.do"
											target="_blank" class="link_btn03"><span>투표신청</span></a></li>
										<c:if test="${userId eq 'ad5f2a7662b95e771af051269c8dcd77' || userId eq '194db5451dfea84361b3a8ed272bef36'}">	
											<li class="box02"><a
												href="http://www.sejong.go.kr/vote/sys/login.do?user_id=${user_id}&amp;returnUrl=/sys/index.do"
												target="_blank" class="link_btn03"><span>투표관리</span></a></li>

										</c:if>
									</ul>
									
								</div>
							</div>
							<!-- 							<a href="#" class="link_btn">바로가기</a> -->
						</div>
					</div>
				</div>
				<div class="box">
					<div class="vote">
						<div class="mar">
							<h3>문자 투표</h3>
							<a href="#" class="link_btn" onclick="go_manual('sms');">매뉴얼</a>
							<div class="cont01">
								<div class="vote al_center">
									<img src="images/vote/sms_phone.png" alt="문자투표">
									<ul>
									<c:if test="${userId eq 'ad5f2a7662b95e771af051269c8dcd77' || userId eq '194db5451dfea84361b3a8ed272bef36'}">
										<li class="box02"><a
											href="http://smart.sejong.go.kr/admin" target="_blank"
											class="link_btn03"><span>관리자</span></a></li>
										<li class="box02"><a
											href="https://www.sejong.go.kr/ecm/jsp/sms/message/messageWrite.jsp"
											target="_blank" class="link_btn03"><span>문자발송</span></a></li>
									</c:if>																						
										<li class="box02"><a
											href="http://www.sejong.go.kr/vote/sys/login.do?user_id=${user_id}&amp;returnUrl=/sys/bbs/article/index.do?bbsId=BBSMSTR_000000000110"
											target="_blank" class="link_btn03"><span>투표신청</span></a></li>
									</ul>
								</div>
							</div>
							<!-- 							<a href="#" class="link_btn">바로가기</a> -->
						</div>
					</div>
				</div>
				<div class="box">
					<div class="vote">
						<div class="mar">
							<h3>현장 투표</h3>
							<a href="#" class="link_btn" onclick="go_manual('field');">매뉴얼</a>
							<div class="cont01">
								<div class="vote al_center">
									<img src="images/vote/vote_real.png" alt="현장투표">
									<ul>
										<li class="box01"><a
											href="http://www.sejong.go.kr/vote/sys/login.do?user_id=${user_id}&amp;returnUrl=/sys/bbs/article/index.do?bbsId=BBSMSTR_000000000111"
											target="_blank" class="link_btn01"><span>현장투표 신청</span></a></li>
									</ul>
								</div>
							</div>
							<!-- 							<a href="#" class="link_btn">바로가기</a> -->
						</div>
					</div>
				</div>
			</div>
			<!-- Contents2 :E -->
			<!-- Contents_weather:S -->
			<div id="contents_wt">
				<div class="slogon">
					<p>
						<span>시민과 소통하는 </span><strong><span>오늘의 세종</span>입니다.</strong>
					</p>
				</div>
				<div class="mar_wt">
					<h2 class="h3_wt">오늘의 날씨</h2>
						<div class="time_collec">
							<span id="collecMontn">01</span>월 
							<span id="collecDay">01</span>일 
							<span id="collecyoil">(월)</span>요일
							<span id="collecHour">00</span>:<span id="collecMin">00</span> 기준
						</div>
						<div class="box_left">
							<p id="p_sjm">10.5C</p>
							<img id="img_sjm" src="images/contents/Snow.png" alt="소정면 온도"
								title="소정면 눈 옴" />
							<p id="p_jwm">10.5C</p>
							<img id="img_jwm" src="images/contents/Snow.png" alt="전의면 온도"
								title="전의면 눈 옴" />
							<p id="p_jdm">10.5C</p>
							<img id="img_jdm" src="images/contents/Snow.png" alt="전동면 온도"
								title="전동면 눈 옴" />
							<p id="p_jcw">10.5C</p>
							<img id="img_jcw" src="images/contents/Snow.png" alt="조치원읍 온도"
								title="조치원읍 눈 옴" />
							<p id="p_ysm">10.5C</p>
							<img id="img_ysm" src="images/contents/Snow.png" alt="연서면 온도"
								title="연서면 눈 옴" />
							<p id="p_ydm">10.5C</p>
							<img id="img_ydm" src="images/contents/Snow.png" alt="연동면 온도"
								title="연동면 눈 옴" />
							<p id="p_ygm">10.5C</p>
							<img id="img_ygm" src="images/contents/Snow.png" alt="연기면 온도"
								title="연기면 눈 옴" />
							<p id="p_bgm">10.5C</p>
							<img id="img_bgm" src="images/contents/Snow.png" alt="부강면 온도"
								title="부강면 눈 옴" />
							<p id="p_brd">10.5C</p>
							<img id="img_brd" src="images/contents/Snow.png" alt="보람동 온도"
								title="보람동 눈 옴" />
							<p id="p_gnm">10.5C</p>
							<img id="img_gnm" src="images/contents/Snow.png" alt="금남면 온도"
								title="금남면 눈 옴" />
							<p id="p_jgm">10.5C</p>
							<img id="img_jgm" src="images/contents/Snow.png" alt="장군면 온도"
								title="장군면 눈 옴" />
							<p id="p_gwd">10.5C</p>
							<img id="img_gwd" src="images/contents/Snow.png" alt="고운동 온도"
								title="고운동 눈 옴" />
							<p id="p_ard">10.5C</p>
							<img id="img_ard" src="images/contents/Snow.png" alt="아름동 온도"
								title="아름동 눈 옴" />
							<p id="p_jcd">10.5C</p>
							<img id="img_jcd" src="images/contents/Snow.png" alt="종촌동 온도"
								title="종촌동 눈 옴" />
							<p id="p_srd">10.5C</p>
							<img id="img_srd" src="images/contents/Snow.png" alt="새롬동 온도"
								title="새롬동 눈 옴" />
							<p id="p_hsd">10.5C</p>
							<img id="img_hsd" src="images/contents/Snow.png" alt="한솔동 온도"
								title="한솔동 눈 옴" />
							<p id="p_ddd">10.5C</p>
							<img id="img_ddd" src="images/contents/Snow.png" alt="도담동 온도"
								title="도담동 눈 옴" /> 
							<p id="p_dpd">10.5C</p>
							<img id="img_dpd" src="images/contents/Snow.png" alt="대평동 온도"
								title="대평동 눈 옴" />
							<p id="p_sdd">10.5C</p>
							<img id="img_sdd" src="images/contents/Snow.png" alt="소담동 온도"
								title="소담동 눈 옴" />
						</div>
						<div class="box_right">
							<table class="tbl_basic">
								<thead>
									<tr>
										<th>지명</th>
										<th>온도</th>
										<th>날씨</th>
									</tr>
								</thead>
								<tbody id="tblTbody">
								</tbody>
							</table>
						</div>
				</div>
				<!-- mar_wt:E -->
			</div>
			<!-- Contents_weather:E -->
			<!-- Contents_employee:S -->
			<div id="contents_emp">
				<div class="slogon">
					<p>
						<span>시민과 소통하는 </span><strong><span>오늘의 세종</span>입니다.</strong>
					</p>
				</div>
				<div class="mar">
					<h3>고용률 (세종 / 전국)</h3>
					<!-- 					<span class="pop-close">닫기<i class="fa fa-times"aria-hidden="true"></i></span>  -->
					<em class="top_txt_box" id="span_topEmploy"><span
						class="top_line">세종</span> 00년 하반기 : 00.0% (0.0% 상승<img
						src="images/btn_arr_up.png" alt="상승" />)</em>
					<div class="pop_wrap">
						<div class="con_pop_box_01">
							<!--     	그래프들어갈곳 -->
							<canvas id="canvasEmpSejong"></canvas>
						</div>
						<div class="con_pop_box_02">
							<div class="con_pop_box_02_01">
								<div class="posi_re">
									<h2>검색년도</h2>
									<select name="searchyear" id="searchyear"
										onchange="fn_getjobEmployTableList()"></select> <span
										class="posi_ab">(단위 %)</span>
								</div>
								<table class="pop_basic_table" id="graphTable">
									<caption>구분, 고용률(전국), 고용률(세종)순으로 정보제공</caption>
									<colgroup>
										<col style="width: auto" />
										<col style="width: 33.3%" />
										<col style="width: 33.3%" />
									</colgroup>
									<thead>
										<tr>
											<th scope="col">구분</th>
											<th scope="col">세종</th>
											<th scope="col">전국</th>
										</tr>
									</thead>
									<tbody id="my-tbody"></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- mar:E -->
			</div>
			<!-- Contents_employee:E -->
			<!-- Contents_unemployee:S -->
			<div id="contents_unemp">
				<div class="slogon">
					<p>
						<span>시민과 소통하는 </span><strong><span>오늘의 세종</span>입니다.</strong>
					</p>
				</div>
				<div class="mar">
					<h3>실업률 (세종 / 전국)</h3>
					<!-- 					<span class="pop-close">닫기<i class="fa fa-times"aria-hidden="true"></i></span>  -->
					<em class="top_txt_box" id="span_topUnemploy"><span
						class="top_line">세종</span>00년 하반기 : 00.0% (0.0% 상승<img
						src="images/btn_arr_up.png" alt="상승" />)</em>
					<div class="pop_wrap">
						<!-- 			<div class="top_pop_box"> -->
						<!-- 					</div> -->
						<div class="con_pop_box_01">
							<!--     	그래프들어갈곳 -->
							<canvas id="canvasUnempTotal" width="800px" height="400px"></canvas>
						</div>
						<div class="con_pop_box_02">
							<div class="con_pop_box_02_01">
								<div class="posi_re">
									<h2>검색년도</h2>
									<select name="searchyear" id="searchyear_unemp"
										onchange="fn_getUnEmpDatatableList()"></select> <span
										class="posi_ab">(단위 %)</span>
								</div>
								<table class="pop_basic_table" id="graphTable">
									<caption>구분, 실업률(전국), 실업률(세종)순으로 정보제공</caption>
									<colgroup>
										<col style="width: auto" />
										<col style="width: 33.3%" />
										<col style="width: 33.3%" />
									</colgroup>
									<thead>
										<tr>
											<th scope="col">구분</th>
											<th scope="col">세종</th>
											<th scope="col">전국</th>
										</tr>
									</thead>
									<tbody id="my-tbody_unemp"></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Contents_employee:E -->
			<!-- contents_population :S -->
			<div id="contents_population">
				<div class="box50">
					<div class="slogon">
						<p>
							<span>세종의오늘, </span><strong><span>통계와 인포그래픽으로
									알아보는 세종</span>입니다.</strong>
						</p>
					</div>
					
					<div class="people">
					<div class="mar_popul1">
						<h3>세종시 인구현황</h3>
						<div class="obj" id="obj01">
							<div class="explanatory">
								<div class="data_table">
									<div class="hbox">
										<div class="ig">
											<img class="hboximg"
												src="images/stat/main/explanatory_img.png"
												alt="세종시 전체인구 인구현황 아이콘" />
										</div>
										<div class="if if-col3">
											<span class="tit">세종 총 인구</span> <strong
												class="num totalSumLayer">0명</strong> <span
												class="date yesterday"> </span>
										</div>
									</div>
								</div>
<!-- 								<h4>전체인구</h4> -->
<!-- 								<p> -->
<%-- 									<fmt:formatNumber value="${totalSum }" pattern="#,###" /> --%>
<!-- 									명 -->
<!-- 								</p> -->
							</div>
							<div class="map_popul">
									<span 
									class="txt_village_01"> <span class="skip">소정면 인구</span> 
									<span id="span_sjm" data-orgcode="3611039000">0</span></span> <span
									class="txt_village_02"> <span class="skip">전의면 인구</span>
									<span id="span_jwm" data-orgcode="3611037000">0</span></span> <span
									class="txt_village_03"> <span class="skip">전동면 인구</span>
									<span id="span_jdm" data-orgcode="3611038000">0</span></span> <span
									class="txt_village_04"> <span class="skip">조치원읍 인구</span> 
									<span id="span_jcw" data-orgcode="3611025000">0</span></span> <span
									class="txt_village_05"> <span class="skip">연서면 인구</span>
									<span id="span_ysm" data-orgcode="3611036000">0</span></span> <span
									class="txt_village_06"> <span class="skip">연동면 인구</span>
									<span id="span_ydm" data-orgcode="3611032000">0</span></span> <span
									class="txt_village_07"> <span class="skip">연기면 인구</span>
									<span id="span_ygm" data-orgcode="3611031000">0</span></span> <span
									class="txt_village_08"> <span class="skip">도담동 인구</span>
									<span id="span_ddd" data-orgcode="3611052000">0</span></span> <span
									class="txt_village_09"> <span class="skip">장군면 인구</span>
									<span id="span_jgm" data-orgcode="3611035000">0</span></span> <span
									class="txt_village_10"> <span class="skip">한솔동 인구</span>
									<span id="span_hsd" data-orgcode="3611051000">0</span></span> <span
									class="txt_village_11"> <span class="skip">부강면 인구</span>
									<span id="span_bgm" data-orgcode="3611033000">0</span></span> <span
									class="txt_village_12"> <span class="skip">금남면 인구</span>
									<span id="span_gnm" data-orgcode="3611034000">0</span></span> <span
									class="txt_village_13"> <span class="skip">아름동 인구</span>
									<span id="span_ard" data-orgcode="3611053000">0</span></span> <span
									class="txt_village_14"> <span class="skip">종촌동 인구</span>
									<span id="span_jcd" data-orgcode="3611054000">0</span></span> <span
									class="txt_village_15"> <span class="skip">고운동 인구</span>
									<span id="span_gwd" data-orgcode="3611055000">0</span></span> <span
									class="txt_village_16"> <span class="skip">보람동 인구</span>
									<span id="span_brd" data-orgcode="3611056000">0</span></span> <span
									class="txt_village_17"> <span class="skip">새롬동 인구</span>
									<span id="span_srd" data-orgcode="3611051500">0</span></span>
							</div>
							<div class="legend">
								<ul>
									<li class="icon1">40,000명 이상</li>
									<li class="icon2">30,000명 이상</li>
									<li class="icon3">20,000명 이상</li>
									<li class="icon4">10,000명 이상</li>
									<li class="icon5">10,000명 미만</li>
								</ul>
							</div>
						</div>
					</div>
					</div>
				</div>
				<div class="box50">
					<div class="people">
					<div class="mar_popul2">
						<h3>연도별 인구통계</h3>
						<div class="obj" id="obj02">
							<!--<div class="explanatory">
									<div class="data_table"></div>
								</div>-->
							<div class="legend1">
								<div class="legend1_0">
									<img src="images/stat/main/explanatory_img.png" alt="" />
									<h4 class="expla_h3">인구수(명)</h4>
								</div>
								<div class="legend1_1">
									<ul class="expl_list_01">
										<li class="icon1"><span class="expl_list_01">50,000명<br>이상
										</span></li>
										<li class="icon2"><span class="expl_list_01">150,000명
												<br>이상
										</span></li>
										<li class="icon3"><span class="expl_list_01">250,000명
												<br>이상
										</span></li>
									</ul>
								</div>
								<div class="legend1_1_1">
									<h4 class="bg_large">전년대비 인구 증감율(%)</h4>
									<ul class="expl_list_02">
										<li class="icon4">증가</li>
										<li class="icon5">감소</li>
									</ul>
								</div>
							</div>
								<div class="graphchartBox">
								</div>
								<div class="graph">
<!-- 									<div class="box"> -->
										<span 
											class="txt_2012"><span class="skip">2012년 인구</span><span 
											class="mgnum" id="popul2012">115,388</span><em id="em2012"></em></span> <span
											class="txt_2013"><span class="skip">2013년 인구</span><span
											class="mgnum" id="popul2013">124,615</span><em id="em2013">8.0%</em></span> <span
											class="txt_2014"><span class="skip">2014년 인구</span><span
											class="mgnum" id="popul2014">158,844</span><em id="em2014">27.5%</em></span> <span
											class="txt_2015"><span class="skip">2015년 인구</span><span
											class="mgnum" id="popul2015">214,364</span><em id="em2015">35.0%</em></span> <span
											class="txt_2016"><span class="skip">2016년 인구</span><span
											class="mgnum" id="popul2016">246,793</span><em id="em2016">15.1%</em></span> <span
											class="txt_2017"><span class="skip">2017년 인구</span><span
											class="mgnum" id="popul2017">284,353</span><em id="em2017">15.2%</em></span> <span
											class="txt_2018"><span class="skip">2018년 인구</span><span
											class="mgnum totalSumLayerG" id="popul2018">0</span><em
											class="totalSumLayerP" id="em2018">0%</em></span>
<!-- 									</div> -->
								</div>
						</div>
					</div>
					</div>
				</div>
			</div>
			<!-- contents_population :S -->
		</div>
		<!-- Container :E -->
	</div>
</body>
</html>