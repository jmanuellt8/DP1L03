
package acme.features.administrator.banner.noncommercial;

import acme.entities.banners.NonCommercialBanner;
import acme.features.authenticated.banner.noncommercial.AuthenticatedNonCommercialBannerRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdministratorNonCommercialBannerListService implements AbstractListService<Administrator, NonCommercialBanner> {

	@Autowired
	private AuthenticatedNonCommercialBannerRepository repository;


	@Override
	public boolean authorise(final Request<NonCommercialBanner> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<NonCommercialBanner> request, final NonCommercialBanner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "slogan", "targetURL");

	}

	@Override
	public Collection<NonCommercialBanner> findMany(final Request<NonCommercialBanner> request) {

		return this.repository.findMany();
	}

}
