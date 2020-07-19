package edu.core.etl2.common.field;

import edu.core.etl2.common.exception.BaseException;

public interface FieldConvertor {

    default boolean convert() throws BaseException {
        return true;
    }
}
