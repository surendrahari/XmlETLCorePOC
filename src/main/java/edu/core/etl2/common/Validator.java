package edu.core.etl2.common;

import edu.core.etl2.common.exception.BaseException;

@FunctionalInterface
public interface Validator<H, D> {
    boolean validate(H header, D data) throws BaseException;
}
