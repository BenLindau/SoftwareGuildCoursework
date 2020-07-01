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
        <h1 id='titleHeader'>Vending Machine</h1>
        <hr/>
          <ul class="list-group" id="errorMessages"></ul>
      </div>
        <div class='column'>
           <div id='itemsList'>
               <h2>Available Items</h2>

               <ul id="itemsTable" class="list">
                   <c:forEach var="currentItem" items="${itemsMap}">
                       <a href="getAllItems?itemId=${currentItem.itemId}">
                           <li> 
                               <button id="selectItemButton" data-val="${currentItem.itemId}"><c:out value="${currentItem.itemId}"/></button>
                           <c:out value="${currentItem.itemName}"/>
                           <c:out value="${currentItem.itemPrice}"/>
                           <c:out value="${currentItem.itemQuantity}"/>
                           </li>
                       </a>
                   </c:forEach>
                </ul>
              </div>
          </div>
          <div class='column' >


<form class="form-horizontal" role='form' id='changeForm'>
  <div>
    <div class='container' id='item'>
        <div>
         <label id="inputCash">Total In:</label>
       </div>
       <div>
              <input type="double" id="changeDisplay" value='0' required/>
       </div>
     <div>
         <button type="button" id='addQuarter' class='btn btn-default'>Add .25</button>
         <button type="button" id='addDime' class='btn btn-default'>Add .10</button>
    <div>
      <button type="button" id='addNickle' class='btn btn-default'>Add .05</button>
      <button type="button" id='addPenny' class='btn btn-default'>Add .01</button>
    </div>
    </div>
    </div>
  </div>
  </form>


        <hr/>
             <form class="form-horizontal" role='form' id='inputSelection'>
             <div>
               <div>
                 <label id="messageHeader">Messages:</label>
                 <div>
                      <input type="text" id="messages" required/>
                   </div>
              </div>
                 <div class='container' id='selection'>
                    <div>
                      <label id="add-item">Item:</label>
                         <input type="int" id="input-item" placeholder='Item' required/>
                        </div>
                           <button type="button" id='makePurchase' class='btn btn-default'>Vend Item</button>
                 </div>
             </div>
               </form>
            <hr/>


<form class="form-horizontal" role='form' id='changeForm'>
<div>
  <div>
    <inputs class='container' id='selection'>
         <label id="add-item">Change:</label>
         <div id='changeBlock'>
                <ul type="text" id='changeReturn' >

                </ul>
         </div>
    </inputs>
  </div>
</div>
  </form>

             <hr/>
           </div>
   

        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/vendingMachine.js"></script>
    </body>
</html>