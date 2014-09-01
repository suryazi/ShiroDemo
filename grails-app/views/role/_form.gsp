<%@ page import="com.example.Role" %>



<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="role.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${roleInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'permissions', 'error')} ">
	<label for="permissions">
		<g:message code="role.permissions.label" default="Permissions" />
		
	</label>
	<g:select name="permissions" from="${com.example.Permission.list()}" multiple="multiple" optionKey="id" size="5" value="${roleInstance?.permissions*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'users', 'error')} ">
	<label for="users">
		<g:message code="role.users.label" default="Users" />
		
	</label>
	

</div>

