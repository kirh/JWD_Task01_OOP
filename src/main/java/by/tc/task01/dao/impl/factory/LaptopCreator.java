package by.tc.task01.dao.impl.factory;

import by.tc.task01.entity.Laptop;

import java.util.Map;

import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.BATTERY_CAPACITY;
import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.CPU;
import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.DISPLAY_INCHS;
import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.MEMORY_ROM;
import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.OS;
import static by.tc.task01.entity.criteria.SearchCriteria.Laptop.SYSTEM_MEMORY;

final class LaptopCreator implements ApplianceCreator {

    @Override
    public Laptop getAppliance(Map<String, Object> properties) {
        Laptop laptop = new Laptop();
        try {
            laptop.setBatteryCapacity(Double.parseDouble(properties.get(BATTERY_CAPACITY.name()).toString()));
            laptop.setCpu(Double.parseDouble(properties.get(CPU.name()).toString()));
            laptop.setDisplayInchs(Double.parseDouble(properties.get(DISPLAY_INCHS.name()).toString()));
            laptop.setMemoryROM(Integer.parseInt(properties.get(MEMORY_ROM.name()).toString()));
            laptop.setOs(properties.get(OS.name()).toString());
            laptop.setSystemMemory(Integer.parseInt(properties.get(SYSTEM_MEMORY.name()).toString()));
        } catch (NumberFormatException | NullPointerException e) {
            laptop = null;
        }
        return laptop;
    }
}
