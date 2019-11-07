<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.entity-request.list.label.ticker" path="ticker" />
	<acme:form-textbox code="authenticated.entity-request.list.label.title" path="title" />
	<acme:form-textarea code="authenticated.entity-request.list.label.description" path="description" />
	<acme:form-moment code="authenticated.entity-request.list.label.creationMoment" path="creationMoment"/>
	<acme:form-money code="authenticated.entity-request.list.label.deadline" path="deadline"/>
	<acme:form-money code="authenticated.entity-request.list.label.reward" path="reward"/>

	<acme:form-return code="authenticated.entity-request.form.button.return" />
</acme:form> 
