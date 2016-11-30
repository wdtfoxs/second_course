<%@ page import="BaseOfData.entitys.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="BaseOfData.entitys.Comment" %>
<%--
  Created by IntelliJ IDEA.
  User: nikk
  Date: 10.11.2015
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="utf-8">
  <title>Главная</title>
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/css/main.css" rel="stylesheet">
  <style type="text/css">
    .thumbnail{
      width: 1200px;
      height: auto;
      background-color: #FFFAFA;
    }
    .leftimg {
      float:left; /* Выравнивание по левому краю */
      margin: 7px 7px 7px 0; /* Отступы вокруг картинки */
    }
  </style>
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
          String logName = (String) request.getSession().getAttribute("logName");
          if (login != null &&login.equals("true")) {
            if (logName.equals("Admin")){
        %>
        <li><a><b>Привет, <%=logName%>!</b></a></li>
        <li><a href="/bucket"><b><img src="/resources/image/bucket.png" width="24" height="24"> <span class="badge"><%=count%></span></b></a></li>
        <li><a href="/add">Добавить товар</a></li>
        <li><a href="/logout"><b>Выйти</b></a></li>
        <%
        }else {
        %>
        <li><a><b>Привет, <%=logName%>!</b></a></li>
        <li><a href="/bucket"><b><img src="/resources/image/bucket.png" width="24" height="24"> <span class="badge"><%=count%></span></b></a></li>        <li><a href="/logout"><b>Выйти</b></a></li>
        <%
          }
        }
        else {
        %>
        <li><a href="/bucket"><b><img src="/resources/image/bucket.png" width="24" height="24"> <span class="badge"><%=count%></span></b></a></li>
        <li><a href="/login" >Войти</a></li>
        <li><a href="/registration">Зарегистрироваться</a></li>
        <%
          }
        %>
      </ul>
    </div>
  </div>
</nav>



<div class="container" id="tovar">
  <div class="row">
    <%
      Product product = (Product) request.getSession().getAttribute("product");
    %>
    <br>
      <div class="panel panel-default">
        <div class="col-sm-6 col-md-4">
                <a href="/product?id=<%=product.getId()%>"><img src="/resources/image/<%=product.getImage()%>" class="img-rounded" alt="Картинка товара" style="min-width:270px;width:270px;min-height:400px;height:400px;"></a>
        </div>
          <div class="panel-body">
            <h5><b>Название:</b> <%=product.getNameOfProduct()%></h5>
            <h5><b>Для кого:</b> <%=product.getPet()%></h5>
            <h5><b>Тип товара:</b> <%=product.getTypeOfProduct()%></h5>
            <h5><b>Цена:</b> <%=product.getPrice()%> руб.</h5>
            <h5><b>Описание:</b> <%=product.getDescription()%></h5>
            <%if (request.getSession().getAttribute("logName") != null && request.getSession().getAttribute("logName").equals("Admin")){%>
            <p><a href="/editProd?id=<%=product.getId()%>"><button type="submit" class="btn btn-warning">Редактировать</button></a>
            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#<%=product.getId()%>">Удалить</button></p>
            <%}else {%>
            <a href="/buy?id=<%=product.getId()%>"><p><button type="submit" class="btn btn-success">В корзину</button></p></a>
            <%}%>
          </div>

        <div class="panel-heading">
              <h4 align="center">Комментарии пользователей</h4>
        </div>
          <ul class="list-group">
            <%
            ArrayList<Comment> arrayList = (ArrayList) request.getSession().getAttribute("comments");
              if (arrayList != null){
              for(int i = (arrayList.size()-1); i>=0; i--) {
                Comment comment = arrayList.get(i);
            %>
            <li class="list-group-item"><h5><span class="glyphicon glyphicon-user"></span><b><%=comment.getName()%>:</b></h5> <%=comment.getComment()%></li>
            <%
              }
              }
            if (login != null &&login.equals("true")){
            %>
            <form action="/comment?id=<%=product.getId()%>&login=<%=logName%>" method="post">
              <li class="list-group-item"><textarea class="form-control" rows="3" name="comment" placeholder="Написать комментарий" maxlength="100"></textarea>
                <br>
                <p align="right"><button type="submit" class="btn btn-default">Добавить комментарий</button></p></li>
            </form>
            <%
            } else {
              %>
            <li class="list-group-item">
            <div class="alert alert-info" role="alert" align="center">Комментарии могут оставлять только зарегистрированные пользователи</div>
            </li>
            <div class="modal fade" tabindex="-1" role="dialog" id="<%=product.getId()%>">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title"><b>Удалить продукт</b></h4>
                  </div>
                  <div class="modal-body">
                    <p>Вы действительно хотите удалить данный товар?</p>
                  </div>
                  <div class="modal-footer">
                    <form action="/delete?id=<%=product.getId()%>" method="post"><button type="submit" class="btn btn-danger">Удалить</button></form>
                  </div>
                </div>
              </div>
            </div>
            <%
            }
            %>
          </ul>
        </div>
    </div>
  </div>
</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>