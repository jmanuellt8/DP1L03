<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<acme:form>
	<fieldset>
	<legend>
		<acme:message code=".banner.commercial.banner" />
	</legend>
		<acme:form-textbox code="administrator.banner.commercial.picture" path="picture" />
		<acme:form-textbox code="administrator.banner.commercial.slogan" path="slogan" />
		<acme:form-textbox code="administrator.banner.commercial.targetURL" path="targetURL" />
	</fieldset>
	<fieldset>
		<legend>
			<acme:message code="administrator.banner.commercial.creditCard" />
		</legend>
		<acme:form-textbox code="administrator.banner.commercial.brand" path="brand" />
		<acme:form-textbox code="administrator.banner.commercial.cvv" path="CVV" />
		<acme:form-textbox code="administrator.banner.commercial.expMonth" path="expirationMonth" />
		<acme:form-textbox code="administrator.banner.commercial.expYear" path="expirationYear" />
	</fieldset>

	<acme:form-submit test="${command == 'show'}"
					  code="administrator.banner.commercial.form.button.update"
					  action="/administrator/commercial-banner/update"/>

	<acme:form-submit test="${command == 'show'}"
					  code="administrator.banner.commercial.form.button.delete"
					  action="/administrator/commercial-banner/delete"/>

	<acme:form-submit test="${command == 'create'}"
					  code="administrator.banner.commercial.form.button.create"
					  action="/administrator/commercial-banner/create"/>

	<acme:form-submit test="${command == 'update'}"
					  code="administrator.banner.commercial.form.button.update"
					  action="/administrator/commercial-banner/update"/>

	<acme:form-submit test="${command == 'delete'}"
					  code="administrator.banner.commercial.form.button.delete"
					  action="/administrator/commercial-banner/delete"/>

	<acme:form-return code="administrator.banner.commercial.form.button.return" />

</acme:form>

