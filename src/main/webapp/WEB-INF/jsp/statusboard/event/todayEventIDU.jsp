<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>

        <link href="css/statusboard/event/board.css" rel="stylesheet">
        <link href="css/statusboard/event/company.css" rel="stylesheet">
        <link href="css/statusboard/event/content.css" rel="stylesheet">
        <link href="css/statusboard/event/guide.css" rel="stylesheet">
        <link href="css/statusboard/event/layout.css" rel="stylesheet">
        <link href="css/statusboard/event/promotion.css" rel="stylesheet">
        <link href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css" rel="stylesheet">
        <link href="css/statusboard/timepicker/jquery.timepicker.css" rel="stylesheet">

        <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
        <script src="js/library/timepicker/jquery.timepicker.js"></script>

        <script type="text/javascript">
            $(function() {

                $("#fromDate").datepicker({
                    dateFormat: "yy-mm-dd"
                });

                $('#fromTime').timepicker({
                    timeFormat: 'H:mm',
                    interval: 10,
                    minTime: '9',
                    maxTime: '6:00pm',
                    defaultTime: '11',
                    startTime: '09:00',
                    dynamic: false,
                    dropdown: true,
                    scrollbar: true
                });
            });
        </script>

        <script type="text/javascript">
            function insertData() {

                var title = $("#title").val();
                var fromDate = $("#fromDate").val();
                var fromTime = $("#fromTime").val();
                var personnel = $("#personnel").val();
                var place = $("#place").val();
                var department = $("#department").val();
                var remarks = $("#remarks").val();

                $.ajaxSettings.traditional = true;

                $.ajax({
                    type: "POST",
                    url: "/setInsertTodayEventData.do",
                    dataType: "JSON",
                    data: {
                        "title": title,
                        "fromDate": fromDate,
                        "fromTime": fromTime,
                        "personnel": personnel,
                        "place": place,
                        "department": department,
                        "remarks": remarks
                    },
                    async: false,
                    complete: function(res) {
                        location.reload();
                    }
                });

            }
        </script>

    </head>

    <body>
	    <!--     <div class="board_customer" id="eventInsertForm" style="display: none;"> -->
	    <div class="board_customer" id="eventInsertForm" ">
	       	<div>
    		<ul>
<!--     			<c:choose> -->
<%--                 	<c:when test="${not empty todayeventlist}"> --%>
<!--                     	<li> -->
<!--     						<div style="width: 30%; float: left; margin: auto;"> -->
<!--     							<input type="checkbox" name="eventCheck"> -->
<%--     							<a>${todayeventlist.eventFromtime}</a> --%>
<%--     							<input type="hidden" id="eventDay" value="${todayeventlist.eventFromdate}"> --%>
<!--     						</div> -->
<!--     						<div style="width: 70%; float: right; margin: auto;"> -->
<%--     							<a style="font-size: 13pt; ">${todayeventlist.eventNm}</a> --%>
<!--     						</div> -->
<!--     					</li> -->
<!--                       </c:when> -->
<!--                       <c:otherwise> -->
                        
<!--                       </c:otherwise> -->
<!--                     </c:choose> -->
    			
    		</ul>
    	</div>
	        <div class="dlTable dsB01 ">
	            <dl>
	                <dt class="taL "><label for="title">행사명</label> <span class="icon_require ">필수</span></dt>
	                <dd><input type="text " id="title" name=" " class="recruit_title "></dd>
	            </dl>
	            <dl>
	            <dt class="taL ">일시 <span class="icon_require ">필수</span></dt>
	                <dd>
	                	<input type="text " id="fromDate" placeholder="시작일 입력 " class="recruit_name ">
	                	<input type="text " id="fromTime" placeholder="시작 시간 입력(형식: 09:00) " class="recruit_name ">
	                </dd>
	            </dl>
	            <dl>
	            <dt class="taL ">인원</dt>
	                <dd><input type="text" id="personnel" name=" " class="recruit_title "></dd>
	            </dl>
	            <dl>
	            <dt class="taL ">장소</dt>
	                <dd><input type="text" id="place" name=" " class="recruit_title "></dd>
	            </dl>
	            <dl>
	            <dt class="taL ">담당부서</dt>
	                <dd><input type="text" id="department" name=" " class="recruit_title "></dd>
	            </dl>
	            <dl>
	            <dt class="taL ">비고</dt>
	                <dd><input type="text" id="remarks" name="" class="recruit_title "></dd>
	            </dl>
	             <button type="button " onclick="insertData()" class="btnMid white " style="margin: auto; ">저장</button>
	        </div>
	    </div>
	    <!-- //board_customer -->
</div>
<!-- //board_wrap -->
</body>
</html>