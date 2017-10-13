package by.tc.task01.dao.impl.factory;

import by.tc.task01.entity.Speakers;

import java.util.Map;

import static by.tc.task01.entity.criteria.SearchCriteria.Speakers.CORD_LENGTH;
import static by.tc.task01.entity.criteria.SearchCriteria.Speakers.FREQUENCY_RANGE;
import static by.tc.task01.entity.criteria.SearchCriteria.Speakers.NUMBER_OF_SPEAKERS;
import static by.tc.task01.entity.criteria.SearchCriteria.Speakers.POWER_CONSUMPTION;

final class SpeakersCreator implements ApplianceCreator {

    @Override
    public Speakers getAppliance(Map<String, Object> properties) {
        Speakers speakers = new Speakers();
        try {
            speakers.setCordLength(Double.parseDouble(properties.get(CORD_LENGTH.name()).toString()));
            speakers.setFrequencyRange(properties.get(FREQUENCY_RANGE.name()).toString());
            speakers.setNumberOfSpekears(Integer.parseInt(properties.get(NUMBER_OF_SPEAKERS.name()).toString()));
            speakers.setPowerConsumption(Integer.parseInt(properties.get(POWER_CONSUMPTION.name()).toString()));
        } catch (NumberFormatException | NullPointerException e) {
            speakers = null;
        }
        return speakers;
    }
}
