package org.example;

public class Description {

    private String color;
    private Integer colonna;
    private Integer riga;
    private String type;

    public Description() {
    }

    public Description(String color, Integer colonna, Integer riga, String type) {
        this.color = color;
        this.colonna = colonna;
        this.riga = riga;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getColonna() {
        return colonna;
    }

    public void setColonna(Integer colonna) {
        this.colonna = colonna;
    }

    public Integer getRiga() {
        return riga;
    }

    public void setRiga(Integer riga) {
        this.riga = riga;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
