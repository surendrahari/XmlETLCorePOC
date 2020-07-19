package edu.core.etl2.common;

import edu.core.etl2.common.exception.BaseException;

@FunctionalInterface
public interface Parser<H, M, D> {
    D parse(H header, M message) throws BaseException;
}
