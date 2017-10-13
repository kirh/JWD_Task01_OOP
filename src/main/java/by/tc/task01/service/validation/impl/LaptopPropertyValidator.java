package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.criteria.SearchCriteria.Laptop;
import by.tc.task01.service.validation.PropertyValidator;

import static by.tc.task01.service.validation.ValidatorUtils.isValidString;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveDouble;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveInt;

public class LaptopPropertyValidator implements PropertyValidator {
    @Override
    public boolean validate(String propName, Object value) {
        if (propName.equals(Laptop.CPU.name()) || propName.equals(Laptop.BATTERY_CAPACITY.name())
                || propName.equals(Laptop.DISPLAY_INCHS.name())) {
            return isPositiveDouble(value);
        }
        if (propName.equals(Laptop.MEMORY_ROM.name()) || propName.equals(Laptop.SYSTEM_MEMORY.name())) {
            return isPositiveInt(value);
        }
        if (propName.equals(Laptop.OS.name())) {
            return isValidString(value);
        }
        return false;
    }
}
