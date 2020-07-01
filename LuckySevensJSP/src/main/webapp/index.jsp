<%-- 
    Document   : index
    Created on : Mar 8, 2019, 10:46:09 AM
    Author     : benli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
    </head>
    <body>
        <h1>Lucky Sevens</h1>
        <p>
            Welcome to Lucky Sevens! In this game, you must place a put in a payment and select the amount per 
            roll that you would like to bet. Then select roll and see your winnings!
        </p>
        <form method="post" action="LuckySevens">
            <p>
            Amount to play:
            </p>           
                <input type="text" name="inputCash" />
            <p>
               Bet per roll:     
            </p>
            <input type="text" name="betPerRoll"><br/>
             
            <input type="submit" value="Roll!" />
    
        </form>   
    </body>
</html>
