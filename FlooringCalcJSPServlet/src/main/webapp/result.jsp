<%-- 
    Document   : result
    Created on : Mar 6, 2019, 2:50:32 PM
    Author     : benli
--%>

<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Result</h1>
        <p>
            Total time required = ${stringTime};
        </p>
        <p>
            Labor cost = $${stringLabor};
        </p>
        <p>
            Material cost = $${stringAreaCost};
        </p>
        <p>
            Total cost = $${stringCost};
        </p>
        <p>
            <a href="index.jsp">Price another project!</a>
        </p>
    </body>
</html>
