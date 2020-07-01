<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        <form method="post" action="flooringCalc">
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

