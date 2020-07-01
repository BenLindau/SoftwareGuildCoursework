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
                  <li role="presentation" >
                      <a href="${pageContext.request.contextPath}/displayDvdLibrary">
                          Dvd's
                      </a>
                  </li>
                  <li role="presentation"
                      class="active">
                      <a href="${pageContext.request.contextPath}/displaySearchPage">
                          Search
                      </a>
                  </li>
                </ul>    
            </div>
            <!-- Main Page Content Start -->
            <ul class="list-group" id="errorMessages"></ul>
               
            <div class="row">
                 <div class="col-md-6">
                   <h2>Search Results</h2>
                   <table id="dvdTable" class="tabel tabel-hover">
                       <tr>
                           <th width="20%">Title</th>
                           <th width="10%">Release Date</th>
                           <th width="10%">Director</th>
                           <th width="10%">Studio</th>
                           <th width="10%">Rating</th>
                           <th width="10%">Comments</th>
                       </tr>
                       <tbody id="contentRows" />
                   </table>
                </div>
                <div class="col-md-6">
                    <h2>Search Options</h2>
                    
                    <form class="form-horizontal" role="form" method="POST" action="createDvd">
                        <div class="form-group">
                            <label for="search-title" class="col-md-4 control-label">Title:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-title" placeholder="Title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-releaseDate" class="col-md-4 control-label">Released:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-releaseDate" placeholder="Release Date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-director" class="col-md-4 control-label">Director:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-director" placeholder="director"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-studio" class="col-md-4 control-label">Studio:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-studio" placeholder="Studio"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-rating" class="col-md-4 control-label">Rating:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-rating" placeholder="Rating"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="search-comments" class="col-md-4 control-label">Comments:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="search-comments" placeholder="Comments"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="button" class="btn btn-default" id="search-button" value="Search"/>
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
        <script src="${pageContext.request.contextPath}/js/dvdLibrary.js"></script>
    </body>
</html>