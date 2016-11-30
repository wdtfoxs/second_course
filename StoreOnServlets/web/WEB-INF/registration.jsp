<%@ page import="BaseOfData.entitys.Product" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: nikk
  Date: 09.11.2015
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<html lang="ru">
<head>
  <meta charset="utf-8">
  <title>Регистрация</title>
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
        %>
            <li><a href="/bucket"><b><img src="/resources/image/bucket.png" width="24" height="24"> <span class="badge"><%=count%></span></b></a></li>
            <li><a href="/login" >Войти</a></li>
            <li><a href="/registration">Зарегистрироваться</a></li>
    </div>
  </div>
</nav>

<div class="container">
  <div class="page-header">
    <h1>Регистрация</h1>
  </div>
  <form class="form-horizontal" action="/registration" method="post">
    <div class="form-group">
      <label class="col-sm-2 control-label">Логин</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" name="login" id="login" placeholder="Логин" onchange="validateLogin()">
        <span id="checkLogin"></span>
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">Email</label>
      <div class="col-sm-6">
        <input type="email" class="form-control" name="email" id="email" placeholder="Email">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">Пароль</label>
      <div class="col-sm-6">
        <input type="password" class="form-control" name="password" id="password" placeholder="Введите пароль" onchange="validatePassword()">
        <span id="checkPassword"></span>
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-2 control-label">Повторите пароль</label>
      <div class="col-sm-6">
        <input type="password" class="form-control" name="RePassword" id="RePassword" placeholder="Введите пароль">
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
        <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
      </div>
    </div>
  </form>
  <%
    String registration = (String) request.getSession().getAttribute("registration");
    if (registration == null) {

    }
    else {
          if (registration.equals("false")) {%>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <h3><span class="label label-danger">Данное имя или email уже заняты</span></h3>
        </div>
      </div>
      <%request.getSession().setAttribute("registration", null);%>
      <%}
      else {
        if (registration.equals("wrong")){%>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <h3><span class="label label-danger">Введены неверные данные</span></h3>
        </div>
      </div>
      <%}request.getSession().setAttribute("registration", null);%>
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
