
package acme.features.authenticated.banner.commercial;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.banners.CommercialBanner;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedCommercialBannerRepository extends AbstractRepository {

	@Query("select cb from CommercialBanner cb")
	Collection<CommercialBanner> findMany();

	@Query("select cb from CommercialBanner cb where cb.id = ?1")
	CommercialBanner findOne(int id);

}
