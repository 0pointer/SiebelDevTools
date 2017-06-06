$(document).ready(function(){
   	$("#environment").change(function(event) {
   	    var el = $("#environment");
   		changeEnvironment(el.val(), el.text());
   	});

    function changeEnvironment(id, val){
        $.ajax({
   			type : "POST",
   			contentType : "text/plain",
   			url : "/api/changeEnv",
   			data : id,
   			dataType : 'text',
   			timeout : 100000,
   			success : function(data) {
   			},
   			error : function(e) {

   			},
   			done : function(e) {
   				console.log("DONE");
   			}
   	    });
    }
});