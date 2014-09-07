
<%@ page import="com.example.Role" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="col-sm-offset-2 col-sm-10">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
		</div>
		<g:render template="/templates/shirodemo/sidemenu" model="[active: 'list']"/>
		<div class="col-md-10 row-fluid">
			<div id="list-role" class="content scaffold-list" role="main">
				<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
				</g:if>
				<table class="table table-striped">
				<thead>
						<tr>
						
							<g:sortableColumn property="name" title="${message(code: 'role.name.label', default: 'Name')}" />
						
							<g:sortableColumn property="dateCreated" title="${message(code: 'role.dateCreated.label', default: 'Date Created')}" />
						
							<g:sortableColumn property="lastUpdated" title="${message(code: 'role.lastUpdated.label', default: 'Last Updated')}" />
						
						</tr>
					</thead>
					<tbody>
					<g:each in="${roleInstanceList}" status="i" var="roleInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link action="show" id="${roleInstance.id}">${fieldValue(bean: roleInstance, field: "name")}</g:link></td>
						
							<td><g:formatDate date="${roleInstance.dateCreated}" /></td>
						
							<td><g:formatDate date="${roleInstance.lastUpdated}" /></td>
						
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="pagination">
					<g:paginate total="${roleInstanceCount ?: 0}" />
				</div>
			</div>
		</div>
	</body>
</html>
