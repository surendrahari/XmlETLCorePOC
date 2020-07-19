package edu.core.etl2.xml.model.fields;

import edu.core.etl2.common.exception.BaseException;
import edu.core.etl2.common.field.Field;

public class XMLID implements Field<String, Integer, Integer> {

    private String inputData;
    private Integer data;

    public XMLID(String inputData) {
        this.inputData = inputData;
    }

    @Override
    public String getInputData() {
        return inputData;
    }

    @Override
    public Integer getConvertedData() {
        return data;
    }

    @Override
    public Integer getEnrichedData() {
        return data;
    }

    @Override
    public boolean isValid() throws BaseException {
        try {
            data = Integer.parseInt(inputData);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Exception in ID field : " + nfe.getMessage());
        }
        return false;
    }

    @Override
    public String toString() {
        return "XMLID{" +
                "inputData='" + inputData + '\'' +
                ", data=" + data +
                '}';
    }
}
