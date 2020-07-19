package edu.core.etl2.common.field;

import edu.core.etl2.common.exception.BaseException;

public interface FieldEnricher {

    default boolean enrich() throws BaseException {
        return true;
    }
}
