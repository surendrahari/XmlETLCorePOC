package edu.core.etl2.xml.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class XMLTarget implements Serializable {
    private int id;
    private String name;
    private BigDecimal netAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }
}
