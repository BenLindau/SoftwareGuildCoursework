<%-- 
    Document   : locationDetails
    Created on : May 27, 2019, 8:02:24 PM
    Author     : benli
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hero Details</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <style>
            body {
           background-image: url("${pageContext.request.contextPath}/img/Superman-Batman-Wallpapers.jpg");
           }
           p {
               color: white;
           }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Location Details</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation" ><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayHeroList">Heros</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayLocations">Locations</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightings">Sightings</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizations">Organizations</a></li>
                </ul>    
            </div>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <p>Hello : ${pageContext.request.userPrincipal.name}
                | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
                </p>
            </c:if>
            <h2>Location Details</h2>
            
            <div>
                <p> Name: <c:out value="${location.name}" /> </p>
                <p> Street:  <c:out value="${location.street}" /> </p>
                <p> City:  <c:out value="${location.city}" /> </p>
                <p> State:  <c:out value="${location.state}" /> </p>
                <p> ZipCode:  <c:out value="${location.zipCode}" /> </p>
                <p> Latitude:  <c:out value="${location.latitude}" /> </p>
                <p> Longitude:  <c:out value="${location.longitude}" /> </p>
            </div>
            
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
