<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'permission.label', default: 'Permission')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-permission" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="col-sm-offset-2 col-sm-10">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
		</div>
		<div class="container">
			<g:render template="/templates/shirodemo/sidemenu" model="[active: 'create']"/>
			<div class="col-sm-4">
				<div class="content scaffold-create" role="main">
					<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
					</g:if>
					<g:hasErrors bean="${permissionInstance}">
					<ul class="errors" role="alert">
						<g:eachError bean="${permissionInstance}" var="error">
						<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
						</g:eachError>
					</ul>
					</g:hasErrors>
					<g:form url="[resource:permissionInstance, action:'save']" >
						<fieldset class="form">
							<g:render template="form"/>
						</fieldset>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-primary">
									<g:message code="default.button.create.label" default="Create" />
								</button>
	                            <g:link class="list" action="index" class="btn btn-warning">
	                                    <g:message code="default.button.cancel.label" default="Cancel" />
	                            </g:link>
	                        </div>
						</div>
					</g:form>
				</div>
			</div>
		</div>
	</body>
</html>
