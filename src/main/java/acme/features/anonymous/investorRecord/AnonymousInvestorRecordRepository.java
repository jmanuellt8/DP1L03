
package acme.features.anonymous.investorRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorRecords.InvestorRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousInvestorRecordRepository extends AbstractRepository {

	@Query("select i from InvestorRecord i")
	Collection<InvestorRecord> findMany();

	@Query("select i from InvestorRecord i where i.id = ?1")
	InvestorRecord findOneInvestorRecordById(int id);

}
