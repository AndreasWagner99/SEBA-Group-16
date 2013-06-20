$(document).ready(function(){
$('.newProjectButton').click(function(){
        var parentDialog = $(this).parent().parent().parent().parent();
        var companyId = $(this).data("companyId");
        $(parentDialog).modal('hide');
        
        $('#newProjectSave').click(function(){
            var title = $('#title').val();
            var teaser = $('#teaser').val();
            var description = $('#description');
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
        $('#newProjectDialog').modal();
    });
})