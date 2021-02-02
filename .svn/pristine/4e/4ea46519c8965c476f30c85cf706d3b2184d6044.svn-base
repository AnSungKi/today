//	$(document).ready(function() {
//		fn_topUnemploy();
//		fn_comboBoxUnemploy();
//		fn_getUnEmpDatatableList();
//	});

	/*
	 *  최근 고용률 Select
	 */
	function fn_topUnemploy() {
		$.ajaxSettings.traditional = true;
	
		try {
			$.ajax({
				type: "POST",
				url: G_CONTEXT_PATH + "/getTopUnemploy.do",
				dataType: "JSON",
				async: false,
				success: function(res) {
					console.log('[log] ----> jobUnEmploy.js  .[1] function() ');
					if(res.TopUnemploy[0].unemploySejong > res.TopUnemploy[1].unemploySejong){
						$("#span_topUnemploy").html("<span class='top_line'>세종</span>"
												+ res.TopUnemploy[0].unemployTitle
												+ " : "
												+ res.TopUnemploy[0].unemploySejong
												+ "% ("
												+ Number(res.TopUnemploy[0].unemploySejong - res.TopUnemploy[1].unemploySejong).toFixed(1)
												+ "% 상승<img src='images/btn_arr_up.png' alt='상승' />)");
					} else if(res.TopUnemploy[0].unemploySejong < res.TopUnemploy[1].unemploySejong){
						$("#span_topUnemploy").html("<span class='top_line'>세종</span>"
								                + res.TopUnemploy[0].unemployTitle
								                + " : "
								                + res.TopUnemploy[0].unemploySejong
								                + "% ("
								                + Number(res.TopUnemploy[1].unemploySejong - res.TopUnemploy[0].unemploySejong).toFixed(1)
								                + "% 하락<img src='images/btn_arr_down.png' alt='하락' />)");
					} else if(res.TopUnemploy[0].unemploySejong == res.TopUnemploy[1].unemploySejong){
						$("#span_topUnemploy").html("<span class='top_line'>세종</span>"
								                + res.TopUnemploy[0].unemployTitle
								                + " : "
								                + res.TopUnemploy[0].unemploySejong
								                + "% (0% - )");
					}
				},error: function(res) {
					console.log('[log] ----> jobUnEmploy.js  .[2] function() ');
			    	alert("/getTopUnemploy.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
			});
		} catch (e) {
			// TODO: handle exception
		}
	}
	
    function fn_barChartDrawUnEmp(param) {
//      var dataset = new Array();
     var chartLabels = [];
     var chartData1 = [];
     var chartData2 = [];
     var chartData3 = [];
     var max;
     var sub = [];
     var title = [];
     
     $.ajaxSettings.traditional = true;
     
     try {
    	 $.ajax({
             type: "POST",
             url: G_CONTEXT_PATH + "/getUnEmployGrapeList.do",
             dataType: "JSON",
             data:param,
             async: false,
             success: function(res) {
            	 if(res.unemployLineData.length !=12){
    	        		for(var i =res.unemployLineData.length; i<12; i++){
    	        			res.unemployLineData.push({unemployTitle: (i+1)+"월", unemployTotal: "0", unemploySejong: "0"});
    	        		}
    	        	}
                 $.each(res.unemployLineData, function(inx, obj) {
                     chartLabels.push(obj.unemployTitle);
                     chartData1.push(obj.unemployTotal);
                     chartData2.push(obj.unemploySejong);
                 });
             },error: function(res) {
            	 	console.log('[log] ----> jobUnEmploy.js  .[3] function() ');
    		    	alert("/getUnEmployGrapeList.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    		    }
         });
	} catch (e) {
		// TODO: handle exception
	}

     var chartData = {
         labels: chartLabels,
         datasets: [{
             type: 'bar',
             label: '세종',
             backgroundColor: '#6e7581',
//             backgroundColor: '#5479b5',
//             backgroundColor: '#93DAFF',
             data: chartData2,
             borderColor: 'white',
             borderWidth: 0
         }, {
             type: 'bar',
             label: '전국',
             backgroundColor: '#e4e6ea',
//             backgroundColor: '#4f815e',
//             backgroundColor: '#FF7E9D',
             data: chartData1,
             borderColor: 'white',
             borderWidth: 0
         }]
     };
     
     var ctx = document.getElementById("canvasUnempTotal").getContext("2d");

     if(window.myLineTotalUnEmp) {
       window.myLineTotalUnEmp.destroy();
     }

     window.myLineTotalUnEmp = new Chart(ctx, {
         type: 'bar',
         data: chartData,
         options: {
             responsive: true,
             title: {
                 display: true,
                 text: title,
                 fontSize: 25
             },
             tooltips: {
                 mode: 'index',
                 intersect: false,
                 backgroundColor:'rgba(128, 128, 128, 1.0)'
             },
             scales: {
                 xAxes: [{
                     display: true,
                     scaleLabel: {
                         display: true,
                         labelString: '월별'
                     },
                     barPercentage: 0.5
                 }],
                 yAxes: [{
                     display: true,
                     scaleLabel: {
                         display: true,
                         labelString: '실업률'
                     },
                     ticks: {
             			 min:0
             		 }
                 }]
             }
         }
     });
   }
	
	/*
	 *  검색년도(콤보박스) Select
	 */
     function fn_comboBoxUnemploy() {
         $.ajaxSettings.traditional = true;

         try {
        	 $.ajax({
                 type: "POST",
                 url: G_CONTEXT_PATH + "/getUnemployComboBox.do",
                 dataType: "JSON",
                 async: false,
                 success: function(res) {
                	 console.log('[log] ----> jobUnEmploy.js  .[4] function() ');
                 	var j = res.unemployComboBox.length;
                 	var comboBoxList = [];

                 	$("#searchyear_unemp").empty();
                 	
                 	for(var i = 0; i < j; i++) {
                 		comboBoxList[i] = res.unemployComboBox[i].unemployYear;
                 		
                 		if(i == 0){
                 			$("#searchyear_unemp").append("<option value='" + comboBoxList[i] + "' selected='selected'>"+ comboBoxList[i] +"</option>")
                 		}else{
                 		$("#searchyear_unemp").append("<option value='" + comboBoxList[i] + "'>" + comboBoxList[i] + "</option>")
                 		}
                 	}
                 },error: function(res) {
     		    	alert("/getUnemployComboBox.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
     		    	console.log('[log] ----> jobUnEmploy.js  .[5] function() ');
     		    }
             });
		} catch (e) {
			// TODO: handle exception
		}
     }

     function fn_getUnEmpDatatableList() {
     	var param = {"unemployYear":$("#searchyear_unemp").val()};
     	
    	$.ajaxSettings.traditional = true;

    	try {
    		$.ajax({
    			type: "POST",
    			url: G_CONTEXT_PATH + "/getUnEmpDatatableList.do",
    			dataType: "JSON",
    			"data":param,
    			async: false,
    			success: function(res) {
    				console.log('[log] ----> jobUnEmploy.js  .[6] function() ');
    				$("#my-tbody_unemp").empty();
    				
    				for(var i = 0; i < res.data.length; i++) {
    					$("#my-tbody_unemp").append("<tr><td>" + res.data[i].unemployTitle + "</td><td>" + res.data[i].unemploySejong + "</td><td>" + res.data[i].unemployTotal + "</td></tr>");
    				}
    			},error: function(res) {
     		    	alert("/getUnEmpDatatableList.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
     		    	console.log('[log] ----> jobUnEmploy.js  .[7] function() ');
     		    }
    		});
		} catch (e) {
			// TODO: handle exception
			console.log('[log] ----> jobUnEmploy.js  .[8] function() ');
		}
     	
		fn_barChartDrawUnEmp(param);
     }
     
     
///////////////////////////////////////////////////////////////
     
     
     
     
     
     
     