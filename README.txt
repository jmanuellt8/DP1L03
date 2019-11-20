# README.txt
#
# Copyright (c) 2019 Rafael Corchuelo.
#
# In keeping with the traditional purpose of furthering education and research, it is
# the policy of the copyright owner to permit non-commercial use and redistribution of
# this software. It has been tested carefully, but it is not guaranteed for any particular
# purposes.  The copyright owner does not offer any warranties or representations, nor do
# they accept any liabilities with respect to them.

This is the Acme-Jobs project, which is intended to be a core learning asset for the students
who have enroled the Design and Testing subject of the Software Engineering curriculum of the 
University of Sevilla.  This project provides a template our students can use to get their projects 
up and running very quickly.

Correcciones:
	-En la entidad Company record, le hemos añadido la anotacion @URL a la propiedad website
	-En anonymous hemos añadido top investor y top companies
	-En la entidad Announcement, se ha eliminado la anotacion NotNull a la propiedad moment
	-Hemos arreglado el Dashboard ya que antes no se trataba que pudiera no haber datos para iterar 
		y al intentar hacer una iteracion donde empezaba en 0 y acababa en -1, fallaba.
	-Tanto para Company record como para Investor record se ha cambiado el tipo de la propiedad star
	de string a integer, se le ha añadido las anotaciones NotNull, Min(0) y Max(5)
	-Se ha cambiado el nombre de la entidad EntityRequest a Request_
	-Se ha añadido la anotacion de NotNull en la propiedad deadline de las entidades Request_,
		Challenge y Offer
	-De AuthenticatedChallengeRepository y AuthenticatedRequestRepository se cambiaron los nombres
		de los metodos a findOneChallengeById y findOneRequestById respectivamente
	-En form.jsp de authenticated-request, se cambio acme:form-money por acme:form-double
	-En form.jsp de authenticated challenge se añadio una linea para mostrar el deadline