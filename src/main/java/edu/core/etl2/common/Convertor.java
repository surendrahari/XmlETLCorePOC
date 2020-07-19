package edu.core.etl2.common;

import edu.core.etl2.common.exception.BaseException;

@FunctionalInterface
public interface Convertor<H, D> {
    D convert(H header, D data) throws BaseException;
}
