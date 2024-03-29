<%-- 
    Document   : contactDetails
    Created on : Mar 16, 2019, 1:01:50 PM
    Author     : benli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company Contacts</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel='stylesheet'>
    </head>
    <body>
        <div class='container'>
        <h1>Contact Details</h1>
        <hr/>
        </div>
        <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                	<li role="presentation"><a href="${pageContext.request.contextPath}/displayContactsPage">Contacts</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displaySearchPage">Search</a></li>
                </ul>    
        </div>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
    <p>Hello : ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
    </p>
</c:if>
        <div>
                <p>
                    Name: <c:out value="${contact.firstName}" /> 
                    <C:out value='${contact.lastName}' />
                </p>
                <p>
                    Company: <c:out value="${contact.company}" />
                </p>
                <p>
                    Phone <c:out value="${contact.phone}" />
                </p>
                <p>
                    Email <c:out value="${contact.email}" />
                </p>
</div>
    </body>
</html>
