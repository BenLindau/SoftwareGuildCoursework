<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dvd List</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Dvd Library</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"> 
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                  </li>
                  <li role="presentation"
                      class="active">
                      <a href="${pageContext.request.contextPath}/displayDvdLibrary">
                          Dvd's
                      </a>
                  </li>
                  <li role="presentation">
                      <a href="${pageContext.request.contextPath}/displaySearchPage">
                          Search
                      </a>
                  </li>
                </ul>    
            </div>
            <!-- Main Page Content Start -->
            <div class="row">
                <div class="col-md-6">
                   <h2>My Dvd's</h2>
                   <table id="dvdTable" class="table table-hover">
                       <tr>
                           <th width="30%">Title</th>
                           <th width="30%">Release Date</th>
                           <th width="15%">Director</th>
                           
                       </tr>
                       <c:forEach var="currentDvd" items="${dvdList}">
                           <tr>
                               <td><a href="displayDvdDetails?dvdId=${currentDvd.dvdId}">
                                       <c:out value="${currentDvd.title}"/></a></td>
                               <td><c:out value="${currentDvd.releaseDate}"/></td>
                               <td><c:out value="${currentDvd.director}"/></td>
                               <td><a href="displayEditDvdForm?dvdId=${currentDvd.dvdId}">
                                       Edit</a></td>
                               <td><a href="deleteDvd?dvdId=${currentDvd.dvdId}">
                                       Delete</a></td>
                           </tr>
                       </c:forEach>
                   </table>
                </div>
                <div class="col-md-6">
                    <h2>Add New Dvd</h2>
                    <form class="form-horizontal" role="form" method="POST" action="createDvd">
                        <div class="form-group">
                            <label for="add-title" class="col-md-4 control-label">Title:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="title" placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-releaseDate" class="col-md-4 control-label">Released:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="releaseDate" placeholder="Release Date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-director" class="col-md-4 control-label">Director:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="director" placeholder="director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-studio" class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="studio" placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-rating" class="col-md-4 control-label">Rating:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="rating" placeholder="Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-comments" class="col-md-4 control-label">Comments:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="comments" placeholder="Comments"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-default" value="Create Dvd"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- Main Page Content Stop -->    
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>