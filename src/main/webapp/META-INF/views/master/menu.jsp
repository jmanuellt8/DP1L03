<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>

		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
		    <acme:menu-suboption code="master.menu.anonymous.company-record" action="/anonymous/company-record/list"/>
		    <acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.announcement.list" action="/anonymous/announcement/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.investor-record.list" action="/anonymous/investor-record/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.investor-record.top" action="/anonymous/investor-record/top"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.bulletins.list" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.lobatoBulletin.list" action="/anonymous/lobato-bulletin/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.garridoBulletin.list" action="/anonymous/garrido-bulletin/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.brionesBulletin.list" action="/anonymous/briones-bulletin/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.guerreroBulletin.list" action="/anonymous/guerrero-bulletin/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.horrilloBulletin.list" action="/anonymous/horrillo-bulletin/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.perezBulletin.list" action="/anonymous/perez-bulletin/list" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.bulletins.create" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.lobatoBulletin.create" action="/anonymous/lobato-bulletin/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.garridoBulletin.create" action="/anonymous/garrido-bulletin/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.brionesBulletin.create" action="/anonymous/briones-bulletin/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.guerreroBulletin.create" action="/anonymous/guerrero-bulletin/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.horrilloBulletin.create" action="/anonymous/horrillo-bulletin/create" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.anonymous.perezBulletin.create" action="/anonymous/perez-bulletin/create" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.anonymous.fav-link" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.favourite-link" action="http://www.example.com/"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.albgueram" action="https://github.com/albfree"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.github-josemanuel" action="https://github.com/jmanuellt8"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.linkedin-sergio" action="https://www.linkedin.com/in/sergio-garrido-dom%C3%ADnguez-5a58b2174/"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.brapercob" action="https://github.com/brapercob" />
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.favourite-link.diego" action="http://www.linkedin.com/in/diego-horrillo-dur�n-99b3b7197"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.carruibri" action="https://www.linkedin.com/in/carlos-ruiz-briones-bb8401173/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.announcement.list" action="/administrator/announcement/list"/>
        	<acme:menu-separator/>
        	<acme:menu-suboption code="master.menu.administrator.customization.list" action="/administrator/customization/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.banner.non-commercial.list" action="/administrator/commercial-banner/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.banner.commercial.list" action="/administrator/non-commercial-banner/list"/>
        	<acme:menu-separator/>
        	<acme:menu-suboption code="master.menu.administrator.investor-record.list" action="/administrator/investor-record/list"/>
        	<acme:menu-separator/>
        	<acme:menu-suboption code="master.menu.administrator.investor-record.create" action="/administrator/investor-record/create"/>
        </acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/" />
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.announcement" action="/authenticated/announcement/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.authenticated.offer" action="/authenticated/offer/list" />
			<acme:menu-separator />		
			<acme:menu-suboption code="master.menu.authenticated.investor-record" action="/authenticated/investor-record/list" />
			<acme:menu-separator />	
			<acme:menu-suboption code="master.menu.authenticated.request.list" action="/authenticated/entity-request/list"/>
			<acme:menu-separator />	
			<acme:menu-suboption code="master.menu.authenticated.challenge.list" action="/authenticated/challenge/list"/>
			<acme:menu-separator />	
			<acme:menu-suboption code="master.menu.authenticated.company-record.list" action="/authenticated/company-record/list"/>
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.banner.list.commercial" action="/authenticated/commercial-banner/list" />
			<acme:menu-separator />
			<acme:menu-suboption code="master.menu.banner.list.non-commercial" action="/authenticated/non-commercial-banner/list" />
		</acme:menu-option>

	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()" />
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()" />

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update" />
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create"
				access="!hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update"
				access="hasRole('Provider')" />
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create"
				access="!hasRole('Consumer')" />
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update"
				access="hasRole('Consumer')" />
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()" />
	</acme:menu-right>
</acme:menu-bar>
