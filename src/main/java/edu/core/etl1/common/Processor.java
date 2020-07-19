package edu.core.etl1.common;

import edu.core.etl1.common.exception.BaseException;

@FunctionalInterface
public interface Processor<H, M, T> {
    T process(H header, M message) throws BaseException;
}
