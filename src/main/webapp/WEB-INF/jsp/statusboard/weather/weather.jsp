<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="format-detection" content="telephone=no,email=no,address=no" />
<meta name="author" content="세종특별자치시청" />
<meta name="Keywords" content="세종특별자치시,행복도시 세종" />
<meta name="description" content="세종특별자치시,행복도시 세종" />
<meta name="copyright" content="세종특별자치시 한누리대로 2130 (보람동) (우) 30151 / 대표전화 (044) 120" />
<meta name="viewport" content="initial-scale=1.0,minimum-scale=1.0,width=device-width">
<title>세종특별자치시</title>
<link rel="stylesheet" type="text/css" href="css/common/common.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/popup.css" media="all" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/library/weather/weatherjido.js"></script>
<!-- 데이터셋팅 -->
<script src="./js/library/monitor/monitor.js"></script>
<script type="text/javascript">
	var G_CONTEXT_PATH = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	<!-- iframe Popup -->
	<div id="popup">
		<span class="b-close">닫기<i class="fa fa-times" aria-hidden="true"></i></span>
		<iframe id="popIframe" name="popIframe" onload="loaded();" allowfullscreen></iframe>
		<img class="main-loader" id="iframeLoading" alt="로딩중입니다...." src="images/loader.gif">
	</div>
	<!-- //iframe Popup -->
	<!-- iframe Popup2 : 검색 팝업 -->
	<div id="searchPopup">
		<span class="b-close" style="margin-top: 34.4px;">닫기<i class="fa fa-times" aria-hidden="true"></i></span>
		<div>
			<iframe id="snsPopIframe" name="snsPopIframe" onload="searchLoaded();" allowfullscreen></iframe>
		</div>
		<div style="margin-left: 50%;">
			<iframe id="csPopIframe" name="csPopIframe" onload="searchLoaded();" allowfullscreen></iframe>
		</div>
		<img class="main-loader" id="searchIframeLoading" alt="로딩중입니다...." src="images/loader.gif">
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
	<div id="wrap">
		<!-- Header :S -->
		<div id="header">
			<h1 class="logo">
				<img src="images/common/logo.png" alt="오늘의 세종" />
			</h1>
			<dl class="today">
				<dt>TODAY</dt>
				<dd id="span_dateInput">2018년 1월 4일(목)</dd>
			</dl>
			<div class="search">
				<fieldset>
					<legend>통합검색</legend>
					<label for="search_input" class="hidden">검색어 입력</label> <input type="text" name="search_input" id="search_input" placeholder="검색어를 입력하세요." /> <input type="submit" id="daumsocial" value="검색" />
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
						Copyright © 2017 세종특별자치시. <br /> All Rights Reserved.
					</p>
				</div>
				<!-- Footer :E -->
			</div>
			<!-- Lnb :E -->
	<div id="contents">
		<div class="mar">
		<h3>오늘의 날씨</h3>
			<div class="pop_wrap">
				<div class="box_left">
					<p id="p_sjm">10.5C</p>
					<img id="img_sjm" src="images/contents/Snow.png" alt="소정면 온도" title="소정면 눈 옴" />
					<p id="p_jwm">10.5C</p>
					<img id="img_jwm" src="images/contents/Snow.png" alt="전의면 온도" title="전의면 눈 옴" />
					<p id="p_jdm">10.5C</p>
					<img id="img_jdm" src="images/contents/Snow.png" alt="전동면 온도" title="전동면 눈 옴" />
					<p id="p_jcw">10.5C</p>
					<img id="img_jcw" src="images/contents/Snow.png" alt="조치원읍 온도" title="조치원읍 눈 옴" />
					<p id="p_ysm">10.5C</p>
					<img id="img_ysm" src="images/contents/Snow.png" alt="연서면 온도" title="연서면 눈 옴" />
					<p id="p_ydm">10.5C</p>
					<img id="img_ydm" src="images/contents/Snow.png" alt="연동면 온도" title="연동면 눈 옴" />
					<p id="p_ygm">10.5C</p>
					<img id="img_ygm" src="images/contents/Snow.png" alt="연기면 온도" title="연기면 눈 옴" />
					<p id="p_bgm">10.5C</p>
					<img id="img_bgm" src="images/contents/Snow.png" alt="부강면 온도" title="부강면 눈 옴" />
					<p id="p_brd">10.5C</p>
					<img id="img_brd" src="images/contents/Snow.png" alt="보람동 온도" title="보람동 눈 옴" />
					<p id="p_gnm">10.5C</p>
					<img id="img_gnm" src="images/contents/Snow.png" alt="금남면 온도" title="금남면 눈 옴" />
					<p id="p_jgm">10.5C</p>
					<img id="img_jgm" src="images/contents/Snow.png" alt="장군면 온도" title="장군면 눈 옴" />
					<p id="p_gwd">10.5C</p>
					<img id="img_gwd" src="images/contents/Snow.png" alt="고운동 온도" title="고운동 눈 옴" />
					<p id="p_ard">10.5C</p>
					<img id="img_ard" src="images/contents/Snow.png" alt="아름동 온도" title="아름동 눈 옴" />
					<p id="p_jcd">10.5C</p>
					<img id="img_jcd" src="images/contents/Snow.png" alt="종촌동 온도" title="종촌동 눈 옴" />
					<p id="p_srd">10.5C</p>
					<img id="img_srd" src="images/contents/Snow.png" alt="새롬동 온도" title="새롬동 눈 옴" />
					<p id="p_hsd">10.5C</p>
					<img id="img_hsd" src="images/contents/Snow.png" alt="한솔동 온도" title="한솔동 눈 옴" />
					<p id="p_ddd">10.5C</p>
					<img id="img_ddd" src="images/contents/Snow.png" alt="도담동 온도" title="도담동 눈 옴" /> <img src="images/sejongjido.png" alt="오늘의 세종" />
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
		</div>
	</div>
</body>
</html>