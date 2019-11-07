
package acme.features.authenticated.companyRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.records.CompanyRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedCompanyRecordListService implements AbstractListService<Authenticated, CompanyRecord> {

	@Autowired
	AuthenticatedCompanyRecordRepository repository;


	@Override
	public boolean authorise(final Request<CompanyRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<CompanyRecord> request, final CompanyRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Boolean inc = entity.getIncorporation();

		request.unbind(entity, model, "companyName", "sector", "CEOName", "activitiesDescription", "website", "phone", "email", "incorporation", "stars");
		model.setAttribute("incorporation", inc);
	}

	@Override
	public Collection<CompanyRecord> findMany(final Request<CompanyRecord> request) {
		assert request != null;

		Collection<CompanyRecord> result;
		result = this.repository.findManyAll();

		return result;
	}

}
