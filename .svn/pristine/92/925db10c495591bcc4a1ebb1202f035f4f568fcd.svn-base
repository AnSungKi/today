//function populationLoad(){
//	$.ajax({
//		type: "POST",
//        url: G_CONTEXT_PATH + "/getTotalPopulationPerMonth.do",
//        dataType: "JSON",
//        async: false,
//        success: function(res) {
//        	$("#sapn_popNumber").html(numberWithCommas(Number(res.totPop) + 4253) + "<em>명</em>");
//        },
//        error: function(res) {
//        	alert(1);
//        }
//	});
//}

function populationLoad() {
	try {
		$.ajax({
	        url: G_CONTEXT_PATH + '/getPopulation.do',
	        type: "POST",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {
	        	// totP : 세종시 총 인구
	        	var totP = res.totalPopulation[0].totalCount;
//	        	var foreigner = 4129;

	        	$("#sapn_popNumber").html(numberWithCommas(Number(totP)) + "<em>명</em>");
	        	console.log('[log] ----> population.js  . [성공] -> getPopulation.do ');
		    },error: function(res) {
		    	alert("/getPopulation.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    	console.log('[log] ----> population.js  . [에러] -> getPopulation.do ');
		    }
		});
	} catch (e) {
		// TODO: handle exception
		console.log('[log] ----> population.js  . [예외] -> getPopulation.do ');
	}
}