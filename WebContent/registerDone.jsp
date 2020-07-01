<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- User情報を取得 --%>
<%@ page import="model.User"%>
<%-- セッションスコープのインスタンスを取得 --%>
<% User user = (User) session.getAttribute("user"); %>
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
<% String message = (String) request.getAttribute("message");%>
<% boolean existMail = (boolean) request.getAttribute("existMail");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerDone</title>
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
<div id="index" align="center">
<table class="index">
<tr>
  <th style="text-align: center; font-size: large;">
<br>
<i>＊ 登録結果 ＊　　</i>
  </th></tr>
<tr><td>
  <!-- 新規登録成功した場合の出力 -->
  <%
    if (existMail == false) {
  %>
  <p>ようこそ<%= name %>さん</p>
  <p>Pass : <%= passCode %></p>
  <p>Mail : <%= mail %></p>
<br>
  <p style="color:green">会員登録が完了しました！</p>
<br>

<br>
  <p>
    <a href="/matrixGameIntegral/StartServlet">ゲーム選択画面へ</a>
  </p>
  <% } else { %>
  <!-- 新規登録失敗した場合の出力 -->
  <p>登録失敗</p>
<p style="text-align: center; color: deeppink;" class = "message"><b><%= message %></b></p>
<br>
  <p>
    <a href="/mailRegister/RegisterServlet">新規登録へ戻る</a>
  </p>
  <% } %>
<br>
  <!-- ログアウト処理 -->
  <p>
    <a href="/matrixGameIntegral/LogoutServlet">ログアウト</a>
  </p>
<br>
  <p>
    <a href="mailRegister/RegisterServlet">トップへ戻る</a>
  </p>
</td></tr></table>
</div>
</body>
</html>