package ru.pushkariuss.playground.concurrent.common;

public class Pack {
    protected final String payload;

    public Pack(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Pack{" + payload + '}';
    }
}