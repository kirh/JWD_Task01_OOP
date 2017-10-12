package by.tc.task01.dao.impl.creator;

import by.tc.task01.dao.impl.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class SpeakersCreator implements ApplianceCreator{

    @Override
    public Appliance getAppliance(Map<String, Object> properties) {
        Speakers speakers = new Speakers();
        try {
            speakers.setCordLength(Double.parseDouble(properties.get(SearchCriteria.Speakers.CORD_LENGTH.name()).toString()));
            speakers.setFrequencyRange(properties.get(SearchCriteria.Speakers.FREQUENCY_RANGE.name()).toString());
            speakers.setNumberOfSpekears(Integer.parseInt(properties.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.name()).toString()));
            speakers.setPowerConsumption(Integer.parseInt(properties.get(SearchCriteria.Speakers.POWER_CONSUMPTION.name()).toString()));
        } catch (NumberFormatException | NullPointerException e) {
            speakers = null;
        }
        return speakers;
    }
}
