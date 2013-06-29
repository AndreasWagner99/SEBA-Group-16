$(document).ready(function(){
    $('body').on("click", '#paymentMethodSave',function(){
    	var designerId = $(this).data("id");
		var cardNum = $('#cardno1').val()+$('#cardno2').val()+$('#cardno3').val()+$('#cardno4').val();
		var cardName = $('#cardName').val();
		var creditAmt = $('#creditAmt').val();
		var cvv = $('#cvv').val();
		var month = $('#month').children("option").filter(":selected").text();
		var year = $('#year').children("option").filter(":selected").text();
		var expirydate = month+year;
		
		var formData = new FormData();
		formData.append("cardNum", cardNum);
        formData.append("cardName", cardName);
        formData.append("creditAmt", creditAmt);
        formData.append("cvv", cvv);
        formData.append("expirydate", expirydate);
        formData.append("designerId", designerId);
        
        
        $.ajax({
            type: "POST",
            url: routes.paymentAction(),
            data: formData,
            success: function(data){$('.modal').modal('hide')},
            cache: false,
            contentType: false,
            processData: false
          });
        
    });
});