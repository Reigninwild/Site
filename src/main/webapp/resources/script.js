var url = "http://localhost:8080/reigninwildWebApp";

function show_more() {

	if ($(".main_top_left").css("display") == "none") {

		$({
			deg : 90
		}).animate({
			deg : 0
		}, {
			duration : 200,
			step : function(now) {
				$('#more').css({
					transform : 'rotate(' + now + 'deg)'
				});
			}
		});
		//move logo
		$("#logo").animate({
			'margin-left' : "-=5",
		}, 200, function() {
			//turn off logo
			$("#logo").css("display", "none");
			
			//turn on block
			$(".main_top_left").css("display", "block");
			
			//move block
			$(".main_top_left").animate({

				'margin-left' : "+=400",

			}, 200, function() {
			});
		});
	} else {
		
		$({
			deg : 0
		}).animate({
			deg : 90
		}, {
			duration : 200,
			step : function(now) {
				$('#more').css({
					transform : 'rotate(' + now + 'deg)'
				});
			}
		});
	
		//move block
		$(".main_top_left").animate({
			'margin-left' : "-=400",
		}, 200, function() {
			//turn of block
			$(".main_top_left").css("display", "none");

			//turn on logo
			$("#logo").css("display", "block");
			//move logo
			$("#logo").animate({

				'margin-left' : "+=5",

			}, 200, function() {
				
			});
		});
	}
}

var newsCount=0;

/* get picks */
function getNews(number) {

	var count=0;
	if (number == 'newsCount') {
		count = newsCount+1;
	} else{
		count = number;
	}

	$.ajax({
		type : 'get',
		url : url + '/getnews',
		dataType : "json",
		data : {
			'count' : count
		},
		contentType : 'application/json',
		cache : false,
		success : function(data) {
			drawNews(data);
			newsCount=newsCount+data.length;
			
			if (data.length==0) $("#more_news").css('display','none');
			// alert(data);
		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {

			// alert("standings error= " + XmlHttpRequest.responseText);

		}
	});
}

function drawNews(data) {
	for (var i = 0; i < data.length; i++) {
		drawNewsItem(data[i], i + 1);
	}
}
function drawNewsItem(rowData) {
	var date = new Date(rowData.newsDate);
	var row = $("<div class='container'><div id='news_block'><div id='news_text'>"
					+ rowData.newsText
					+ "</div><div id='rline' onclick='fullnews("+rowData.newsID+","+JSON.stringify(rowData.newsText)+")'><div id='read_more'>Read more</div></div><div id='news_date'>"
					+ date.getDate()+"-"+(date.getMonth()+1) +"-"+date.getFullYear()
					+ "</div><div id='news_author'><div class='glyphicon glyphicon-user'></div>"
					+ rowData.uuser.username + "</div></div></div> ");
	$("#news").append(row);
	
	
}
function fullnews(id,text){
//	location.href = '${pageContext.request.contextPath}/leagues/${leaguename}/${standing.getSID().team.getName()}/roster }';

	document.location.href = url+"/news"+id;

}

function toNews(){
	document.location.href = url+"/index#news";
	//var top = $("#news").position().top;
	//$(window).scrollTop( top );
}

