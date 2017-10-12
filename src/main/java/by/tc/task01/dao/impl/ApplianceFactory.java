package by.tc.task01.dao.impl;

import by.tc.task01.dao.impl.creator.*;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

final class ApplianceFactory {

    private Map<String, ApplianceCreator> creatorMap = new HashMap<>();

    public ApplianceFactory() {
        creatorMap.put("Laptop", new LaptopCreator());
        creatorMap.put("Oven", new OvenCreator());
        creatorMap.put("Refrigerator", new RefrigeratorCreator());
        creatorMap.put("Speakers", new SpeakersCreator());
        creatorMap.put("TabletPC", new TabletPCCreator());
        creatorMap.put("VacuumCleaner", new VacuumCleanerCreator());
    }

    Appliance createAppliance(String type, Map<String, Object> properties) {
        ApplianceCreator applianceCreator = creatorMap.get(type);
        if (applianceCreator == null || properties == null) {
            return null;
        }
        return applianceCreator.getAppliance(properties);
    }

    Appliance createAppliance(Class<? extends Appliance> type, Map<String, Object> properties) {
        return createAppliance(type.getSimpleName(), properties);
    }

}
