package acme.features.administrator.banner.noncommercial;

import acme.entities.banners.NonCommercialBanner;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorNonCommercialBannerDeleteService implements AbstractDeleteService<Administrator, NonCommercialBanner> {
    @Autowired
    private AdministratorNonCommercialBannerRepository repository;

    @Override
    public boolean authorise(Request<NonCommercialBanner> request) {
        assert  request != null;
        return true;
    }

    @Override
    public void bind(Request<NonCommercialBanner> request, NonCommercialBanner entity, Errors errors) {
        assert request != null;
        assert entity != null;
        assert errors != null;

        request.bind(entity, errors);
    }

    @Override
    public void unbind(Request<NonCommercialBanner> request, NonCommercialBanner entity, Model model) {
        assert request != null;
        assert entity != null;
        assert model != null;

        request.unbind(entity, model, "picture", "slogan", "targetURL", "jingle");
    }

    @Override
    public NonCommercialBanner findOne(Request<NonCommercialBanner> request) {

        return this.repository.findOne(request.getModel().getInteger("id"));
    }

    @Override
    public void validate(Request<NonCommercialBanner> request, NonCommercialBanner entity, Errors errors) {
        assert request != null;
        assert entity != null;
        assert errors != null;
    }

    @Override
    public void delete(Request<NonCommercialBanner> request, NonCommercialBanner entity) {
        assert request != null;
        assert entity != null;

        this.repository.delete(entity);

    }
}
