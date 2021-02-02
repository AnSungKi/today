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
<link rel="shortcut icon" type="image/x-icon" href="/images/mweb/favicon.ico" />
<script src="js/jquery-1.11.2.min.js"></script>
<!-- Chart.js js -->
<script src="js/library/chart/dist/Chart.js"></script>
<script src="js/library/chart/samples/utils.js"></script>
<script src="js/library/job/jobUnEmploy.js"></script>
<script type="text/javascript">
	var G_CONTEXT_PATH = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	<div id="contents">
		<div class="mar">
			<h3>실업률 (세종 / 전국)</h3>
			<em class="top_txt_box" id="span_topUnemploy"><span class="top_line">세종</span>00년 하반기 : 00.0% (0.0% 상승<img src="images/btn_arr_up.png" alt="상승" />)</em>
			<div class="pop_wrap">
				<!-- 			<div class="top_pop_box"> -->
				<!-- 					</div> -->
				<div class="con_pop_box_01">
					<!--     	그래프들어갈곳 -->
					<canvas id="canvasUnempTotal"></canvas>
				</div>
				<div class="con_pop_box_02">
					<div class="con_pop_box_02_01">
						<div class="posi_re">
							<h2>검색년도</h2>
							<select name="searchyear" id="searchyear" onchange="fn_getUnEmpDatatableList()"></select>
							<span class="posi_ab">(단위 %)</span>
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
							<tbody id="my-tbody"></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>