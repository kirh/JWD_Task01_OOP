package by.tc.task01.dao.impl.creator;

import by.tc.task01.dao.impl.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import static by.tc.task01.entity.criteria.SearchCriteria.Oven.CAPACITY;
import static by.tc.task01.entity.criteria.SearchCriteria.Oven.DEPTH;
import static by.tc.task01.entity.criteria.SearchCriteria.Oven.HEIGHT;
import static by.tc.task01.entity.criteria.SearchCriteria.Oven.WEIGHT;
import static by.tc.task01.entity.criteria.SearchCriteria.Oven.POWER_CONSUMPTION;
import static by.tc.task01.entity.criteria.SearchCriteria.Oven.WIDTH;

import java.util.Map;

public class OvenCreator implements ApplianceCreator{


    @Override
    public Appliance getAppliance(Map<String, Object> properties) {
        Oven oven = new Oven();
        try {
            oven.setCapacity(Double.parseDouble(properties.get(CAPACITY.name()).toString()));
            oven.setDepth(Double.parseDouble(properties.get(DEPTH.name()).toString()));
            oven.setHeight(Double.parseDouble(properties.get(HEIGHT.name()).toString()));
            oven.setWeight(Double.parseDouble(properties.get(WEIGHT.name()).toString()));
            oven.setPowerConsumption(Integer.parseInt(properties.get(POWER_CONSUMPTION.name()).toString()));
            oven.setWidth(Double.parseDouble(properties.get(WIDTH.name()).toString()));
        } catch (NumberFormatException | NullPointerException e) {
            oven = null;
        }
        return oven;
    }
}
