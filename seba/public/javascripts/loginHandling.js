$(document).ready(function(){
    $('#btnLogin').click(function() {
        var username = $('#username').val();
        var password = $('#password').val();

        $.post('/login', {
            username : username,
            password : password
        }, function(data) {
            //Update menu
            $.get('/ajax/menu', function(data) {
                $('#navwrapper').empty();
                $('#navwrapper').append(data);
            });
            //Update extensions
            $.get('/ajax/extensions', function(data) {
                $('#extensionArea').empty();
                $('#extensionArea').append(data);
            });
        });
    });
});