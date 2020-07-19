package edu.core.etl2.common.field;

import edu.core.etl2.common.exception.BaseException;

public interface FieldValidator {

    default boolean isValid() throws BaseException {
        return true;
    }
}
