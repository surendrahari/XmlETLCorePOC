package edu.core.etl2.xml.model.fields;

import edu.core.etl2.common.model.FieldName;

public enum XMLFieldNames implements FieldName {

    ID("id"),
    NAME("name"),
    NET_AMOUNT("netAmount");

    private final String name;

    XMLFieldNames(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
