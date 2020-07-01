<%-- 
    Document   : contacts
    Created on : Mar 14, 2019, 9:48:24 AM
    Author     : benli
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Company Contacts</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div>
        <h1>Company Contacts</h1>
        <hr/>
        <div class="navbar">
                <ul class="nav nav-tabs">
                	<li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                	<li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayContactsPage">Contacts</a></li>
                        <li role="presentation"><a href="${pageContext.request.contextPath}/displaySearchPage">Search</a></li>
                </ul>    
            </div>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
    <p>Hello : ${pageContext.request.userPrincipal.name}
        | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
    </p>
</c:if>
            <div class="row">
                <div class='col-md-6'>
                    <h2>My Contacts</h2>
                    <table id='contactTable' class='table tabel-hover'>
                        <tr>
                            <th width='40%'>Contact Name</th>
                            <th width='30%'>Company</th>
                            <th width='15%'></th>
                            <th width='15%'></th>
                        </tr>
                        <c:forEach var="currentContact" items="${contactList}">
                            <tr>
                             <td>
                                <a href="displayContactDetails?contactId=${currentContact.contactId}">
                                <c:out value="${currentContact.firstName}"/> <c:out value="${currentContact.lastName}"/>
                                </a>
                            </td>
                            <td>
                                <c:out value="${currentContact.company}"/>
                            </td>
                            <td>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="displayEditContactForm?contactId=${currentContact.contactId}">
                             Edit
                            </a>
                            </sec:authorize>
                            </td>
                            <td>
                                <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="deleteContact?contactId=${currentContact.contactId}">
                            Delete
                            </a>
                            </sec:authorize>
                            </td>
                         </tr>
                    </c:forEach>
                    </table>
                </div>
                <div class='col-md-6'>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <h2>Add New Contact</h2>
                    <form class='form-horizontal' role='form' method='POST' action='createContact'>
                        <div class='form-group'>
                            <label for='add-first-name' class='col-md-4 control-label'>First Name:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='firstName' paceholder='First Name'/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <label for='add-last-name' class='col-md-4 control-label'>Last Name:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='lastName' paceholder='Last Name'/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <label for='add-company' class='col-md-4 control-label'>Company:</label>
                            <div class='col-md-8'>
                                <input type='text' class='form-control' name='company' paceholder='Company'/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <label for='add-phone' class='col-md-4 control-label'>Phone:</label>
                            <div class='col-md-8'>
                                <input type='phone' class='form-control' name='phone' paceholder='Phone'/>
                            </div>
                        </div>
                        <div class='form-group'>
                            <label for='add-email' class='col-md-4 control-label'>Email:</label>
                            <div class='col-md-8'>
                                <input type='email' class='form-control' name='email' paceholder='Email'/>
                            </div>
                            <div class='form-group'>
                                <div class='col-md-offset-4 col-md-8'>
                                <input type='submit' class='btn btn-default' value='Create Contact' />
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
