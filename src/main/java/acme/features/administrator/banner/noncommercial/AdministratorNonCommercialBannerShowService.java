
package acme.features.administrator.banner.noncommercial;

import acme.entities.banners.NonCommercialBanner;
import acme.features.authenticated.banner.noncommercial.AuthenticatedNonCommercialBannerRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorNonCommercialBannerShowService implements AbstractShowService<Administrator, NonCommercialBanner> {

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

		request.unbind(entity, model, "picture", "slogan", "targetURL", "jingle");
	}

	@Override
	public NonCommercialBanner findOne(final Request<NonCommercialBanner> request) {

		return this.repository.findOne(request.getModel().getInteger("id"));
	}

}
