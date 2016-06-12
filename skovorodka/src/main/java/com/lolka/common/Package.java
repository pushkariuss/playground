package com.lolka.common;

/**
 * Created by pushkariuss on 12.06.16.
 */
public class Package {
    private final String payload;

    public Package(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Package{" + payload + '}';
    }
}
