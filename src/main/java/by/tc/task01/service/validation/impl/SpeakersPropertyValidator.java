package by.tc.task01.service.validation.impl;

import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.validation.PropertyValidator;

import static by.tc.task01.service.validation.ValidatorUtils.isPositiveDouble;
import static by.tc.task01.service.validation.ValidatorUtils.isPositiveInt;
import static by.tc.task01.service.validation.ValidatorUtils.isRange;

public class SpeakersPropertyValidator implements PropertyValidator {
    @Override
    public boolean validate(String propName, Object value) {
        if (propName.equals(SearchCriteria.Speakers.POWER_CONSUMPTION.name()) || propName.equals(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.name())) {
            return isPositiveInt(value);
        }
        if (propName.equals(SearchCriteria.Speakers.CORD_LENGTH.name())) {
            return isPositiveDouble(value);
        }
        if (propName.equals(SearchCriteria.Speakers.FREQUENCY_RANGE.name())) {
            return isRange(value);
        }
        return false;
    }
}
