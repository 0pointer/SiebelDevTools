<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">Auswahl des Business Service</h3>
      </div>
      <div class="panel-body">
   <form class="form-horizontal">
      <div class="form-group">
         <label class="control-label col-sm-2" for="email">Operation:</label>
         <div class="col-sm-10">
            <select class="form-control" id="convertSelect">
               <option value="TAB_TO_JIRA">Einzelbearbeitung</option>
               <option value="TAB_TO_JIRA">Batchverarbeitung</option>
               <option value="TAB_TO_JIRA">SQL</option>
            </select>
         </div>
      </div>
      <div class="form-group">
         <label class="control-label col-sm-2" for="folder">Methode:</label>
         <div class="col-sm-10">
            <form:select path="siebelServices" class="form-control" id="bsMethod">
               <form:option value="---" label="---"/>
               <form:options items="${siebelServices}" itemValue="guid" itemLabel="name"/>
            </form:select>
         </div>
      </div>
   </form>
         </div>
       </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">Einzugebende Parameter: Einzelbearbeitung</h3>
      </div>
      <div class="panel-body">
           <form class="form-horizontal" id="siebelInputValues">

           </form>
      </div>
    </div>

</div>
<script>
   $(document).ready(function(){

   	$("#bsMethod").change(function(event) {
   		getParameter();
   	});

   	function getParameter(){
   		var uid = jQuery("#bsMethod").val();

   		$.ajax({
   			type : "POST",
   			contentType : "application/json",
   			url : "api/paramsiebservice",
   			data : uid,
   			dataType : 'json',
   			timeout : 100000,
   			success : function(data) {
                createInputForm(data);
   			},
   			error : function(e) {

   			},
   			done : function(e) {
   				console.log("DONE");
   			}
   		});
   	};

   	function createInputForm(data){
   	    var el = jQuery("#siebelInputValues");

        for(var i = 0; i < data.length; i++){
             var elDivGroup = $("<div>", {
                 class: "form-group"
             });

             var elLabel = $("<label>", {
                 for: "inputEmail3",
                 class: "col-sm-2 control-label",
                 text: data[i]
             });

             var elDiv = $("<div>", {
                 class: "col-sm-10"
             });

             var elInput = $("<input> ", {
                 type: "email",
                 class: "form-control siebparam",
                 id: "inputEmail3",
                 name: data[i]
             });



             elDiv.append(elInput);
             elDivGroup.append(elLabel);
             elDivGroup.append(elDiv);
             el.append(elDivGroup);

        }

                     var elButton = $("<button>", {
                        type: "button",
                        class: "btn btn-primary",
                        id: "submitSiebelForm",
                        text: "Execute"
                     });

                     elButton.click(function(event) {
                                		executeBs();
                                	});

                     el.append(elButton);

   	}

   	function executeBs(){
   	    var el = $('.siebparam')
        var params = [];

   	     for(var i = 0; i < el.length; i++){
            var param = {};
            param["key"] = el[i].name;
            param["value"] = el[i].val;
            params.push(param);
         }

            		$.ajax({
            			type : "POST",
            			contentType : "application/json",
            			url : "api/executesiebservices",
            			data : JSON.stringify(params),
            			dataType : 'json',
            			timeout : 100000,
            			success : function(data) {
                         createInputForm(data);
            			},
            			error : function(e) {

            			},
            			done : function(e) {
            				console.log("DONE");
            			}
            		});
   	}

   });
</script>