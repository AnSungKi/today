/* Graph Script */
function fn_lineChartDraw() {
    var dataset = new Array();
    var chartLabels = [];
    var chartData1 = [];
    var chartData2 = [];

    $.ajaxSettings.traditional = true;

    $.ajax({
        type: "POST",
        url: "getEmployGrapeList.do",
        dataType: "JSON",
        async: false,
        success: function(res) {
            $.each(res.employLineData, function(inx, obj) {
                chartLabels.push(obj.employTitle);
                chartData1.push(obj.employTotal);
                chartData2.push(obj.employSejong);
            });
        }
    });

    var config = {
        type: 'line',
        data: {
            labels: chartLabels,
            datasets: [{
                label: "고용률(전국)",
                backgroundColor: window.chartColors.red,
                borderColor: window.chartColors.red,
                pointRadius: 5,
                lineTension: 0,
                data: chartData1,
                fill: false,
            }, {
                label: "고용률(세종)",
                fill: false,
                backgroundColor: window.chartColors.blue,
                borderColor: window.chartColors.blue,
                pointRadius: 5,
                lineTension: 0,
                data: chartData2,
            }]
        },
        options: {
            responsive: true,
            hover: {
                mode: 'nearest',
                intersect: true
            },
            tooltips: {
                mode: 'index',
                intersect: false,
                backgroundColor:'rgba(128, 128, 128, 1.0)'
            },
            scales: {
                xAxes: [{
                    display: true
                }],
                yAxes: [{
                    display: true
                }]
            }
        }
    };

    var ctx = document.getElementById("canvas").getContext("2d");
    
    if(window.myLine) {
    	window.myLine.destroy();
    }
    
    window.myLine = new Chart(ctx, config);
}