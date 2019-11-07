
package acme.features.anonymous.bulletins.perezBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.PerezBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousPerezBulletinCreateService implements AbstractCreateService<Anonymous, PerezBulletin> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AnonymousPerezBulletinRepository repository;


	@Override
	public boolean authorise(final Request<PerezBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<PerezBulletin> request, final PerezBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "content");
	}

	@Override
	public void bind(final Request<PerezBulletin> request, final PerezBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<PerezBulletin> request, final PerezBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<PerezBulletin> request, final PerezBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}

	@Override
	public PerezBulletin instantiate(final Request<PerezBulletin> request) {
		assert request != null;

		PerezBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new PerezBulletin();
		result.setTitle("Título");
		result.setContent("Contenido");
		result.setMoment(moment);

		return result;
	}

}
