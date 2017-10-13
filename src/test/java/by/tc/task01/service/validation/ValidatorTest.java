package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {
    Criteria<Object> criteria;
    @Before
    public void setUp() throws Exception {
        criteria = new Criteria<>();
        criteria.setApplianceType("Oven");
    }

    @Test
    public void searchCriteriaIsNull() throws Exception {
        criteria.add(null, 30);
        assertFalse(Validator.criteriaValidator(criteria));
    }

    @Test
    public void valueIsNull() throws Exception {
        criteria.add(SearchCriteria.Oven.WIDTH, null);
        assertFalse(Validator.criteriaValidator(criteria));
    }

    @Test
    public void valueIsZero() throws Exception {
        criteria.add(SearchCriteria.Oven.WIDTH, 0);
        assertFalse(Validator.criteriaValidator(criteria));
    }

    @Test
    public void validCriteria() throws Exception {
        criteria.add(SearchCriteria.Oven.WIDTH, 1);
        assertTrue(Validator.criteriaValidator(criteria));
    }

    @Test
    public void searchCriteriasForDifferentEntities() throws Exception {
        criteria.add(SearchCriteria.Laptop.BATTERY_CAPACITY, 1);
        assertFalse(Validator.criteriaValidator(criteria));
    }

    @Test
    public void criteriaIsNull() throws Exception {
        assertFalse(Validator.criteriaValidator(null));
    }

    @Test
    public void searchCriteriaIsEmptyString() throws Exception {
        criteria.add("", 5);
        assertFalse(Validator.criteriaValidator(criteria));
    }

    @Test
    public void valueIsEmptyString() throws Exception {
        criteria.setApplianceType("TabletPC");
        criteria.add(SearchCriteria.TabletPC.COLOR, "");
        assertFalse(Validator.criteriaValidator(criteria));
    }

}