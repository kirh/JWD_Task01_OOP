package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;
import by.tc.task01.service.validation.ValidatorNotFoundException;

public class ApplianceServiceImpl implements ApplianceService {

	@Override
	public <E> Appliance find(Criteria<E> criteria) {
		try {
			if (!Validator.criteriaValidator(criteria)) {
				return null;
			}
		} catch (ValidatorNotFoundException e) {
			return null;
		}

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();

		Appliance appliance = applianceDAO.find(criteria);

		return appliance;
	}

}
