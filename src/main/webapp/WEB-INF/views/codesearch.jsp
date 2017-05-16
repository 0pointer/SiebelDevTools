<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<?xml version="1.0"?>
<html>
  <head>
    <script src="http://localhost:8080/webjars/jquery/3.2.0/jquery.min.js"></script>
    <script src="http://localhost:8080/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://localhost:8080/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Hello world Example</title>
  </head>
  <body>
    <%@include file="includes/header.jsp" %>
    <div class="container">
        <form class="form-horizontal">
          <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Suchanfrage: </label>
            <div class="col-sm-10">
              <input type="email" class="form-control" id="inputEmail3" placeholder="Eingabe">
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-default">Suche ausführen</button>
            </div>
          </div>
        </form>
    </div>
  </body>
</html>