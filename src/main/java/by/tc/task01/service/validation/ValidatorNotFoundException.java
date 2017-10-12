package by.tc.task01.service.validation;

public final class ValidatorNotFoundException extends RuntimeException {

    public ValidatorNotFoundException() {
        super();
    }

    public ValidatorNotFoundException(String message) {
        super(message);
    }
}
