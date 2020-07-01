$(document).ready(function () {
    $('#akronInfoDiv').hide();
    $('#akronWeather').hide();
    $('#minneapolisInfoDiv').hide();
    $('#minneapolisWeather').hide();
    $('#louisvilleInfoDiv').hide();
    $('#louisvilleWeather').hide();

$('#akronButton').on('click', function () {
  $('#akronInfoDiv').show();
  $('#mainInfoDiv').hide();
  $('#minneapolisInfoDiv').hide();
  $('#louisvilleInfoDiv').hide();
  });

$('#minneapolisButton').on('click', function() {
  $('#minneapolisInfoDiv').show();
  $('#mainInfoDiv').hide();
  $('#louisvilleInfoDiv').hide();
  $('#akronInfoDiv').hide();
});

$('#louisvilleButton').on('click', function() {
  $('#louisvilleInfoDiv').show();
  $('#mainInfoDiv').hide();
  $('#minneapolisInfoDiv').hide();
  $('#akronInfoDiv').hide();
});

$('#akronWeatherButton').on('click', function() {
  $('#akronWeather').toggle();
});
$('#minneapolisWeatherButton').on('click', function() {
  $('#minneapolisWeather').toggle();
});
$('#louisvilleWeatherButton').on('click', function() {
  $('#louisvilleWeather').toggle();
});

$('td').hover(
  //in function
  function() {
    $(this).css('background-color', 'WhiteSmoke');
  },
  //out function
  function() {
    $(this).css('background-color', '');
  }
);
});
