
package acme.features.authenticated.entityRequest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.entityRequest.EntityRequest;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/entity-request/")
public class AuthenticatedEntityRequestController extends AbstractController<Authenticated, EntityRequest> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedEntityRequestListService	listService;

	@Autowired
	private AuthenticatedEntityRequestShowService	showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
