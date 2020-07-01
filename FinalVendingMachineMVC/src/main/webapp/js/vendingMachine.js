$(document).ready(function () {

  loadItems();

var changeDisplay = 0;
//add change----------------------------------------------------------
$('#addQuarter').click(function (event) {
  changeDisplay = changeDisplay += .25;
  $('#changeDisplay').val(changeDisplay);
});
$('#addDime').click(function (event) {
  changeDisplay = changeDisplay += .10;
  $('#changeDisplay').val(changeDisplay);
});
$('#addNickle').click(function (event) {
  changeDisplay = changeDisplay += .05;
  $('#changeDisplay').val(changeDisplay);
});
$('#addPenny').click(function (event) {
  changeDisplay = changeDisplay += .01;
  $('#changeDisplay').val(changeDisplay);
});

// Select Item Button ---------------------------------------------------------
//$(document).on('click', '#selectItemButton', function(event) {
//       
//    var selectedItem = $(this).data('val');
//
//    $('#input-item').val(selectedItem);
//
//    $.ajax({
//      type: 'GET',
//      url: '/FinalVendingMachineMVC/inventory/',
//      success: function(itemArray) {
//        var item = itemArray[selectedItem - 1];
//
//        var id = item.id;
//        var name = item.name;
//        var quantity = item.quantity;
//        var price = item.price;
//        var inputCash = $('#changeDisplay').val();
//
//        $('#input-item').val(name);
//
//
//
//         if (price > inputCash) {
//           $('#messages').val('Please input more money!');
//           $('#makePurchase').click(id, function (event) {
//
//            $.ajax({
//             type: 'GET',
//             url: 'http://localhost:8080/money/' + $('#changeDisplay').val() + '/item/'+ item.id ,
//             success: function(changeReturned) {
//               var change = [];
//
//               $.each(changeReturned, function(index, coins) {
//                 change.push('<li>' + index + ': '+  coins + '</li>')
//               });
//               $('#changeReturn').append(change);
//               $('#messages').val('Enjoy!')
//               $('#itemsTable').empty();
//               loadItems();
//
//           },
//            error: function() {
//                
//               $('#errorMessages')
//               .append($('<li>')
//             .text('Error calling web service. Please try again later'));
//           }
//         });
//         });
//       } else if (quantity == 0) {
//          $('#messages').val('Sold Out!');
//        } else {
//          $('#makePurchase').click(id, function (event) {
//
//           $.ajax({
//            type: 'GET',
//            url: 'http://localhost:8080/money/' + $('#changeDisplay').val() + '/item/'+ item.id ,
//            success: function(changeReturned) {
//              var change = [];
//
//              $.each(changeReturned, function(index, coins) {
//                change.push('<li>' + index + ': '+  coins + '</li>')
//              });
//              $('#changeReturn').append(change);
//              $('#messages').val('Enjoy!')
//               $('#itemsTable').empty();
//              loadItems();
//
//
//          },
//            error: function() {
//              $('#errorMessages')
//              .append($('<li>')
//            .text('Error calling web service. Please try again later'));
//          }
//        });
//
//      });
//      }
//        console.log($('#messages').val());
//     },
//     error: function() {
//       $('#errorMessages')
//       .append($('<li>')
//     .text('Error calling web service. Please try again later'));
//     }
//
//   });
//
//
//});

});//doc ready
//load items-------------------------------------------------------------
function loadItems() {
  var itemsTable = $('#itemsTable');
  var itemRows = $('#itemRows');
    $.ajax({
      type:'GET',
      url: 'http://localhost:8080/inventory',
      success: function(itemArray) {
        var items = [];

        $.each(itemArray, function(index, item) {

                  items.push('<li>'+ ('<button id="selectItemButton" class="itemButtons" data-val=' +  item.id + '>' + item.id
                   + '</button>') + ': ' + item.name + ' '+ '<br/>' + '$'
                    + item.price + '<br/>' + ' Available: ' + item.quantity + '</li>')

            });
            console.log(itemArray)
          $('#itemsTable').append(items);

      },
      error: function() {
        $('#errorMessages')
        .append($('<li>')
      .text('Error calling web service. Please try again later'));
      }
    });
}


