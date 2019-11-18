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

<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>

<acme:form>
    <fieldset>
        <legend>
            <acme:message code="administrator.banner.non-commercial.banner"/>
        </legend>
        <acme:form-textbox code="administrator.banner.non-commercial.picture" path="picture"/>
        <acme:form-textbox code="administrator.banner.non-commercial.slogan" path="slogan"/>
        <acme:form-textbox code="administrator.banner.non-commercial.targetURL" path="targetURL"/>
    </fieldset>
    <fieldset>
        <acme:form-textbox code="administrator.banner.non-commercial.jingle" path="jingle"/>
    </fieldset>

    <acme:form-submit test="${command == 'show'}"
                      code="administrator.banner.non-commercial.form.button.update"
                      action="/administrator/non-commercial-banner/update"/>

    <acme:form-submit test="${command == 'show'}"
                      code="administrator.banner.non-commercial.form.button.delete"
                      action="/administrator/non-commercial-banner/delete"/>

    <acme:form-submit test="${command == 'create'}"
                      code="administrator.banner.non-commercial.form.button.create"
                      action="/administrator/non-commercial-banner/create"/>

    <acme:form-submit test="${command == 'update'}"
                      code="administrator.banner.non-commercial.form.button.update"
                      action="/administrator/non-commercial-banner/update"/>

    <acme:form-submit test="${command == 'delete'}"
                      code="administrator.banner.non-commercial.form.button.delete"
                      action="/administrator/non-commercial-banner/delete"/>

    <acme:form-return code="administrator.banner.non-commercial.form.button.return"/>
</acme:form>
