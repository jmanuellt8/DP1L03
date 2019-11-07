<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="administrator.customization.list.label.spamWords" path="spamWords" />
	<acme:form-textbox code="administrator.customization.list.label.threshold" path="threshold" />
	

	<acme:form-return code="administrator.customization.form.button.return" />
</acme:form> 