package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.PropertyValidator;

import static by.tc.task01.service.validation.ValidatorUtils.isEmptyString;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveInt;

public class VacuumCleanerPropertyValidator implements PropertyValidator {
    @Override
    public boolean validate(String propName, Object value) {
        if (propName.equals(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.name()) || propName.equals(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.name())
                || propName.equals(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.name())) {
            return isPositiveInt(value);
        }
        if (propName.equals(SearchCriteria.VacuumCleaner.BAG_TYPE.name()) || propName.equals(SearchCriteria.VacuumCleaner.FILTER_TYPE.name())
                || propName.equals(SearchCriteria.VacuumCleaner.WAND_TYPE.name())) {
            return !isEmptyString(value);
        }
        return false;
    }
}
