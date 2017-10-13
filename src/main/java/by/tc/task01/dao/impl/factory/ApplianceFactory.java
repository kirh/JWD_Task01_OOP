package by.tc.task01.dao.impl.factory;

import by.tc.task01.entity.*;

import java.util.HashMap;
import java.util.Map;

public final class ApplianceFactory {

    private static final ApplianceFactory applianceFactory = new ApplianceFactory();
    private Map<String, ApplianceCreator> creatorMap = new HashMap<>();

    public static ApplianceFactory getApplianceFactory() {
        return applianceFactory;
    }

    private ApplianceFactory() {
        creatorMap.put("Laptop", new LaptopCreator());
        creatorMap.put("Oven", new OvenCreator());
        creatorMap.put("Refrigerator", new RefrigeratorCreator());
        creatorMap.put("Speakers", new SpeakersCreator());
        creatorMap.put("TabletPC", new TabletPCCreator());
        creatorMap.put("VacuumCleaner", new VacuumCleanerCreator());
    }

    public Appliance createAppliance (String type, Map<String, Object> properties){
        if (type == null || properties == null){
            return null;
        }
        ApplianceCreator applianceCreator = creatorMap.get(type);
        if (applianceCreator == null) {
            return null;
        }
        return applianceCreator.getAppliance(properties);

    }



}
