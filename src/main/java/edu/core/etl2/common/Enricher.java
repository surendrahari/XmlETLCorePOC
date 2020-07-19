package edu.core.etl2.common;

import edu.core.etl2.common.exception.BaseException;

@FunctionalInterface
public interface Enricher<H, D> {
    D enrich(H header, D data) throws BaseException;
}
