<?xml version="1.0"?>
<html>
	<head>
	</head>
	<body>
		<div class="container">
			<div class="form-group">
				<label for="inputTextarea">Eingabe:</label>
				<textarea class="form-control" id="inputTextarea" rows="15"></textarea>
			</div>
			<div class="form-group">
				<label for="exampleSelect1">Ausgabeformat:</label>
				<select class="form-control" id="convertSelect">
					<option value="TAB_TO_JIRA">Tab to JIRA</option>
					<option value="ROWID_TO_SIEBELQL">RowId to SiebelQL ([Id]='XXX')</option>
					<option value="OR_CONNECTED">OR-Verknüft('XXX' OR 'YYY')</option>
				</select>
			</div>
			<div class="form-group">
				<label>Mit Überschrift: <input type="checkbox" id="hasHeaderCheckBox"></label>
			</div>
			<div class="form-group">
				<label for="outputTextarea">Ausgabe:</label>
				<textarea class="form-control" id="outputTextarea" rows="15"></textarea>
			</div>
			<button type="button" class="btn btn-primary" id="transformButton">Transform</button>
			<button type="button" class="btn btn-success" id="copyToClipboardButton">Copy to clipboard</button>
		</div>
	<script>
		$(document).ready(function(){
			$("#copyToClipboardButton").click(function(event) {
				copyToClipboard();
			});

			$("#transformButton").click(function(event) {
				convert();
			});

			function convert(){
				var search = {};

				search["request"] = jQuery("#inputTextarea").val();
				search["convertType"] = jQuery("#convertSelect").val();
				search["headerAvailable"] = jQuery("#hasHeaderCheckBox").is(':checked')?"true":"false";

				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "api/convert",
					data : JSON.stringify(search),
					dataType : 'json',
					timeout : 100000,
					success : function(data) {
						$("#outputTextarea").val(data.result);
					},
					error : function(e) {
						console.log("ERROR: ", e);
						$("#outputTextarea").val(e);
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