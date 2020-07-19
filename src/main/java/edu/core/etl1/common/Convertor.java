package edu.core.etl1.common;

import edu.core.etl1.common.exception.BaseException;

@FunctionalInterface
public interface Convertor<H, S, T> {
    T convert(H header, S source) throws BaseException;
}
