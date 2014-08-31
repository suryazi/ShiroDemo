<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Register</title>
    <meta name="layout" content="main" />
</head>

<body>
    <div class="container">
      
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>

      <g:hasErrors bean="${user}">
        <div class="alert alert-error">
            <g:renderErrors bean="${user}" as="list"/>
        </div>
      </g:hasErrors>

      <form class="form-signin" role="form" action="register">
        <label for="username">User Name:</label>
        <input type="email" class="form-control" placeholder="Email address" name="username" value="${username}" required autofocus>
        <label for="password">Password:</label>
        <input type="password" class="form-control" placeholder="Password" name="password" value="" required>
        <label for="password2">Confirm Password:</label>
        <input type="password" class="form-control" placeholder="Confirm Password" name="password2" value="" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
      <form>
    </div>
</body>

</html>