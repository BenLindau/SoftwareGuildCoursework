6<%-- 
    Document   : editSighting
    Created on : May 30, 2019, 2:58:41 PM
    Author     : benli
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>EditOrganizations</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
        <style>
            body {
           background-image: url("${pageContext.request.contextPath}/img/Superman-Batman-Wallpapers.jpg");
           }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Super Hero Catalog</h1>
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
            <h2>Edit Sighting:</h2>
        </div>
                
        <sf:form class="form-horizontal" role="form" method="POST"
            action="editSighting" modelAttribute="sighting"> 
             <sf:input type="hidden" path="sightingId" />
                        
                <div class="form-group">
                <label for="add-heroId" class="col-md-4 control-label">Hero:</label>
                <sf:select id="add-heroId" path="heroId">
                                <c:forEach var="currentHero" items="${heroList}">
                                    <option value="${currentHero.heroId}" >${currentHero.name}</option>
                                </c:forEach>
                </sf:select>
                </div>
                <div>
                            <label for="add-locationId" class="col-md-4 control-label">Location:</label>
                            <sf:select id="add-locationId" path="locationId">
                                <c:forEach var="currentLocation" items="${locationList}">
                                    <option value="${currentLocation.locationId}" >${currentLocation.name}</option>
                                </c:forEach>
                            </sf:select>
                        </div>
                <div class="form-group">
                    <label for="add-date" class="col-md-4 control-label">Date:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-date"
                                  path="date" placeholder="Date"/>
                    </div>
                    </div>
                <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Edit Sighting"/>
                            </div>
                        </div>
                    
            </sf:form>
               
        
                
        
    </body>
</html>
