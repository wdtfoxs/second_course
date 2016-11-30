<%@ page import="java.util.ArrayList" %>
<%@ page import="BaseOfData.entitys.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: nikk
  Date: 15.11.2015
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="utf-8">
  <title>Вход в систему</title>
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
<nav class="navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/main"><b>Все для домашних животных</b></a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <%
          ArrayList<Product> countBucket = (ArrayList) request.getSession().getAttribute("bucket");
          int count;
          if (countBucket != null){
            count = countBucket.size();
          }
          else {
            count = 0;
          }
          String login = (String) request.getSession().getAttribute("login");
        %>
        <li><a href="/bucket"><b><img src="/resources/image/bucket.png" width="24" height="24"> <span class="badge"><%=count%></span></b></a></li>        <li><a href="/login" >Войти</a></li>
        <li><a href="/registration">Зарегистрироваться</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
  <div class="page-header">
    <h1>Вход</h1>
  </div>
  <form class="form-horizontal" action="/login" method="post">
    <div class="form-group">
      <label class="col-sm-2 control-label">Логин:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" name="login" id="login" placeholder="Логин" onchange="validateLogin()">
        <span id="checkLogin"></span>
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">Пароль:</label>
      <div class="col-sm-6">
        <input type="password" class="form-control" name="password" id="password" placeholder="Введите пароль" onchange="validatePassword()">
        <span id="checkPassword"></span>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label>
            <input type="checkbox" name="remember"> Запомнить меня
          </label>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Войти</button>
        <a href="/registration" class="btn btn-primary">Зарегистрироваться</a>
      </div>
    </div>
  </form>
  <%
    if (login == null) {

    }
    else {
      if (login.equals("false")) {%>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <h3><span class="label label-danger">Неверный логин или пароль</span></h3>
          </div>
        </div>
        <%request.getSession().setAttribute("login", null);%>
    <%}
    else {
          if (login.equals("wrong")){%>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <h3><span class="label label-danger">Введены неверные данные</span></h3>
          </div>
        </div>
  <%}request.getSession().setAttribute("login", null);%>
  <% }
  }
  %>
</div>

<script type="text/javascript">
  function validateLogin(){
    var login = document.getElementById('login');
    var login_regexp = /^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$/;
    if(!login_regexp.test(login.value)){
      $("#checkLogin").text("Логин должен состоять более чем из одного символа и начинаться с буквы").css("color", "#696969");
    }
  }
  function validatePassword () {
    var password1 = document.getElementById('password');
    if(password1.value.length > 20){
      $("#checkPassword").text("Пароль содержит более 20 символов").css("color", "#696969");
    }
  }

</script>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
