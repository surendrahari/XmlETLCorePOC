package edu.core.etl2.xml.model.fields;

import edu.core.etl2.common.field.Field;

public class XMLName implements Field<String, String, String> {
    private final String inputData;

    public XMLName(String inputData) {
        this.inputData = inputData;
    }

    @Override
    public String getInputData() {
        return inputData;
    }

    @Override
    public String getConvertedData() {
        return inputData;
    }

    @Override
    public String getEnrichedData() {
        return inputData;
    }

    @Override
    public String toString() {
        return "FixmlName{" +
                "inputData='" + inputData + '\'' +
                '}';
    }
}
