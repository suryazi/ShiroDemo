<%@ page import="com.example.Permission" %>



<div class="fieldcontain ${hasErrors(bean: permissionInstance, field: 'acl', 'error')} required">
	<label for="acl">
		<g:message code="permission.acl.label" default="Acl" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="acl" required="" value="${permissionInstance?.acl}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: permissionInstance, field: 'roles', 'error')} ">
	<label for="roles">
		<g:message code="permission.roles.label" default="Roles" />
		
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: permissionInstance, field: 'users', 'error')} ">
	<label for="users">
		<g:message code="permission.users.label" default="Users" />
		
	</label>
	

</div>

