<%-- 
    Document   : searchHero
    Created on : May 21, 2019, 9:01:50 AM
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
            <h2>Edit Organization:</h2>
        </div>
        
                <sf:form class="form-horizontal" role="form" method="POST" 
                         action="editOrganization" modelAttribute="org">
                     <sf:input type="hidden" path="orgId" />
                        
                    <div class="form-group">
                    <label for="add-name" class="col-md-4 control-label">Name:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-name"
                                  path="name" placeholder="Name"/>
                    </div>
                    </div>
                    <div class="form-group">
                            <label for="add-locationId" class="col-md-4 control-label">Location:</label>
                            <sf:select id="add-locationId" path="locationId">
                                <c:forEach var="currentLocation" items="${locationList}">
                                    <option value="${currentLocation.locationId}" >${currentLocation.name}</option>
                                </c:forEach>
                            </sf:select>
                        </div>
                    <div class="form-group">
                            <label for="add-phone" class="col-md-4 control-label">Phone:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" path="phone" placeholder="Phone" />
                            </div>
                        </div>
                    <div class="form-group">
                            <label for="add-email" class="col-md-4 control-label">Email:</label>
                            <div class="col-md-8">
                                <sf:input type="text" class="form-control" path="email" placeholder="${organization.email}" />
                            </div>
                        </div>
                    <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Edit Organization"/>
                            </div>
                        </div>
                </sf:form>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>