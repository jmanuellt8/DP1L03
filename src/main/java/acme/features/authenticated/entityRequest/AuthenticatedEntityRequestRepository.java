
package acme.features.authenticated.entityRequest;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.entityRequest.EntityRequest;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedEntityRequestRepository extends AbstractRepository {

	@Query("select r from EntityRequest r where r.id = ?1")
	EntityRequest findOneOfferById(int id);

	@Query("select r from EntityRequest r")
	Collection<EntityRequest> findMany();

}
