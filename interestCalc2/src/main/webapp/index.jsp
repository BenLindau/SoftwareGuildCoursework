<%-- 
    Document   : index
    Created on : Mar 7, 2019, 12:53:25 PM
    Author     : benli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interest Calculator</title>
    </head>
    <body>
        <h1>Interest Calculator</h1>
        <p>
            This program is an interest calculator.
            Please input your initial amount, 
            the interest rate and the length of time 
            your investment will be accruing interest.
        </p>
        <form method="post" action="">
            <p>
                Amount:
            </p>
                <input type="text" name="amount" />
            <p>
                Interest Rate:
            </p>
                <input type="text" name="interest" />
            <p>
                Length of Investment: 
            </p>
                <input type="text" name="time" /><br/>
                
                <input type="submit" value="Calculate!" />
            
        </form>
    </body>
</html>
