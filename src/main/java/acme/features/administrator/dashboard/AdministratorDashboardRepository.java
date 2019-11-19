
package acme.features.administrator.dashboard;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.records.CompanyRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from Announcement a")
	Integer countAnnouncement();

	@Query("select cr from CompanyRecord cr where cr.stars = 5")
	Collection<CompanyRecord> getCRBy5Starts();

	@Query("select count(cr) from CompanyRecord cr")
	Integer countCR();

	@Query("select min(r.reward) * 1.0 from Request_ r")
	Double minEntityRequest();

	@Query("select  max(r.reward) * 1.0 from Request_ r")
	Double maxEntityRequest();

	@Query("select avg(r.reward)*1.0 from Request_ r")
	Double avgEntityRequest();

	@Query("select stddev(r.reward) * 1.0 from Request_ r")
	Double stddevEntityRequest();

	@Query("select min(o.rangeFrom.amount) From Offer o")
	Double minOffer();

	@Query("select max(o.rangeTo.amount) From Offer o")
	Double maxOffer();

	@Query("select (sum(o.rangeFrom.amount)+sum(o.rangeTo.amount))/(count(o.rangeFrom.amount)*2) From Offer o")
	Double avgOffer();

	@Query("select stddev(o.rangeFrom.amount) From Offer o")
	Double fromStddev();

	@Query("select stddev(o.rangeTo.amount) From Offer o")
	Double toStddev();

	@Query("select count(i) from InvestorRecord i")
	Integer countIR();

	@Query("select i.sector, count(i) from InvestorRecord i group by i.sector")
	List<Object[]> investorGroupedBySector();

	@Query("select cr.sector, count(cr) from CompanyRecord cr group by cr.sector")
	List<Object[]> companyRecordGroupedBySector();
}
