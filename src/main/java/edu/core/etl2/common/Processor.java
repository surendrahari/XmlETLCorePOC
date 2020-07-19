package edu.core.etl2.common;

import edu.core.etl2.common.exception.BaseException;

@FunctionalInterface
public interface Processor<H, M, D> {
    D process(H header, M message) throws BaseException;
}
