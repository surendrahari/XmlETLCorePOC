package edu.core.etl2.common.model;

import edu.core.etl2.common.field.Field;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Data {
    private final Map<FieldName, Field> fieldMap = new HashMap<>();

    public Data addField(FieldName fieldName, Field field) {
        fieldMap.put(fieldName, field);
        return this;
    }

    public Set<FieldName> getFieldNames() {
        return fieldMap.keySet();
    }

    public Field getField(FieldName fieldName) {
        return fieldMap.get(fieldName);
    }

    @Override
    public String toString() {
        return "Data{" +
                "fieldMap=" + fieldMap +
                '}';
    }
}
