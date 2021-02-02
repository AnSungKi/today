            /* Graph Script */
            function fn_IntrolineChartDraw() {
                var dataset = new Array();
                var chartLabels = [];
                var chartData1 = [];
                var chartData2 = [];
                
                $.ajaxSettings.traditional = true;
                
                $.ajax({
                    type: "POST",
                    url: "getJobIntroduceGrapeList.do",
                    dataType: "JSON",
                    async: false,
                    success: function(res) {
                        $.each(res.jobIntroduceLineData, function(inx, obj) {
                            chartLabels.push(obj.jobMonth);
                            chartData1.push(obj.jobIntro);
                            chartData2.push(obj.jobEmploy);
                        });
                    }
                });

                var config = {
                    type: 'line',
                    data: {
                        labels: chartLabels,
                        datasets: [{
                            label: "알선",
                            backgroundColor: window.chartColors.red,
                            borderColor: window.chartColors.red,
                            pointRadius: 5,
                            lineTension: 0,
                            data: chartData1,
                            fill: false,
                        }, {
                            label: "취업",
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