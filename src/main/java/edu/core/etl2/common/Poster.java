package edu.core.etl2.common;

import edu.core.etl2.common.exception.BaseException;

@FunctionalInterface
public interface Poster<H, D> {
    D post(H header, D target) throws BaseException;
}
