package by.tc.task01.service.validation;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorUtilsTest {
    @Test
    public void isPositiveInt() throws Exception {
        assertFalse(ValidatorUtils.isPositiveInt(-1));
        assertFalse(ValidatorUtils.isPositiveInt(0));
        assertFalse(ValidatorUtils.isPositiveInt(null));
        assertTrue(ValidatorUtils.isPositiveInt(1));
    }

    @Test
    public void isPositiveDouble() throws Exception {
        assertFalse(ValidatorUtils.isPositiveDouble(-1));
        assertFalse(ValidatorUtils.isPositiveDouble(0));
        assertFalse(ValidatorUtils.isPositiveDouble(null));
        assertTrue(ValidatorUtils.isPositiveDouble(1));
    }

    @Test
    public void isValidString() throws Exception {
        assertTrue(ValidatorUtils.isValidString("123"));
        assertFalse(ValidatorUtils.isValidString(""));
        assertFalse(ValidatorUtils.isValidString(null));
    }

    @Test
    public void isRange() throws Exception {
        assertTrue(ValidatorUtils.isRange("1-3"));
        assertTrue(ValidatorUtils.isRange("1.1-1.3"));
        assertFalse(ValidatorUtils.isRange("not range"));
        assertFalse(ValidatorUtils.isRange("1f-3"));
        assertFalse(ValidatorUtils.isRange(null));
    }

}