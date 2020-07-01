<%-- 
    Document   : result
    Created on : Mar 7, 2019, 10:15:05 AM
    Author     : benli
--%>

<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator</title>
    </head>
    <body>
        <h1>Interest Calculator: Result</h1>
            <p>
                Your started with $${startAmount}.
            </p>
            <p>
               After ${stringTime} years, you will have accrued $${stringInterest} in interest.
            </p>
            <p>
                Your final amount is: $${stringAmount}
            </p>
            <p>
                <a href="index.jsp">Make another investment!</a>
            </p>
    </body>
</html>
