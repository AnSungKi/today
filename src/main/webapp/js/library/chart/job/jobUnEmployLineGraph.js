            /* Graph Script */
            function fn_UnEmplineChartDraw() {
                var chartLabels = [];
                var chartData1 = [];
                var chartData2 = [];
                
                $.ajaxSettings.traditional = true;
                
                 $.ajax({
                    type: "POST",
                    url: "getUnEmployGrapeList.do",
                    dataType: "JSON",
                    async: false,
                    success: function(res) {
                        $.each(res.unemployLineData, function(inx, obj) {
                            chartLabels.push(obj.unemployTitle);
                            chartData1.push(obj.unemployTotal);
                            chartData2.push(obj.unemploySejong);
                        });
                    }
                });

                var config = {
                        type: 'line',
                        data: {
                            labels: chartLabels,
                            datasets: [{
                                label: "실업률(전국)",
                                backgroundColor: window.chartColors.red,
                                borderColor: window.chartColors.red,
                                pointRadius: 5,
                                lineTension: 0,
                                data: chartData1,
                                fill: false,
                            }, {
                                label: "실업률(세종)",
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