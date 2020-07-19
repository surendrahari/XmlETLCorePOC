package edu.core.etl2.xml.model.fields;

import edu.core.etl2.common.exception.BaseException;
import edu.core.etl2.common.field.Field;

import java.math.BigDecimal;

public class XMLNetAmount implements Field<String, BigDecimal, BigDecimal> {

    private String inputData;
    private BigDecimal data;

    public XMLNetAmount(String inputData) {
        this.inputData = inputData;
    }

    @Override
    public String getInputData() {
        return inputData;
    }

    @Override
    public BigDecimal getConvertedData() {
        return data;
    }

    @Override
    public BigDecimal getEnrichedData() {
        return data;
    }

    @Override
    public boolean isValid() throws BaseException {
        try {
            data = new BigDecimal(inputData);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FixmlNetAmount{" +
                "inputData='" + inputData + '\'' +
                ", data=" + data +
                '}';
    }
}
