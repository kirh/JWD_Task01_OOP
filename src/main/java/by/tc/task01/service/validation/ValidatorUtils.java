package by.tc.task01.service.validation;

public final class ValidatorUtils {

    private ValidatorUtils() {
    }

    public static boolean isPositiveInt(Object value) {
        if (value instanceof Integer){
            return (Integer) value > 0;
        }
        boolean isValid;
        try {
            isValid = Integer.parseInt(value.toString()) > 0;
        } catch (NumberFormatException | NullPointerException e) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isPositiveDouble(Object value) {
        if (value instanceof Double){
            return (Double) value > 0;
        }
        boolean isValid;
        try {
            isValid = Double.parseDouble(value.toString()) > 0;
        } catch (NumberFormatException | NullPointerException e) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidString(Object value) {
        return value != null && !value.toString().equals("");
    }

    public static boolean isRange(Object value) {
        return value != null && value.toString().matches("^\\d+(\\.\\d+)?-\\d+(\\.\\d+)?$");
    }
}
