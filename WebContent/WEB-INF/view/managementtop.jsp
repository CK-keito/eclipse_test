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

	<a href="/keiziban/boardtop"><button>TOPに戻る</button></a>
	<%
		ArrayList<BoardBean> list = (ArrayList<BoardBean>) request.getAttribute("list_board");

		String time_edit;

		for (int i = 0; i < list.size(); i++) {
			BoardBean board = list.get(i);

			if (board.getTime_edit() == null) {
				time_edit = "なし";
			} else {
				time_edit = board.getTime_edit();
			}
	%>

	<p>
		投稿内容:
		<%=board.getContent()%><br> 投稿者：
		<%=board.getName()%>
		mail:
		<%=board.getMail()%>
		投稿時間:
		<%=board.getTime_contribute()%>
		編集時間:<%=time_edit%>

	</p>
<%


			if(board.getApp_file().contains(".png") || board.getApp_file().contains(".jpg") || board.getApp_file().contains(".PNG") || board.getApp_file().contains(".JPG")){

				%>
				<img src="./upload/<%=board.getApp_file()%>"><br>
		  <%}
			else{%>
				<a href="./upload/<%=board.getApp_file()%>"><%=board.getApp_file()%></a><br>
			<%}

		%>

	<div style="display: inline-flex">

		<form class="buttonform1" action="/keiziban/boardedit" method="post">

			<input type="hidden" name="edit" value="<%=board.getId()%>">


			<input type="submit" value="編集">

		</form>

		<form class="buttonform2" action="/keiziban/boarddelete" method="post">

			<input type="hidden" name="delete" value="<%=board.getId()%>">


			<input type="submit" value="削除">

		</form>

	</div>


<%
}
%>

	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

	<script>
		$('.buttonform1').submit(function() {
			var result = window.confirm("編集します。よろしいですか");

			if (result) {
				return true;
			} else {
				return false;
			}
		});

		$('.buttonform2').submit(function() {
			var result = window.confirm("削除します。よろしいですか");

			if (result) {
				return true;
			} else {
				return false;
			}
		});
	</script>


</body>
</html>