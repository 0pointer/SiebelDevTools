<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<nav class="navbar navbar-default">
   <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">

         <a class="navbar-brand" href="#">
            ECB Dev Tools
         </a>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-th-large" aria-hidden="true"></span> Entwicklung<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li><a href="scaffolding">Scaffolder</a></li>
                  <li><a href="scaffolding">Quellcodesuche</a></li>
               </ul>
            </li>
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-save-file" aria-hidden="true"></span> Deployment<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li><a href="/svn/adm">ADM</a></li>
                  <li><a href="/svn/merge">Merge</a></li>
               </ul>
            </li>
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-flash" aria-hidden="true"></span> Test<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li><a href="converter">Testdatenermittlung</a></li>
               </ul>
            </li>
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-scissors" aria-hidden="true"></span> Maintenance<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li><a href="/maintenance/siebservice">Datenkorrekturen</a></li>
               </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> Tools<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/tools/converter">Converter</a></li>
                        <li><a href="/tools/linklist">Linkliste</a></li>
                    </ul>
                </li>
         </ul>
         <form:form modelAttribute="environmentConfiguration" class="navbar-form navbar-right">
            <div class="form-group">
               <div class="input-group">
                  <span class="input-group-addon">Umgebung</span>
                    <form:select id="environment" path="curEnvironment" class="form-control">
                          <form:option value="-" label="-"/>
                          <form:options items="${environmentConfiguration.environments}" itemValue="id" itemLabel="abbreviation"/>
                     </form:select>
               </div>
            </div>
         </form:form>
         <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
               <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-user"></span></a>
               <ul class="dropdown-menu">
                  <li><a href="#">Informationen</a></li>
                  <li><a href="/logout">Abmelden</a></li>
               </ul>
            </li>

         </ul>
                  <ul class="nav navbar-nav navbar-right">
                     <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-tasks"></span></a>
                        <ul class="dropdown-menu">
                           <li><a href="#">Keine offenen Tasks</a></li>
                        </ul>
                     </li>
                  </ul>
      </div>
   </div>
</nav>