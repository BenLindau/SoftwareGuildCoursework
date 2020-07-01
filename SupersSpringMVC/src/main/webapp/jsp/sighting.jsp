<%-- 
    Document   : addSighting
    Created on : May 27, 2019, 8:10:58 PM
    Author     : benli
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hero List</title>
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
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySightings">Sightings</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizations">Organizations</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/login">Login</a></li>
                </ul>    
            </div>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <p>Hello : ${pageContext.request.userPrincipal.name}
                | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
                </p>
            </c:if>
        <h2>Sightings</h2>
        <div>
            
            <div class="row">
                <div class="col-md-6">
                    <table id="sightingTable" class="table table-hover">
                        <tr>
                            <th width="33%">Hero</th>
                            <th width="33%">Location</th>
                            <th width="33%">Date</th>
                        </tr>
                        <c:forEach var="currentSighting" items="${sightingList}">
                            <tr>
                                <td><a href="displayHeroDetails?heroId=${currentSighting.heroId}">
                                       <c:out value="${currentSighting.heroId}"/></a></td>
                                <td><a href="displayLocationDetails?locationId=${currentSighting.locationId}">
                                       <c:out value="${currentSighting.locationId}"/></a></td>
                                <td><c:out value="${currentSighting.date}" /></td>   
                                <sec:authorize access="hasRole('ROLE_USER')">
                                <td><a href="dislpayEditSightingForm?sightingId=${currentSighting.sightingId}">
                                       Edit</a></td>
                            </sec:authorize>           
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td><a href="deleteSighting?sightingId=${currentSighting.sightingId}">
                                       Delete</a></td> 
                            </sec:authorize>
                            </tr> 
                        </c:forEach>
                    </table>
                </div>
            
            <div class="col-md-6">
                <sec:authorize access="hasRole('ROLE_USER')">
                <h2>Add Sighting</h2>
                <form class="form-horizontal" role="form" method="POST" action="createSighting">
                    <div class="form-group">
                            <label for="add-heroId" class="col-md-4 control-label">Hero:</label>
                            <select id="add-heroId" name="heroId">
                                <c:forEach var="currentHero" items="${heroList}">
                                    <option value="${currentHero.heroId}" >${currentHero.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="add-locationId" class="col-md-4 control-label">Location:</label>
                            <select id="add-locationId" name="locationId">
                                <c:forEach var="currentLocation" items="${locationList}">
                                    <option value="${currentLocation.locationId}">${currentLocation.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    <div class="form-group">
                            <label for="add-date" class="col-md-4 control-label">Date:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="date" placeholder="mm/dd/yyyy" />
                            </div>
                        </div>
                    <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Add Sighting"/>
                            </div>
                        </div>
                </form>
                </sec:authorize>
            </div> 
            </div>
        </div>
    </body>
</html>
