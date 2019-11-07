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

<acme:form>
	<acme:form-textbox code="authenticated.investor-record.form.label.name" path="name"/>
	<acme:form-textbox code="authenticated.investor-record.form.label.sector" path="sector"/>
	<acme:form-textarea code="authenticated.investor-record.form.label.statement" path="investingStatement"/>
	
	<!-- <!--
	Aquí debería ir esta tag
	<acme:form-textarea code="authenticated.investor-record.form.label.stars" path="stars"/>
	Pero no sé si esa entidad es derivada o no, así que lo dejo preparado por si acaso no lo fuera.
	Si no lo es, queda añadir a los mensajes de internacionalización ese code. -->

  	<acme:form-return code="authenticated.investor-record.form.button.return"/>
</acme:form>
