package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;

import java.util.Map;

public interface ApplianceCreator {
    Appliance getAppliance(Map<String, Object> properties);
}
