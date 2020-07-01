<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%User user = (User) session.getAttribute("user");%>
<% String name = user.getName();%>
<% String pass = user.getPass();%>
<% String mail = user.getMail(); %>

<% // ---- make passCode with passLength ----
   int passLength = pass.codePointCount(0, pass.length());
   StringBuilder passCode = new StringBuilder();

   for (int i = 1; i <= passLength; i++){
       passCode.append("*");
   }//for
%>
<!-- Userのセッションスコープを獲得 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>matrix登録画面</title>
<link rel="stylesheet" href="indexStyle.css">
</head>
<body>
<!-- Upper Section -->
<div id="upper">
<hr color="white" size="5">
<h1><i>＊ Honey Sea ＊　</i></h1>
<hr color="white" size="5">
</div>
<br>
<br>
<br>
<div id="index" align="center">
<table class="index">
<tr>
  <th style="text-align: center; font-size: large;">
<i>＊ 登録内容確認 ＊　　</i>
  </th></tr>
<tr><td>
  <p>ユーザー名　：<%= name %></p>
  <p>パスワード　：<%= passCode %></p>
  <p>Mailアドレス：<%= mail %></p>
<br>
<br>
<p>上記の内容で登録しますか？</p>
<p><a href="/mailRegister/RegisterServlet?action=done">登録する</a></p>
<p><a href="/mailRegister/RegisterServlet">戻る</a></p>

</td></tr></table>
</div>
</body>
</html>