 <%-- 
    Document   : result
    Created on : Mar 12, 2019, 10:59:53 AM
    Author     : benli
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Result</h1>
        <p>
            Total time required = ${wholeTime};
        </p>
        <p>
            Labor cost = $${laborCost};
        </p>
        <p>
            Material cost = $${areaCost};
        </p>
        <p>
            Total cost = $${totalCost};
        </p>
        <p>
            <a href="index.jsp">Price another project!</a>
        </p>
    </body>
</html>
