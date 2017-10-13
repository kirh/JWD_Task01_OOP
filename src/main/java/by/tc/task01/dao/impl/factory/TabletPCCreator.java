package by.tc.task01.dao.impl.factory;

import by.tc.task01.entity.TabletPC;

import java.util.Map;

import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC.COLOR;
import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC.DISPLAY_INCHES;
import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC.MEMORY_ROM;
import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC.BATTERY_CAPACITY;
import static by.tc.task01.entity.criteria.SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY;

final class TabletPCCreator implements ApplianceCreator {

    @Override
    public TabletPC getAppliance(Map<String, Object> properties) {
        TabletPC tabletPC = new TabletPC();
        try {
            tabletPC.setBatteryCapacity(Double.parseDouble(properties.get(BATTERY_CAPACITY.name()).toString()));
            tabletPC.setColor(properties.get(COLOR.name()).toString());
            tabletPC.setDisplayInches(Double.parseDouble(properties.get(DISPLAY_INCHES.name()).toString()));
            tabletPC.setFlashMemoryCapacity(Integer.parseInt(properties.get(FLASH_MEMORY_CAPACITY.name()).toString()));
            tabletPC.setMemoryROM(Integer.parseInt(properties.get(MEMORY_ROM.name()).toString()));
        } catch (NumberFormatException | NullPointerException e) {
            tabletPC = null;
        }
        return tabletPC;
    }
}
