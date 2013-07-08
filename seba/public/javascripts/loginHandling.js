$(document).ready(function(){
    $('#btnLogin').click(function() {
        var username = $('#username').val();
        var password = $('#password').val();

        $.post('/authenticate', {
            username : username,
            password : password
        }, function(data, text, response) {
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
            //Update info-area
            $.get('/ajax/info', function(data) {
                $('#infoArea').empty();
                $('#infoArea').append(data);
            });
            //Remove registration bar
            $('#registrationBar').remove();
        })
        .error(function(req, textStatus, errorThrown){
            if(req.status == 403){
                alert("wrong username or password");
            }
        });
    });
});
