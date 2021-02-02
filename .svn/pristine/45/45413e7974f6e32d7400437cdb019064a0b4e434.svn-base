function financeLoad(){
	try {
		$.ajax({
			type: "POST",
	        url: G_CONTEXT_PATH + "/getTotalFinance.do",
	        dataType: "JSON",
	        async: false,
	        success: function(res) {  //totalFinanceData
	        	console.log('[log] ----> finance.js  .[1] function() ');
//	        	var budget = res.finance.budget;
//	        	var income = res.finance.income;
//	        	var expenses = res.finance.expenses;
	        	var budget = Number(res.finance.budget / 100000000).toFixed(0);
	        	var income = Number(res.finance.income / 100000000).toFixed(0);
	        	var expenses = Number(res.finance.expenses / 100000000).toFixed(0);
	        	var incomePer = Number((income / budget) * 100).toFixed(2);
	        	var expensesPer = Number((expenses / budget) * 100).toFixed(2);
	        	
	        	$("#span_inputSil").html(numberWithCommas(income) + "<em>억원</em>");
	        	$("#span_inputPer").text("(" + numberWithCommas(incomePer) + "%)");

	        	$("#span_outputSil").html(numberWithCommas(expenses) + "<em>억원</em>");
	        	$("#span_outputPer").text("(" + numberWithCommas(expensesPer) + "%)");
	        },error: function(res) {
			    	alert("/getTotalFinance.do  code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			    	console.log('[log] ----> finance.js  .[2] function() ');
			    }
		});
	} catch (e) {
		// TODO: handle exception
	}
}