<%@ page import="BaseOfData.entitys.Product" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: nikk
  Date: 09.11.2015
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Добавление</title>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
<nav class="navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="/main" class="navbar-brand"><b>Все для домашних животных</b></a>
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
                        String logName = (String) request.getSession().getAttribute("logName");
                    %>
                    <li><a><b>Привет, <%=logName%>!</b></a></li>
                <li><a href="/bucket"><b><img src="/resources/image/bucket.png" width="24" height="24"> <span class="badge"><%=count%></span></b></a></li>
                    <li><a href="/add">Добавить товар</a></li>
                    <li><a href="/logout"><b>Выйти</b></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="page-header">
        <h1>Добавить товар</h1>
    </div>
    <form action="/add" method="post" class="form-horizontal" accept-charset="UTF-8">
        <div class="form-group">
            <label class="col-sm-2 control-label">Животное:</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" name="pet" placeholder="Животное">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Тип товара:</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" name="type" placeholder="Тип товара">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Название:</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" name="nameOfProduct" placeholder="Название">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Описание:</label>

            <div class="col-sm-6">
                <textarea class="form-control" rows="3" name="description" placeholder="Описание"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Цена:</label>

            <div class="col-sm-6">
                <input type="text" class="form-control" name="price" placeholder="Цена">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Картинка продукта:</label>
            <div class="col-sm-6">
                <input type="file" name="image">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </div>
    </form>
    <%
        String log = (String) request.getSession().getAttribute("log");
        if (log == null) {

        }
        else {
            if (log.equals("true")) {%>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <h3><span class="label label-default">Товар добавлен</span></h3>
                    </div>
                </div>
            <%} else {
                    if (log.equals("wrong")){%>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <h3><span class="label label-default">Введен неверный формат данных в строке "цена"</span></h3>
                            </div>
                        </div>
                    <%}else {%>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <h3><span class="label label-default">Данный товар с таким же описанием уже существет в базе</span></h3>
                            </div>
                        </div>
                        <%}%>
    <% }
    request.getSession().setAttribute("log", null);
    }
    %>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>