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
            <h1>Super Hero Catalog</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                	<li role="presentation"><a href="${pageContext.request.contextPath}/displayHeroList">Heros</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocations">Locations</a></li>
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
            <h2>Find Your Favorite Hero!</h2>
            <p>
                Welcome to the Hero Finder! You can find all of your favorite heros, organizations or post a new sighting.
                Just click on the tabs at the top of the page to navigate to the listing pages and add new heros, locations,
                sightings or organizations. Click on any of the number references to view the Hero, location or organization details!
                Take a look below at the recent sightings:
            </p>
            
            <h3>Recent Sightings</h3>
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
                            </tr> 
                            
                        </c:forEach>
                    </table>
           
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

