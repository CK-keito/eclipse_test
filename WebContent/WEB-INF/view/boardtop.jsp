<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Bean.BoardBean"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>掲示板</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>


	<a href="/keiziban/managementtop"><button>管理画面</button></a>


	<span id="view_time"></span>


	<form id="actionform" action="/keiziban/boardresult" enctype="multipart/form-data"  method="post">

		<p>投稿者</p>
		<br> <input type="text" id="text1" name="name"><br>

		<p>メールアドレス</p>
		<br> <input type="email" id="text2" name="mail"><br>

		<p>アップロード</p><br>

		<input type="file" id="file"name="file" ><br/>

		<p>内容</p>
		<br> <input type="text" id="text3" name="content"><br>
		<input type="submit" value="投稿"><br>

	</form>

	<%
ArrayList<BoardBean> list = (ArrayList<BoardBean>)request.getAttribute("list_board");

String time_edit;

	for(int i = 0; i < list.size(); i++){
		BoardBean board = list.get(i);

		if(board.getTime_edit() == null){
			time_edit = "なし";
		}
		else{
			time_edit = board.getTime_edit();
		}

%>

	<p>投稿内容:
		<%=board.getContent()%><br>
		投稿者：
		<%=board.getName() %>
		　mail:
		<%=board.getMail() %>
		　投稿時間:
		<%=board.getTime_contribute() %>
		　編集時間:<%=time_edit %>



		</p>

		<%
		if(board.getApp_file() != null){
			if(board.getApp_file().contains(".png") || board.getApp_file().contains(".jpg") || board.getApp_file().contains(".PNG") || board.getApp_file().contains(".JPG")){

				%>
				<img src="./upload/<%=board.getApp_file()%>"><br>
		  <%}
			else{%>
				<a href="./upload/<%=board.getApp_file()%>"><%=board.getApp_file()%></a><br>
			<%}

		}



	}

%>







	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

	<script>
var text1;
var text2;
var text3;
function gettext(){
text1  = document.getElementById("text1").value;

text2  = document.getElementById("text2").value;

text3  = document.getElementById("text3").value;
}

var file;
function getfile(){
	 file = document.getElementById("file").value;
}



$('#actionform').submit(function(){
	gettext();
	getfile();

	if(text1 === "" || text2 === "" || text3 === ""){

		alert('入力エラー   ※すべての項目を入力してください');
		return false;
	}
	else if(!(file.match(/.elsx/) || file.match(/.docx/) || file.match(/.pdf/) || file.match(/.ppt/) || file.match(/.pptx/) || file.match(/.png/) || file.match(/.jpg/)) && !(file.equals(""))){

		alert('入力エラー   ※選択されたファイルはアップロードできません');
		return false;

	}
	/*else if(!(~file.indexOf(".elsx") || ~file.indexOf(".docx") || ~file.indexOf(".pdf") || ~file.indexOf(".ppt")|| ~file.indexOf(".pptx")|| ~file.indexOf(".png")|| ~file.indexOf(".jpg"))){

		alert('入力エラー   ※選択されたファイルはアップロードできません');
		return false;
	}*/


	else{
		return true;
	}
});





</script>

</body>
</html>