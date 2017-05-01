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
        <form:form modelAttribute="thread" action="merge" method="post" class="form-horizontal">
          <div class="form-group">
          <div class="row">
            <div class="col-md-4">
              <div class="input-group">
                <div class="input-group-addon">Von Version </div>
                <select path="version" class="form-control">
                  <option>52.1</option>
                  <option>53.0</option>
                  <option>53.1</option>
                  <option>54.0</option>
                </select>
              </div>
            </div>
            <div class="col-md-4">
              <div class="input-group">
                <div class="input-group-addon">Auf Version </div>
                <select class="form-control">
                  <option>52.1</option>
                  <option>53.0</option>
                  <option>53.1</option>
                  <option>54.0</option>
                </select>
              </div>
            </div>
            <div class="col-md-4">
              <button type="submit" class="btn btn-primary">Ausf&#xFC;hren</button>
            </div>
          </div>
          </div>
        </form:form>
    </div>
  </body>
</html>
