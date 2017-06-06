<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
	<head>
		<script src="http://localhost:8080/webjars/jquery/3.2.0/jquery.min.js"></script>
		<script src="http://localhost:8080/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="http://localhost:8080/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title><tiles:getAsString name="title"/></title>
	</head>
    <body>
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
    </body>
</html>