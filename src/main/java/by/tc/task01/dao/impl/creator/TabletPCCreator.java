package by.tc.task01.dao.impl.creator;

import by.tc.task01.dao.impl.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Map;

public class TabletPCCreator implements ApplianceCreator {

    @Override
    public Appliance getAppliance(Map<String, Object> properties) {
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
    }
}
