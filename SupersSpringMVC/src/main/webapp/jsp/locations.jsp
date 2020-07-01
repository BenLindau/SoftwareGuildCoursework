<%-- 
    Document   : locations
    Created on : May 29, 2019, 8:15:05 AM
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
        <title>Location List</title>
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
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayHeroList">Heros</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayLocations">Locations</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightings">Sightings</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizations">Organizations</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/login">Login</a></li>
                </ul>    
            </div>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <p>Hello : ${pageContext.request.userPrincipal.name}
                | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
                </p>
            </c:if>
        <h1>Locations:</h1>
        <hr/>
        <div class="row">
            <div class="col-md-6">
                <table id="locationTable" class="table table-hover">
                    <tr>
                        <th width="5%">Id:</th>
                        <th width="15%">Name:</th>
                        <th width="15%">Street:</th>
                        <th width="15%">City:</th>
                        <th width="15%">State:</th>
                        
                    </tr>
                    <c:forEach var="currentLocation" items="${locationList}">
                        <tr>
                            <td><a href="displayLocationDetails?locationId=${currentLocation.locationId}">
                                    <c:out value="${currentLocation.locationId}" /></a></td>
                            <td><c:out value="${currentLocation.name}" /></td>
                            <td><c:out value="${currentLocation.street}" /></td>
                            <td><c:out value="${currentLocation.city}" /></td>
                            <td><c:out value="${currentLocation.state}" /></td>
                              
                            <sec:authorize access="hasRole('ROLE_USER')">
                            <td><a href="dislpayEditLocationForm?locationId=${currentLocation.locationId}">
                                       Edit</a></td>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td><a href="deleteLocation?locationId=${currentLocation.locationId}">
                                       Delete</a></td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-6">
                <sec:authorize access="hasRole('ROLE_USER')">
                    <h2>Add Location</h2>
                <form class="form-horizontal" role="form" method="POST" action="createLocation">
                            <div class="form-group">
                            <label for="add-name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="name" placeholder="Name" />
                            </div>
                            </div>
                            <div class="form-group">
                            <label for="add-street" class="col-md-4 control-label">Street:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="street" placeholder="Street" />
                            </div>
                            </div>
                            <div class="form-group">
                            <label for="add-city" class="col-md-4 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="city" placeholder="City" />
                            </div>
                            </div>
                            <div class="form-group">
                            <label for="add-state" class="col-md-4 control-label">State:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="state" placeholder="State" />
                            </div>
                            </div>
                            <div class="form-group">
                            <label for="add-zipCode" class="col-md-4 control-label">ZipCode:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="zipCode" placeholder="ZipCode" />
                            </div>
                            </div>
                            <div class="form-group">
                            <label for="add-latitude" class="col-md-4 control-label">Latitude:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="latitude" placeholder="longitude" />
                            </div>
                            </div>
                            <div class="form-group">
                            <label for="add-longitude" class="col-md-4 control-label">Longitude:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="longitude" placeholder="Longitude" />
                            </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Add Location"/>
                            </div>
                        </div>
                    </div>
                </form>
                </sec:authorize>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
