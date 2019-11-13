
package acme.features.administrator.banner.commercial;

import acme.entities.banners.CommercialBanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;
import acme.framework.entities.Authenticated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/administrator/commercial-banner/")
public class AdministratorCommercialBannerController extends AbstractController<Administrator, CommercialBanner> {

	@Autowired
	private AdministratorCommercialBannerCreateService createService;

	@Autowired
	private AdministratorCommercialBannerUpdateService updateService;

	@Autowired
	private AdministratorCommercialBannerDeleteService	deleteService;

	//TODO: Añadir método de show y de list para el administrador


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, deleteService);
	}
}
