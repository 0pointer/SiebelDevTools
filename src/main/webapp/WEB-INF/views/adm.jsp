<?xml version="1.0"?>
<html>
	<head>
	</head>
	<body>
        <div class="container">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="control-label col-sm-2" for="email">Operation:</label>
                <div class="col-sm-10">
			        <select class="form-control" id="convertSelect">
					    <option value="TAB_TO_JIRA">Importieren aus Ordner</option>
					    <option value="TAB_TO_JIRA">Importieren aus Datei</option>
					    <option value="TAB_TO_JIRA">Export</option>
				    </select>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-sm-2" for="folder">Speicherort:</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="folder" placeholder="Geben Sie den Speicherort an">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="button" class="btn btn-default" id="submit">Submit</button>
                </div>
              </div>
              <div class="col-sm-offset-2 col-sm-10">
                  <div id="successAlert" class="alert alert-success" style="display: none;">
                    <strong>Success</strong> Everything is ready.
                  </div>
                    <div id="errorAlert" class="alert alert-danger" style="display: none;">
                      <strong>Error</strong> Import not successful! Look into the log.
                    </div>
                </div>
            </form>
	    </div>
	    <script>
        		$(document).ready(function(){

        			$("#submit").click(function(event) {
        				importAdm();
        			});

        			function importAdm(){
        				var search = {};

        				search["folder"] = jQuery("#folder").val();

        				$.ajax({
        					type : "POST",
        					contentType : "application/json",
        					url : "api/importAdm",
        					data : JSON.stringify(search),
        					dataType : 'json',
        					timeout : 100000,
        					success : function(data) {
                                $("#errorAlert").hide();
                                $("#successAlert").show();
        					},
        					error : function(e) {
                                $("#errorAlert").show();
                                $("#successAlert").hide();
        					},
        					done : function(e) {
        						console.log("DONE");
        					}
        				});
        			};

        			function copyToClipboard() {
        				var target = jQuery('#outputTextarea');
        				target.attr('type', 'text');
        				target.focus();
        				target[0].setSelectionRange(0, target.val().length);

        				var succeed;
        				try {
        					succeed = document.execCommand("copy");
        				} catch (e) {
        					succeed = false;
        				}

        				target.attr('type', 'hidden');

        				return succeed;
        			}
        		});
        	</script>
	</body>
</html>