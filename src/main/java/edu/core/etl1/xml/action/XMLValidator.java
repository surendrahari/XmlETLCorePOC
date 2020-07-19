package edu.core.etl1.xml.action;

import edu.core.etl1.common.Validator;
import edu.core.etl1.common.exception.BaseException;
import edu.core.etl1.xml.model.source.XMLSource;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class XMLValidator implements Validator<String, XMLSource> {

    // Validate logic here or separate class which implements Validator interface
    private static final Predicate<XMLSource> IdValidation = fixMLSource -> {
        try {
            Integer.parseInt(fixMLSource.getId());
            return true;
        } catch (Exception e) {
            System.out.println("Exception during Id field validation " + e.getMessage());
        }
        return false;
    };

    private static final Predicate<XMLSource> netAmountValidation = fixMLSource -> {
        try {
            new BigDecimal(fixMLSource.getNetAmount());
            return true;
        } catch (Exception e) {
            System.out.println("Exception during netAmount field validation " + e.getMessage());
        }
        return false;
    };

    static Set<Predicate> getAllRules() {
        Set<Predicate> predicateSet = new HashSet<>();
        predicateSet.add(IdValidation);
        predicateSet.add(netAmountValidation);
        return predicateSet;
    }

    @Override
    public boolean validate(String header, XMLSource source) throws BaseException {
        // Validate logic here or separate interface
        boolean isFieldsValid = getAllRules()
                .stream()
                .allMatch(validator -> validator.test(source));

        System.out.println("postParseValidator  : isFieldsValid=" + isFieldsValid + ", header=" + header + ", source=" + source);

        return isFieldsValid;
    }
}
