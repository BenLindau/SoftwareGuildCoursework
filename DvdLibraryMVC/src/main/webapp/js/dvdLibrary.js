$(document).ready(function () {
   
    
    $('#search-button').click(function (event) {
        
        $.ajax({
            type: 'POST',
            url: 'search/dvds',
            data: JSON.stringify({
                title: $('#search-title').val(),
                releaseDate: $('#search-releaseDate').val(),
                director: $('#search-director').val(),
                studio: $('#search-studio').val(),
                rating: $('#search-rating').val(),
                comments: $('#search-comments').val()
            }),
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
            'dataType' : 'json',
            success: function (data) {
                $('#errorMessages').empty();
                fillDvdTable(data);
            },
              error: function() {
                  $('#errorMessages')
                  .append($('li')
                        .attr({class: 'list-group-item list-group-item-danger'})
                          .text('Error calling web service. Please try again later.'));
              
              }
        });
    });
});

function fillDvdTable(data) {
    
    clearDvdTable();
    
    var contentRows = $('#contentRows');
    
    $.each(data, function(index, dvd) {
        var title = dvd.title;
        var releaseDate = dvd.releaseDate;
        var director = dvd.director;
        var studio = dvd.studio;
        var rating = dvd.rating;
        var comments = dvd.comments;
        
        var row = '<tr>';
            row + '<td>' + title + '</td>';
            row + '<td>' + releaseDate + '</td>';
            row + '<td>' + director + '</td>';
            row + '<td>' + studio + '</td>';
            row + '<td>' + rating + '</td>';
            row + '<td>' + comments + '</td>';
            row + '</tr>';
            contentRows.append(row);
    });
}
function clearDvdTable() {
    $('#contentRows').empty();
}