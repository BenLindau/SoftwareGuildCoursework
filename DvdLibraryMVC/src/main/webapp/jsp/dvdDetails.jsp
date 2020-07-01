<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Dvd Details</title>
        
         <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    
    </head>
    <body>
        <div class="container">
            <h1>Dvd Details</h1>
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
                          <p>
                              Title: <c:out value="${dvd.title}"/>
                          </p>
                          <p>
                              Release Date: <c:out value="${dvd.releaseDate}"/>
                          </p>
                          <p>
                              Director: <c:out value="${dvd.director}"/>
                          </p>
                          <p>
                              Studio: <c:out value="${dvd.studio}"/>
                          </p>
                          <p>
                              Rating: <c:out value="${dvd.rating}"/>
                          </p>
                          <p>
                              Comments: <c:out value="${dvd.comments}"/>
                          </p>
        </div>     
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
