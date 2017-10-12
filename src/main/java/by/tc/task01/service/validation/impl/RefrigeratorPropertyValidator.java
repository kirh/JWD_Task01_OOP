package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.PropertyValidator;

import static by.tc.task01.service.validation.ValidatorUtils.isPositiveDouble;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveInt;

public class RefrigeratorPropertyValidator implements PropertyValidator {
    @Override
    public boolean validate(String propName, Object value) {
        if (propName.equals(SearchCriteria.Refrigerator.FREEZER_CAPACITY.name()) || propName.equals(SearchCriteria.Refrigerator.HEIGHT.name())
                || propName.equals(SearchCriteria.Refrigerator.OVERALL_CAPACITY.name()) || propName.equals(SearchCriteria.Refrigerator.WEIGHT.name())
                || propName.equals(SearchCriteria.Refrigerator.WIDTH.name())) {
            return isPositiveDouble(value);
        }
        if (propName.equals(SearchCriteria.Refrigerator.POWER_CONSUMPTION.name())) {
            return isPositiveInt(value);
        }
        return false;
    }
}
