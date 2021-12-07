<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="mypage_image">
    </div>
    <div class="mypage_select">
      <div class="mypage_userinfo">
        <a href=""><p class="mypage_userinfo_select">회원정보</p></a>
        <a href=""><p>보안설정</p></a>
      </div>
    </div>
  </nav>
  <!-- 메인 시작 -->
  <main class="mypage">
    <div id="page">
      <h3>가게 이름이 나타나는 곳</h3>
      <div class="company_graph">
      	<canvas  id="myChart"></canvas>
      </div>
    </div>
  </main>
  
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
	<script type="text/javascript" src='js/chart.js'></script>
  
  <script type="text/javascript"  charset="UTF-8">
		
	  var arrLabel ;
			var arrData ;
			var arrtitle ;
			var arrcolor ;
			$.ajax({
				   type: "POST",
				   dataType: "json",
				   url: "month_list",
				   success: function( response ) 
				   { 
					 
					    arrLabel = new Array(response.length);
					    arrData = new Array(response.length);
					    arrtitle= new Array(response.length);
					    arrcolor= new Array(response.length);
					    for (var i=0; i<response.length; i++) {
							var data = ""
							var cnt = 0;
							arrLabel[i] = new Array(13);
							arrData[i] = new Array(13);
							for (key in response[i]) {
								if(key == 'title'){
									arrtitle[i]= response[i][key];
								}else if(key == 'color'){
									arrcolor[i]= response[i][key];
								}else{
									arrLabel[i][cnt] = key;
									arrData[i][cnt] = response[i][key];
									cnt ++ ;
								}
							
							
								
								
						  }
						
						}
					
					    initChart();
			      
				   },
				   error: function( error )
				   {
				     alert( error );
				   }
				});
			
			
			function initChart(){
			    var GraphDatasetsArray = [];
			    for (i=0; i < arrtitle.length; i++)
			    {
			    
			    GraphDatasetsArray[i] = 
			                        {
			                        label: arrtitle[i],
			                        data: arrData[i], 
			                        fill: false, 
			                        borderColor: 'rgba(255, 99, 132, 1)', 
			                        backgroundColor: arrcolor[i],
			                        pointBackgroundColor: '#ffffff', 
			                        tension: 0,
			                        }   
			    }
				var chartdata = {
					    labels:  arrLabel[0],
					    datasets: GraphDatasetsArray
					    	
					    
					};
			
					 
			
					//차트 옵션 설정(X,Y축)
					var chartOptions = {
					    scales: {
					        xAxes: [
					            {
					                ticks: {
					                    beginAtZero: true
					                },
					                scaleLabel: {
					                    display: true,
					                    labelString: "x축 텍스트",
					                    fontColor: "red"
					                },
					                stacked: true
					            }
					        ],
					        yAxes: [
					            {
					                scaleLabel: {
					                    display: true,
					                    labelString: "y축 텍스트",
					                    fontColor: "green"
					                },
					                ticks: {
					                    // max: 7000,
					                    min: 0,
					                    // stepSize: 1000,
					                    autoSkip: true
					                },
					                stacked: true
					            }
					        ]
					    },
					    responsive: true,
					    onClick: function(point, event) {
					          if(event.length <= 0) return;
			
					          console.log(event[0]['_index'])
					        }
					};
			
					 
			
					//차트 추가
					var ctx = document.getElementById("myChart");
					JsChartBar = new Chart(ctx, {
					    type: 'bar',
					    data: chartdata
					});
				
			}
		

	</script>
