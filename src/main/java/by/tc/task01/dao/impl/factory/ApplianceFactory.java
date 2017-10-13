package by.tc.task01.dao.impl.factory;

import by.tc.task01.entity.*;

import java.util.HashMap;
import java.util.Map;

public final class ApplianceFactory {

    private static final ApplianceFactory applianceFactory = new ApplianceFactory();
    private static final String APPLIANCE_PACKAGE = Appliance.class.getPackage().getName();
    private Map<Class<? extends Appliance>, ApplianceCreator> creatorMap = new HashMap<>();

    public static ApplianceFactory getApplianceFactory() {
        return applianceFactory;
    }

    private ApplianceFactory() {
        creatorMap.put(Laptop.class, new LaptopCreator());
        creatorMap.put(Oven.class, new OvenCreator());
        creatorMap.put(Refrigerator.class, new RefrigeratorCreator());
        creatorMap.put(Speakers.class, new SpeakersCreator());
        creatorMap.put(TabletPC.class, new TabletPCCreator());
        creatorMap.put(VacuumCleaner.class, new VacuumCleanerCreator());
    }

    public Appliance createAppliance (String type, Map<String, Object> properties) throws ApplianceCreatorNotFoundException{
        if (properties == null || type == null){
            return null;
        }
        Class<?> applianceClass;
        try {
            applianceClass = Class.forName(APPLIANCE_PACKAGE + "." + type);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return createAppliance(applianceClass, properties);
    }

    Appliance createAppliance(Class<?> type, Map<String, Object> properties) throws ApplianceCreatorNotFoundException{
        if (type == null || properties == null){
            return null;
        }
        ApplianceCreator applianceCreator = creatorMap.get(type);
        if (applianceCreator == null) {
            throw new ApplianceCreatorNotFoundException("There is no Creator for \"" + type.getName() + "\"");
        }
        return applianceCreator.getAppliance(properties);
    }

}
