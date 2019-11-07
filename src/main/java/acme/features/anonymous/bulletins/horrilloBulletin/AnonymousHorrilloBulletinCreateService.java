
package acme.features.anonymous.bulletins.horrilloBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.HorrilloBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousHorrilloBulletinCreateService implements AbstractCreateService<Anonymous, HorrilloBulletin> {

	@Autowired
	AnonymousHorrilloBulletinRepository repository;


	@Override
	public boolean authorise(final Request<HorrilloBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<HorrilloBulletin> request, final HorrilloBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "text");
	}

	@Override
	public void bind(final Request<HorrilloBulletin> request, final HorrilloBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<HorrilloBulletin> request, final HorrilloBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<HorrilloBulletin> request, final HorrilloBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

	@Override
	public HorrilloBulletin instantiate(final Request<HorrilloBulletin> request) {
		assert request != null;

		HorrilloBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new HorrilloBulletin();
		result.setTitle("Bruce Wayne");
		result.setText("I just bought this entire hotel");
		result.setMoment(moment);

		return result;
	}

}
