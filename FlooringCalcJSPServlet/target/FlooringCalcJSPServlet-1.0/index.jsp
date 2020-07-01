<%-- 
    Document   : index
    Created on : Mar 6, 2019, 2:49:27 PM
    Author     : benli
--%>

<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator</title>
    </head>
    <body>
        <h1>Flooring Calculator</h1>
        <p>
            Please enter the length:
        </p>
        <form method="post" action="FlooringCalc">
            <input type="text" name="lengthOfArea"/><br/>
        <p>
            Please enter the width:
        </p>
            <input type="text" name="widthOfArea" /><br/>
        <p>
            Please enter the cost per square foot:
        </p>
            <input type="text" name="cost" /><br/>
                    
            <input type="submit" value="Find Area!" />
        </form>
    </body>
</html>
