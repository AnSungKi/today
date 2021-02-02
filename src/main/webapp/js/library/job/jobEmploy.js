//	$(document).ready(function() {
//		fn_topEmploy();
//		fn_comboBoxEmploy();
//		fn_getjobEmployTableList();
//	});

	/*
	 *  최근 고용률 Select
	 */
	function fn_topEmploy() {
		$.ajaxSettings.traditional = true;
	
		try {
			$.ajax({
				type: "POST",
				url: G_CONTEXT_PATH + "/getTopEmploy.do",
				dataType: "JSON",
				async: false,
				success: function(res) {
					console.log('[log] ----> jobEmploy.js  .[1] function() ');
					var j = res.TopEmploy.length;
					var upAndDown;

					if(res.TopEmploy[0].employSejong > res.TopEmploy[1].employSejong){
						$("#span_topEmploy").html("<span class='top_line'>세종</span>"
												+ res.TopEmploy[0].employTitle
												+ " : "
												+ res.TopEmploy[0].employSejong
												+ "% ("
												+ Number(res.TopEmploy[0].employSejong - res.TopEmploy[1].employSejong).toFixed(1)
												+ "% 상승<img src='images/btn_arr_up.png' alt='상승' />)");
					} else if(res.TopEmploy[0].employSejong < res.TopEmploy[1].employSejong){
						$("#span_topEmploy").html("<span class='top_line'>세종</span>"
								                + res.TopEmploy[0].employTitle
								                + " : "
								                + res.TopEmploy[0].employSejong
								                + "% ("
								                + Number(res.TopEmploy[1].employSejong - res.TopEmploy[0].employSejong).toFixed(1)
								                + "% 하락<img src='images/btn_arr_down.png' alt='하락' />)");
					} else if(res.TopEmploy[0].employSejong == res.TopEmploy[1].employSejong){
						$("#span_topEmploy").html("<span class='top_line'>세종</span>"
								                + res.TopEmploy[0].employTitle
								                + " : "
								                + res.TopEmploy[0].employSejong
								                + "% (0% - )");
					}
				},error: function(res) {
			    	alert("/getTopEmploy.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    }
			});
		} catch (e) {
			// TODO: handle exception
		}
	}
	
	function fn_barChartDraw(param) {
	    var dataset = new Array();
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
		        url: G_CONTEXT_PATH + "/getEmployGrapeList.do",
		        dataType: "JSON",
		        data:param,
		        async: false,
		        success: function(res) {
		        	console.log('[log] ----> jobEmploy.js  .[2] function() ');
		        	if(res.employLineData.length !=12){
		        		for(var i =res.employLineData.length; i<12; i++){
		        			res.employLineData.push({employTitle: (i+1)+"월", employTotal: "0", employSejong: "0"});
		        		}
		        	}
		            $.each(res.employLineData, function(inx, obj) {
		                chartLabels.push(obj.employTitle);
		                chartData1.push(obj.employTotal);
		                chartData2.push(obj.employSejong);
		            });
		        },error: function(res) {
			    	alert("/getEmployGrapeList.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    	console.log('[log] ----> jobEmploy.js  .[3] function() ');
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
//	            backgroundColor: '#5479b5',
//	            backgroundColor: '#93DAFF',
	            data: chartData2,
	            borderColor: 'white',
	            borderWidth: 0
	        }, {
	            type: 'bar',
	            label: '전국',
	            backgroundColor: '#e4e6ea',
//	            backgroundColor: '#4f815e',
//	            backgroundColor: '#FF7E9D',
	            data: chartData1,
	            borderColor: 'white',
	            borderWidth: 0
	        }]
	    };
	    
	    var ctx = document.getElementById("canvasEmpSejong").getContext("2d");

	    if(window.myLineTotal) {
	      window.myLineTotal.destroy();
	    }

	    window.myLineTotal = new Chart(ctx, {
	        type: 'bar',
	        data: chartData,
	        options: {
	            responsive: true,
	            title: {
	                display: true,
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
	                        labelString: '고용률'
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
	function fn_comboBoxEmploy() {
		$.ajaxSettings.traditional = true;

		try {
			$.ajax({
				type: "POST",
				url: G_CONTEXT_PATH + "/getEmployComboBox.do",
				dataType: "JSON",
				async: false,
				success: function(res) {
					console.log('[log] ----> jobEmploy.js  .[4] function() ');
					var j = res.employComboBox.length;
					var comboBoxList = [];
					
					$("#searchyear").empty();
	                    	
					for(var i = 0; i < j; i++) {
						comboBoxList[i] = res.employComboBox[i].employYear;
	                    
						if(i == 0){
							$("#searchyear").append("<option value='" + comboBoxList[i] + "' selected='selected'>"+ comboBoxList[i] +"</option>")
						}else {
							$("#searchyear").append("<option value='" + comboBoxList[i] + "'>" + comboBoxList[i] + "</option>")
						}
					}
				},error: function(res) {
			    	alert("/getEmployComboBox.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    	console.log('[log] ----> jobEmploy.js  .[5] function() ');
			    }
			});
		} catch (e) {
			// TODO: handle exception
			console.log('[log] ----> jobEmploy.js  .[6] function() ');
		}
		
	}
	
    function fn_getjobEmployTableList() {
    	var param = {"employYear":$("#searchyear").val()};
    	
    	$.ajaxSettings.traditional = true;

    	try {
    		$.ajax({
    			type: "POST",
    			url: G_CONTEXT_PATH + "/getjobEmployDataTableList.do",
    			dataType: "JSON",
    			"data":param,
    			async: false,
    			success: function(res) {
    				console.log('[log] ----> jobEmploy.js  .[7] function() ');
    				$("#my-tbody").empty();
    				
    				for(var i = 0; i < res.data.length; i++) {
    					$("#my-tbody").append("<tr><td>" + res.data[i].employTitle + "</td><td>" + res.data[i].employSejong + "</td><td>" + res.data[i].employTotal + "</td></tr>");
    				}
    			},error: function(res) {
    				console.log('[log] ----> jobEmploy.js  .[8] function() ');
    		    	alert("/getjobEmployDataTableList.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
    		    }
    		});
		} catch (e) {
			// TODO: handle exception
			console.log('[log] ----> jobEmploy.js  .[9] function() ');
		}
    	fn_barChartDraw(param);
    }	
    
    
    
    /////////////////////////////////////////////////////////////////////
    