package edu.core.etl1.common;

import edu.core.etl1.common.exception.BaseException;

@FunctionalInterface
public interface Parser<H, M, S> {
    S parse(H header, M message) throws BaseException;
}
