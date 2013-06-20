$(document).ready(function(){
    $('#btnLogin').click(function() {
        var username = $('#username').val();
        var password = $('#password').val();

        $.post('/login', {
            username : username,
            password : password
        }, function(data) {
            //alert("Login successful!");
            $.get('/ajax/menu', function(data) {
                $('#navwrapper').empty();
                $('#navwrapper').append(data);
            });
        });
    });
});