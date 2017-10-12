package by.tc.task01.dao.impl.creator;

import by.tc.task01.dao.impl.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class RefrigeratorCreator implements ApplianceCreator{

    @Override
    public Appliance getAppliance(Map<String, Object> properties) {
        Refrigerator refrigerator = new Refrigerator();
        try {
            refrigerator.setFreezerCapacity(Double.parseDouble(properties.get(SearchCriteria.Refrigerator.FREEZER_CAPACITY.name()).toString()));
            refrigerator.setHeight(Double.parseDouble(properties.get(SearchCriteria.Refrigerator.HEIGHT.name()).toString()));
            refrigerator.setOveralCapacity(Double.parseDouble(properties.get(SearchCriteria.Refrigerator.OVERALL_CAPACITY.name()).toString()));
            refrigerator.setPowerConsumption(Integer.parseInt(properties.get(SearchCriteria.Refrigerator.POWER_CONSUMPTION.name()).toString()));
            refrigerator.setWeight(Double.parseDouble(properties.get(SearchCriteria.Refrigerator.WEIGHT.name()).toString()));
            refrigerator.setWidth(Double.parseDouble(properties.get(SearchCriteria.Refrigerator.WIDTH.name()).toString()));
        } catch (NumberFormatException | NullPointerException e) {
            refrigerator = null;
        }
        return refrigerator;
    }
}
