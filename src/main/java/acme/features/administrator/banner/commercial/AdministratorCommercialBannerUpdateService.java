package acme.features.administrator.banner.commercial;

import acme.entities.banners.CommercialBanner;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorCommercialBannerUpdateService implements AbstractUpdateService<Administrator, CommercialBanner> {

    @Autowired
    private AdministratorCommercialBannerRepository repository;
    @Override
    public boolean authorise(Request<CommercialBanner> request) {
        assert request != null;

        return true;
    }

    @Override
    public void bind(Request<CommercialBanner> request, CommercialBanner entity, Errors errors) {
        assert request != null;
        assert entity != null;
        assert errors != null;

        request.bind(entity, errors);
    }

    @Override
    public void unbind(Request<CommercialBanner> request, CommercialBanner entity, Model model) {
        assert request != null;
        assert entity != null;
        assert model != null;

        request.unbind(entity, model, "picture", "targetURL", "slogan", "brand", "CVV", "expirationMonth", "expirationYear");
    }

    @Override
    public CommercialBanner findOne(Request<CommercialBanner> request) {
        assert request != null;
        return this.repository.findOne(request.getModel().getInteger("id"));
    }

    @Override
    public void validate(Request<CommercialBanner> request, CommercialBanner entity, Errors errors) {
        assert request != null;
        assert entity != null;
        assert errors != null;
    }

    @Override
    public void update(Request<CommercialBanner> request, CommercialBanner entity) {
        assert request != null;
        assert entity != null;

        this.repository.save(entity);
    }
}
