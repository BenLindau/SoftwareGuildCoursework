<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator</title>
    </head>
    <body>
        <h1>Tip Calculator</h1>
        <p>
            Please enter the follow information to calculate your tip!
        </p>
        <form method="POST" action="tipCalc">
            <p>
                Bill:
            </p>
                <input type="text" name="bill" />
            <p>
                Tip %:
            </p>
            <input type="text" name="tip" /></br>
            <input type="submit"   value="Submit"/>
                
        </form>
    </body>
</html>

