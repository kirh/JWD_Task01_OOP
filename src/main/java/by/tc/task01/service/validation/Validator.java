package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.validation.impl.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Validator {

    private Validator() {
    }

    private static Map<String, PropertyValidator> applianceValidatorMap = new HashMap<>();

    static {
        applianceValidatorMap.put("Oven", new OvenPropertyValidator());
        applianceValidatorMap.put("Laptop", new LaptopPropertyValidator());
        applianceValidatorMap.put("Refrigerator", new RefrigeratorPropertyValidator());
        applianceValidatorMap.put("Speakers", new SpeakersPropertyValidator());
        applianceValidatorMap.put("TabletPC", new TabletPCPropertyValidator());
        applianceValidatorMap.put("VacuumCleaner", new VacuumCleanerPropertyValidator());
    }

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {

        if (criteria == null || criteria.isEmpty() || criteria.getCriteria().containsKey(null)) {
            return false;
        }

        PropertyValidator propertyValidator = applianceValidatorMap.get(criteria.getApplianceType());

        if (propertyValidator == null) {
            return false;
        }

        boolean isValid = true;
        Iterator<Map.Entry<E, Object>> iterator = criteria.getCriteria().entrySet().iterator();
        while (isValid && iterator.hasNext()) {
            Map.Entry<E, Object> next = iterator.next();
            isValid &= propertyValidator.validate(next.getKey().toString(), next.getValue());
        }
        return isValid;
    }

}