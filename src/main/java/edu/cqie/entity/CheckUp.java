package edu.cqie.entity;

public class CheckUp {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CheckUp{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
