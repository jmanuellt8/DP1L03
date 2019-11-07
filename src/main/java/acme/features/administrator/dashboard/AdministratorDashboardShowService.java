
package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.forms.GroupedBy;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "numberOfAnnouncements", "numberOfCompanyRecords", "numberOfInvestorRecords", "minimumRewardsRequest", "maximumRewardsRequest", "avgRewardsRequest", "stddevRewardsRequest", "minimumRewardsOffers",
			"maximumRewardsOffers", "avgRewardsOffers", "stddevRewardsOffersFrom", "stddevRewardsOffersTo", "companiesSector", "investorGroupedBySector", "labels");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		Dashboard dashboard = new Dashboard();

		dashboard.setNumberOfAnnouncements(this.repository.countAnnouncement());
		dashboard.setNumberOfCompanyRecords(this.repository.countCR());
		dashboard.setNumberOfInvestorRecords(this.repository.countIR());

		dashboard.setMinimumRewardsRequest(this.repository.minEntityRequest());
		dashboard.setMaximumRewardsRequest(this.repository.maxEntityRequest());
		dashboard.setAvgRewardsRequest(this.repository.avgEntityRequest());
		dashboard.setStddevRewardsRequest(this.repository.stddevEntityRequest());

		dashboard.setMinimumRewardsOffers(this.repository.minOffer());
		dashboard.setMaximumRewardsOffers(this.repository.maxOffer());
		dashboard.setAvgRewardsOffers(this.repository.avgOffer());
		dashboard.setStddevRewardsOffersFrom(this.repository.fromStddev());
		dashboard.setStddevRewardsOffersTo(this.repository.toStddev());

		List<Object[]> result = this.repository.companyRecordGroupedBySector();
		List<String> text = new ArrayList<>();
		List<String> amount = new ArrayList<>();

		if (result != null && !result.isEmpty()) {
			for (Object[] o : result) {
				//GroupedBy g = new GroupedBy(o[0].toString(), Integer.parseInt(o[1].toString()));
				text.add(o[0].toString());
				amount.add(o[1].toString());
			}
		}

		GroupedBy companiesQuery = new GroupedBy(text, amount);
		dashboard.setCompaniesSector(companiesQuery);

		List<Object[]> result1 = this.repository.investorGroupedBySector();
		text = new ArrayList<>();
		amount = new ArrayList<>();
		if (result1 != null && !result1.isEmpty()) {
			for (Object[] o : result1) {
				text.add(o[0].toString());
				amount.add(o[1].toString());
			}
		}

		GroupedBy irQuiery = new GroupedBy(text, amount);
		dashboard.setInvestorGroupedBySector(irQuiery);

		List<String> sectors = new ArrayList<>();
		sectors.addAll(companiesQuery.getText());
		sectors.addAll(irQuiery.getText());
		String[] labels = new String[sectors.size()];
		for (int i = 0; i < sectors.size(); i++) {
			labels[i] = sectors.get(i);
		}

		dashboard.setLabels(labels);

		return dashboard;
	}
}
