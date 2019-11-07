
package acme.features.anonymous.bulletins.horrilloBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.HorrilloBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousHorrilloBulletinListService implements AbstractListService<Anonymous, HorrilloBulletin> {

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

		request.unbind(entity, model, "title", "text", "moment");
	}

	@Override
	public Collection<HorrilloBulletin> findMany(final Request<HorrilloBulletin> request) {
		assert request != null;

		Collection<HorrilloBulletin> result;

		result = this.repository.findMany();

		return result;
	}

}
