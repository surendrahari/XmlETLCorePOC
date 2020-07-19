package edu.core.etl1.common;

import edu.core.etl1.common.exception.BaseException;

@FunctionalInterface
public interface Poster<H, T> {
    T post(H header, T target) throws BaseException;
}
