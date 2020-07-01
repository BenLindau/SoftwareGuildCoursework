<%-- 
    Document   : Organization
    Created on : May 29, 2019, 8:55:13 PM
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
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocations">Locations</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightings">Sightings</a></li>
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayOrganizations">Organizations</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/login">Login</a></li>
                </ul>    
            </div>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <p>Hello : ${pageContext.request.userPrincipal.name}
                | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
                </p>
            </c:if>
        <h1>Super Groups</h1>
        
        <div class="row">
                <div class="col-md-6">
                    <table id="orgTable" class="table table-hover">
                        <tr>
                            <th width="5%">Id:</th>
                            <th width="25%">Name:</th>
                            <th width="25%">Location:</th>
                            <th width="25">Email:</th>
                           
                        </tr>
                        <c:forEach var="currentOrg" items="${orgList}">
                            <tr>
                                <td><a href="displayOrgDetails?orgId=${currentOrg.orgId}">
                                       <c:out value="${currentOrg.orgId}"/></a></td>
                                <td><c:out value="${currentOrg.name}"/></td>
                                <td><a href="displayLocationDetails?locationId=${currentOrg.locationId}">
                                       <c:out value="${currentOrg.locationId}"/></a></td>
                                <td><c:out value="${currentOrg.email}"/></td>
                                <sec:authorize access="hasRole('ROLE_USER')">
                                <td><a href="dislpayEditOrganizationForm?orgId=${currentOrg.orgId}">
                                       Edit</a></td>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td><a href="deleteOrganization?orgId=${currentOrg.orgId}">
                                       Delete</a></td> 
                                </sec:authorize>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <h2>Add Organization:</h2>
                        <form class="form-horizontal" role="form" method="POST" action="createOrg">
                            <div class="form-group">
                            <label for="add-name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="name" placeholder="Name" />
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
                            <label for="add-phone" class="col-md-4 control-label">Phone:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="phone" placeholder="Phone" />
                            </div>
                            </div>
                            <div class="form-group">
                            <label for="add-email" class="col-md-4 control-label">Email:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="email" placeholder="Email" />
                            </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Add Organization"/>
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
