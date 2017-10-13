package by.tc.task01.dao.impl.factory;

import by.tc.task01.entity.Appliance;

import java.util.Map;

interface ApplianceCreator {
    Appliance getAppliance(Map<String, Object> properties);
}
