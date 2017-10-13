package by.tc.task01.dao.impl.factory;

import by.tc.task01.entity.VacuumCleaner;

import java.util.Map;

import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner.BAG_TYPE;
import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner.CLEANING_WIDTH;
import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner.FILTER_TYPE;
import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION;
import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner.POWER_CONSUMPTION;
import static by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner.WAND_TYPE;

final class VacuumCleanerCreator implements ApplianceCreator {

    @Override
    public VacuumCleaner getAppliance(Map<String, Object> properties) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        try {
            vacuumCleaner.setBagType(properties.get(BAG_TYPE.name()).toString());
            vacuumCleaner.setCleaningWidth(Integer.parseInt(properties.get(CLEANING_WIDTH.name()).toString()));
            vacuumCleaner.setFilterType(properties.get(FILTER_TYPE.name()).toString());
            vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt(properties.get(MOTOR_SPEED_REGULATION.name()).toString()));
            vacuumCleaner.setPowerConsumption(Integer.parseInt(properties.get(POWER_CONSUMPTION.name()).toString()));
            vacuumCleaner.setWandType(properties.get(WAND_TYPE.name()).toString());
        } catch (NumberFormatException | NullPointerException e) {
            vacuumCleaner = null;
        }
        return vacuumCleaner;
    }
}
