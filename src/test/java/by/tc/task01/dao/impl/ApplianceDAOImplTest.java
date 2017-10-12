package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplianceDAOImplTest {

    ApplianceDAO applianceDAO = new ApplianceDAOImpl();
    Criteria<Object> criteria;

    @Before
    public void setCriteria(){
        criteria = new Criteria<>();
        criteria.setApplianceType("Oven");
    }

    @Test
    public void findOvenWithWrongParams() throws Exception {
        criteria.add(SearchCriteria.Oven.WEIGHT, 10);
        criteria.add(SearchCriteria.Oven.POWER_CONSUMPTION, 1500);
        Appliance appliance = applianceDAO.find(criteria);
        assertNull(appliance);
    }

    @Test
    public void findOven() throws Exception {
        criteria.add(SearchCriteria.Oven.POWER_CONSUMPTION, 1000);
        criteria.add(SearchCriteria.Oven.WEIGHT, 10);
        criteria.add(SearchCriteria.Oven.CAPACITY, 32);
        criteria.add(SearchCriteria.Oven.DEPTH, 60);
        criteria.add(SearchCriteria.Oven.HEIGHT, 45.5);
        criteria.add(SearchCriteria.Oven.WIDTH, 59.5);
        Appliance ovem = applianceDAO.find(criteria);
        Oven testOven = new Oven();
        testOven.setWidth(59.5);
        testOven.setPowerConsumption(1000);
        testOven.setWeight(10);
        testOven.setHeight(45.5);
        testOven.setDepth(60);
        testOven.setCapacity(32);
        assertEquals(testOven, ovem);
    }

    @Test
    public void findRefrigerator() throws Exception {

    }

    @Test
    public void findWithParamsFromOvenAndLaptopIsNull() throws Exception {
        criteria.add(SearchCriteria.Oven.WIDTH, 59.5);
        criteria.add(SearchCriteria.Laptop.BATTERY_CAPACITY, 1);
        Appliance appliance = applianceDAO.find(criteria);
        assertNull(appliance);
    }
}