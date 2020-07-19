package edu.core.etl2.common.field;

public interface Field<I extends Object, T extends Object, E extends Object> extends FieldValidator, FieldConvertor, FieldEnricher {

    I getInputData();

    default T getConvertedData() {
        return null;
    }

    default E getEnrichedData() {
        return null;
    }
}
