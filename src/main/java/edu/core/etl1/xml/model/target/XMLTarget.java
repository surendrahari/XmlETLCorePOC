package edu.core.etl1.xml.model.target;

import java.io.Serializable;
import java.math.BigDecimal;

public class XMLTarget implements Serializable {
    private Integer id;
    private String name;
    private BigDecimal netAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "FIXML{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", netAmount=" + netAmount +
                '}';
    }
}
