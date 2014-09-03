
<%@ page import="com.example.Permission" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'permission.label', default: 'Permission')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="col-sm-offset-2 col-sm-10">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
		</div>
		<g:render template="/templates/shirodemo/sidemenu" model="[active: 'list']"/>
		<div class="col-md-10 row-fluid">
			<div id="list-permission" class="content scaffold-list" role="main">
				<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
				</g:if>
				<table class="table table-striped">
				<thead>
						<tr>
						
							<g:sortableColumn property="acl" title="${message(code: 'permission.acl.label', default: 'Acl')}" />
						
							<g:sortableColumn property="dateCreated" title="${message(code: 'permission.dateCreated.label', default: 'Date Created')}" />
						
							<g:sortableColumn property="lastUpdated" title="${message(code: 'permission.lastUpdated.label', default: 'Last Updated')}" />
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${permissionInstanceList}" status="i" var="permissionInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${permissionInstance.id}">${fieldValue(bean: permissionInstance, field: "acl")}</g:link></td>
						
							<td><g:formatDate date="${permissionInstance.dateCreated}" /></td>
						
							<td><g:formatDate date="${permissionInstance.lastUpdated}" /></td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${permissionInstanceCount ?: 0}" />
				</div>
			</div>
		</div>
	</body>
</html>
