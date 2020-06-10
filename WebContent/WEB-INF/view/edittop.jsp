<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Bean.BoardBean"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>掲示板/編集画面</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>

<a href="/keiziban/boardtop"><button>TOPに戻る</button></a>
	<%
HttpSession session1 = request.getSession();
BoardBean bb = (BoardBean)session1.getAttribute("edit_board");


%>

<form id="actionform" action="/keiziban/boardeditresult" method="post">

	投稿者名:<input type="text" id="name" name="name" value="<%=bb.getName()%>">
	メールアドレス:<input type="text" id="mail" name="mail" value="<%=bb.getMail()%>">
	内容:<input type="text" id="content" name="content" value="<%=bb.getContent()%>">


	<input type="submit" value="変更">
</form>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>


	<script>
var name;
var mail;
var content;
function gettext(){
name  = document.getElementById("name").value;

mail  = document.getElementById("mail").value;

content  = document.getElementById("content").value;
}



$('#actionform').submit(function(){
	gettext();

	if(name === "" || mail === "" || content === ""){

		alert('入力エラー   ※すべての項目を入力してください');
		return false;
	}
	else{

		return true;
	}
});





</script>





</body>
</html>