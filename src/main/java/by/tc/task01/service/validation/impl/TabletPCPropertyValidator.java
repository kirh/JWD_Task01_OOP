package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.criteria.SearchCriteria.TabletPC;
import by.tc.task01.service.validation.PropertyValidator;

import static by.tc.task01.service.validation.ValidatorUtils.isValidString;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveDouble;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveInt;

public class TabletPCPropertyValidator implements PropertyValidator {
    @Override
    public boolean validate(String propName, Object value) {
        if (propName.equals(TabletPC.BATTERY_CAPACITY.name()) || propName.equals(TabletPC.DISPLAY_INCHES.name())) {
            return isPositiveDouble(value);
        }
        if (propName.equals(TabletPC.FLASH_MEMORY_CAPACITY.name()) || propName.equals(TabletPC.MEMORY_ROM.name())) {
            return isPositiveInt(value);
        }
        if (propName.equals(TabletPC.COLOR.name())) {
            return isValidString(value);
        }
        return false;
    }
}
