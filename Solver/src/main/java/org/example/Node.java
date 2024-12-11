package org.example;

public class Node {
    private String id;
    private Double EV;
    private Choice choice;


    public Node() {
    }

    public Node(String id, Double EV, Choice choice) {
        this.id = id;
        this.EV = EV;
        this.choice = choice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getEV() {
        return EV;
    }

    public void setEV(Double EV) {
        this.EV = EV;
    }

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice choice) {
        this.choice = choice;
    }
}
