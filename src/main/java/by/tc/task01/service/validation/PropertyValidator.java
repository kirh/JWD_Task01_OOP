package by.tc.task01.service.validation;

@FunctionalInterface
public interface PropertyValidator {
    boolean validate(String propName, Object value);
}
