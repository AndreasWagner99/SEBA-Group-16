$(document).ready(function(){
    $('#newProjectSave').click(function(){
        var companyId = $(this).data("id");
        var title = $('#title').val();
        var teaser = $('#teaser').val();
        var description = $('#description').val();
        var form = $('#newProjectForm');
        var formData = new FormData();
        formData.append("title", title);
        formData.append("teaser", teaser);
        formData.append("description", description);
        formData.append("companyId", companyId);
        
        
        $.ajax({
            type: "POST",
            url: routes.projectAction(),
            data: formData,
            success: function(data){$('.modal').modal('hide')},
            cache: false,
            contentType: false,
            processData: false
          });
        
    });
});