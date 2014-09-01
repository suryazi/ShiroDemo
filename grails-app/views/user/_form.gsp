<%@ page import="com.example.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="user.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="email" name="username" required="" value="${userInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwordHash', 'error')} required">
	<label for="passwordHash">
		<g:message code="user.passwordHash.label" default="Password Hash" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="passwordHash" required="" value="${userInstance?.passwordHash}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'passwordSalt', 'error')} required">
	<label for="passwordSalt">
		<g:message code="user.passwordSalt.label" default="Password Salt" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="passwordSalt" name="passwordSalt" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'permissions', 'error')} ">
	<label for="permissions">
		<g:message code="user.permissions.label" default="Permissions" />
		
	</label>
	<g:select name="permissions" from="${com.example.Permission.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.permissions*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'roles', 'error')} ">
	<label for="roles">
		<g:message code="user.roles.label" default="Roles" />
		
	</label>
	<g:select name="roles" from="${com.example.Role.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.roles*.id}" class="many-to-many"/>

</div>

