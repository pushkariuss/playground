package ru.pushkariuss.smp.dto;

public class Pet {

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet() {
    }

    public Pet(String kind, String name) {
        this.kind = kind;
        this.name = name;
    }

    private String kind;
    private String name;
}
