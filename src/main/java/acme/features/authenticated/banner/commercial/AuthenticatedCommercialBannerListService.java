
package acme.features.authenticated.banner.commercial;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.CommercialBanner;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedCommercialBannerListService implements AbstractListService<Authenticated, CommercialBanner> {

	@Autowired
	private AuthenticatedCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<CommercialBanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<CommercialBanner> request, final CommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "slogan", "targetURL");

	}

	@Override
	public Collection<CommercialBanner> findMany(final Request<CommercialBanner> request) {

		return this.repository.findMany();

	}

}
