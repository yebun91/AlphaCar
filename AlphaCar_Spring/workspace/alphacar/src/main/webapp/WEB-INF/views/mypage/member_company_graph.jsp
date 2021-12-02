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
      <h1>가게 이름이 나타나는 곳</h1>
      <div class="company_graph">
      	<canvas  id="myChart"></canvas>
      </div>
    </div>
  </main>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.js"></script>
  
  <script type="text/javascript">
	//canvas 가져오기
  const canvas = document.querySelector("#myChart");

  // context 등록!
  const context = canvas.getContext("2d");
  const ctx = document.getElementById('myChart');
  
  const DATA_COUNT = 7;
  const NUMBER_CFG = {count: DATA_COUNT, min: -100, max: 100};

  const labels = Utils.months({count: DATA_COUNT});
  const data = {
    labels: labels,
    datasets: [
      {
        label: 'Dataset 1',
        data: Utils.numbers(NUMBER_CFG),
        borderColor: Utils.CHART_COLORS.red,
        backgroundColor: Utils.transparentize(Utils.CHART_COLORS.red, 0.5),
        tension: 0.4,
      },
      {
        label: 'Dataset 2',
        data: Utils.numbers(NUMBER_CFG),
        borderColor: Utils.CHART_COLORS.blue,
        backgroundColor: Utils.transparentize(Utils.CHART_COLORS.blue, 0.5),
        tension: 0.2,
      }
    ]
  };
  
  const actions = [
	  {
	    name: 'Randomize',
	    handler(chart) {
	      chart.data.datasets.forEach(dataset => {
	        dataset.data = Utils.numbers({count: chart.data.labels.length, min: -100, max: 100});
	      });
	      chart.update();
	    }
	  },
	  {
	    name: 'Add Dataset',
	    handler(chart) {
	      const data = chart.data;
	      const dsColor = Utils.namedColor(chart.data.datasets.length);
	      const newDataset = {
	        label: 'Dataset ' + (data.datasets.length + 1),
	        backgroundColor: Utils.transparentize(dsColor, 0.5),
	        borderColor: dsColor,
	        data: Utils.numbers({count: data.labels.length, min: -100, max: 100}),
	      };
	      chart.data.datasets.push(newDataset);
	      chart.update();
	    }
	  },
	  {
	    name: 'Add Data',
	    handler(chart) {
	      const data = chart.data;
	      if (data.datasets.length > 0) {
	        data.labels = Utils.months({count: data.labels.length + 1});

	        for (let index = 0; index < data.datasets.length; ++index) {
	          data.datasets[index].data.push(Utils.rand(-100, 100));
	        }

	        chart.update();
	      }
	    }
	  },
	  {
	    name: 'Remove Dataset',
	    handler(chart) {
	      chart.data.datasets.pop();
	      chart.update();
	    }
	  },
	  {
	    name: 'Remove Data',
	    handler(chart) {
	      chart.data.labels.splice(-1, 1); // remove the label first

	      chart.data.datasets.forEach(dataset => {
	        dataset.data.pop();
	      });

	      chart.update();
	    }
	  }
	];
  
  const config = {  
		  type: 'line',
		  data: data,
		  options: {
		    animations: {
		      radius: {
		        duration: 400,
		        easing: 'linear',
		        loop: (context) => context.active
		      }
		    },
		    hoverRadius: 12,
		    hoverBackgroundColor: 'yellow',
		    interaction: {
		      mode: 'nearest',
		      intersect: false,
		      axis: 'x'
		    },
		    plugins: {
		      tooltip: {
		        enabled: false
		      }
		    }
		  },
		};
  const chart = new Chart(ctx, config, actions);
  
  
  
  </script>
  
