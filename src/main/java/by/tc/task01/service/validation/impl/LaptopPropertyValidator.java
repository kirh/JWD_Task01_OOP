package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.PropertyValidator;

import static by.tc.task01.service.validation.ValidatorUtils.isEmptyString;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveDouble;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveInt;

public class LaptopPropertyValidator implements PropertyValidator {
    @Override
    public boolean validate(String propName, Object value) {
        if (propName.equals(SearchCriteria.Laptop.CPU.name()) || propName.equals(SearchCriteria.Laptop.BATTERY_CAPACITY.name())
                || propName.equals(SearchCriteria.Laptop.DISPLAY_INCHS.name())) {
            return isPositiveDouble(value);
        }
        if (propName.equals(SearchCriteria.Laptop.MEMORY_ROM.name()) || propName.equals(SearchCriteria.Laptop.SYSTEM_MEMORY.name())) {
            return isPositiveInt(value);
        }
        if (propName.equals(SearchCriteria.Laptop.OS.name())) {
            return !isEmptyString(value);
        }
        return false;
    }
}
