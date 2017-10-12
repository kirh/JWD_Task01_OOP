package by.tc.task01.entity.criteria;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CriteriaTest {
    Criteria<Object> criteria;

    @Before
    public void setUp() throws Exception {
        criteria = new Criteria<>();
    }

    @Test
    public void criteriaWithAddedTypeAndCriteriaisNotEmpty() throws Exception {
        criteria.setApplianceType("oven");
        criteria.add(SearchCriteria.Oven.WEIGHT, 33);
        assertFalse(criteria.isEmpty());
    }

    @Test
    public void criteriaWithoutTypeIsEmpty(){
        criteria.add(SearchCriteria.Oven.WEIGHT, 33);
        assertTrue(criteria.isEmpty());
    }

    @Test
    public void criteriaWithoutAddedCriteriasIsEmpty(){
        criteria.setApplianceType("Oven");
        assertTrue(criteria.isEmpty());
    }

}