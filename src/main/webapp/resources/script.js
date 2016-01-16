var url = "http://ec2-54-153-47-168.us-west-1.compute.amazonaws.com:8080";


function subscribe() {

	var email = $("#nlt_email").val();
	if (validateEmail(email) == 1) {
		$("#email_error").text("Incorrect email");
		$("#email_error").css("color", "red");
		$("#email_error").css("display", "block");
	} else {

		$.ajax({
			type : 'get',
			url : url + '/subscribe',
			data : {
				'email' : email
			},
			dataType : "json",
			contentType : 'application/json',
			cache : false,
			success : function(data) {

				if (data == 0) {
					$("#email_error").text(
							"You are already subscribed to updates");
					$("#email_error").css("color", "red");
					$("#email_error").css("display", "block");
				} else if (data == 1) {
					$("#email_error").text(
							"You are successfully subscribed to updates");
					$("#email_error").css("color", "#c2a67f");
					$("#email_error").css("display", "block");
				}

			},
			error : function(XmlHttpRequest, textStatus, errorThrown) {
			}
		});
	}
}

function add_picture() {

	$("#upload_status").text("Uploading...");
	$("#upload_status").css("display", "block");
	var pic_desc = $("#pic_desc").val();
	var pic_url = $("#pic_url").val();

	$.ajax({
		type : 'get',
		url : url + '/uploadpicture',
		data : {
			'desc' : pic_desc,
			'url' : pic_url
		},
		dataType : "json",
		contentType : 'application/json',
		cache : false,
		success : function(data) {

			if (data == 0) {
				$("#upload_status").text("Uploading failed");
				$("#upload_status").css("display", "block");
			} else if (data == 1) {
				$("#upload_status").text("File successfully uploaded");
				$("#upload_status").css("display", "block");
			}

		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {
		}
	});

}

function add_video() {

	$("#v_upload_status").text("Uploading...");
	$("#v_upload_status").css("display", "block");
	var pic_desc = $("#vid_desc").val();
	var pic_url = $("#vid_url").val();

	$.ajax({
		type : 'get',
		url : url + '/uploadvideo',
		data : {
			'desc' : pic_desc,
			'url' : pic_url
		},
		dataType : "json",
		contentType : 'application/json',
		cache : false,
		success : function(data) {

			if (data == 0) {
				$("#v_upload_status").text("Uploading failed");
				$("#v_upload_status").css("display", "block");
			} else if (data == 1) {
				$("#v_upload_status").text("File successfully uploaded");
				$("#v_upload_status").css("display", "block");
			}

		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {
		}
	});

}

function validateEmail(email) {
	/*
	 * checking email/ Email must have @, dot . after @, and at least 2 sumbols
	 * after @
	 */
	var result = 0;
	var atpos = email.indexOf("@");
	var dotpos = email.lastIndexOf(".");
	if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length
			|| email.length < 6) {
		result = 1;
	}
	return result;
}

function getNewsCount(page) {

	$.ajax({
		type : 'get',
		url : url + '/news/getnewscount',
		data : {
			'page' : page
		},
		dataType : "json",
		contentType : 'application/json',
		cache : false,
		success : function(data) {
			$("#news").empty();
			drawNews(data);

		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {
		}
	});

}

/* get news */
function getLastNews() {

	$.ajax({
		type : 'get',
		url : url + '/getlast',
		dataType : "json",
		contentType : 'application/json',
		cache : false,
		success : function(data) {
			$("#news").html("");
			drawNewsItem(data);

		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {
		}
	});
}

var newsCount = 0;

function drawNews(data) {
	for (var i = data.length - 1; i > -1; i--) {
		drawNewsItem(data[i]);
	}
}

function drawNewsItem(rowData) {

	var date = new Date(rowData.newsDate);
	date.yyyymmdd();

	var row = $("<div id='news_title'>"
			+ rowData.newsTitle
			+ "</div><div id='news_text'>"
			+ rowData.newsText
			+ "</div><div id='news_date'><div class='glyphicon glyphicon-calendar'></div>"
			+ date.yyyymmdd() + "</div><div id='news_author'></div> ");
	$("#news").append(row);

	var line = $("<div class='bot_line'></div>");
	$("#news").append(line);

}

Date.prototype.yyyymmdd = function() {
	var yyyy = this.getFullYear().toString();
	var mm = (this.getMonth() + 1).toString(); // getMonth() is zero-based
	var dd = this.getDate().toString();

	var hh = this.getHours().toString();
	var min = this.getMinutes().toString();
	var ss = this.getSeconds().toString();
	return yyyy + "-" + (mm[1] ? mm : "0" + mm[0]) + "-"
			+ (dd[1] ? dd : "0" + dd[0]) + " " + (hh[1] ? hh : "0" + hh[0])
			+ ":" + (min[1] ? min : "0" + min[0]) + ":"
			+ (ss[1] ? ss : "0" + ss[0]); // padding
};

function send_report() {
	var subject = $("#subject").val();
	var content = $("#content").val();

	if (subject.length < 4) {
		document.getElementById('parent_popup3').style.display = 'block';
	} else if (content.length < 10) {
		document.getElementById('parent_popup4').style.display = 'block';
	} else {
		$
				.ajax({
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
						document.getElementById('parent_popup').style.display = 'block';
						$("#subject").val("");
						$("#content").val("");
					},
					error : function(XmlHttpRequest, textStatus, errorThrown) {
						document.getElementById('parent_popup2').style.display = 'block';
					}
				});
	}

}
