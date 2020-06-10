<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.BoardBean" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>掲示板</title>
<link rel = "stylesheet"
href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.min.css">
</head>
<body>


    <a href="/keiziban/managementtop"><button>管理画面</button></a>


    <span id="view_time"></span>


    <form id="actionform" action="/keiziban/boardresult" method="post">

    <p>投稿者</p><br>
        <input type="text" id="text1"><br>

    <p>メールアドレス</p><br>
        <input type="e-mail" id="text2"><br>

    <p>内容</p><br>
        <input type="text" id="text3"><br>



        <input type="submit"  value="投稿"><br>

    </form>

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



$('#actionform').submit(function(){
	gettext();

	if(text1 === "" || text2 === "" || text3 === ""){

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