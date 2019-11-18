
package acme.features.administrator.banner.noncommercial;

import acme.entities.banners.NonCommercialBanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;
import acme.framework.entities.Authenticated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/administrator/non-commercial-banner/")
public class AdministratorNonCommercialBannerController extends AbstractController<Administrator, NonCommercialBanner> {

	@Autowired
	private AdministratorNonCommercialBannerCreateService	createService;

	@Autowired
	private AdministratorNonCommercialBannerUpdateService updateService;

	@Autowired
	private AdministratorNonCommercialBannerDeleteService deleteService;

	@Autowired
	private AdministratorNonCommercialBannerListService listService;

	@Autowired
	private AdministratorNonCommercialBannerShowService showService;
	//TODO: Añadir método de show y de list para el administrador

	@PostConstruct
	private void initialize() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, deleteService);
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
}
