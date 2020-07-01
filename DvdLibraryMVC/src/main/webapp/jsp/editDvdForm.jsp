<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Edit Dvd Page</title>
        
         <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    
    </head>
    <body>
        <div class="containter">
        <div class="navbar">
                <ul class="nav nav-tabs">
                  <li role="presentation" 
                      class="active">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            Home
                        </a>
                  </li>
                  <li role="presentation">
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
                          
                          
                      <sf:form class="form-horizontal" role="form" modelAttribute="dvd"
                               action="editDvd" method="POST">
                          <div class="form-group">
                              <label for="add-title" class="col-md-4 control-label">Title:</label>
                              <div class="col-md-8">
                                  <sf:input type="text" class="form-control" id="add-title"
                                            path="title" placeholder="Title" />
                                  <sf:errors path="title" csscalss="error"></sf:errors>
                              </div>
                              <label for="add-releaseDate" class="col-md-4 control-label">Release Date:</label>
                              <div class="col-md-8">
                                  <sf:input type="text" class="form-control" id="add-releaseDate"
                                            path="releaseDate" placeholder="Release Date" />
                                  <sf:errors path="releaseDate" csscalss="error"></sf:errors>
                              </div>
                              <label for="add-director" class="col-md-4 control-label">Director:</label>
                              <div class="col-md-8">
                                  <sf:input type="text" class="form-control" id="add-director"
                                            path="director" placeholder="Director" />
                                  <sf:errors path="director" csscalss="error"></sf:errors>
                              </div>
                              <label for="add-studio" class="col-md-4 control-label">Studio:</label>
                              <div class="col-md-8">
                                  <sf:input type="text" class="form-control" id="add-studio"
                                            path="studio" placeholder="Studio" />
                                  <sf:errors path="studio" csscalss="error"></sf:errors>
                              </div>
                              <label for="add-rating" class="col-md-4 control-label">Rating:</label>
                              <div class="col-md-8">
                                  <sf:input type="text" class="form-control" id="add-rating"
                                            path="rating" placeholder="Rating" />
                                  <sf:errors path="rating" csscalss="error"></sf:errors>
                              </div>
                              <label for="add-comments" class="col-md-4 control-label">Comments:</label>
                              <div class="col-md-8">
                                  <sf:input type="text" class="form-control" id="add-comments"
                                            path="comments" placeholder="Comments" />
                                  <sf:errors path="comments" csscalss="error"></sf:errors>
                              </div>
                              <div class="form-group">
                                 <div class="col-md-offset-4 col-md-8">
                                    <input type="submit" class="btn btn-default" value="Update Dvd"/>
                                 </div>
                              </div>
                          </div>
                      </sf:form>
                          
                          
        </div>
               <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
               <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
