
package acme.features.authenticated.banner.noncommercial;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.banners.NonCommercialBanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/non-commercial-banner/")
public class AuthenticatedNonCommercialBannerController extends AbstractController<Authenticated, NonCommercialBanner> {

	@Autowired
	private AuthenticatedNonCommercialBannerCreateService	create;

	@Autowired
	private AuthenticatedNonCommercialBannerListService		list;

	@Autowired
	private AuthenticatedNonCommercialBannerShowService		show;


	@PostConstruct
	private void initialize() {
		super.addBasicCommand(BasicCommand.LIST, this.list);
		super.addBasicCommand(BasicCommand.CREATE, this.create);
		super.addBasicCommand(BasicCommand.SHOW, this.show);
	}
}
