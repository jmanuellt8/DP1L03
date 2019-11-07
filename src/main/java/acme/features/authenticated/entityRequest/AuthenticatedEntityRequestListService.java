
package acme.features.authenticated.entityRequest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.entityRequest.EntityRequest;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedEntityRequestListService implements AbstractListService<Authenticated, EntityRequest> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedEntityRequestRepository repository;


	@Override
	public boolean authorise(final Request<EntityRequest> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<EntityRequest> request, final EntityRequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "description", "creationMoment", "deadline", "reward");
	}

	@Override
	public Collection<EntityRequest> findMany(final Request<EntityRequest> request) {
		assert request != null;

		Collection<EntityRequest> result;

		result = this.repository.findMany();

		return result;
	}

}
