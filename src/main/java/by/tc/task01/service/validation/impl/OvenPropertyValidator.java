package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.PropertyValidator;

import static by.tc.task01.service.validation.ValidatorUtils.isPositiveDouble;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveInt;


public class OvenPropertyValidator implements PropertyValidator {
    @Override
    public boolean validate(String propName, Object value) {
        if (propName.equals(SearchCriteria.Oven.DEPTH.name()) || propName.equals(SearchCriteria.Oven.CAPACITY.name()) || propName.equals(SearchCriteria.Oven.HEIGHT.name())
                || propName.equals(SearchCriteria.Oven.WEIGHT.name()) || propName.equals(SearchCriteria.Oven.WIDTH.name())) {
            return isPositiveDouble(value);
        }
        if (propName.equals(SearchCriteria.Oven.POWER_CONSUMPTION.name())) {
            return isPositiveInt(value);
        }
        return false;
    }
}
