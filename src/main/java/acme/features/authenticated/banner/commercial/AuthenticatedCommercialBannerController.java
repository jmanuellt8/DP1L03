
package acme.features.authenticated.banner.commercial;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.banners.CommercialBanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/commercial-banner/")
public class AuthenticatedCommercialBannerController extends AbstractController<Authenticated, CommercialBanner> {

	@Autowired
	private AuthenticatedCommercialBannerCreateService	createService;

	@Autowired
	private AuthenticatedCommercialBannerListService	listService;

	@Autowired
	private AuthenticatedCommercialBannerShowService	showService;

	@Autowired
	private AuthenticatedCommercialBannerUpdateService	updateService;
	//TODO: Añadir esto al inis... y en el commercial banner igual


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
