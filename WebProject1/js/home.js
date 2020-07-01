$(document).ready(function () {
  $('h1').addClass('text-center');
  $('h2').addClass('text-center');
  $('ul').addClass('text-center');

  $('#yellowHeading').append().text('Yellow Team');
  $('#yellowTeamList').append($('<li>').text('Joseph Banks'));
  $('#yellowTeamList').append($('<li>').text('Simon Jones'));

  $('#orangeHeading').css('background-color', 'Orange');
  $('#blueHeading').css('background-color', 'Blue');
  $('#redHeading').css('background-color', 'red');
  $('#yellowHeading').css('background-color', 'Yellow');

  $('#oops').hide();
  $('#footerPlaceholder').remove();
  $('#footer').append('p').css({'font': 'Courier', 'height': '24'}).text('Ben Lindau, benlindau9@gmail.com');
  $('footer').addClass('text-center');
});
