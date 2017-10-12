package by.tc.task01.dao.impl;

import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

final class ApplianceFactory {

    private Map<String, Function<Map<String, Object>, Appliance>> creatorMap = new HashMap<>();

    public ApplianceFactory() {
        creatorMap.put("Laptop", getLaptopCreator());
        creatorMap.put("Oven", getOvenCreator());
        creatorMap.put("Refrigerator", getRefrigeratorCreator());
        creatorMap.put("Speakers", getSpeakersCreator());
        creatorMap.put("TabletPC", getTabletPCCreator());
        creatorMap.put("VacuumCleaner", getVacuumCleanerCreator());
    }

    Appliance createAppliance(String type, Map<String, Object> properties) {
        Function<Map<String, Object>, Appliance> applianceCreator = creatorMap.get(type);
        if (applianceCreator == null || properties == null) {
            return null;
        }
        return applianceCreator.apply(properties);
    }

    Appliance createAppliance(Class<? extends Appliance> type, Map<String, Object> properties) {
        return createAppliance(type.getSimpleName(), properties);
    }

    private Function<Map<String, Object>, Appliance> getLaptopCreator() {
        return properties -> {
            Laptop laptop = new Laptop();
            try {
                laptop.setBatteryCapacity(Double.parseDouble(properties.get(SearchCriteria.Laptop.BATTERY_CAPACITY.name()).toString()));
                laptop.setCpu(Double.parseDouble(properties.get(SearchCriteria.Laptop.CPU.name()).toString()));
                laptop.setDisplayInchs(Double.parseDouble(properties.get(SearchCriteria.Laptop.DISPLAY_INCHS.name()).toString()));
                laptop.setMemoryROM(Integer.parseInt(properties.get(SearchCriteria.Laptop.MEMORY_ROM.name()).toString()));
                laptop.setOs(properties.get(SearchCriteria.Laptop.OS.name()).toString());
                laptop.setSystemMemory(Integer.parseInt(properties.get(SearchCriteria.Laptop.SYSTEM_MEMORY.name()).toString()));
            } catch (NumberFormatException | NullPointerException e) {
                laptop = null;
            }
            return laptop;
        };
    }

    private Function<Map<String, Object>, Appliance> getOvenCreator() {
        return properties -> {
            Oven oven = new Oven();
            try {
                oven.setCapacity(Double.parseDouble(properties.get(SearchCriteria.Oven.CAPACITY.name()).toString()));
                oven.setDepth(Double.parseDouble(properties.get(SearchCriteria.Oven.DEPTH.name()).toString()));
                oven.setHeight(Double.parseDouble(properties.get(SearchCriteria.Oven.HEIGHT.name()).toString()));
                oven.setWeight(Double.parseDouble(properties.get(SearchCriteria.Oven.WEIGHT.name()).toString()));
                oven.setPowerConsumption(Integer.parseInt(properties.get(SearchCriteria.Oven.POWER_CONSUMPTION.name()).toString()));
                oven.setWidth(Double.parseDouble(properties.get(SearchCriteria.Oven.WIDTH.name()).toString()));
            } catch (NumberFormatException | NullPointerException e) {
                oven = null;
            }
            return oven;
        };
    }

    private Function<Map<String, Object>, Appliance> getRefrigeratorCreator() {
        return properties -> {
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
        };
    }

    private Function<Map<String, Object>, Appliance> getTabletPCCreator() {
        return properties -> {
            TabletPC tabletPC = new TabletPC();
            try {
                tabletPC.setBatteryCapacity(Double.parseDouble(properties.get(SearchCriteria.TabletPC.BATTERY_CAPACITY.name()).toString()));
                tabletPC.setColor(properties.get(SearchCriteria.TabletPC.COLOR.name()).toString());
                tabletPC.setDisplayInches(Double.parseDouble(properties.get(SearchCriteria.TabletPC.DISPLAY_INCHES.name()).toString()));
                tabletPC.setFlashMemoryCapacity(Integer.parseInt(properties.get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.name()).toString()));
                tabletPC.setMemoryROM(Integer.parseInt(properties.get(SearchCriteria.TabletPC.MEMORY_ROM.name()).toString()));
            } catch (NumberFormatException | NullPointerException e) {
                tabletPC = null;
            }
            return tabletPC;
        };
    }

    private Function<Map<String, Object>, Appliance> getSpeakersCreator() {
        return properties -> {
            Speakers speakers = new Speakers();
            try {
                speakers.setCordLength(Double.parseDouble(properties.get(SearchCriteria.Speakers.CORD_LENGTH.name()).toString()));
                speakers.setFrequencyRange(properties.get(SearchCriteria.Speakers.FREQUENCY_RANGE.name()).toString());
                speakers.setNumberOfSpekears(Integer.parseInt(properties.get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.name()).toString()));
                speakers.setPowerConsumption(Integer.parseInt(properties.get(SearchCriteria.Speakers.POWER_CONSUMPTION.name()).toString()));
            } catch (NumberFormatException | NullPointerException e) {
                speakers = null;
            }
            return speakers;
        };
    }

    private Function<Map<String, Object>, Appliance> getVacuumCleanerCreator() {
        return properties -> {
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
        };
    }

}
