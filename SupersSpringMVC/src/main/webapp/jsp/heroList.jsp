<%-- 
    Document   : heroList
    Created on : May 21, 2019, 9:01:15 AM
    Author     : benli
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayHeroList">Heros</a></li>
                        <li role="presentation" ><a href="${pageContext.request.contextPath}/displayLocations">Locations</a></li>
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
 <!--   MAIN PAGE CONTENT-->
    <div>
            
            <div class="row">
                <div class="col-md-6">
                <table id="heroTable" class="table table-hover">
                    <tr>
                        <th width="20%">Hero</th>
                        <th width="20%">Description</th>
                        <th width="20%">Power</th>
                        <th width="20%">location</th>
                        <th width="20%">Organization</th>
                    </tr>
                    <c:forEach var="currentHero" items="${heroList}">
                        <tr>
                            <td><a href="displayHeroDetails?heroId=${currentHero.heroId}">
                                       <c:out value="${currentHero.name}"/></a></td>
                            <td><c:out value="${currentHero.description}" /></td>
                            <td><c:out value="${currentHero.powers}" /></td>
                            <td><a href="displayLocationDetails?locationId=${currentHero.locationId}">
                                       <c:out value="${currentHero.locationId}"/></a></td>
                            <td><a href="displayOrgDetails?orgId=${currentHero.organizationId}">
                                       <c:out value="${currentHero.organizationId}"/></a></td>
                            <sec:authorize access="hasRole('ROLE_USER')">
                            <td><a href="dislpayEditHeroForm?heroId=${currentHero.heroId}">
                                       Edit</a></td>
                                </sec:authorize>      
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td><a href="deleteHero?heroId=${currentHero.heroId}">
                                       Delete</a></td>
                                </sec:authorize>
                        </tr>
                    </c:forEach>
                </table>
                </div>
                <div class="col-md-6">
                    <sec:authorize access="hasRole('ROLE_USER')">
                    <h2>Add Hero</h2>
                    <form class="form-horizontal" role="form" method="POST" action="createHero">
                        <div class="form-group">
                            <label for="add-name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="name" placeholder="Name" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="description" placeholder="Description" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-powers" class="col-md-4 control-label">Powers:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="powers" placeholder="Powers" />
                            </div>
                        </div>
                       <div class="form-group">
                            <label for="add-locationId" class="col-md-4 control-label">Location:</label>
                            <select id="add-locationId" name="locationId">
                                <c:forEach var="currentLocation" items="${locationList}">
                                    <option value="${currentLocation.locationId}" >${currentLocation.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="add-organization" class="col-md-4 control-label">Organization:</label>
                            <select id="add-organization" name="orgId">
                                <c:forEach var="currentOrganization" items="${orgList}">
                                    <option value="${currentOrganization.orgId}">${currentOrganization.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Add Hero"/>
                            </div>
                        </div>
                   </form>
                    </sec:authorize>
                </div>
            </div>
    </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
