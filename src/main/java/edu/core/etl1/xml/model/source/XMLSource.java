package edu.core.etl1.xml.model.source;

public class XMLSource {
    private String id;
    private String name;
    private String netAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(String netAmount) {
        this.netAmount = netAmount;
    }

    @Override
    public String toString() {
        return "FixMLSource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", netAmount='" + netAmount + '\'' +
                '}';
    }
}
