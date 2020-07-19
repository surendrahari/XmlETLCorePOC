package edu.core.etl1.common;

import edu.core.etl1.common.exception.BaseException;

@FunctionalInterface
public interface Enricher<H, T> {
    T enrich(H header, T target) throws BaseException;
}
