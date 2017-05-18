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
                <label class="control-label col-sm-2" for="pwd">Speicherort:</label>
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="pwd" placeholder="Geben Sie den Speicherort an">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default">Submit</button>
                </div>
              </div>
            </form>
	    </div>
	</body>
</html>