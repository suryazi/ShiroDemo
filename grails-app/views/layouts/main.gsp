<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${assetPath(src: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${assetPath(src: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${assetPath(src: 'apple-touch-icon-retina.png')}">
    <asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
		<g:layoutHead/>
	</head>
	<body>

    <div class="container theme-showcase" role="navigation">

      <div class="navbar navbar-inverse">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">ShiroDemo</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li><g:link controller="Permission">Permission</g:link></li>
              <li><g:link controller="Role">Role</g:link></li>
              <li><g:link controller="User">User</g:link></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Home <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><g:link controller="Home" action="index">Index</g:link></li>
                  <li class="divider"></li>
                  <li class="dropdown-header">Admin</li>
                  <li><g:link controller="Home" action="admin">admin</g:link></li>
                </ul>
              </li>
              <li><g:link controller="Auth" action="signOut">Sign Out</g:link> </li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>

		</div>
    <div class="container">
      <div class="starter-template">
        <g:layoutBody/>
        <div class="col-sm-12">
          <footer>
            &copy;
            <shiro:copyright startYear="2013">Cloud Computing Company.</shiro:copyright>  
          </footer>
        </div>
      </div>
    </div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>
