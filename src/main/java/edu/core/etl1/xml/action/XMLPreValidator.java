package edu.core.etl1.xml.action;

import edu.core.etl1.common.Validator;
import edu.core.etl1.common.exception.BaseException;

import java.util.Optional;
import java.util.function.Predicate;

public class XMLPreValidator implements Validator<String, String> {

    @Override
    public boolean validate(String header, String message) throws BaseException {
        // Validate logic here or separate class which implements Validator interface

        Predicate<String> headerValidation = (headerObject) -> Optional.ofNullable(headerObject)
                .map(String::trim)
                .filter(filterHeader -> !filterHeader.isEmpty())
                .isPresent();

        Predicate<String> messageValidation = (messageObject) -> Optional.ofNullable(messageObject)
                .map(String::trim)
                .filter(filterHeader -> !filterHeader.isEmpty())
                .isPresent();

        boolean isValid = headerValidation.test(header) && messageValidation.test(message);

        System.out.println("preParseValidator  : isValid=" + isValid + ", header=" + header + ", message=" + message);

        return isValid;
    }
}
