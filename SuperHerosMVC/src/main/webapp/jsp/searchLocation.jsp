<%-- 
    Document   : searchLocation
    Created on : May 21, 2019, 9:02:26 AM
    Author     : benli
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Super Hero Catalog</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                	<li role="presentation"><a href="${pageContext.request.contextPath}/displayHeroList">Heros</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displaySearchHero">Find Hero</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySearchLocation">Search By Location</a></li>
                </ul>    
            </div>
            <h2>Search By Location:</h2>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>