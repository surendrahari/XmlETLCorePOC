package edu.core.etl1.common;

import edu.core.etl1.common.exception.BaseException;

@FunctionalInterface
public interface Validator<H, D> {
    boolean validate(H header, D data) throws BaseException;
}
