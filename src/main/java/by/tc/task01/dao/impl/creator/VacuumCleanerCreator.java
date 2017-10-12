package by.tc.task01.dao.impl.creator;

import by.tc.task01.dao.impl.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class VacuumCleanerCreator implements ApplianceCreator {

    @Override
    public Appliance getAppliance(Map<String, Object> properties) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        try {
            vacuumCleaner.setBagType(properties.get(SearchCriteria.VacuumCleaner.BAG_TYPE.name()).toString());
            vacuumCleaner.setCleaningWidth(Integer.parseInt(properties.get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.name()).toString()));
            vacuumCleaner.setFilterType(properties.get(SearchCriteria.VacuumCleaner.FILTER_TYPE.name()).toString());
            vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(properties.get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.name()).toString()));
            vacuumCleaner.setPowerConsumption(Integer.parseInt(properties.get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.name()).toString()));
            vacuumCleaner.setWandType(properties.get(SearchCriteria.VacuumCleaner.WAND_TYPE.name()).toString());
        } catch (NumberFormatException | NullPointerException e) {
            vacuumCleaner = null;
        }
        return vacuumCleaner;
    }
}
