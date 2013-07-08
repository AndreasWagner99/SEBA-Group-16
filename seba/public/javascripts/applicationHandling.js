function createProjIdHandler(projId){
    return function(){
        var description = $('#description').val();
        var form = $('#applicationForm');
        var formData = new FormData();
        formData.append("description", description);
        formData.append("projId", projId);
        formData.append("file", form[0][1].files[0]);
        
        $.ajax({
            type: "POST",
            url: routes.applicationAction(),
            data: formData,
            success: function(data){$('.modal').modal('hide')},
            cache: false,
            contentType: false,
            processData: false
        });
    }
}

$(document).ready(function(){
    $('.applyButton').click(function(){
        var parentDialog = $(this).parent().parent().parent().parent();
        var projId = $(this).data("project");
        $(parentDialog).modal('hide');
        
        $('#applSave').unbind();
        $('#applSave').click(createProjIdHandler(projId));
        
        $('#applicationDialog').modal();
    });
    
    $('body').on("click", '.appldismiss', function(){
        var applicationId = $(this).data("applicationid");
        var button = $(this);
        
        $.post(routes.applDismissAction(),{applicationid: applicationId},function(data){
            var item = button.parent().parent().parent().parent(); 
            item.fadeOut();
        });
        
    });
    
    $('body').on("click", '.applaccept', function(){
        var applicationId = $(this).data("applicationid");
        var button = $(this);
        
        $.post(routes.applAcceptAction(),{applicationid: applicationId},function(data){
            $('.modal').modal('hide');
            $('#applicationArea').empty();
            //Application Object
            $('#applicationArea').append(data);
        });
    });
}
);

