<div class="col-md-2" style="background-color: #dedef8; box-shadow:inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
    <ul class="nav nav-pills nav-stacked">
        <li class="nav-header">${entityName}</li>
          <g:if test="${pageScope?.getProperty('active')=='list'}">
            <li class="active">
          </g:if>
          <g:else>
            <li>
          </g:else>
                <g:link class="list" action="index">
                        <g:message code="default.list.label" args="[entityName]" />
                </g:link>
            </li>
          <g:if test="${pageScope?.getProperty('active')=='create'}">
            <li class="active">
          </g:if>
          <g:else>
            <li>
          </g:else>
                <g:link class="create" action="create">
                        <g:message code="default.add.label" args="[entityName]" />
                </g:link>
            </li>
          <g:if test="${pageScope?.getProperty('active')=='grid'}">
            <li class="active">
          </g:if>
          <g:else>
            <li>
          </g:else>
                <g:link class="grid" action="grid">
                        <g:message code="default.grid.label" args="[entityName]" />
                </g:link>
        	</li>
    </ul>
</div>