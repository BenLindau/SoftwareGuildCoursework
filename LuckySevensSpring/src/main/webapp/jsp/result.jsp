<%-- 
    Document   : result
    Created on : Mar 12, 2019, 8:26:37 PM
    Author     : benli
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens: Result</title>
    </head>
    <body>
        <h1>Lucky Sevens: Result</h1>
        <p>
            You bet:
        </p>
        <p>
            You ran out of money after ${numberOfRolls} rolls.
        </p>
        <p> you should have quit at ${maxRolledAt} rolls when
            you had $${max}
        </p>
        <p>
            <a href="index.jsp">Play Again!</a>
        </p>
    </body>
</html>

