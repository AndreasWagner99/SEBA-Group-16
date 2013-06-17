$(document).ready(function(){
    $('.applyButton').click(function(){
        var parentDialog = $(this).parent().parent().parent().parent();
        var projId = $(this).data("project");
        $(parentDialog).modal('hide');
        
        $('#applSave').click(function(){
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
            
        });
        
        $('#applicationDialog').modal();
    });
}
);