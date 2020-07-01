$(document).ready(function () {
  $('#newWeather').hide();

  $('#getWeatherButton').click(function (event) {
   
    var haveValidationErrors = checkAndDisplayValidationErrors($('#input-zip').find('input'));

    if(haveValidationErrors) {
      return false;
    }

    var date;
    var icon;
    var low;
    var high;
  $.ajax({

   type: 'GET',
   url: 'http://api.openweathermap.org/data/2.5/weather?q=' + $('#input-zip').val() + ',us&APPID=41da3a1fa580d92cb2c85993fcb8adb1&units=' + $('#units').val(),
   data: JSON.stringify({
     dt_txt: date,
     icon: icon,
     temp_min: low,
     temp_max: high


   }),
   headers: {
     'Accept': 'application/json',
     'Content-Type': 'application/json'
   },
   'dataType': 'json',
   success(currentWeather) {
    var weatherRows = $('#weatherRows');
    var iconurl = "http://openweathermap.org/img/w/" + currentWeather.weather[0].icon + ".png";

     $('#errorMessages').empty();
     
     $('#weatherHeader').append('Current Weather Condidtions: ' + currentWeather.name);

     $('#wicon').attr('src', iconurl);

     var row =
            
            $('#imageLine').append(currentWeather.weather[0].main)

            
            row += '<td>' + 'Temp:' + currentWeather.main.temp + '<br/>' +
               'Humidity:' + currentWeather.main.humidity  +  '<br/>' +
             'Wind:'+  currentWeather.wind.speed + '<td>'
            
      
     $('#dataLine').append(row);
    
     console.log(currentWeather);
   },
   error: function() {
     $('errorMessages')
     .append($('<li>')
     .attr({class: 'list-group-item list-group-item-danger'})
     .text('Error calling web services. Please try again later'));
   }
   })
   $('#newWeather').show();
   displayForcast();
  });
}); //doc ready

function displayForcast() {

  var weatherData = $('#forcastTable');

    var forcastRows = $('#forcastRows');
    var i = 8
    $.ajax({
      type:'GET',
      url: 'http://api.openweathermap.org/data/2.5/forecast?q=' + $('#input-zip').val() + ',us&APPID=41da3a1fa580d92cb2c85993fcb8adb1&units=' + $('#units').val(),
        success: function(forcastArray) {
         $.each(forcastArray, function(index, weather) {
           console.log(forcastArray);
           
           var forcastUrl = "http://openweathermap.org/img/w/" + forcastArray.list[i].weather[0].icon + ".png"

            var row =  '<td>' + forcastArray.list[i].dt_txt + '<br/>'
             + '<img src="'+forcastUrl+'" />' + '<br/>'
             + 'Low:' + forcastArray.list[i].main['temp_min'] + '<br/>'
             + 'High:'+  forcastArray.list[i].main['temp_max'] + '<br/>'
              if ($('#units').val() == 'imperial')  {
                row += 'F' + '</td>'
              } else {
                row += 'C' + '</td>'
              }
            
          
            forcastRows.append(row);  
           i += 8;
        });
        

      },
      error: function() {
        $('#errorMessages')
        .append($({class: 'list-group-item list-group-item-danger'})
        .text('Error calling web services. Please try again later'));
      }
    });
  }


function checkAndDisplayValidationErrors(input) {
 
  if($('#input-zip').length != 5 ) {
    var errorField = 'Please enter Zipcode';
    $('#errorMessages').append(errorField);   
    
    }
  }

