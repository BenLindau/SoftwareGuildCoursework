<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vending Machine</title>

        <link href="css/bootstrap.css"
              rel="stylesheet">
    <style>
      form {
        margin: 0 auto;
        width: 500px;
      }
    </style>
    </head>
    <body>
      <div>
        <h1 id='titleHeader'>Item Vend</h1>
        <hr/>
          
      </div>

        <div class='column'>
             <div id='items'>
               <h2>Available Items</h2>

               <ul id="itemsTable" class="list">
                   <c:forEach var="currentInventory" items="${inventory}">
                   
                       <li>
                           <a href="menuItems?currentId=${currentInventory.itemId}"  class='btn btn-default' type="submit" class="btn-default"   id="selectItemButton" value="${currentInventory.itemId}">${currentInventory.itemId}</a>
                           <br/>
                          <c:out value="${currentInventory.soda}" />
                           <br/>
                           <c:out value="$ ${currentInventory.price}" />
                           <br/>
                           <c:out value="${currentInventory.inventory}" />
                        </li>
                    
                   </c:forEach>
                </ul>
              </div>
          </div>
          <div class='column' >


<form class="form-horizontal" role='form' class="col-md-8" id='changeForm'>
<div>
  <div>
    <div class='container' id='item'>
        <div>
         <label id="inputCash">Total In:</label>
       </div>
       <div>
              <input  id="changeDisplay"  value='${change}'required/>
       </div>
     <div>
         <button type="button" class="btn btn-default"  id='addQuarter' >Add .25</button>
         <button type="button" class="btn btn-default" id='addDime' >Add .10</button>
     </div>
    <div>
      <button type="button" class="btn btn-default" id='addNickle' >Add .05</button>
      <button type="button" class="btn btn-default" id='addPenny' >Add .01</button>
    </div>
    </div>
  </div>
</div>
  </form>


        
             <form class="form-horizontal" role='form' class="col-md-8" id='inputSelection'>
             <div>
               <div>
                 <label id="messageHeader">Messages:</label>
                 <div>
                      <input type="text" id="messages" value='Thank You & Enjoy!'/>
                   </div>
              </div>
                 <div class='container' id='selection'>
                    <div>
                      <label id="add-item">Item:</label>
                         <input id="input-item" value=<c:out value="${item.soda}"/> />
                    </div>
                        <p>
                        <a href="makePurchase?currentId=${item.itemId}"  class='btn btn-default' type="submit" class="btn-default"   id="makePurchase" >Vend Item</a>
                           
                    </p>  
                 
                 </div>
             </div>
               </form>
            <hr/>


<form class="form-horizontal" role='form'  class="col-md-8" id='changeForm'>
<div>
  <div>
    <div class='container' id='selection'>
         <label id="add-item">Change:</label>
         <div id='changeBlock'>
                <ul type="text" id='changeReturn' >

                </ul>
         </div>
        <a href="abort?"  class='btn btn-default' type="submit" class="btn-default"   id="/" >Change Return</a>
          </div>
             <hr/>
           </div>
          </div>
</form>
</div>
        
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vendingMachine.js"></script>
    </body>
</html>
