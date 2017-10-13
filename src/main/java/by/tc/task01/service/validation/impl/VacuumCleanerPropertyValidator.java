package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner;
import by.tc.task01.service.validation.PropertyValidator;

import static by.tc.task01.service.validation.ValidatorUtils.isValidString;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveInt;

public class VacuumCleanerPropertyValidator implements PropertyValidator {
    @Override
    public boolean validate(String propName, Object value) {
        if (propName.equals(VacuumCleaner.CLEANING_WIDTH.name()) || propName.equals(VacuumCleaner.MOTOR_SPEED_REGULATION.name())
                || propName.equals(VacuumCleaner.POWER_CONSUMPTION.name())) {
            return isPositiveInt(value);
        }
        if (propName.equals(VacuumCleaner.BAG_TYPE.name()) || propName.equals(VacuumCleaner.FILTER_TYPE.name())
                || propName.equals(VacuumCleaner.WAND_TYPE.name())) {
            return isValidString(value);
        }
        return false;
    }
}
