package by.tc.task01.dao.impl.factory;

import by.tc.task01.entity.Refrigerator;

import java.util.Map;

import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator.FREEZER_CAPACITY;
import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator.HEIGHT;
import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator.OVERALL_CAPACITY;
import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator.POWER_CONSUMPTION;
import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator.WIDTH;
import static by.tc.task01.entity.criteria.SearchCriteria.Refrigerator.WEIGHT;

final class RefrigeratorCreator implements ApplianceCreator {

    @Override
    public Refrigerator getAppliance(Map<String, Object> properties) {
        Refrigerator refrigerator = new Refrigerator();
        try {
            refrigerator.setFreezerCapacity(Double.parseDouble(properties.get(FREEZER_CAPACITY.name()).toString()));
            refrigerator.setHeight(Double.parseDouble(properties.get(HEIGHT.name()).toString()));
            refrigerator.setOveralCapacity(Double.parseDouble(properties.get(OVERALL_CAPACITY.name()).toString()));
            refrigerator.setPowerConsumption(Integer.parseInt(properties.get(POWER_CONSUMPTION.name()).toString()));
            refrigerator.setWeight(Double.parseDouble(properties.get(WEIGHT.name()).toString()));
            refrigerator.setWidth(Double.parseDouble(properties.get(WIDTH.name()).toString()));
        } catch (NumberFormatException | NullPointerException e) {
            refrigerator = null;
        }
        return refrigerator;
    }
}
