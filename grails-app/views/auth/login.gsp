<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="layout" content="signin" />

    <title>Signin</title>

    
  </head>

  <body>

    <div class="container">

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>

      <form class="form-signin" role="form" action="signIn">
        <input type="hidden" name="targetUri" value="${targetUri}" />
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="email" class="form-control" placeholder="Email address" name="username" value="${username}" required autofocus>
        <input type="password" class="form-control" placeholder="Password" name="password" value="" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me" name="rememberMe" value="${rememberMe}"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>