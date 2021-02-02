/*
 * BarGraph
 */
 function fn_financeOutputBarGraph() {
	 var dataset = new Array();
     var chartLabels = ["예산", "지출액"];
    
     
     var color = Chart.helpers.color;
     var horizontalBarChartData = {
         labels: chartLabels,
         datasets: [{
             label: '예산',
             backgroundColor: color(window.chartColors.red).alpha(1.0).rgbString(),
             borderColor: window.chartColors.red,
             borderWidth: 1,
             data: [11962]
         }, {
             label: '지출액',
             backgroundColor: color(window.chartColors.red).alpha(0.1).rgbString(),
             borderColor: window.chartColors.red,
             data: [9195]
         }]

     };
     
     var ctx = document.getElementById("financeOutputCanvas").getContext("2d");
     window.myHorizontalBar = new Chart(ctx, {
         type: 'horizontalBar',
         data: horizontalBarChartData,
         options: {
             // Elements options apply to all of the options unless overridden in a dataset
             // In this case, we are setting the border of each horizontal bar to be 2px wide
             elements: {
                 rectangle: {
                     borderWidth: 2,
                 }
             },
             responsive: true,
             legend: {
                 position: 'right',
             },
             title: {
                 display: true,
                 text: 세출
             },
             tooltips: {
                 mode: 'index',
                 intersect: false,
                 backgroundColor:'rgba(128, 128, 128, 1.0)'
             },
             scales: {
            	 xAxes: [{
            		 ticks: {
            			 min:0
            		 }
            	 }]
             }
         }
     });
}