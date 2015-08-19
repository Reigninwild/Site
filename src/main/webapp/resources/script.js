var url = "http://app-reigninwild.rhcloud.com/reign";

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

var rowID=1;
function add_material(){
	
	
	var item="<label>material</label><br>";
	var select = $("#select").html();
	
	var count ="<input type='text' value='count' text='count' id='count"+rowID+"'/><hr>";

	$("#craft_materials").append(item);
	$("#craft_materials").append(select);
	$("#craft_materials").append(count);
	
	rowID++;
	
}

function addcraft(){
	$(".materials_select").each(function (index){
		if (index !=0) {
		material=$(this).val();
		item = $("#targetMaterial").val();
		count = $("#count"+index+"").val();

		addCraftMaterial(item,material,count);
		}
	});
	
}

function addCraftMaterial(craft_id,material_id,count){
	console.log("add "+craft_id+" "+material_id+" "+count);

	$.ajax({
		type : 'GET',
		url : url + '/savecraft',
		dataType : "json",
		data : {
			'craft_id' : craft_id,
			'material_id' : material_id,
			'count' : count
			
		},
		contentType : 'application/json',
		cache : false,
		success : function(data) {
			location.reload();
		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {

			 console.log("standings error= " + errorThrown);

		}
	});
}

function showMaterialsType(type){
	
	$(".materials_types").css("display","none");
	$(".materials_list").css("display","block");
	//$(".materials_list").children().remove();
	
	$.ajax({
		type : 'GET',
		url : url + '/getmaterialstype',
		dataType : "json",
		data : {
			'type' : type
			
		},
		contentType : 'application/json',
		cache : false,
		success : function(data) {
			drawMaterials(data);
		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {

		}
	});
}

function backitems(){
	$(".materials_types").css("display","block");
	$(".materials_list").css("display","none");	
}


function getCraftMaterials(id){

	$.ajax({
		type : 'GET',
		url : url + '/getmaterialscraft',
		dataType : "json",
		data : {
			'id' : id
			
		},
		contentType : 'application/json',
		cache : false,
		success : function(data) {
			drawCraftMaterials(data);
		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {
		}
	});
}

function drawMaterials(data) {
	$(".item_record").remove();
	$(".show_sub_button").remove();

	
	for (var i = 0; i < data.length; i++) {
		drawMaterial(data[i]);
	}
}
function drawMaterial(rowData) {
	//var row = $("<div class='container'><div class='item_img'><img src='"+ctx+"/resources/images/materials/"+rowData.materialPic+"' /> </div><div class='item_name'>"+rowData.materialName+"</div><div class='item_desc'>"+rowData.materialDesc+"</div></div>");

	//var row = $("<tr> <td width='80px'></td> <td> <table><tr><td></td></tr> <tr><td><div class='item_desc'>"+rowData.materialDesc+"</div></td></tr></table> </td> </tr>");
	var row = $("<div class='item_record' id='"+rowData.materialID+"'><div class='row'><div class='col-xs-8'><div class='item_name'>"+rowData.materialName+"</div></div></div> <div class='row' > <div class='col-xs-2'><img class='item-img' height='70' width='70' src='"+ctx+"/resources/images/materials/"+rowData.materialPic+"' /> </div><div class='col-xs-10'><div class='item_desc'>"+rowData.materialDesc+"</div> </div></div></div>");
	
	$(".materials_list").append(row);
	
	$(".materials_list").append($("<div class='show_sub_button' onclick='show_sub_items("+rowData.materialID+")'><div class='show_sub'></div></div>"));
	
	//get materials to craft this item
	getCraftMaterials(rowData.materialID);
	

}
function show_sub_items(id){
	if ($("#sub_item"+id+"").css("display")=="none"){
		$("#sub_item"+id+"").css("display","block");
	} else{
		$("#sub_item"+id+"").css("display","none");
	}
	
}

function drawCraftMaterials(data){
	var block = $("<div class='sub_items' id ='sub_item"+data[0].item.materialID+"'></div>");
	$("#"+data[0].item.materialID+"").append(block);
	for (var i = 0; i < data.length; i++) {
		drawCraftMaterialsItems(data[i]);
		
	}
	$("#"+data[0].item.materialID+"").append($("<div class='row'></div>"));
	
	
	//var outer = $("<div class=''></div>");
}

function drawCraftMaterialsItems(rowData){
	var row = $("<div class='row'><div class='col-xs-12'><div class='item_small_name'><img height='60' width='60' src='"+ctx+"/resources/images/materials/"+rowData.material.materialPic+"' />"+rowData.material.materialName+"</div><div class='item_count'> x"+rowData.materialCount+"</div> </div></div>");
	
	
	
	$("#sub_item"+rowData.item.materialID+"").append(row);
	
}

function send_report(){
	var subject = $("#subject").val();
	var content = $("#content").val();
	
	if (subject.length < 4) {
		document.getElementById('parent_popup3').style.display='block';
	} else if (content.length < 10){
		document.getElementById('parent_popup4').style.display='block';
	} else {
		$.ajax({
			type : 'GET',
			url : url + '/sendemail',
			dataType : "json",
			data : {
				'content' : content,
				'subject' : subject
			},
			contentType : 'application/json',
			cache : false,
			success : function(data) {
				document.getElementById('parent_popup').style.display='block';
				$("#subject").val("");
				$("#content").val("");
			},
			error : function(XmlHttpRequest, textStatus, errorThrown) {
				document.getElementById('parent_popup2').style.display='block';
			}
		});
	}
	
	
	



}

